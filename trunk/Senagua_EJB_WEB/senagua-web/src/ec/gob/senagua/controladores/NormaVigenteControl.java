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

import ec.gob.senagua.modelo.RhMcaParametrosNormavigente;
import ec.gob.senagua.servicios.RhMcaParametrosNormavigenteLocal;
import ec.gob.senagua.util.CargaArchivoS;

@ManagedBean
@SessionScoped
public class NormaVigenteControl implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4804004392734666407L;

	@EJB
	RhMcaParametrosNormavigenteLocal rhMcaParametrosNormavigenteLocal;

	private RhMcaParametrosNormavigente rhMcaParametrosNormavigente;
	private List<RhMcaParametrosNormavigente> rhMcaParametrosNormavigenteLst;
	private List<RhMcaParametrosNormavigente> rhMcaParametrosNormavigenteLstTmp;
	private CargaArchivoS cargaArchivoNormaVigente;
	private InputStream input;
	private boolean flag;
	private boolean flagUpload;
	private boolean flagCancelarUpload;

	@PostConstruct
	public void init() {
		rhMcaParametrosNormavigente = new RhMcaParametrosNormavigente();
		rhMcaParametrosNormavigenteLst = new ArrayList<RhMcaParametrosNormavigente>();
		rhMcaParametrosNormavigenteLstTmp = new ArrayList<RhMcaParametrosNormavigente>();
		rhMcaParametrosNormavigenteLst = rhMcaParametrosNormavigenteLocal
				.buscaEstadoTrue();

		flag = false;
		flagUpload = false;
		flagCancelarUpload = false;
		cargaArchivoNormaVigente = new CargaArchivoS();
	}

	/**
	 * Nuevo AnalisisReport
	 * */
	public void nuevo() {
		rhMcaParametrosNormavigente = new RhMcaParametrosNormavigente();
		rhMcaParametrosNormavigenteLst.add(rhMcaParametrosNormavigente);
	}

	/**
	 * Cargar Objeto
	 * **/
	public void actualizar() {
		rhMcaParametrosNormavigenteLst = new ArrayList<RhMcaParametrosNormavigente>();
		rhMcaParametrosNormavigenteLst = rhMcaParametrosNormavigenteLocal
				.buscaEstadoTrue();

		for (RhMcaParametrosNormavigente p : rhMcaParametrosNormavigenteLst) {
			System.out.println(p.getNorvId());

		}

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
		List<RhMcaParametrosNormavigente> tmp = new ArrayList<RhMcaParametrosNormavigente>();
		if (rhMcaParametrosNormavigenteLstTmp.size() == 0) {
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_WARN,
					"Carga Archivos", "Carga Excel : Existe Datos Para Cargar");
			FacesContext.getCurrentInstance().addMessage(null, message);
		} else {
			// Cambiar de estado
			tmp = rhMcaParametrosNormavigenteLocal.getAll();
			for (RhMcaParametrosNormavigente t : tmp) {
				t.setNorvEstado(false);
			}
			for (RhMcaParametrosNormavigente t : tmp) {
				rhMcaParametrosNormavigenteLocal.makePersistent(t);
			}

			for (RhMcaParametrosNormavigente l : rhMcaParametrosNormavigenteLstTmp) {
				rhMcaParametrosNormavigenteLocal.makePersistent(l);
			}
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,
					"Carga Archivos",
					"Información se Guardó con Éxito Y actualizo estado..");
			FacesContext.getCurrentInstance().addMessage(null, message);
			init();

		}

	}

	/**
	 * Cancelar Guardar de archivos
	 */
	public void guardar() {
		try {
			for (RhMcaParametrosNormavigente n : rhMcaParametrosNormavigenteLst) {
				rhMcaParametrosNormavigenteLocal.makePersistent(n);
			}
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,
					"Contaminacion:", "Información se Guardó con Éxito..:");
			FacesContext.getCurrentInstance().addMessage(null, message);
			init();
			rhMcaParametrosNormavigenteLst = rhMcaParametrosNormavigenteLocal
					.buscaEstadoTrue();
		} catch (Exception e) {
			FacesMessage message = new FacesMessage(
					FacesMessage.SEVERITY_ERROR, "NormaVigente:",
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
			rhMcaParametrosNormavigenteLstTmp = cargaArchivoNormaVigente
					.leerExcelNormaVigente(input);

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

	public RhMcaParametrosNormavigente getRhMcaParametrosNormavigente() {
		return rhMcaParametrosNormavigente;
	}

	public void setRhMcaParametrosNormavigente(
			RhMcaParametrosNormavigente rhMcaParametrosNormavigente) {
		this.rhMcaParametrosNormavigente = rhMcaParametrosNormavigente;
	}

	public List<RhMcaParametrosNormavigente> getRhMcaParametrosNormavigenteLst() {
		return rhMcaParametrosNormavigenteLst;
	}

	public void setRhMcaParametrosNormavigenteLst(
			List<RhMcaParametrosNormavigente> rhMcaParametrosNormavigenteLst) {
		this.rhMcaParametrosNormavigenteLst = rhMcaParametrosNormavigenteLst;
	}

	public List<RhMcaParametrosNormavigente> getRhMcaParametrosNormavigenteLstTmp() {
		return rhMcaParametrosNormavigenteLstTmp;
	}

	public void setRhMcaParametrosNormavigenteLstTmp(
			List<RhMcaParametrosNormavigente> rhMcaParametrosNormavigenteLstTmp) {
		this.rhMcaParametrosNormavigenteLstTmp = rhMcaParametrosNormavigenteLstTmp;
	}

	public CargaArchivoS getCargaArchivoNormaVigente() {
		return cargaArchivoNormaVigente;
	}

	public void setCargaArchivoNormaVigente(
			CargaArchivoS cargaArchivoNormaVigente) {
		this.cargaArchivoNormaVigente = cargaArchivoNormaVigente;
	}
}
