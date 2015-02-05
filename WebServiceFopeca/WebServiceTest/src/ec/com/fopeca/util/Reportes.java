package ec.com.fopeca.util;

import java.io.Serializable;

import javax.faces.context.FacesContext;

import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;

public class Reportes implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2834272544198365735L;

	private Datasource ds;

	/**
	 * Cargar Pdf
	 * 
	 */
	public byte[] cargarPdfEjemplo() {

		byte[] pdf = new byte[] { 0 };
		try {
			String reportPath = FacesContext.getCurrentInstance()
					.getExternalContext()
					.getRealPath("/reportes/reportMysql.jrxml");
			JasperReport report;
			report = JasperCompileManager.compileReport(reportPath);
			JasperPrint print = JasperFillManager.fillReport(report, null,
					ds.getConnection());
			pdf = JasperExportManager.exportReportToPdf(print);
			ds.closeConnection();

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return pdf;
	}

}
