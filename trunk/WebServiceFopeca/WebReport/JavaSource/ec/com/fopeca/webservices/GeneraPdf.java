package ec.com.fopeca.webservices;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.jws.WebService;
import javax.servlet.ServletContext;
import javax.xml.ws.WebServiceContext;
import javax.xml.ws.handler.MessageContext;

import ec.com.fopeca.util.Reportes;

@Stateless
@WebService()
public class GeneraPdf implements GeneraPdfWS {
	@Resource
	private WebServiceContext context;
	private Reportes rpt = new Reportes();
	private String plantilla;
	private String ubicacionLogo;

	@PostConstruct
	public void init() {
		plantilla = "";
		ubicacionLogo = "";
	}

	/**
	 * Ubicacion del Archivo War en Server
	 * */
	public String realPathWar(String plantilla) {
		ServletContext servletContext = (ServletContext) context
				.getMessageContext().get(MessageContext.SERVLET_CONTEXT);
		return servletContext.getRealPath(plantilla);
	}

	@Override
	public byte[] generarPDF() {
		// TODO Auto-generated method stub
		plantilla = "/reportes/reportMysql.jrxml";
		return rpt.cargarPdfEjemplo(realPathWar(plantilla));
	}

	@Override
	public byte[] generarPdfRgen0001(String cabm_codemp, String cabm_numemo,
			String cabm_codplan, String cabm_area, String CABM_TIPOMEMO) {
		plantilla = "/reportes/MemoFopeca.jrxml";
		ubicacionLogo = "/reportes/img/logo.png";
		return rpt.CargarPdfRgen0001(realPathWar(plantilla), cabm_codemp,
				cabm_numemo, cabm_codplan, cabm_area, CABM_TIPOMEMO,
				ubicacionLogo = realPathWar(ubicacionLogo));
	}

	/**
	 * Get and Set
	 * */
	public Reportes getRpt() {
		return rpt;
	}

	public void setRpt(Reportes rpt) {
		this.rpt = rpt;
	}

	public WebServiceContext getContext() {
		return context;
	}

	public void setContext(WebServiceContext context) {
		this.context = context;
	}

	public String getPlantilla() {
		return plantilla;
	}

	public void setPlantilla(String plantilla) {
		this.plantilla = plantilla;
	}

}
