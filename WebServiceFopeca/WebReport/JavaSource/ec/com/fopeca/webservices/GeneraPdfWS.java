package ec.com.fopeca.webservices;

import javax.jws.WebParam;
import javax.jws.WebService;

@WebService()
public interface GeneraPdfWS {

	public byte[] generarPDF();

	public byte[] generarPdfRgen0001(
			@WebParam(name = "cabm_codemp") String cabm_codemp,
			@WebParam(name = "cabm_numemo") String cabm_numemo,
			@WebParam(name = "cabm_codplan") String cabm_codplan,
			@WebParam(name = "cabm_area") String cabm_area,
			@WebParam(name = "cabm_tipomemo") String CABM_TIPOMEMO);

}
