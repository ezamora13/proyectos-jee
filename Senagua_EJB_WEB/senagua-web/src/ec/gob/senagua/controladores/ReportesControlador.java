package ec.gob.senagua.controladores;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.Serializable;
import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.export.JRPdfExporterParameter;
import net.sf.jasperreports.engine.export.JRXlsExporter;
import net.sf.jasperreports.engine.export.JRXlsExporterParameter;

import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

import ec.gob.senagua.modelo.TmpGetFoto;
import ec.gob.senagua.servicios.TmpGetFotosLocal;
import ec.gob.senagua.util.Datasource;

@ManagedBean
@SessionScoped
public class ReportesControlador implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EJB
	private TmpGetFotosLocal fotosLocal;

	private TmpGetFoto foto;
	private JasperPrint jasprint;
	private Connection conexion;
	private byte[] archivoPdf;
	private byte[] archivoExcel;
	private InputStream in;
	private StreamedContent file;
	private MatrizSeguimientoPlanesMaControl mtz;

	@PostConstruct
	private void init() {
		archivoPdf = null;
		in = null;
		archivoExcel = null;
		foto = new TmpGetFoto();
		foto = fotosLocal.buscarCod("MCA");

	}

	/**
	 * Cargar Excel Mga_Seguimiento_Plan_Manejo_Ambiental
	 * */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public byte[] cargarExcelMgaMatrizSeguimiento(Integer id) {
		try {
			conexion = new Datasource().getConnection();
			Map parameters = new HashMap();
			parameters.put("id", id);
			String reportPath = FacesContext
					.getCurrentInstance()
					.getExternalContext()
					.getRealPath(
							"/reportes/ModuloGestionAmbiental/Mga_Seguimiento_Plan_Manejo_Ambiental.jrxml");
			JasperReport report;
			report = JasperCompileManager.compileReport(reportPath);
			JasperPrint print = JasperFillManager.fillReport(report,
					parameters, conexion);
			ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
			JRXlsExporter exporterXLS = new JRXlsExporter();
			exporterXLS
					.setParameter(JRXlsExporterParameter.JASPER_PRINT, print);
			exporterXLS.setParameter(JRXlsExporterParameter.OUTPUT_STREAM,
					byteArrayOutputStream);
			exporterXLS.exportReport();
			archivoExcel = byteArrayOutputStream.toByteArray();
			return archivoExcel;

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return archivoExcel;
	}

	/**
	 * Cargar Pdf Mga_Seguimiento_Plan_Manejo_Ambiental
	 * 
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public byte[] cargarPdfMgaMatrizSeguimiento(Integer id) {

		try {
			conexion = new Datasource().getConnection();
			Map parameters = new HashMap();
			parameters.put("id", id);
			String reportPath = FacesContext
					.getCurrentInstance()
					.getExternalContext()
					.getRealPath(
							"/reportes/ModuloGestionAmbiental/Mga_Seguimiento_Plan_Manejo_Ambiental.jrxml");
			/*****************************/
			JasperReport report;
			report = JasperCompileManager.compileReport(reportPath);
			JasperPrint print = JasperFillManager.fillReport(report,
					parameters, conexion);
			ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
			// JRXlsExporter exporterXLS = new JRXlsExporter();
			JRPdfExporter exporterPDF = new JRPdfExporter();
			// exporterXLS.setParameter(JRXlsExporterParameter.JASPER_PRINT,
			// print);
			exporterPDF
					.setParameter(JRPdfExporterParameter.JASPER_PRINT, print);

			// exporterXLS.setParameter(JRXlsExporterParameter.OUTPUT_STREAM,byteArrayOutputStream);
			exporterPDF.setParameter(JRPdfExporterParameter.OUTPUT_STREAM,
					byteArrayOutputStream);

			// exporterXLS.exportReport();
			exporterPDF.exportReport();

			// archivoExcel = byteArrayOutputStream.toByteArray();
			archivoPdf = byteArrayOutputStream.toByteArray();

			// return archivoExcel;
			return archivoPdf;
			/*****************************/
			/*
			 * JasperReport report; report =
			 * JasperCompileManager.compileReport(reportPath); JasperPrint print
			 * = JasperFillManager.fillReport(report, parameters, conexion);
			 * 
			 * archivoPdf = JasperExportManager.exportReportToPdf(print);
			 */
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return archivoPdf;
	}

	/**
	 * Cargar Excel Mga_ContaminacionAmbiental
	 * */
	public void cargarExcelMgaContaminacionAmbinetal() {
		try {
			conexion = new Datasource().getConnection();
			String reportPath = FacesContext
					.getCurrentInstance()
					.getExternalContext()
					.getRealPath(
							"/reportes/ModuloGestionAmbiental/Mga_Contaminacion_Ambiental.jrxml");
			JasperReport report;
			report = JasperCompileManager.compileReport(reportPath);
			JasperPrint print = JasperFillManager.fillReport(report, null,
					conexion);
			ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
			JRXlsExporter exporterXLS = new JRXlsExporter();
			exporterXLS
					.setParameter(JRXlsExporterParameter.JASPER_PRINT, print);
			exporterXLS.setParameter(JRXlsExporterParameter.OUTPUT_STREAM,
					byteArrayOutputStream);
			exporterXLS.exportReport();
			archivoExcel = byteArrayOutputStream.toByteArray();

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	/**
	 * Cargar Pdf Mga_ContaminacionAmbiental
	 * 
	 */
	public void cargarPdfMgaContaminacionAmbiental() {
		try {
			conexion = new Datasource().getConnection();
			String reportPath = FacesContext
					.getCurrentInstance()
					.getExternalContext()
					.getRealPath(
							"/reportes/ModuloGestionAmbiental/Mga_Contaminacion_Ambiental.jrxml");
			JasperReport report;
			report = JasperCompileManager.compileReport(reportPath);
			JasperPrint print = JasperFillManager.fillReport(report, null,
					conexion);

			archivoPdf = JasperExportManager.exportReportToPdf(print);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	/**
	 * Cargar Excel Mga_Licenciamiento_Ambiental.jrxml
	 * */
	public byte[] cargarExcelMgaLicenciamientoAmbiental() {
		archivoExcel = null;
		try {
			conexion = new Datasource().getConnection();
			// Map parametros = new HashMap<>();
			// parametros.put("ZONA", parametroZona);
			// parametros.put("NUMEROFACTURA", numeroFactura);
			String reportPath = FacesContext
					.getCurrentInstance()
					.getExternalContext()
					.getRealPath(
							"/reportes/ModuloGestionAmbiental/Mga_Licenciamiento_Ambiental.jrxml");
			JasperReport report;
			report = JasperCompileManager.compileReport(reportPath);
			JasperPrint print = JasperFillManager.fillReport(report, null,
					conexion);
			ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
			JRXlsExporter exporterXLS = new JRXlsExporter();
			exporterXLS
					.setParameter(JRXlsExporterParameter.JASPER_PRINT, print);
			exporterXLS.setParameter(JRXlsExporterParameter.OUTPUT_STREAM,
					byteArrayOutputStream);
			exporterXLS.exportReport();
			archivoExcel = byteArrayOutputStream.toByteArray();
			return archivoExcel;

		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

	/**
	 * Cargar Pdf Mga_Licenciamiento_Ambiental.jrxml
	 * 
	 */
	public void cargarPdfMgaLicenciamientoAmbiental() {

		try {
			conexion = new Datasource().getConnection();
			String reportPath = FacesContext
					.getCurrentInstance()
					.getExternalContext()
					.getRealPath(
							"/reportes/ModuloGestionAmbiental/Mga_Licenciamiento_Ambiental.jrxml");
			JasperReport report;
			report = JasperCompileManager.compileReport(reportPath);
			JasperPrint print = JasperFillManager.fillReport(report, null,
					conexion);
			archivoPdf = JasperExportManager.exportReportToPdf(print);
			// Set BDD
			foto.setFt_archivo(archivoPdf);
			fotosLocal.makePersistent(foto);
			// get BDD
			foto = fotosLocal.buscarCod("MCA");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	/**
	 * Descargar archivo Excel Mga_Licenciamiento_Ambiental.jrxml
	 * */
	public StreamedContent getSelectedFileExcelMgaLicenciamientoAmbiental() {
		cargarExcelMgaLicenciamientoAmbiental();
		InputStream in = new ByteArrayInputStream(foto.getFt_archivo());
		return new DefaultStreamedContent(in, "doc/xls",
				"Mga_Licenciamiento_Ambiental.xls");
	}

	/**
	 * Descargar archivo Chunchi
	 * */
	public StreamedContent getSelectedFilePdfMgaLicenciamientoAmbiental() {
		cargarPdfMgaLicenciamientoAmbiental();
		InputStream in = new ByteArrayInputStream(foto.getFt_archivo());
		return new DefaultStreamedContent(in, "doc/pdf",
				"Mga_Licenciamiento_Ambiental.pdf");
	}

	/**
	 * Descargar archivo Excel Mga_ContaminacionLicenciamiento_Ambiental.jrxml
	 * */
	public StreamedContent getSelectedFileExcelMgaContaminacionAmbiental() {
		cargarExcelMgaContaminacionAmbinetal();
		InputStream in = new ByteArrayInputStream(archivoExcel);
		return new DefaultStreamedContent(in, "doc/xls",
				"Mga_Contaminación_Ambiental.xls");
	}

	/**
	 * Descargar archivo Chunchi
	 * */
	public StreamedContent getSelectedFilePdfMgaContaminacionAmbiental() {
		cargarPdfMgaContaminacionAmbiental();
		InputStream in = new ByteArrayInputStream(archivoPdf);
		return new DefaultStreamedContent(in, "doc/pdf",
				"Mga_Contaminación_Ambiental.pdf");
	}

	public Connection getConexion() {
		return conexion;
	}

	public void setConexion(Connection conexion) {
		this.conexion = conexion;
	}

	public byte[] getArchivoPdf() {
		return archivoPdf;
	}

	public void setArchivoPdf(byte[] archivoPdf) {
		this.archivoPdf = archivoPdf;
	}

	public byte[] getArchivoExcel() {
		return archivoExcel;
	}

	public void setArchivoExcel(byte[] archivoExcel) {
		this.archivoExcel = archivoExcel;
	}

	public InputStream getIn() {
		return in;
	}

	public void setIn(InputStream in) {
		this.in = in;
	}

	public StreamedContent getFile() {
		return file;
	}

	public void setFile(StreamedContent file) {
		this.file = file;
	}

	public JasperPrint getJasprint() {
		return jasprint;
	}

	public void setJasprint(JasperPrint jasprint) {
		this.jasprint = jasprint;
	}

	public MatrizSeguimientoPlanesMaControl getMtz() {
		return mtz;
	}

	public void setMtz(MatrizSeguimientoPlanesMaControl mtz) {
		this.mtz = mtz;
	}

	public TmpGetFoto getFoto() {
		return foto;
	}

	public void setFoto(TmpGetFoto foto) {
		this.foto = foto;
	}

}
