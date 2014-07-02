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

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

import ec.gob.senagua.modelo.RhMgaLicenciamientoambiental;
import ec.gob.senagua.modelo.RhParametroSistema;
import ec.gob.senagua.modelo.TmpGetFoto;
import ec.gob.senagua.servicios.RhMgaLicenciamientoambientalLocal;
import ec.gob.senagua.servicios.RhParametroSistemaLocal;
import ec.gob.senagua.servicios.TmpGetFotosLocal;
import ec.gob.senagua.util.CargaArchivoS;
import ec.gob.senagua.util.MenuLicenciamientoAmbiental;

@ManagedBean
@SessionScoped
public class LicenciamientoAmbientalControl implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4804004392734666407L;

	@EJB
	private RhMgaLicenciamientoambientalLocal rhMgaLicenciamientoambientalLocal;
	@EJB
	private RhParametroSistemaLocal rhParametroSistemaLocal;
	@EJB
	private TmpGetFotosLocal fotosLocal;

	private RhMgaLicenciamientoambiental rhMgaLicenciamientoambiental;
	private List<RhMgaLicenciamientoambiental> rhMgaLicenciamientoambientalList;
	private List<RhMgaLicenciamientoambiental> rhMgaLicenciamientoambientalListTmp;
	private MenuLicenciamientoAmbiental menuLicenciamientoAmbiental;
	private CargaArchivoS cargaArchivoLicenciamientoAmbiental;
	private InputStream input;
	private boolean flag;
	private boolean flagUpload;
	private boolean flagCancelarUpload;
	private boolean flagWaiting;
	private ReportesControlador reportesControlador;
	private TmpGetFoto foto;

	@PostConstruct
	public void init() {
		rhMgaLicenciamientoambiental = new RhMgaLicenciamientoambiental();
		rhMgaLicenciamientoambientalList = new ArrayList<RhMgaLicenciamientoambiental>();
		rhMgaLicenciamientoambientalListTmp = new ArrayList<RhMgaLicenciamientoambiental>();
		menuLicenciamientoAmbiental = new MenuLicenciamientoAmbiental();
		rhMgaLicenciamientoambientalList = rhMgaLicenciamientoambientalLocal
				.buscarOrdenarId();
		flag = false;
		flagUpload = false;
		flagCancelarUpload = false;
		flagWaiting = false;
		cargaArchivoLicenciamientoAmbiental = new CargaArchivoS();
		reportesControlador = new ReportesControlador();
		foto = new TmpGetFoto();

		menuLicenciamientoAmbiental = creaMenu();
	}

	/**
	 * Parametro Sistema Menu contaminacion 142
	 * */
	private MenuLicenciamientoAmbiental creaMenu() {
		List<RhParametroSistema> rhParametroSistemas = new ArrayList<RhParametroSistema>();
		for (RhParametroSistema p : rhParametroSistemaLocal.getAll()) {
			if (p.getPrPadre() != null) {
				if (p.getPrPadre() == 142) {
					rhParametroSistemas.add(p);
				}
			}
		}

		for (RhParametroSistema pa : rhParametroSistemas) {

			if (pa.getPrCodigo().equals("1")) {
				menuLicenciamientoAmbiental.setN(pa.getPrDescripcion());
			}
			if (pa.getPrCodigo().equals("2")) {
				menuLicenciamientoAmbiental.setProyecto(pa.getPrDescripcion());
			}
			if (pa.getPrCodigo().equals("3")) {
				menuLicenciamientoAmbiental.setDemarcacionResponsable(pa
						.getPrDescripcion());
			}
			if (pa.getPrCodigo().equals("4")) {
				menuLicenciamientoAmbiental.setAutoridadAmbientalResponsable(pa
						.getPrDescripcion());
			}
			if (pa.getPrCodigo().equals("5")) {
				menuLicenciamientoAmbiental.setFaseProyecto(pa
						.getPrDescripcion());
			}
			if (pa.getPrCodigo().equals("6")) {
				menuLicenciamientoAmbiental.setCertificadointerseccion(pa
						.getPrDescripcion());
			}
			if (pa.getPrCodigo().equals("7")) {
				menuLicenciamientoAmbiental
						.setOficioSolicitudCertificadoInterseccion(pa
								.getPrDescripcion());
			}
			if (pa.getPrCodigo().equals("8")) {
				menuLicenciamientoAmbiental.setOficioCertificadoInterseccion(pa
						.getPrDescripcion());
			}
			if (pa.getPrCodigo().equals("9")) {
				menuLicenciamientoAmbiental
						.setIntersectaConAreasprotegidasSiNo(pa
								.getPrDescripcion());
			}
			if (pa.getPrCodigo().equals("10")) {
				menuLicenciamientoAmbiental.setCategorizacion(pa
						.getPrDescripcion());
			}
			if (pa.getPrCodigo().equals("11")) {
				menuLicenciamientoAmbiental
						.setOficioSolicitudCertificadoCategorizacion(pa
								.getPrDescripcion());
			}
			if (pa.getPrCodigo().equals("12")) {
				menuLicenciamientoAmbiental.setOficioCategorizacionMae(pa
						.getPrDescripcion());
			}
			if (pa.getPrCodigo().equals("13")) {
				menuLicenciamientoAmbiental.setCategoriaProyecto_abc_i(pa
						.getPrDescripcion());
			}
			if (pa.getPrCodigo().equals("14")) {
				menuLicenciamientoAmbiental.setTerminosDeReferencia(pa
						.getPrDescripcion());
			}
			if (pa.getPrCodigo().equals("15")) {
				menuLicenciamientoAmbiental
						.setOficioDeSolicitudAprobacionDetdrs(pa
								.getPrDescripcion());
			}
			if (pa.getPrCodigo().equals("16")) {
				menuLicenciamientoAmbiental.setOficioDAprobacionDlosTdrs(pa
						.getPrDescripcion());
			}
			if (pa.getPrCodigo().equals("17")) {
				menuLicenciamientoAmbiental
						.setElaboraciondelBorradorEiaFichaAmbiental(pa
								.getPrDescripcion());
			}
			if (pa.getPrCodigo().equals("18")) {
				menuLicenciamientoAmbiental
						.setConsultora(pa.getPrDescripcion());
			}
			if (pa.getPrCodigo().equals("19")) {
				menuLicenciamientoAmbiental
						.setTiempoEstimadoDeElaboracionEia_fichAmbiental(pa
								.getPrDescripcion());
			}
			if (pa.getPrCodigo().equals("20")) {
				menuLicenciamientoAmbiental.setParticipacionSocial(pa
						.getPrDescripcion());
			}
			if (pa.getPrCodigo().equals("21")) {
				menuLicenciamientoAmbiental.setSolicitudDeFacilidador(pa
						.getPrDescripcion());
			}
			if (pa.getPrCodigo().equals("22")) {
				menuLicenciamientoAmbiental
						.setRespuestaDelMaeAsolicitudDefacilitador(pa
								.getPrDescripcion());
			}
			if (pa.getPrCodigo().equals("23")) {
				menuLicenciamientoAmbiental
						.setEntregaAlMaeDelInformeDfacilitador(pa
								.getPrDescripcion());
			}
			if (pa.getPrCodigo().equals("24")) {
				menuLicenciamientoAmbiental
						.setEstudioDeImpactoAmbientalEsiaFinal(pa
								.getPrDescripcion());
			}
			if (pa.getPrCodigo().equals("25")) {
				menuLicenciamientoAmbiental
						.setEntregaDelEsiaPorParteDsenagua(pa
								.getPrDescripcion());
			}
			if (pa.getPrCodigo().equals("26")) {
				menuLicenciamientoAmbiental.setRespuestaDelmae(pa
						.getPrDescripcion());
			}
			if (pa.getPrCodigo().equals("27")) {
				menuLicenciamientoAmbiental
						.setRespuestaAobservacionesPorparteDsenagua(pa
								.getPrDescripcion());
			}

			if (pa.getPrCodigo().equals("28")) {
				menuLicenciamientoAmbiental
						.setAprobaciondelEsiaPorParteDelMae(pa
								.getPrDescripcion());
			}
			if (pa.getPrCodigo().equals("29")) {
				menuLicenciamientoAmbiental.setFaseDeEmisionDeLicencia(pa
						.getPrDescripcion());
			}
			if (pa.getPrCodigo().equals("30")) {
				menuLicenciamientoAmbiental.setPagoDeTasas(pa
						.getPrDescripcion());
			}
			if (pa.getPrCodigo().equals("31")) {
				menuLicenciamientoAmbiental.setEmisionDeLicenciAmbiental(pa
						.getPrDescripcion());
			}

		}

		return menuLicenciamientoAmbiental;
	}

	/**
	 * Nuevo AnalisisReport
	 * */
	public void nuevo() {
		rhMgaLicenciamientoambiental = new RhMgaLicenciamientoambiental();
		rhMgaLicenciamientoambientalList.add(rhMgaLicenciamientoambiental);

	}

	/**
	 * Cargar Objeto
	 * **/
	public void actualizar() {
		init();
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,
				"Licenciamiento Ambiental:", "Actualización...");
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
	 * Cancelar Carga de archivos
	 */
	public void guardarLista(ActionEvent actionEvent) {
		List<RhMgaLicenciamientoambiental> rhMgaLicenciamientoambientalBdds = new ArrayList<RhMgaLicenciamientoambiental>();

		boolean flag = false;
		if (rhMgaLicenciamientoambientalListTmp.size() == 0) {
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_WARN,
					"Subir Archivos", "Excel :No existe datos para Cargar");
			FacesContext.getCurrentInstance().addMessage(null, message);
		} else {
			rhMgaLicenciamientoambientalBdds = rhMgaLicenciamientoambientalLocal
					.getAll();
			if (rhMgaLicenciamientoambientalBdds.size() == 0) {
				for (RhMgaLicenciamientoambiental lic : rhMgaLicenciamientoambientalListTmp) {
					rhMgaLicenciamientoambientalLocal.makePersistent(lic);
				}
				FacesContext.getCurrentInstance().addMessage(
						null,
						new FacesMessage(FacesMessage.SEVERITY_INFO,
								"Subir Archivo:", "Registros ingresados.."));
				flagWaiting = true;
				init();

			} else {
				// Comparacion con nuevo Registro
				for (RhMgaLicenciamientoambiental excel : rhMgaLicenciamientoambientalListTmp) {
					for (RhMgaLicenciamientoambiental bdd : rhMgaLicenciamientoambientalBdds) {
						if (bdd.getLic_n().equals(excel.getLic_n())) {
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
						rhMgaLicenciamientoambientalBdds.add(excel);
					}

					flag = false;

				}
				// Comparado
				for (RhMgaLicenciamientoambiental bdd : rhMgaLicenciamientoambientalBdds) {
					// System.out.println("Va a la base id:" + bdd.getLicId()
					// + bdd.getLic_proyecto());
					rhMgaLicenciamientoambientalLocal.makePersistent(bdd);

				}
				FacesContext.getCurrentInstance().addMessage(
						null,
						new FacesMessage(FacesMessage.SEVERITY_INFO,
								"Subir Archivo:", "Registros ingresados.."));
				flagWaiting = true;
				init();
			}

		}

	}

	/**
	 * Inserta la nueva informacion en el Objeto
	 * */
	public void duplicarObjeto(RhMgaLicenciamientoambiental bdd,
			RhMgaLicenciamientoambiental excel) {
		bdd.setLic_n(excel.getLic_n());
		bdd.setLic_proyecto(excel.getLic_proyecto());
		bdd.setLic_demarcacionresponsable(excel.getLic_demarcacionresponsable());
		bdd.setLic_autoridadresponsable(excel.getLic_autoridadresponsable());
		bdd.setLic_faseproyecto(excel.getLic_faseproyecto());
		bdd.setLic_certificadointerseccion_oficiosolicitudcertificadointersecc(excel
				.getLic_certificadointerseccion_oficiosolicitudcertificadointersecc());
		bdd.setLic_certificadointerseccionoficiocertificadointerseccion(excel
				.getLic_certificadointerseccionoficiocertificadointerseccion());
		bdd.setLic_certificadointerseccionintersectaconareasprotegidassino(excel
				.getLic_certificadointerseccionintersectaconareasprotegidassino());
		bdd.setLic_categorizacion_oficiosolicitudcertificadoccategorizacion(excel
				.getLic_categorizacion_oficiosolicitudcertificadoccategorizacion());
		bdd.setLic_categorizacion_oficiocategorizacionmae(excel
				.getLic_categorizacion_oficiocategorizacionmae());
		bdd.setLic_categorizacion_categoriaproyecto(excel
				.getLic_categorizacion_categoriaproyecto());
		bdd.setLic_terminosreferencia_oficiosolicitudaprobaciontdrs(excel
				.getLic_terminosreferencia_oficiosolicitudaprobaciontdrs());
		bdd.setLic_terminosreferencia_oficioaprobaciontdrs(excel
				.getLic_terminosreferencia_oficioaprobaciontdrs());
		bdd.setLic_elaboracionborradoreiaficha_ambiental_consultora(excel
				.getLic_elaboracionborradoreiaficha_ambiental_consultora());
		bdd.setLic_elaboracionborradoreiaficha_ambiental_tiempoestimadoelabora(excel
				.getLic_elaboracionborradoreiaficha_ambiental_tiempoestimadoelabora());
		bdd.setLic_participacionsocial_solicitudfacilidador(excel
				.getLic_participacionsocial_solicitudfacilidador());
		bdd.setLic_participacionsocial_respuestamaesolicitudfacilitador(excel
				.getLic_participacionsocial_respuestamaesolicitudfacilitador());
		bdd.setLic_participacionsocial_entregamaeinformefacilitador(excel
				.getLic_participacionsocial_entregamaeinformefacilitador());
		bdd.setLic_estudioimpactoambientalesiafinal_entregaesiapartesenagua(excel
				.getLic_estudioimpactoambientalesiafinal_entregaesiapartesenagua());
		bdd.setLic_estudioimpactoambientalesiafinal_respuestamae(excel
				.getLic_estudioimpactoambientalesiafinal_respuestamae());
		bdd.setLic_estudioimpactoambientalesiafinal_respuestaobservacionespart(excel
				.getLic_estudioimpactoambientalesiafinal_respuestaobservacionespart());
		bdd.setLic_estudioimpactoambientalesiafinal_aprobacionesiapartemae(excel
				.getLic_estudioimpactoambientalesiafinal_aprobacionesiapartemae());
		bdd.setLic_faseemisionlicencia_pagotasas(excel
				.getLic_faseemisionlicencia_pagotasas());
		bdd.setLic_faseemisionlicencia_emisionlicenciaambiental(excel
				.getLic_faseemisionlicencia_emisionlicenciaambiental());
	}

	/**
	 * Cancelar Carga de archivos
	 */
	public void guardar() {

		for (RhMgaLicenciamientoambiental lic : rhMgaLicenciamientoambientalList) {
			rhMgaLicenciamientoambientalLocal.makePersistent(lic);
		}
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,
				"Carga Archivos", "Información se Guardó con Éxito..");
		FacesContext.getCurrentInstance().addMessage(null, message);
		init();
		rhMgaLicenciamientoambientalList = rhMgaLicenciamientoambientalLocal
				.buscarOrdenarId();

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
			rhMgaLicenciamientoambientalListTmp = cargaArchivoLicenciamientoAmbiental
					.leerExcelLicenciamientoAmbiental(input);
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
		rhMgaLicenciamientoambientalLocal
				.makeTransient(rhMgaLicenciamientoambiental);
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,
				"Licenciamiento Ambiental", "Registro eliminado con Exito..");
		FacesContext.getCurrentInstance().addMessage(null, message);
		init();
		rhMgaLicenciamientoambientalList = rhMgaLicenciamientoambientalLocal
				.getAll();

	}

	/**
	 * Elimina Todos los Registros Registro
	 */
	public void eliminarAll() {
		flagWaiting = true;
		if (rhMgaLicenciamientoambientalList.size() == 0) {
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_WARN,
							"Licenciamiento Ambienta:",
							"No existe datos para eliminar.."));
			flagWaiting = false;
		} else {
			for (RhMgaLicenciamientoambiental li : rhMgaLicenciamientoambientalList) {
				rhMgaLicenciamientoambientalLocal.makeTransient(li);
			}
			FacesContext.getCurrentInstance()
					.addMessage(
							null,
							new FacesMessage(FacesMessage.SEVERITY_INFO,
									"Licenciamiento Ambienta:",
									"Registros eliminos.."));
			init();
		}

	}

	public void postProcessXLS(Object document) {
		HSSFWorkbook wb = (HSSFWorkbook) document;
		HSSFSheet sheet = wb.getSheetAt(0);
		HSSFRow header = sheet.getRow(0);

		HSSFCellStyle cellStyle = wb.createCellStyle();
		cellStyle.setFillForegroundColor(HSSFColor.GREEN.index);
		cellStyle.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);

		for (int i = 0; i < header.getPhysicalNumberOfCells(); i++) {
			HSSFCell cell = header.getCell(i);

			cell.setCellStyle(cellStyle);
		}
	}

	/**
	 * Descargar archivo Excel Mga_Licenciamiento_Ambiental.jrxml
	 * */
	public StreamedContent getSelectedFileExcel() {
		// get BDD
		foto = fotosLocal.buscarCod("MCA");
		// set Objeto
		foto.setFt_archivo(reportesControlador
				.cargarExcelMgaLicenciamientoAmbiental());
		fotosLocal.makePersistent(foto);
		// get BDD
		foto = fotosLocal.buscarCod("MCA");
		InputStream in = new ByteArrayInputStream(foto.getFt_archivo());
		return new DefaultStreamedContent(in, "doc/xls",
				"Mga_Licenciamiento_Ambiental.xls");
	}

	public RhMgaLicenciamientoambiental getRhMgaLicenciamientoambiental() {
		return rhMgaLicenciamientoambiental;
	}

	public void setRhMgaLicenciamientoambiental(
			RhMgaLicenciamientoambiental rhMgaLicenciamientoambiental) {
		this.rhMgaLicenciamientoambiental = rhMgaLicenciamientoambiental;
	}

	public List<RhMgaLicenciamientoambiental> getRhMgaLicenciamientoambientalList() {
		return rhMgaLicenciamientoambientalList;
	}

	public void setRhMgaLicenciamientoambientalList(
			List<RhMgaLicenciamientoambiental> rhMgaLicenciamientoambientalList) {
		this.rhMgaLicenciamientoambientalList = rhMgaLicenciamientoambientalList;
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

	public List<RhMgaLicenciamientoambiental> getRhMgaLicenciamientoambientalListTmp() {
		return rhMgaLicenciamientoambientalListTmp;
	}

	public void setRhMgaLicenciamientoambientalListTmp(
			List<RhMgaLicenciamientoambiental> rhMgaLicenciamientoambientalListTmp) {
		this.rhMgaLicenciamientoambientalListTmp = rhMgaLicenciamientoambientalListTmp;
	}

	public boolean isFlagWaiting() {
		return flagWaiting;
	}

	public void setFlagWaiting(boolean flagWaiting) {
		this.flagWaiting = flagWaiting;
	}

	public MenuLicenciamientoAmbiental getMenuLicenciamientoAmbiental() {
		return menuLicenciamientoAmbiental;
	}

	public void setMenuLicenciamientoAmbiental(
			MenuLicenciamientoAmbiental menuLicenciamientoAmbiental) {
		this.menuLicenciamientoAmbiental = menuLicenciamientoAmbiental;
	}

	public ReportesControlador getReportesControlador() {
		return reportesControlador;
	}

	public void setReportesControlador(ReportesControlador reportesControlador) {
		this.reportesControlador = reportesControlador;
	}

	public TmpGetFoto getFoto() {
		return foto;
	}

	public void setFoto(TmpGetFoto foto) {
		this.foto = foto;
	}
}
