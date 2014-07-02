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

import ec.gob.senagua.modelo.RhMcaMuestreo;
import ec.gob.senagua.modelo.RhMcaReportelaboratorio;
import ec.gob.senagua.servicios.RhMcaMuestreoLocal;
import ec.gob.senagua.servicios.RhMcaReportelaboratorioLocal;
import ec.gob.senagua.servicios.RhTabletRegistroLocal;
import ec.gob.senagua.util.CargaArchivoS;

@ManagedBean
@SessionScoped
public class ReporteLaboratorioControl implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4804004392734666407L;

	@EJB
	private RhMcaReportelaboratorioLocal rhMcaReporteanalisisLocal;
	@EJB
	private RhTabletRegistroLocal rhTabletRegistroLocal;
	@EJB
	private RhMcaMuestreoLocal rhMcaMuestreoLocal;

	private Integer idRegTablet;
	private RhMcaMuestreo rhMcaMuestreo;
	private List<RhMcaMuestreo> rhMcaMuestreosLst;
	private RhMcaReportelaboratorio rhMcaReportelaboratorio;
	private List<RhMcaReportelaboratorio> rhMcaReportelaboratoriosList;
	private List<RhMcaReportelaboratorio> rhMcaReportelaboratoriosListTmp;
	private CargaArchivoS cargaArchivoModuloCalidadAgua;
	private InputStream input;
	private boolean flag;
	private boolean flagUpload;
	private boolean flagCancelarUpload;
	private boolean flagDatosReporte;

	@PostConstruct
	public void init() {
		idRegTablet = 0;
		rhMcaMuestreo = new RhMcaMuestreo();
		rhMcaMuestreosLst = new ArrayList<RhMcaMuestreo>();
		rhMcaReportelaboratorio = new RhMcaReportelaboratorio();
		rhMcaReportelaboratoriosList = new ArrayList<RhMcaReportelaboratorio>();
		rhMcaReportelaboratoriosListTmp = new ArrayList<RhMcaReportelaboratorio>();
		rhMcaMuestreosLst = rhMcaMuestreoLocal.getAll();
		flag = false;
		flagUpload = false;
		flagCancelarUpload = false;
		cargaArchivoModuloCalidadAgua = new CargaArchivoS();
		flagDatosReporte = false;

	}

	/**
	 * Nuevo AnalisisReport
	 * */
	public void nuevo() {
		rhMcaReportelaboratoriosList = new ArrayList<RhMcaReportelaboratorio>();
		rhMcaReportelaboratoriosList.add(rhMcaReportelaboratorio);

	}

	/**
	 * Cargar Objeto
	 * **/
	public void actualizar() {
		rhMcaReportelaboratoriosList = new ArrayList<RhMcaReportelaboratorio>();
		rhMcaReportelaboratoriosList = rhMcaReporteanalisisLocal.getAll();
		// flag = false;
		// flagUpload = false;
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
	 * Cancelar Carga de archivos
	 */
	public void guardarLista(ActionEvent actionEvent) {
		if (rhMcaReportelaboratoriosListTmp.size() == 0) {
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_WARN,
					"Carga Archivos", "Carga Excel : Existe Datos Para Cargar");
			FacesContext.getCurrentInstance().addMessage(null, message);
		} else {
			for (RhMcaReportelaboratorio r : rhMcaReportelaboratoriosListTmp) {
				rhMcaReporteanalisisLocal.makePersistent(r);
			}
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,
					"Carga Archivos", "Información se Guardó con Éxito..");
			FacesContext.getCurrentInstance().addMessage(null, message);
			rhMcaReportelaboratoriosList = rhMcaReporteanalisisLocal
					.buscarXIdFicha(idRegTablet);
			flagDatosReporte = true;

		}

	}

	/**
	 * Cancelar Carga de archivos
	 */
	public void guardar() {

		for (RhMcaReportelaboratorio r : rhMcaReportelaboratoriosList) {
			rhMcaReporteanalisisLocal.makePersistent(r);
		}
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,
				"Carga Archivos", "Información se Guardó con Éxito..");
		FacesContext.getCurrentInstance().addMessage(null, message);

		rhMcaReportelaboratoriosList = rhMcaReporteanalisisLocal
				.buscarXIdFicha(idRegTablet);
		flagDatosReporte = true;

	}

	/**
	 * upload Archivo
	 * 
	 * @throws IOException
	 * @throws BiffException
	 */
	public void handleFileUpload(FileUploadEvent event) throws BiffException {
		rhMcaMuestreo = new RhMcaMuestreo();
		rhMcaMuestreo.setMsId(idRegTablet);

		try {
			input = event.getFile().getInputstream();
			rhMcaReportelaboratoriosListTmp = cargaArchivoModuloCalidadAgua
					.leerExcelReporteGruntec(input, rhMcaMuestreo);
		} catch (IOException e) {
			FacesMessage message = new FacesMessage(
					FacesMessage.SEVERITY_ERROR, "Carga Archivos",
					"Carga Excel : Revise el Archivo de carga");
			FacesContext.getCurrentInstance().addMessage(null, message);
		}

	}

	/**
	 * Cargar Reporte de Fichas:(Gruntec)
	 * */

	public void cargaDatosReporte() {
		if (idRegTablet == 0) {
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,
					"Reportes Laboratorio:",
					"Escoja primero el Codigo: Ficha..");
			FacesContext.getCurrentInstance().addMessage(null, message);
			flagDatosReporte = false;
		} else {
			rhMcaReportelaboratoriosList = rhMcaReporteanalisisLocal
					.buscarXIdFicha(idRegTablet);
			flagDatosReporte = true;

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

	public CargaArchivoS getCargaArchivoModuloCalidadAgua() {
		return cargaArchivoModuloCalidadAgua;
	}

	public void setCargaArchivoModuloCalidadAgua(
			CargaArchivoS cargaArchivoModuloCalidadAgua) {
		this.cargaArchivoModuloCalidadAgua = cargaArchivoModuloCalidadAgua;
	}

	public RhMcaReportelaboratorio getRhMcaReportelaboratorio() {
		return rhMcaReportelaboratorio;
	}

	public void setRhMcaReportelaboratorio(
			RhMcaReportelaboratorio rhMcaReportelaboratorio) {
		this.rhMcaReportelaboratorio = rhMcaReportelaboratorio;
	}

	public List<RhMcaReportelaboratorio> getRhMcaReportelaboratoriosList() {
		return rhMcaReportelaboratoriosList;
	}

	public void setRhMcaReportelaboratoriosList(
			List<RhMcaReportelaboratorio> rhMcaReportelaboratoriosList) {
		this.rhMcaReportelaboratoriosList = rhMcaReportelaboratoriosList;
	}

	public List<RhMcaReportelaboratorio> getRhMcaReportelaboratoriosListTmp() {
		return rhMcaReportelaboratoriosListTmp;
	}

	public void setRhMcaReportelaboratoriosListTmp(
			List<RhMcaReportelaboratorio> rhMcaReportelaboratoriosListTmp) {
		this.rhMcaReportelaboratoriosListTmp = rhMcaReportelaboratoriosListTmp;
	}

		public boolean isFlagDatosReporte() {
		return flagDatosReporte;
	}

	public void setFlagDatosReporte(boolean flagDatosReporte) {
		this.flagDatosReporte = flagDatosReporte;
	}

	public Integer getIdRegTablet() {
		return idRegTablet;
	}

	public void setIdRegTablet(Integer idRegTablet) {
		this.idRegTablet = idRegTablet;
	}

	public RhMcaMuestreo getRhMcaMuestreo() {
		return rhMcaMuestreo;
	}

	public void setRhMcaMuestreo(RhMcaMuestreo rhMcaMuestreo) {
		this.rhMcaMuestreo = rhMcaMuestreo;
	}

	public List<RhMcaMuestreo> getRhMcaMuestreosLst() {
		return rhMcaMuestreosLst;
	}

	public void setRhMcaMuestreosLst(List<RhMcaMuestreo> rhMcaMuestreosLst) {
		this.rhMcaMuestreosLst = rhMcaMuestreosLst;
	}
}
