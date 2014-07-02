package ec.gob.senagua.reportes;

import java.io.IOException;
import java.io.PrintStream;
import java.sql.Connection;
import java.sql.SQLException;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;

@ManagedBean
@SessionScoped
public class ReporteControladorInfoActores{
	 JasperPrint jasperprint;
	  private final PrintStream out1 = System.out;
	  private Connection connection;
	  
	  public void Loadpdf() throws JRException, IOException{

	        try {
	            connection = new DatasourceSenagua().getConnection();
	            FacesContext ctx = FacesContext.getCurrentInstance();
	            String path = ctx.getExternalContext().getRealPath("/") + "reportes/";


	            jasperprint = JasperFillManager.fillReport(path + "actoresSenagua.jasper", null, connection);

	            HttpServletResponse httpServletResponse = (
	            		HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext()
	            		.getResponse();
	            httpServletResponse.setContentType("application/pdf");
	            httpServletResponse.setHeader("Content-Disposition",
	                    "attachment; filename=\"Reporte_Actores_senagua.pdf\";");
	            ServletOutputStream servletOutputStream = httpServletResponse.getOutputStream();
	            JasperExportManager.exportReportToPdfStream(jasperprint, servletOutputStream);
	            ctx.getApplication().getStateManager().saveView(ctx);
	            FacesContext.getCurrentInstance().responseComplete();

	            connection.close();
	        } catch (SQLException e) {
	            out1.println(e.getMessage() + " " + e.getCause());
	        }
	    }
	  }
