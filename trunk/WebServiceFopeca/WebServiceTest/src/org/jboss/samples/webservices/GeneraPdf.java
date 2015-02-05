package org.jboss.samples.webservices;

import javax.ejb.Stateless;
import javax.jws.WebService;

import ec.com.fopeca.util.Reportes;

@Stateless
@WebService()
public class GeneraPdf implements GeneraPdfWS {

	private Reportes rpt = new Reportes();

	// @Override
	// public byte[] generarPDF() {
	// // TODO Auto-generated method stub
	// return rpt.cargarPdfEjemplo();
	// }

	public Reportes getRpt() {
		return rpt;
	}

	public void setRpt(Reportes rpt) {
		this.rpt = rpt;
	}

}
