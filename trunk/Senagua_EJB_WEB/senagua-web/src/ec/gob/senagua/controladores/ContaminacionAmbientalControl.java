package ec.gob.senagua.controladores;

import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import jxl.read.biff.BiffException;

import org.primefaces.event.FileUploadEvent;

import ec.gob.senagua.modelo.RhMgaContaminacion;
import ec.gob.senagua.modelo.RhParametroSistema;
import ec.gob.senagua.servicios.RhMgaContaminacionLocal;
import ec.gob.senagua.servicios.RhParametroSistemaLocal;
import ec.gob.senagua.util.CargaArchivoS;
import ec.gob.senagua.util.MenuContaminacionAmbiental;

@ManagedBean
@SessionScoped
public class ContaminacionAmbientalControl implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4804004392734666407L;

	@EJB
	private RhMgaContaminacionLocal rhMgaContaminacionLocal;
	@EJB
	private RhParametroSistemaLocal rhParametroSistemaLocal;

	private RhMgaContaminacion rhMgaContaminacion;
	private List<RhMgaContaminacion> rhMgaContaminacionLts;
	private List<RhMgaContaminacion> rhMgaContaminacionLtsTmp;
	private MenuContaminacionAmbiental menuContaminacionAmbiental;
	private CargaArchivoS cargaArchivoMGA;
	private InputStream input;
	private boolean flag;
	private boolean flagUpload;
	private boolean flagCancelarUpload;
	private boolean flagWaiting;

	@PostConstruct
	public void init() {
		rhMgaContaminacion = new RhMgaContaminacion();
		rhMgaContaminacionLts = new ArrayList<RhMgaContaminacion>();
		rhMgaContaminacionLtsTmp = new ArrayList<RhMgaContaminacion>();
		rhMgaContaminacionLts = rhMgaContaminacionLocal.getAll();
		menuContaminacionAmbiental = new MenuContaminacionAmbiental();
		flag = false;
		flagUpload = false;
		flagCancelarUpload = false;
		flagWaiting = false;
		setCargaArchivoMGA(new CargaArchivoS());
		//
		menuContaminacionAmbiental = creaMenu();

	}

	/**
	 * Parametro Sistema Menu contaminacion 121
	 * */
	private MenuContaminacionAmbiental creaMenu() {
		List<RhParametroSistema> rhParametroSistemas = new ArrayList<RhParametroSistema>();
		for (RhParametroSistema p : rhParametroSistemaLocal.getAll()) {
			if (p.getPrPadre() != null) {
				if (p.getPrPadre() == 121) {
					rhParametroSistemas.add(p);
				}
			}
		}

		//
		for (RhParametroSistema pa : rhParametroSistemas) {
			if (pa.getPrCodigo().equals("1")) {
				menuContaminacionAmbiental.setDemarcacionHidrografica(pa
						.getPrDescripcion());
			}
			if (pa.getPrCodigo().equals("2")) {
				menuContaminacionAmbiental.setEvento(pa.getPrDescripcion());
			}
			if (pa.getPrCodigo().equals("3")) {
				menuContaminacionAmbiental.setFechadeInspeccion(pa
						.getPrDescripcion());
			}
			if (pa.getPrCodigo().equals("4")) {
				menuContaminacionAmbiental.setCodigodeFicha(pa
						.getPrDescripcion());
			}
			if (pa.getPrCodigo().equals("5")) {
				menuContaminacionAmbiental.setCodigodeInforme(pa
						.getPrDescripcion());
			}
			if (pa.getPrCodigo().equals("6")) {
				menuContaminacionAmbiental.setFechadeInforme(pa
						.getPrDescripcion());
			}
			if (pa.getPrCodigo().equals("7")) {
				menuContaminacionAmbiental.setEdicion(pa.getPrDescripcion());
			}

		}

		return menuContaminacionAmbiental;
	}

	/**
	 * Nuevo AnalisisReport
	 * */
	public void nuevo() {
		rhMgaContaminacion = new RhMgaContaminacion();
		rhMgaContaminacionLts.add(rhMgaContaminacion);

	}

	/**
	 * Cargar Objeto
	 * **/
	public void actualizar() {
		init();
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,
				"Contaminacion:", "Información Actualizada..");
		FacesContext.getCurrentInstance().addMessage(null, message);

	}

	/**
	 * cargar Archivos
	 * */
	public void activarCargarArchivos() {
		setFlagUpload(true);
		setFlagCancelarUpload(true);
	}

	/**
	 * Cancelar Carga de archivos
	 */
	public void cancelarCargarArchivos() {
		flagUpload = false;
		flagCancelarUpload = false;
	}

	/**
	 * Cancelar Guardar de archivos Lista
	 */
	public void guardarLista(ActionEvent actionEvent) {
		if (rhMgaContaminacionLtsTmp.size() == 0) {
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_WARN,
					"Carga Archivos", "Carga Excel : Existe Datos Para Cargar");
			FacesContext.getCurrentInstance().addMessage(null, message);
		} else {
			for (RhMgaContaminacion c : rhMgaContaminacionLtsTmp) {
				rhMgaContaminacionLocal.makePersistent(c);
			}
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,
					"Carga Archivos", "Información se Guardó con Éxito..");
			FacesContext.getCurrentInstance().addMessage(null, message);
			flagWaiting = true;
			init();

		}

	}

	/**
	 * Cancelar Carga de archivos
	 */
	public void guardar() {
		if (rhMgaContaminacionLts.size() != 0) {
			for (RhMgaContaminacion c : rhMgaContaminacionLts) {
				rhMgaContaminacionLocal.makePersistent(c);
			}
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,
					"Contaminacion:", "Información se Guardó con Éxito..");
			FacesContext.getCurrentInstance().addMessage(null, message);
			init();
			rhMgaContaminacionLts = rhMgaContaminacionLocal.getAll();
			flagWaiting = true;
		} else {
			FacesMessage message = new FacesMessage(
					FacesMessage.SEVERITY_ERROR, "Contaminacion:",
					"No existe Información para Guardar..");
			FacesContext.getCurrentInstance().addMessage(null, message);
		}
		flagWaiting = false;
	}

	/**
	 * upload Archivo
	 * 
	 * @throws IOException
	 * @throws BiffException
	 */
	public void handleFileUpload(FileUploadEvent event) throws BiffException {

		try {
			input = event.getFile().getInputstream();
			rhMgaContaminacionLtsTmp = cargaArchivoMGA
					.leerExcelContaminacion(input);

		} catch (IOException e) {
			FacesMessage message = new FacesMessage(
					FacesMessage.SEVERITY_ERROR, "Carga Archivos",
					"Carga Excel : Revise el Archivo de carga");
			FacesContext.getCurrentInstance().addMessage(null, message);
		}

	}

	/**
	 * Elimina Registro
	 */
	public void eliminar() {
		rhMgaContaminacionLocal.makeTransient(rhMgaContaminacion);
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,
				"Contaminacion Ambiental", "Registro eliminado con Exito..");
		FacesContext.getCurrentInstance().addMessage(null, message);
		init();
		rhMgaContaminacionLts = rhMgaContaminacionLocal.getAll();

	}

	public boolean isFlagUpload() {
		return flagUpload;
	}

	public void setFlagUpload(boolean flagUpload) {
		this.flagUpload = flagUpload;
	}

	public boolean isFlagCancelarUpload() {
		return flagCancelarUpload;
	}

	public void setFlagCancelarUpload(boolean flagCancelarUpload) {
		this.flagCancelarUpload = flagCancelarUpload;
	}

	public boolean isFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}

	public InputStream getInput() {
		return input;
	}

	public void setInput(InputStream input) {
		this.input = input;
	}

	public List<RhMgaContaminacion> getRhMgaContaminacionLts() {
		return rhMgaContaminacionLts;
	}

	public void setRhMgaContaminacionLts(
			List<RhMgaContaminacion> rhMgaContaminacionLts) {
		this.rhMgaContaminacionLts = rhMgaContaminacionLts;
	}

	public RhMgaContaminacion getRhMgaContaminacion() {
		return rhMgaContaminacion;
	}

	public void setRhMgaContaminacion(RhMgaContaminacion rhMgaContaminacion) {
		this.rhMgaContaminacion = rhMgaContaminacion;
	}

	public List<RhMgaContaminacion> getRhMgaContaminacionLtsTmp() {
		return rhMgaContaminacionLtsTmp;
	}

	public void setRhMgaContaminacionLtsTmp(
			List<RhMgaContaminacion> rhMgaContaminacionLtsTmp) {
		this.rhMgaContaminacionLtsTmp = rhMgaContaminacionLtsTmp;
	}

	public CargaArchivoS getCargaArchivoMGA() {
		return cargaArchivoMGA;
	}

	public void setCargaArchivoMGA(CargaArchivoS cargaArchivoMGA) {
		this.cargaArchivoMGA = cargaArchivoMGA;
	}

	public boolean isFlagWaiting() {
		return flagWaiting;
	}

	public void setFlagWaiting(boolean flagWaiting) {
		this.flagWaiting = flagWaiting;
	}

	public MenuContaminacionAmbiental getMenuContaminacionAmbiental() {
		return menuContaminacionAmbiental;
	}

	public void setMenuContaminacionAmbiental(
			MenuContaminacionAmbiental menuContaminacionAmbiental) {
		this.menuContaminacionAmbiental = menuContaminacionAmbiental;
	}
}
