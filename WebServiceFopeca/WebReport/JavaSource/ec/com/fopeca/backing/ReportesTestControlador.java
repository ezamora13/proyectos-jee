package ec.com.fopeca.backing;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;

import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

import ec.com.fopeca.util.Datasource;

@ManagedBean
@SessionScoped
public class ReportesTestControlador implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7615600213058028099L;

	private Datasource ds;
	private byte[] archivoPdf;

	@PostConstruct
	public void init() {
		ds = new Datasource();

	}

	/**
	 * Cargar Pdf
	 * 
	 */
	public void cargarPdfMgaLicenciamientoAmbiental() {

		try {
			String reportPath = FacesContext.getCurrentInstance()
					.getExternalContext()
					.getRealPath("/reportes/reportMysql.jrxml");
			JasperReport report;
			report = JasperCompileManager.compileReport(reportPath);
			JasperPrint print = JasperFillManager.fillReport(report, null,
					ds.getConnection());
			archivoPdf = JasperExportManager.exportReportToPdf(print);
			ds.closeConnection();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	/**
	 * Descargar archivo
	 * */
	public StreamedContent getSelectedFilePdf() {
		cargarPdfMgaLicenciamientoAmbiental();
		InputStream in = new ByteArrayInputStream(archivoPdf);
		return new DefaultStreamedContent(in, "doc/pdf", "ReportExxample.pdf");
	}

	public Datasource getDs() {
		return ds;
	}

	public void setDs(Datasource ds) {
		this.ds = ds;
	}

}
