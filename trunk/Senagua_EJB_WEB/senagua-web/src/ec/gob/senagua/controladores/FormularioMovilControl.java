package ec.gob.senagua.controladores;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import jxl.read.biff.BiffException;

import org.apache.commons.io.IOUtils;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

import ec.gob.senagua.modelo.RhParametroSistema;
import ec.gob.senagua.modelo.RhTabletFoto;
import ec.gob.senagua.modelo.RhTabletRegistro;
import ec.gob.senagua.modelo.TmpObtienedato;
import ec.gob.senagua.modelo.VwObtienedato;
import ec.gob.senagua.servicios.RhParametroSistemaLocal;
import ec.gob.senagua.servicios.RhTabletFotoLocal;
import ec.gob.senagua.servicios.RhTabletRegistroLocal;
import ec.gob.senagua.servicios.TmpObtieneDatoLocal;
import ec.gob.senagua.servicios.VwObtienedatoLocal;

@ManagedBean
@SessionScoped
public class FormularioMovilControl implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2619281548789897806L;
	// private Logger log = Logger.getLogger(UsuarioControlador.class);

	@EJB
	private RhTabletRegistroLocal rhTabletRegistroLocal;
	@EJB
	private TmpObtieneDatoLocal tmpObtieneDatoLocal;
	@EJB
	private RhParametroSistemaLocal rhParametroSistemaLocal;
	@EJB
	private RhTabletFotoLocal rhTabletFotoLocal;
	@EJB
	private VwObtienedatoLocal vwObtienedatoLocal;

	private RhTabletRegistro rhTabletRegistro;
	private TmpObtienedato tmpObtienedato;
	private RhTabletFoto rhTabletFoto;
	private VwObtienedato vwObtienedato;
	private List<RhTabletRegistro> rhTabletRegistroMCALts;
	private List<RhTabletRegistro> rhTabletRegistroMGALst;
	private List<RhParametroSistema> rhParametroSistemaLstUbicacion;
	private List<RhParametroSistema> rhParametroSistemaLstRepresentabilidad;
	private List<RhParametroSistema> rhParametroSistemaLstCondicionesClimaticas;

	private List<RhTabletFoto> rhTabletFotoLst;
	private List<VwObtienedato> vwObtienedatos;

	private InputStream in;
	private boolean flagWaiting;

	@PostConstruct
	public void init() {
		rhTabletRegistro = new RhTabletRegistro();
		tmpObtienedato = new TmpObtienedato();
		vwObtienedato = new VwObtienedato();
		rhTabletFoto = new RhTabletFoto();
		rhTabletRegistroMCALts = new ArrayList<RhTabletRegistro>();
		rhTabletRegistroMGALst = new ArrayList<RhTabletRegistro>();
		rhParametroSistemaLstUbicacion = new ArrayList<RhParametroSistema>();
		rhParametroSistemaLstRepresentabilidad = new ArrayList<RhParametroSistema>();
		rhParametroSistemaLstCondicionesClimaticas = new ArrayList<RhParametroSistema>();
		rhTabletFotoLst = new ArrayList<RhTabletFoto>();
		vwObtienedatos = new ArrayList<VwObtienedato>();

		// Carga datos
		rhTabletRegistroMCALts = recuperarUbicacionFuente(rhTabletRegistroLocal
				.buscarXtipoFicha("MCA"));
		rhTabletRegistroMGALst = recuperarUbicacionFuente(rhTabletRegistroLocal
				.buscarXtipoFicha("MGA"));
		cargarCombosParametros();

		flagWaiting = false;

	}

	/**
	 * Recuperacion de Ubicacion geografia - GIS
	 * */
	public void cargarCombosParametros() {
		for (RhParametroSistema p : rhParametroSistemaLocal.getAll()) {
			if (p.getPrPadre() != null) {
				if (p.getPrPadre() == 29) {
					rhParametroSistemaLstUbicacion.add(p);
				}
				if (p.getPrPadre() == 37) {
					rhParametroSistemaLstRepresentabilidad.add(p);
				}
				if (p.getPrPadre() == 33) {
					rhParametroSistemaLstCondicionesClimaticas.add(p);
				}

			}
		}
	}

	/**
	 * Recuperacion de Ubicacion geografia - GIS
	 * */
	public List<RhTabletRegistro> recuperarUbicacionFuente(
			List<RhTabletRegistro> rhTabletRegistros) {

		try {

			for (RhTabletRegistro rg : rhTabletRegistros) {
				tmpObtienedato = new TmpObtienedato();
				tmpObtienedato = tmpObtieneDatoLocal.buscarId(1);
				tmpObtienedato.setCoordenadaX(rg.getRgCoordenadax());
				tmpObtienedato.setCoordenadaY(rg.getRgCoordenaday());
				tmpObtienedato.setEsCalidadagua(true);
				tmpObtienedato = tmpObtieneDatoLocal
						.makePersistent(tmpObtienedato);
				vwObtienedatos = vwObtienedatoLocal.getAll();
				vwObtienedato = vwObtienedatos.get(0);
				if (vwObtienedato == null) {
					System.out.println("no hay datos");
				} else {
					rg.setRg_provincia(vwObtienedato.getProvincia());
					rg.setRg_canton(vwObtienedato.getCanton());
					rg.setRgIdparroquia(vwObtienedato.getCodparroquia());
					rg.setRg_parroquia(vwObtienedato.getParroquia());
					rg.setRgIddemarcacion(vwObtienedato.getCoddemarcacion());
					rg.setRg_demarcacion(vwObtienedato.getDemarcacion());
					rg.setRg_codpfafsteter(vwObtienedato.getCodpfafsteter());
					rg.setRg_pfafsteter(vwObtienedato.getPfafsteter());
					rg.setRg_cuenca(vwObtienedato.getCuenca());
					rg.setRg_subcuenca(vwObtienedato.getSubcuenca());
					rg.setRgIdmicrocuenca(vwObtienedato.getCodmicrocuenca());
					rg.setRgIdmicrocuenca(vwObtienedato.getCodmicrocuenca());
					rg.setRg_microcuenca(vwObtienedato.getMicrocuenca());
				}
			}
		} catch (Exception e) {
			System.out.println("Problema con vista");
		}
		return rhTabletRegistros;

	}

	/**
	 * Añadir nuevo Calidad Agua
	 * */
	public void anadirCalidadAgua() {
		rhTabletRegistro = new RhTabletRegistro();
		rhTabletFotoLst = new ArrayList<RhTabletFoto>();
		rhTabletRegistro.setRgTipomodulo("MCA");
		rhTabletRegistro.setRgNombreficha("Ficha Inspección");
		rhTabletRegistro.setRgFecha(new Date());

	}

	/**
	 * Añadir nuevo Calidad Agua
	 * */
	public void anadirGestionAmbiental() {
		rhTabletRegistro = new RhTabletRegistro();
		rhTabletFotoLst = new ArrayList<RhTabletFoto>();
		rhTabletRegistro.setRgTipomodulo("MGA");
		rhTabletRegistro.setRgNombreficha("Ficha Inspección");
		rhTabletRegistro.setRgFecha(new Date());

	}

	/**
	 * Guardar Registro MGA
	 * */
	public void actualizarMga() {
		rhTabletRegistroMGALst = recuperarUbicacionFuente(rhTabletRegistroLocal
				.buscarXtipoFicha("MGA"));

	}

	/**
	 * Guardar Registro MCA
	 * */
	public void actualizarMca() {
		rhTabletRegistroMCALts = recuperarUbicacionFuente(rhTabletRegistroLocal
				.buscarXtipoFicha("MCA"));

	}

	/**
	 * Editar Ficha
	 * */
	public void editarFicha() {
		rhTabletFotoLst = new ArrayList<RhTabletFoto>();
		rhTabletFotoLst = rhTabletFotoLocal
				.buscarXidTabletRegitro(rhTabletRegistro);

	}

	/**
	 * Añadir Registro Foto
	 * */
	public void anadirRegistroFoto() {
		rhTabletFoto = new RhTabletFoto();
		rhTabletFotoLst.add(rhTabletFoto);
	}

	/**
	 * Añadir Registro Foto
	 * */
	public void guardarRegistroFoto() {
		try {
			rhTabletFoto.setRhTabletRegistro(rhTabletRegistro);
			rhTabletFoto = rhTabletFotoLocal.makePersistent(rhTabletFoto);
			rhTabletFotoLst = rhTabletFotoLocal
					.buscarXidTabletRegitro(rhTabletRegistro);
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,
					"Registro Tablet Foto:", "Registro guardado ..");
			FacesContext.getCurrentInstance().addMessage(null, message);

		} catch (Exception e) {
			FacesMessage message = new FacesMessage(
					FacesMessage.SEVERITY_ERROR, "Registro Tablet Foto:",
					"No se pudo guardar el Registro..");
			FacesContext.getCurrentInstance().addMessage(null, message);
		}
	}

	/**
	 * Guarda Ficha MCA
	 * */
	public void guardarFichaMCA() {
		try {
			if (rhTabletRegistro.getRg_provincia().isEmpty()
					|| rhTabletRegistro.getRg_parroquia().isEmpty()
					|| rhTabletRegistro.getRg_parroquia().isEmpty()) {
				FacesMessage message = new FacesMessage(
						FacesMessage.SEVERITY_INFO, "Registro Tablet:",
						"Verifique las Cordenadas..");
				FacesContext.getCurrentInstance().addMessage(null, message);
			} else {
				rhTabletRegistro = rhTabletRegistroLocal
						.makePersistent(rhTabletRegistro);
				FacesMessage message = new FacesMessage(
						FacesMessage.SEVERITY_INFO, "Registro Tablet:",
						"Registro Guardado..");
				FacesContext.getCurrentInstance().addMessage(null, message);
				rhTabletRegistroMCALts = recuperarUbicacionFuente(rhTabletRegistroLocal
						.buscarXtipoFicha("MCA"));

			}
		} catch (Exception e) {
			System.out.println("no hay datos");
			FacesMessage message = new FacesMessage(
					FacesMessage.SEVERITY_ERROR, "Registro Tablet:",
					"Verifique la informacion..");
			FacesContext.getCurrentInstance().addMessage(null, message);
		}
	}

	/**
	 * Guarda Ficha MGA
	 * */
	public void guardarFichaMGA() {
		try {
			if (rhTabletRegistro.getRg_provincia().isEmpty()
					|| rhTabletRegistro.getRg_parroquia().isEmpty()
					|| rhTabletRegistro.getRg_parroquia().isEmpty()) {
				FacesMessage message = new FacesMessage(
						FacesMessage.SEVERITY_INFO, "Resgistro Tablet:",
						"Verifique las Cordenadas..");
				FacesContext.getCurrentInstance().addMessage(null, message);
			} else {
				rhTabletRegistro = rhTabletRegistroLocal
						.makePersistent(rhTabletRegistro);
				FacesMessage message = new FacesMessage(
						FacesMessage.SEVERITY_INFO, "Registro Tablet:",
						"Registro Guardado..");
				FacesContext.getCurrentInstance().addMessage(null, message);
				rhTabletRegistroMCALts = recuperarUbicacionFuente(rhTabletRegistroLocal
						.buscarXtipoFicha("MGA"));

			}
		} catch (Exception e) {
			System.out.println("no hay datos");
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,
					"Registro Tablet:", "Verifique la informacion..");
			FacesContext.getCurrentInstance().addMessage(null, message);
		}
	}

	/**
	 * Validar coordenadas
	 * */
	public void validarCoordenadas() {
		System.out.println(rhTabletRegistro.getRgCoordenadax());
		if (rhTabletRegistro.getRgCoordenadax().equals(BigDecimal.ZERO)
				|| rhTabletRegistro.getRgCoordenaday().equals(BigDecimal.ZERO)) {
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_WARN,
					"Coordenadas:", "Ingrese las Coordenadas (X,Y)..");
			FacesContext.getCurrentInstance().addMessage(null, message);
		} else {
			tmpObtienedato = tmpObtieneDatoLocal.buscarId(1);
			tmpObtienedato.setCoordenadaX(rhTabletRegistro.getRgCoordenadax());
			tmpObtienedato.setCoordenadaY(rhTabletRegistro.getRgCoordenaday());
			tmpObtienedato.setEsCalidadagua(true);
			tmpObtienedato = tmpObtieneDatoLocal.makePersistent(tmpObtienedato);
			vwObtienedatos = vwObtienedatoLocal.getAll();
			vwObtienedato = vwObtienedatos.get(0);
			if (vwObtienedato == null) {
				FacesMessage message = new FacesMessage(
						FacesMessage.SEVERITY_WARN, "Coordenadas:",
						"Fuera del Limite..");
				FacesContext.getCurrentInstance().addMessage(null, message);
				rhTabletRegistro = new RhTabletRegistro();

			} else {
				cargarInformacionUbicacion(vwObtienedato, rhTabletRegistro,
						true);

			}

		}

	}

	/**
	 * Carga Informacion de Ubocacion en Objeto
	 * */
	public void cargarInformacionUbicacion(VwObtienedato vwObtienedato,
			RhTabletRegistro rhTabletRegistro, Boolean nuevo) {
		rhTabletRegistro.setRg_provincia(vwObtienedato.getProvincia());
		rhTabletRegistro.setRg_canton(vwObtienedato.getCanton());
		rhTabletRegistro.setRgIdparroquia(vwObtienedato.getCodparroquia());
		rhTabletRegistro.setRg_parroquia(vwObtienedato.getParroquia());
		rhTabletRegistro.setRgIddemarcacion(vwObtienedato.getCoddemarcacion());
		rhTabletRegistro.setRg_demarcacion(vwObtienedato.getDemarcacion());
		rhTabletRegistro.setRg_codpfafsteter(vwObtienedato.getCodpfafsteter());
		rhTabletRegistro.setRg_pfafsteter(vwObtienedato.getPfafsteter());
		rhTabletRegistro.setRg_cuenca(vwObtienedato.getCuenca());
		rhTabletRegistro.setRg_subcuenca(vwObtienedato.getSubcuenca());
		rhTabletRegistro.setRgIdmicrocuenca(vwObtienedato.getCodmicrocuenca());
		rhTabletRegistro.setRgIdmicrocuenca(vwObtienedato.getCodmicrocuenca());
		rhTabletRegistro.setRg_microcuenca(vwObtienedato.getMicrocuenca());
		if (nuevo) {
			rhTabletRegistro.setRgNumeroficha(vwObtienedato.getCodficha());
		}
	}

	/**
	 * upload Archivo
	 * 
	 * @throws IOException
	 * @throws BiffException
	 */
	public void handleFileUpload(FileUploadEvent event) throws BiffException {

		in = null;
		try {
			in = event.getFile().getInputstream();
			rhTabletFoto.setFtArchivo(IOUtils.toByteArray(in));
			FacesMessage msg = new FacesMessage("Archivo:", event.getFile()
					.getFileName() + " Listo para Subir..");
			FacesContext.getCurrentInstance().addMessage(null, msg);
			// flag = false;
		} catch (IOException e) {
			FacesMessage msg = new FacesMessage("Error;", event.getFile()
					.getFileName() + " No esta Listo para cargado");
			FacesContext.getCurrentInstance().addMessage(null, msg);
			e.printStackTrace();

		}

	}

	/**
	 * Descargar archivo
	 * */
	public StreamedContent getSelectedFileToDownload() {
		InputStream in = new ByteArrayInputStream(rhTabletFoto.getFtArchivo());
		return new DefaultStreamedContent(in, "image/jpeg",
				"download_senagua.jpg");
	}

	public RhTabletRegistro getRhTabletRegistro() {
		return rhTabletRegistro;
	}

	public void setRhTabletRegistro(RhTabletRegistro rhTabletRegistro) {
		this.rhTabletRegistro = rhTabletRegistro;
	}

	public List<RhTabletRegistro> getRhTabletRegistroMCALts() {
		return rhTabletRegistroMCALts;
	}

	public void setRhTabletRegistroMCALts(
			List<RhTabletRegistro> rhTabletRegistroMCALts) {
		this.rhTabletRegistroMCALts = rhTabletRegistroMCALts;
	}

	public List<RhTabletRegistro> getRhTabletRegistroMGALst() {
		return rhTabletRegistroMGALst;
	}

	public void setRhTabletRegistroMGALst(
			List<RhTabletRegistro> rhTabletRegistroMGALst) {
		this.rhTabletRegistroMGALst = rhTabletRegistroMGALst;
	}

	public TmpObtienedato getTmpObtienedato() {
		return tmpObtienedato;
	}

	public void setTmpObtienedato(TmpObtienedato tmpObtienedato) {
		this.tmpObtienedato = tmpObtienedato;
	}

	public List<RhTabletFoto> getRhTabletFotoLst() {
		return rhTabletFotoLst;
	}

	public void setRhTabletFotoLst(List<RhTabletFoto> rhTabletFotoLst) {
		this.rhTabletFotoLst = rhTabletFotoLst;
	}

	public RhTabletFoto getRhTabletFoto() {
		return rhTabletFoto;
	}

	public void setRhTabletFoto(RhTabletFoto rhTabletFoto) {
		this.rhTabletFoto = rhTabletFoto;
	}

	public InputStream getIn() {
		return in;
	}

	public void setIn(InputStream in) {
		this.in = in;
	}

	public VwObtienedato getVwObtienedato() {
		return vwObtienedato;
	}

	public void setVwObtienedato(VwObtienedato vwObtienedato) {
		this.vwObtienedato = vwObtienedato;
	}

	public List<VwObtienedato> getVwObtienedatos() {
		return vwObtienedatos;
	}

	public void setVwObtienedatos(List<VwObtienedato> vwObtienedatos) {
		this.vwObtienedatos = vwObtienedatos;
	}

	public List<RhParametroSistema> getRhParametroSistemaLstUbicacion() {
		return rhParametroSistemaLstUbicacion;
	}

	public void setRhParametroSistemaLstUbicacion(
			List<RhParametroSistema> rhParametroSistemaLstUbicacion) {
		this.rhParametroSistemaLstUbicacion = rhParametroSistemaLstUbicacion;
	}

	public List<RhParametroSistema> getRhParametroSistemaLstRepresentabilidad() {
		return rhParametroSistemaLstRepresentabilidad;
	}

	public void setRhParametroSistemaLstRepresentabilidad(
			List<RhParametroSistema> rhParametroSistemaLstRepresentabilidad) {
		this.rhParametroSistemaLstRepresentabilidad = rhParametroSistemaLstRepresentabilidad;
	}

	public List<RhParametroSistema> getRhParametroSistemaLstCondicionesClimaticas() {
		return rhParametroSistemaLstCondicionesClimaticas;
	}

	public void setRhParametroSistemaLstCondicionesClimaticas(
			List<RhParametroSistema> rhParametroSistemaLstCondicionesClimaticas) {
		this.rhParametroSistemaLstCondicionesClimaticas = rhParametroSistemaLstCondicionesClimaticas;
	}

	public boolean isFlagWaiting() {
		return flagWaiting;
	}

	public void setFlagWaiting(boolean flagWaiting) {
		this.flagWaiting = flagWaiting;
	}

}
