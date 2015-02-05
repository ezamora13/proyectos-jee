package ec.com.fopeca.util;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;

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

	@PostConstruct
	public void init() {
		ds = new Datasource();
	}

	public byte[] cargarPdfEjemplo(String realPathWar) {
		ds = new Datasource();
		System.out.println(realPathWar);
		byte[] pdf = new byte[] { 0 };
		try {

			JasperReport report;
			report = JasperCompileManager.compileReport(realPathWar);
			JasperPrint print = JasperFillManager.fillReport(report, null,
					ds.getConnection());
			pdf = JasperExportManager.exportReportToPdf(print);
			ds.closeConnection();

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return pdf;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public byte[] CargarPdfRgen0001(String realPathWar, String cabm_codemp,
			String cabm_numemo, String cabm_codplan, String cabm_area,
			String CABM_TIPOMEMO,String ubicacionLogo) {
		ds = new Datasource();
		System.out.println(realPathWar);
		byte[] pdf = new byte[] { 0 };
		try {
			Map parameters = new HashMap();
			parameters.put("cabm_codemp", cabm_codemp);
			parameters.put("cabm_numemo", cabm_numemo);
			parameters.put("cabm_codplan", cabm_codplan);
			parameters.put("cabm_area", cabm_area);
			parameters.put("CABM_TIPOMEMO", CABM_TIPOMEMO);
			parameters.put("ubicacionLogo", ubicacionLogo);
			JasperReport report;
			report = JasperCompileManager.compileReport(realPathWar);
			JasperPrint print = JasperFillManager.fillReport(report, parameters,
					ds.getConnectionOra());
			pdf = JasperExportManager.exportReportToPdf(print);
			ds.closeConnectionOra();

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return pdf;
	}

	public Datasource getDs() {
		return ds;
	}

	public void setDs(Datasource ds) {
		this.ds = ds;
	}

}
