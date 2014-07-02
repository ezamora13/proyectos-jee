package ec.gob.senagua.controladores;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import ec.gob.senagua.modelo.RhMcaMuestreo;
import ec.gob.senagua.modelo.RhMcaReportelaboratorio;
import ec.gob.senagua.modelo.RhTabletRegistro;
import ec.gob.senagua.modelo.TmpObtienedato;
import ec.gob.senagua.modelo.VwObtienedato;
import ec.gob.senagua.modelo.gis.DpaCantone;
import ec.gob.senagua.modelo.gis.DpaParroquia;
import ec.gob.senagua.modelo.gis.DpaProvincia;
import ec.gob.senagua.servicios.DpaCantoneLocal;
import ec.gob.senagua.servicios.DpaParroquiaLocal;
import ec.gob.senagua.servicios.DpaProvinciaLocal;
import ec.gob.senagua.servicios.RhMcaMuestreoLocal;
import ec.gob.senagua.servicios.RhMcaReportelaboratorioLocal;
import ec.gob.senagua.servicios.RhTabletRegistroLocal;
import ec.gob.senagua.servicios.TmpObtieneDatoLocal;
import ec.gob.senagua.servicios.VwObtienedatoLocal;

@ManagedBean
@SessionScoped
public class ReporteBusquedaParametros implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3981669892749643974L;

	@EJB
	private RhMcaReportelaboratorioLocal rhMcaReporteanalisisLocal;
	@EJB
	private RhMcaMuestreoLocal rhMcaMuestreoLocal;
	@EJB
	private VwObtienedatoLocal vwObtienedatoLocal;
	@EJB
	private TmpObtieneDatoLocal tmpObtieneDatoLocal;
	@EJB
	private RhTabletRegistroLocal rhTabletRegistroLocal;
	@EJB
	private RhMcaReportelaboratorioLocal rhMcaReportelaboratorioLocal;
	@EJB
	private DpaProvinciaLocal dpaProvinciaLocal;
	@EJB
	private DpaCantoneLocal dpaCantoneLocal;
	@EJB
	private DpaParroquiaLocal dpaParroquiaLocal;

	private List<DpaProvincia> dpaProvincias;
	private List<DpaCantone> dpaCantones;
	private List<DpaParroquia> dpaParroquias;
	private List<RhMcaMuestreo> rhMcaMuestreosLst;
	private List<RhMcaReportelaboratorio> rhMcaReportelaboratoriosList;
	private List<VwObtienedato> vwObtienedatos;
	private RhTabletRegistro rhTabletRegistro;
	private List<RhTabletRegistro> rhTabletRegistros;
	private TmpObtienedato tmpObtienedato;
	private VwObtienedato vwObtienedato;
	private List<String> parametros;
	private List<String> condicionantes;
	private List<String> selectedParametros;

	private Integer idRegTablet;
	private String codProvincia;
	private String codCanton;
	private String codParroquia;
	private Integer valor;
	private String condicionante;
	private boolean flagValor;
	private boolean flagConsulta;

	@PostConstruct
	public void init() {
		rhMcaMuestreosLst = new ArrayList<RhMcaMuestreo>();
		rhMcaReportelaboratoriosList = new ArrayList<RhMcaReportelaboratorio>();
		vwObtienedatos = new ArrayList<VwObtienedato>();
		rhTabletRegistros = new ArrayList<RhTabletRegistro>();
		rhTabletRegistro = new RhTabletRegistro();
		tmpObtienedato = new TmpObtienedato();
		parametros = new ArrayList<String>();
		condicionantes = new ArrayList<String>();
		selectedParametros = new ArrayList<String>();
		idRegTablet = 0;
		flagValor = true;
		valor = 0;
		flagConsulta = false;

		// Carga Datos
		rhMcaMuestreosLst = rhMcaMuestreoLocal.getAll();
		rhTabletRegistros = rhTabletRegistroLocal.getAll();
		condicionantes = condicionantes();
		dpaProvincias = dpaProvinciaLocal.getAll();

	}

	public List<String> condicionantes() {
		condicionantes = new ArrayList<String>();
		condicionantes.add(">");
		condicionantes.add("<");
		condicionantes.add("=");
		return condicionantes;

	}

	/**
	 * Cargar informacion Muestreo
	 * */

	public void cargaInformacionCodigo() {
		flagConsulta = false;
		if (idRegTablet == 0) {
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,
					"Reportes :", "Escoja primero el Codigo: Ficha..");
			FacesContext.getCurrentInstance().addMessage(null, message);

		} else {
			rhTabletRegistro = new RhTabletRegistro();
			rhMcaReportelaboratoriosList = new ArrayList<RhMcaReportelaboratorio>();
			rhTabletRegistro = rhTabletRegistroLocal.buscarId(idRegTablet);
			validarCoordenadas();
			parametros = rhMcaReportelaboratorioLocal
					.buscarXidTablet(idRegTablet);

			if (parametros.size() == 0) {
				condicionantes = new ArrayList<String>();
				flagValor = true;
			} else {
				condicionantes = condicionantes();
				flagValor = false;
			}

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
	 * Consulta los parametros en la base de datos
	 * */
	public void consultar() {

		if (selectedParametros.size() == 0 || condicionante.isEmpty()
				|| valor == 0) {
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_WARN,
					"Reporte:", "Escoja los Parametros ..");
			FacesContext.getCurrentInstance().addMessage(null, message);
		} else {

			rhMcaReportelaboratoriosList = rhMcaReportelaboratorioLocal
					.buscarXidTabletParametrosCondicionates(idRegTablet,
							selectedParametros, valor, condicionante);
			if (rhMcaReportelaboratoriosList.size() == 0) {
				flagConsulta = false;
				FacesMessage message = new FacesMessage(
						FacesMessage.SEVERITY_WARN, "Reporte:",
						"No existe resultados ..");
				FacesContext.getCurrentInstance().addMessage(null, message);
			} else {
				flagConsulta = true;
			}
		}

	}

	/**
	 * Cargar Canton
	 * */

	public void cargaCanton() {

	}

	public Integer getIdRegTablet() {
		return idRegTablet;
	}

	public void setIdRegTablet(Integer idRegTablet) {
		this.idRegTablet = idRegTablet;
	}

	public List<RhMcaMuestreo> getRhMcaMuestreosLst() {
		return rhMcaMuestreosLst;
	}

	public void setRhMcaMuestreosLst(List<RhMcaMuestreo> rhMcaMuestreosLst) {
		this.rhMcaMuestreosLst = rhMcaMuestreosLst;
	}

	public List<RhMcaReportelaboratorio> getRhMcaReportelaboratoriosList() {
		return rhMcaReportelaboratoriosList;
	}

	public void setRhMcaReportelaboratoriosList(
			List<RhMcaReportelaboratorio> rhMcaReportelaboratoriosList) {
		this.rhMcaReportelaboratoriosList = rhMcaReportelaboratoriosList;
	}

	public RhTabletRegistro getRhTabletRegistro() {
		return rhTabletRegistro;
	}

	public void setRhTabletRegistro(RhTabletRegistro rhTabletRegistro) {
		this.rhTabletRegistro = rhTabletRegistro;
	}

	public TmpObtienedato getTmpObtienedato() {
		return tmpObtienedato;
	}

	public void setTmpObtienedato(TmpObtienedato tmpObtienedato) {
		this.tmpObtienedato = tmpObtienedato;
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

	public List<RhTabletRegistro> getRhTabletRegistros() {
		return rhTabletRegistros;
	}

	public void setRhTabletRegistros(List<RhTabletRegistro> rhTabletRegistros) {
		this.rhTabletRegistros = rhTabletRegistros;
	}

	public List<String> getParametros() {
		return parametros;
	}

	public void setParametros(List<String> parametros) {
		this.parametros = parametros;
	}

	public List<String> getCondicionantes() {
		return condicionantes;
	}

	public void setCondicionantes(List<String> condicionantes) {
		this.condicionantes = condicionantes;
	}

	public List<String> getSelectedParametros() {
		return selectedParametros;
	}

	public void setSelectedParametros(List<String> selectedParametros) {
		this.selectedParametros = selectedParametros;
	}

	public Integer getValor() {
		return valor;
	}

	public void setValor(Integer valor) {
		this.valor = valor;
	}

	public String getCondicionante() {
		return condicionante;
	}

	public void setCondicionante(String condicionante) {
		this.condicionante = condicionante;
	}

	public boolean isFlagValor() {
		return flagValor;
	}

	public void setFlagValor(boolean flagValor) {
		this.flagValor = flagValor;
	}

	public boolean isFlagConsulta() {
		return flagConsulta;
	}

	public void setFlagConsulta(boolean flagConsulta) {
		this.flagConsulta = flagConsulta;
	}

	public List<DpaProvincia> getDpaProvincias() {
		return dpaProvincias;
	}

	public void setDpaProvincias(List<DpaProvincia> dpaProvincias) {
		this.dpaProvincias = dpaProvincias;
	}

	public List<DpaCantone> getDpaCantones() {
		return dpaCantones;
	}

	public void setDpaCantones(List<DpaCantone> dpaCantones) {
		this.dpaCantones = dpaCantones;
	}

	public List<DpaParroquia> getDpaParroquias() {
		return dpaParroquias;
	}

	public void setDpaParroquias(List<DpaParroquia> dpaParroquias) {
		this.dpaParroquias = dpaParroquias;
	}

	public String getCodProvincia() {
		return codProvincia;
	}

	public void setCodProvincia(String codProvincia) {
		this.codProvincia = codProvincia;
	}

	public String getCodCanton() {
		return codCanton;
	}

	public void setCodCanton(String codCanton) {
		this.codCanton = codCanton;
	}

	public String getCodParroquia() {
		return codParroquia;
	}

	public void setCodParroquia(String codParroquia) {
		this.codParroquia = codParroquia;
	}

}
