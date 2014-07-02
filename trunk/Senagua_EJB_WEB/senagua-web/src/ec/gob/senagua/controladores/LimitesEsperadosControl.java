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

import ec.gob.senagua.modelo.RhMcaParametrosLimitesesperado;
import ec.gob.senagua.servicios.RhMcaParametrosLimitesesperadoLocal;
import ec.gob.senagua.util.CargaArchivoS;

@ManagedBean
@SessionScoped
public class LimitesEsperadosControl implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4804004392734666407L;

	@EJB
	private RhMcaParametrosLimitesesperadoLocal rhMcaParametrosLimitesesperadoLocal;

	private RhMcaParametrosLimitesesperado rhMcaParametrosLimitesesperado;
	private List<RhMcaParametrosLimitesesperado> rhMcaParametrosLimitesesperadoLst;
	private List<RhMcaParametrosLimitesesperado> rhMcaParametrosLimitesesperadoLstTmp;
	private CargaArchivoS cargaArchivoLimitesEsperados;
	private InputStream input;
	private boolean flag;
	private boolean flagUpload;
	private boolean flagCancelarUpload;

	@PostConstruct
	public void init() {
		rhMcaParametrosLimitesesperado = new RhMcaParametrosLimitesesperado();
		rhMcaParametrosLimitesesperadoLst = new ArrayList<RhMcaParametrosLimitesesperado>();
		rhMcaParametrosLimitesesperadoLstTmp = new ArrayList<RhMcaParametrosLimitesesperado>();
		rhMcaParametrosLimitesesperadoLst = rhMcaParametrosLimitesesperadoLocal
				.buscaEstadoTrue();
		flag = false;
		flagUpload = false;
		flagCancelarUpload = false;
		cargaArchivoLimitesEsperados = new CargaArchivoS();
	}

	/**
	 * Nuevo AnalisisReport
	 * */
	public void nuevo() {
		rhMcaParametrosLimitesesperado = new RhMcaParametrosLimitesesperado();
		rhMcaParametrosLimitesesperadoLst.add(rhMcaParametrosLimitesesperado);

	}

	/**
	 * Cargar Objeto
	 * **/
	public void actualizar() {
		rhMcaParametrosLimitesesperadoLst = new ArrayList<RhMcaParametrosLimitesesperado>();
		rhMcaParametrosLimitesesperadoLst = rhMcaParametrosLimitesesperadoLocal
				.buscaEstadoTrue();

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
		List<RhMcaParametrosLimitesesperado> tmp = new ArrayList<RhMcaParametrosLimitesesperado>();
		if (rhMcaParametrosLimitesesperadoLstTmp.size() == 0) {
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_WARN,
					"Carga Archivos", "Carga Excel : Existe Datos Para Cargar");
			FacesContext.getCurrentInstance().addMessage(null, message);
		} else {
			// Cambiar de estado
			tmp = rhMcaParametrosLimitesesperadoLocal.getAll();
			for (RhMcaParametrosLimitesesperado t : tmp) {
				t.setLespEstado(false);
			}
			for (RhMcaParametrosLimitesesperado t : tmp) {
				rhMcaParametrosLimitesesperadoLocal.makePersistent(t);
			}

			for (RhMcaParametrosLimitesesperado l : rhMcaParametrosLimitesesperadoLstTmp) {
				rhMcaParametrosLimitesesperadoLocal.makePersistent(l);
			}
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,
					"Carga Archivos",
					"Información se Guardó con Éxito Y actualizo estado..");
			FacesContext.getCurrentInstance().addMessage(null, message);
			init();

		}

	}

	/**
	 * Cancelar Carga de archivos
	 */
	public void guardar() {

		try {

			for (RhMcaParametrosLimitesesperado c : rhMcaParametrosLimitesesperadoLst) {
				rhMcaParametrosLimitesesperadoLocal.makePersistent(c);
			}
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,
					"Contaminacion:", "Información se Guardó con Éxito..id:"
							+ rhMcaParametrosLimitesesperado.getLespId());
			FacesContext.getCurrentInstance().addMessage(null, message);
			init();
			rhMcaParametrosLimitesesperadoLst = rhMcaParametrosLimitesesperadoLocal
					.buscaEstadoTrue();
		} catch (Exception e) {
			FacesMessage message = new FacesMessage(
					FacesMessage.SEVERITY_ERROR, "Limites Esperados:",
					"Error no se guardar la información..:");
			FacesContext.getCurrentInstance().addMessage(null, message);
		}
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
			rhMcaParametrosLimitesesperadoLstTmp = cargaArchivoLimitesEsperados
					.leerExcelLimitesEsperados(input);

		} catch (IOException e) {
			FacesMessage message = new FacesMessage(
					FacesMessage.SEVERITY_ERROR, "Carga Archivos",
					"Carga Excel : Revise el Archivo de carga");
			FacesContext.getCurrentInstance().addMessage(null, message);
		}

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

	public RhMcaParametrosLimitesesperado getRhMcaParametrosLimitesesperado() {
		return rhMcaParametrosLimitesesperado;
	}

	public void setRhMcaParametrosLimitesesperado(
			RhMcaParametrosLimitesesperado rhMcaParametrosLimitesesperado) {
		this.rhMcaParametrosLimitesesperado = rhMcaParametrosLimitesesperado;
	}

	public List<RhMcaParametrosLimitesesperado> getRhMcaParametrosLimitesesperadoLst() {
		return rhMcaParametrosLimitesesperadoLst;
	}

	public void setRhMcaParametrosLimitesesperadoLst(
			List<RhMcaParametrosLimitesesperado> rhMcaParametrosLimitesesperadoLst) {
		this.rhMcaParametrosLimitesesperadoLst = rhMcaParametrosLimitesesperadoLst;
	}

	public List<RhMcaParametrosLimitesesperado> getRhMcaParametrosLimitesesperadoLstTmp() {
		return rhMcaParametrosLimitesesperadoLstTmp;
	}

	public void setRhMcaParametrosLimitesesperadoLstTmp(
			List<RhMcaParametrosLimitesesperado> rhMcaParametrosLimitesesperadoLstTmp) {
		this.rhMcaParametrosLimitesesperadoLstTmp = rhMcaParametrosLimitesesperadoLstTmp;
	}

	public CargaArchivoS getCargaArchivoLimitesEsperados() {
		return cargaArchivoLimitesEsperados;
	}

	public void setCargaArchivoLimitesEsperados(
			CargaArchivoS cargaArchivoLimitesEsperados) {
		this.cargaArchivoLimitesEsperados = cargaArchivoLimitesEsperados;
	}
}
