package ec.gob.senagua.controladores;

import java.io.ByteArrayInputStream;
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
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

import ec.gob.senagua.modelo.RhMgaMatrizseguimientoplanesma;
import ec.gob.senagua.modelo.RhMgaProyectomatrizseguimientoplanesma;
import ec.gob.senagua.modelo.RhParametroSistema;
import ec.gob.senagua.modelo.TmpGetFoto;
import ec.gob.senagua.servicios.RhMgaMatrizseguimientoplanesmaLocal;
import ec.gob.senagua.servicios.RhMgaProyectoMatrizseguimientoplanesmaLocal;
import ec.gob.senagua.servicios.RhParametroSistemaLocal;
import ec.gob.senagua.servicios.TmpGetFotosLocal;
import ec.gob.senagua.util.CargaArchivoS;
import ec.gob.senagua.util.MenuSeguimientoPlanAmbiental;

@ManagedBean
@SessionScoped
public class MatrizSeguimientoPlanesMaControl implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4804004392734666407L;

	@EJB
	private RhMgaMatrizseguimientoplanesmaLocal rhMgaMatrizseguimientoplanesmaLocal;
	@EJB
	private RhMgaProyectoMatrizseguimientoplanesmaLocal rhMgaProyectoMatrizseguimientoplanesmaLocal;
	@EJB
	private RhParametroSistemaLocal rhParametroSistemaLocal;
	@EJB
	private TmpGetFotosLocal fotosLocal;

	private RhMgaMatrizseguimientoplanesma rhMgaMatrizseguimientoplanesma;
	private RhMgaProyectomatrizseguimientoplanesma rhMgaProyectomatrizseguimientoplanesma;
	private List<RhMgaProyectomatrizseguimientoplanesma> rhMgaProyectomatrizseguimientoplanesmalist;
	private List<RhMgaMatrizseguimientoplanesma> rhMgaMatrizseguimientoplanesmaList;
	private List<RhMgaMatrizseguimientoplanesma> rhMgaMatrizseguimientoplanesmaListTmp;
	private MenuSeguimientoPlanAmbiental menuSeguimientoPlanAmbiental;
	private CargaArchivoS cargaArchivoLicenciamientoAmbiental;
	private TmpGetFoto foto;
	private InputStream input;
	private boolean flag;
	private boolean flagUpload;
	private boolean flagCancelarUpload;
	private boolean flagDatosProyecto;
	private boolean flagWaiting;
	private Integer id;
	private ReportesControlador reportesControlador;

	@PostConstruct
	public void init() {
		rhMgaMatrizseguimientoplanesma = new RhMgaMatrizseguimientoplanesma();
		rhMgaProyectomatrizseguimientoplanesma = new RhMgaProyectomatrizseguimientoplanesma();
		rhMgaProyectomatrizseguimientoplanesmalist = new ArrayList<RhMgaProyectomatrizseguimientoplanesma>();
		rhMgaMatrizseguimientoplanesmaList = new ArrayList<RhMgaMatrizseguimientoplanesma>();
		rhMgaMatrizseguimientoplanesmaListTmp = new ArrayList<RhMgaMatrizseguimientoplanesma>();
		menuSeguimientoPlanAmbiental = new MenuSeguimientoPlanAmbiental();
		rhMgaProyectomatrizseguimientoplanesmalist = rhMgaProyectoMatrizseguimientoplanesmaLocal
				.getAll();
		foto = new TmpGetFoto();
		foto = fotosLocal.buscarCod("MCA");
		flag = false;
		flagUpload = false;
		flagCancelarUpload = false;
		cargaArchivoLicenciamientoAmbiental = new CargaArchivoS();
		flagDatosProyecto = false;
		flagWaiting = false;
		id = 0;
		reportesControlador = new ReportesControlador();
		menuSeguimientoPlanAmbiental = creaMenu();
	}

	/**
	 * Nuevo AnalisisReport
	 * */
	public void nuevo() {
		rhMgaMatrizseguimientoplanesma = new RhMgaMatrizseguimientoplanesma();
		rhMgaMatrizseguimientoplanesmaList.add(rhMgaMatrizseguimientoplanesma);

	}

	/**
	 * Parametro Sistema Menu contaminacion 129
	 * */
	private MenuSeguimientoPlanAmbiental creaMenu() {
		List<RhParametroSistema> rhParametroSistemas = new ArrayList<RhParametroSistema>();
		for (RhParametroSistema p : rhParametroSistemaLocal.getAll()) {
			if (p.getPrPadre() != null) {
				if (p.getPrPadre() == 129) {
					rhParametroSistemas.add(p);
				}
			}
		}

		for (RhParametroSistema pa : rhParametroSistemas) {

			if (pa.getPrCodigo().equals("1")) {
				menuSeguimientoPlanAmbiental.setN(pa.getPrDescripcion());
			}
			if (pa.getPrCodigo().equals("2")) {
				menuSeguimientoPlanAmbiental.setProgramasSUBPROGRAMASPMA(pa
						.getPrDescripcion());
			}
			if (pa.getPrCodigo().equals("3")) {
				menuSeguimientoPlanAmbiental.setPorcentajeCumplimiento(pa
						.getPrDescripcion());
			}
			if (pa.getPrCodigo().equals("4")) {
				menuSeguimientoPlanAmbiental.setResponsables(pa
						.getPrDescripcion());
			}
			if (pa.getPrCodigo().equals("5")) {
				menuSeguimientoPlanAmbiental.setSenagua(pa.getPrDescripcion());
			}
			if (pa.getPrCodigo().equals("6")) {
				menuSeguimientoPlanAmbiental.setContratista(pa
						.getPrDescripcion());
			}
			if (pa.getPrCodigo().equals("7")) {
				menuSeguimientoPlanAmbiental.setMediosVerificacion(pa
						.getPrDescripcion());
			}
			if (pa.getPrCodigo().equals("8")) {
				menuSeguimientoPlanAmbiental.setFechaCumplimiento(pa
						.getPrDescripcion());
			}
			if (pa.getPrCodigo().equals("9")) {
				menuSeguimientoPlanAmbiental.setAnoDoce(pa.getPrDescripcion());
			}
			if (pa.getPrCodigo().equals("10")) {
				menuSeguimientoPlanAmbiental.setAnoTrece(pa.getPrDescripcion());
			}
			if (pa.getPrCodigo().equals("11")) {
				menuSeguimientoPlanAmbiental.setObservacionOB(pa
						.getPrDescripcion());
			}
			if (pa.getPrCodigo().equals("12")) {
				menuSeguimientoPlanAmbiental.setEdicion(pa.getPrDescripcion());
			}

		}

		return menuSeguimientoPlanAmbiental;
	}

	/**
	 * Cargar Objeto
	 * **/
	public void actualizar() {
		if (rhMgaProyectomatrizseguimientoplanesma.getPmzId() == null) {
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,
					"Actualización:", "Escoja primero un proyecto..");
			FacesContext.getCurrentInstance().addMessage(null, message);
		} else {

			rhMgaMatrizseguimientoplanesmaList = new ArrayList<RhMgaMatrizseguimientoplanesma>();
			rhMgaMatrizseguimientoplanesmaList = rhMgaMatrizseguimientoplanesmaLocal
					.buscarOrdenarId(rhMgaProyectomatrizseguimientoplanesma);
		}

	}

	/**
	 * cargar Archivos
	 * */
	public void activarCargarArchivos() {
		if (rhMgaProyectomatrizseguimientoplanesma.getPmzId() == null) {
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,
					"Carga Archivos:", "Escoja primero un proyecto..");
			FacesContext.getCurrentInstance().addMessage(null, message);
		} else {
			setFlagUpload(true);
			setFlagCancelarUpload(true);
		}
	}

	/**
	 * Guardar Proyecto
	 * */
	public void guardarProyecto() {
		rhMgaProyectomatrizseguimientoplanesma = rhMgaProyectoMatrizseguimientoplanesmaLocal
				.makePersistent(rhMgaProyectomatrizseguimientoplanesma);
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,
				"Guardar Proyecto:", "Proyecto Guardado..");
		FacesContext.getCurrentInstance().addMessage(null, message);
		rhMgaProyectomatrizseguimientoplanesmalist = new ArrayList<RhMgaProyectomatrizseguimientoplanesma>();
		rhMgaProyectomatrizseguimientoplanesmalist = rhMgaProyectoMatrizseguimientoplanesmaLocal
				.getAll();

	}

	/**
	 * crear Proyecto
	 * */
	public void crearProyecto() {
		rhMgaProyectomatrizseguimientoplanesma = new RhMgaProyectomatrizseguimientoplanesma();

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
		flagWaiting = false;
		List<RhMgaMatrizseguimientoplanesma> rhMgaMatrizseguimientoplanesmasBdds = new ArrayList<RhMgaMatrizseguimientoplanesma>();
		boolean flag = false;
		if (rhMgaMatrizseguimientoplanesmaListTmp.size() == 0) {
			FacesMessage message = new FacesMessage(
					FacesMessage.SEVERITY_ERROR, "Carga Archivos",
					"Carga Excel : No Existe Datos Para Cargar...");
			FacesContext.getCurrentInstance().addMessage(null, message);
		} else {
			rhMgaMatrizseguimientoplanesmasBdds = rhMgaMatrizseguimientoplanesmaLocal
					.buscarOrdenarId(rhMgaProyectomatrizseguimientoplanesma);

			if (rhMgaMatrizseguimientoplanesmasBdds.size() == 0) {

				for (RhMgaMatrizseguimientoplanesma ma : rhMgaMatrizseguimientoplanesmaListTmp) {
					rhMgaMatrizseguimientoplanesmaLocal.makePersistent(ma);
				}
				rhMgaMatrizseguimientoplanesmaList = rhMgaMatrizseguimientoplanesmaLocal
						.buscarOrdenarId(rhMgaProyectomatrizseguimientoplanesma);
				cancelarCargarArchivos();
				flagWaiting = true;
				FacesContext.getCurrentInstance().addMessage(
						null,
						new FacesMessage(FacesMessage.SEVERITY_INFO,
								"Subir Archivo:", "Registros ingresados.."));

			} else {
				// Comparacion con nuevo Registro
				for (RhMgaMatrizseguimientoplanesma excel : rhMgaMatrizseguimientoplanesmaListTmp) {
					for (RhMgaMatrizseguimientoplanesma bdd : rhMgaMatrizseguimientoplanesmasBdds) {
						if (bdd.getMtzN().equals(excel.getMtzN())) {
							// System.out.println(bdd.getLic_proyecto());
							// System.out.println(excel.getLic_proyecto());
							duplicarObjeto(bdd, excel);
							// System.out.println(bdd.getLic_proyecto());
							// System.out.println(excel.getLic_proyecto());
							flag = true;
							System.out.println(flag);
						}
					}
					if (!flag) {
						System.out.println("objeto: no igual " + flag);
						rhMgaMatrizseguimientoplanesmasBdds.add(excel);
					}

					flag = false;

				}
				// Comparado
				for (RhMgaMatrizseguimientoplanesma bdd : rhMgaMatrizseguimientoplanesmasBdds) {
					// System.out.println("Va a la base id:" + bdd.getLicId()
					// + bdd.getLic_proyecto());
					rhMgaMatrizseguimientoplanesmaLocal.makePersistent(bdd);

				}
				rhMgaMatrizseguimientoplanesmaList = rhMgaMatrizseguimientoplanesmaLocal
						.buscarOrdenarId(rhMgaProyectomatrizseguimientoplanesma);
				cancelarCargarArchivos();
				flagWaiting = true;
				FacesContext.getCurrentInstance().addMessage(
						null,
						new FacesMessage(FacesMessage.SEVERITY_INFO,
								"Subir Archivo:", "Registros ingresados.."));

			}
		}
	}

	/**
	 * Inserta la nueva informacion en el Objeto
	 * */
	public void duplicarObjeto(RhMgaMatrizseguimientoplanesma bdd,
			RhMgaMatrizseguimientoplanesma excel) {
		bdd.setMtzN(excel.getMtzN());
		bdd.setMtzProgramasSubprogramapma(excel.getMtzProgramasSubprogramapma());
		bdd.setMtzPorcentajeCumplimiento(excel.getMtzPorcentajeCumplimiento());
		bdd.setMtzResponsablesenagua(excel.getMtzResponsablesenagua());
		bdd.setMtzResponsablecontratista(excel.getMtzResponsablecontratista());
		bdd.setMtzMediosverificacion(excel.getMtzMediosverificacion());
		bdd.setMtzAnualcumplimiento2012(excel.getMtzAnualcumplimiento2012());
		bdd.setMtzAnualcumplimiento2013(excel.getMtzAnualcumplimiento2013());
		bdd.setMtzObservacion(excel.getMtzObservacion());

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
			rhMgaMatrizseguimientoplanesmaListTmp = cargaArchivoLicenciamientoAmbiental
					.leerExcelMatrizSeguimiento(input,
							rhMgaProyectomatrizseguimientoplanesma);
		} catch (IOException e) {
			FacesMessage message = new FacesMessage(
					FacesMessage.SEVERITY_ERROR, "Carga Archivos",
					"Carga Excel : Revise el Archivo de carga");
			FacesContext.getCurrentInstance().addMessage(null, message);
		}

	}

	/**
	 * Guadar Informacion de Proyecto
	 */
	public void guardar() {
		if (rhMgaMatrizseguimientoplanesmaList.size() != 0) {
			for (RhMgaMatrizseguimientoplanesma ma : rhMgaMatrizseguimientoplanesmaList) {
				rhMgaMatrizseguimientoplanesmaLocal.makePersistent(ma);
			}
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,
					"MATRIZ DE SEGUIMIENTO:", "Informacion Guarda con Exito..");
			FacesContext.getCurrentInstance().addMessage(null, message);
			flagWaiting = true;
			rhMgaMatrizseguimientoplanesmaList = rhMgaMatrizseguimientoplanesmaLocal
					.buscarOrdenarId(rhMgaProyectomatrizseguimientoplanesma);
			flagWaiting = true;
		} else {
			FacesMessage message = new FacesMessage(
					FacesMessage.SEVERITY_ERROR, "MATRIZ DE SEGUIMIENTO:",
					"No existe Informacion para Guardar..");
			FacesContext.getCurrentInstance().addMessage(null, message);
		}
		flagWaiting = false;
	}

	public void cargaDatosProyecto() {
		if (id == 0) {
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,
					"Actualización:", "Escoja primero un proyecto..");
			FacesContext.getCurrentInstance().addMessage(null, message);
			flagDatosProyecto = false;
			rhMgaMatrizseguimientoplanesmaList = new ArrayList<RhMgaMatrizseguimientoplanesma>();
		} else {

			rhMgaProyectomatrizseguimientoplanesma = rhMgaProyectoMatrizseguimientoplanesmaLocal
					.buscarId(id);
			flagDatosProyecto = true;
			rhMgaMatrizseguimientoplanesmaList = rhMgaMatrizseguimientoplanesmaLocal
					.buscarOrdenarId(rhMgaProyectomatrizseguimientoplanesma);
		}

	}

	/**
	 * Elimina Registro
	 */
	public void eliminar() {
		rhMgaMatrizseguimientoplanesmaLocal
				.makeTransient(rhMgaMatrizseguimientoplanesma);
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,
				"Seguimiento del Plan de Manejo Ambiental:",
				"Registro eliminado con Exito..");
		FacesContext.getCurrentInstance().addMessage(null, message);
		rhMgaMatrizseguimientoplanesmaList = rhMgaMatrizseguimientoplanesmaLocal
				.buscarOrdenarId(rhMgaProyectomatrizseguimientoplanesma);

	}

	/**
	 * Elimina Registro Proyecto
	 */
	public void eliminarProyecto() {
		rhMgaProyectomatrizseguimientoplanesma = new RhMgaProyectomatrizseguimientoplanesma();
		rhMgaMatrizseguimientoplanesmaList = new ArrayList<RhMgaMatrizseguimientoplanesma>();

		if (id != 0) {
			rhMgaProyectomatrizseguimientoplanesma = rhMgaProyectoMatrizseguimientoplanesmaLocal
					.buscarId(id);
			for (RhMgaMatrizseguimientoplanesma se : rhMgaMatrizseguimientoplanesmaLocal
					.getAll()) {
				if (se.getRhMgaProyectomatrizseguimientoplanesma().getPmzId() == id) {
					rhMgaMatrizseguimientoplanesmaList.add(se);
				}
			}
			// eliminar Base de Datos
			for (RhMgaMatrizseguimientoplanesma spl : rhMgaMatrizseguimientoplanesmaList) {
				rhMgaMatrizseguimientoplanesmaLocal.makeTransient(spl);
			}
			rhMgaProyectoMatrizseguimientoplanesmaLocal
					.makeTransient(rhMgaProyectomatrizseguimientoplanesma);
			// init();
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,
					"Seguimiento del Plan de Manejo Ambiental:",
					"Registro eliminado con Exito..");
			FacesContext.getCurrentInstance().addMessage(null, message);
			flagWaiting = true;
			init();

		} else {
			FacesMessage message = new FacesMessage(
					FacesMessage.SEVERITY_ERROR,
					"Seguimiento del Plan de Manejo Ambiental:",
					"Seleccione un Proyecto para eliminar..");
			FacesContext.getCurrentInstance().addMessage(null, message);

		}

	}

	public void waiting() {
		init();
	}

	/**
	 * Descargar archivo Excel Mga_Matriz Seguimiento.jrxml
	 * */
	public StreamedContent getSelectedFileExcelMgaMatrizSeguimiento() {
		byte[] archivoExcel = null;
		archivoExcel = reportesControlador.cargarExcelMgaMatrizSeguimiento(id);
		// Set BDD
		foto.setFt_archivo(archivoExcel);
		fotosLocal.makePersistent(foto);
		// get BDD
		foto = fotosLocal.buscarCod("MCA");
		InputStream in = new ByteArrayInputStream(foto.getFt_archivo());
		return new DefaultStreamedContent(in, "doc/xls",
				"Mga_MatrizSegumiento.xls");
	}

	/**
	 * Descargar archivo PDF Mga_Matriz Seguimiento.jrxml
	 * */

	public StreamedContent getSelectedFilePdfMgaMatrizSeguimiento() {
		byte[] archivoPdf = null;
		archivoPdf = reportesControlador.cargarPdfMgaMatrizSeguimiento(id);
		// Set BDD
		foto.setFt_archivo(archivoPdf);
		fotosLocal.makePersistent(foto);
		// get BDD
		foto = fotosLocal.buscarCod("MCA");
		InputStream in = new ByteArrayInputStream(archivoPdf);
		return new DefaultStreamedContent(in, "doc/pdf",
				"Mga_MatrizSegumiento.pdf");
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

	public CargaArchivoS getCargaArchivoLicenciamientoAmbiental() {
		return cargaArchivoLicenciamientoAmbiental;
	}

	public void setCargaArchivoLicenciamientoAmbiental(
			CargaArchivoS cargaArchivoLicenciamientoAmbiental) {
		this.cargaArchivoLicenciamientoAmbiental = cargaArchivoLicenciamientoAmbiental;
	}

	public InputStream getInput() {
		return input;
	}

	public void setInput(InputStream input) {
		this.input = input;
	}

	public RhMgaMatrizseguimientoplanesma getRhMgaMatrizseguimientoplanesma() {
		return rhMgaMatrizseguimientoplanesma;
	}

	public void setRhMgaMatrizseguimientoplanesma(
			RhMgaMatrizseguimientoplanesma rhMgaMatrizseguimientoplanesma) {
		this.rhMgaMatrizseguimientoplanesma = rhMgaMatrizseguimientoplanesma;
	}

	public List<RhMgaMatrizseguimientoplanesma> getRhMgaMatrizseguimientoplanesmaList() {
		return rhMgaMatrizseguimientoplanesmaList;
	}

	public void setRhMgaMatrizseguimientoplanesmaList(
			List<RhMgaMatrizseguimientoplanesma> rhMgaMatrizseguimientoplanesmaList) {
		this.rhMgaMatrizseguimientoplanesmaList = rhMgaMatrizseguimientoplanesmaList;
	}

	public List<RhMgaMatrizseguimientoplanesma> getRhMgaMatrizseguimientoplanesmaListTmp() {
		return rhMgaMatrizseguimientoplanesmaListTmp;
	}

	public void setRhMgaMatrizseguimientoplanesmaListTmp(
			List<RhMgaMatrizseguimientoplanesma> rhMgaMatrizseguimientoplanesmaListTmp) {
		this.rhMgaMatrizseguimientoplanesmaListTmp = rhMgaMatrizseguimientoplanesmaListTmp;
	}

	public RhMgaProyectomatrizseguimientoplanesma getRhMgaProyectomatrizseguimientoplanesma() {
		return rhMgaProyectomatrizseguimientoplanesma;
	}

	public void setRhMgaProyectomatrizseguimientoplanesma(
			RhMgaProyectomatrizseguimientoplanesma rhMgaProyectomatrizseguimientoplanesma) {
		this.rhMgaProyectomatrizseguimientoplanesma = rhMgaProyectomatrizseguimientoplanesma;
	}

	public List<RhMgaProyectomatrizseguimientoplanesma> getRhMgaProyectomatrizseguimientoplanesmalist() {
		return rhMgaProyectomatrizseguimientoplanesmalist;
	}

	public void setRhMgaProyectomatrizseguimientoplanesmalist(
			List<RhMgaProyectomatrizseguimientoplanesma> rhMgaProyectomatrizseguimientoplanesmalist) {
		this.rhMgaProyectomatrizseguimientoplanesmalist = rhMgaProyectomatrizseguimientoplanesmalist;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public boolean isFlagDatosProyecto() {
		return flagDatosProyecto;
	}

	public void setFlagDatosProyecto(boolean flagDatosProyecto) {
		this.flagDatosProyecto = flagDatosProyecto;
	}

	public ReportesControlador getReportesControlador() {
		return reportesControlador;
	}

	public void setReportesControlador(ReportesControlador reportesControlador) {
		this.reportesControlador = reportesControlador;
	}

	public boolean isFlagWaiting() {
		return flagWaiting;
	}

	public void setFlagWaiting(boolean flagWaiting) {
		this.flagWaiting = flagWaiting;
	}

	public MenuSeguimientoPlanAmbiental getMenuSeguimientoPlanAmbiental() {
		return menuSeguimientoPlanAmbiental;
	}

	public void setMenuSeguimientoPlanAmbiental(
			MenuSeguimientoPlanAmbiental menuSeguimientoPlanAmbiental) {
		this.menuSeguimientoPlanAmbiental = menuSeguimientoPlanAmbiental;
	}

	public TmpGetFoto getFoto() {
		return foto;
	}

	public void setFoto(TmpGetFoto foto) {
		this.foto = foto;
	}
}
