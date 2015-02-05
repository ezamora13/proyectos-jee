package ec.com.fopeca.backing;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.Serializable;
import java.rmi.RemoteException;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.xml.rpc.ServiceException;

import org.primefaces.context.RequestContext;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

import ec.com.fopeca.webservices.CalculatorWsProxy;
import ec.com.fopeca.webservices.GeneraPdfWSProxy;

@ManagedBean
@SessionScoped
public class ReportesConsumoControlador implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7615600213058028099L;

	private byte[] archivoPdf;
	private Integer a;
	private Integer b;
	private String cabm_codemp;
	private String cabm_numemo;
	private String cabm_codplan;
	private String cabm_area;
	private String cabm_tipomemo;

	@PostConstruct
	public void init() {
		a = 0;
		b = 0;
		cabm_codemp = "";
		cabm_numemo = "";
		cabm_codplan = "";
		cabm_area = "";
		cabm_tipomemo = "";

	}

	/**
	 * Descargar archivo
	 * 
	 * @throws RemoteException
	 * @throws ServiceException
	 * */
	public StreamedContent getSelectedFilePdf() throws RemoteException,
			ServiceException {

		GeneraPdfWSProxy p = new GeneraPdfWSProxy();
		archivoPdf = p.generarPDF();

		InputStream in = new ByteArrayInputStream(archivoPdf);
		return new DefaultStreamedContent(in, "doc/pdf", "ReportExxample.pdf");
	}

	/**
	 * Descargar archivo
	 * 
	 * @throws RemoteException
	 * */
	public void getTest() throws RemoteException {

		CalculatorWsProxy p = new CalculatorWsProxy();
		a = p.getCalculatorWs().multiply(a, b);

		System.out.println(a);
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,
				"Web Service", "multiplicacion..." + a);

		RequestContext.getCurrentInstance().showMessageInDialog(message);

	}

	public void generarPdf() throws RemoteException {

		getSelectedFilePdfReport();
	}

	public StreamedContent getSelectedFilePdfReport() throws RemoteException {
		archivoPdf = new byte[] { 0 };
		GeneraPdfWSProxy p = new GeneraPdfWSProxy();
		archivoPdf = p.generarPdfRgen0001(cabm_codemp, cabm_numemo,
				cabm_codplan, cabm_area, cabm_tipomemo);

		InputStream in = new ByteArrayInputStream(archivoPdf);
		return new DefaultStreamedContent(in, "doc/pdf",
				"ReportEjemploFopeca.pdf");
	}

	public String getCabm_codemp() {
		return cabm_codemp;
	}

	public void setCabm_codemp(String cabm_codemp) {
		this.cabm_codemp = cabm_codemp;
	}

	public String getCabm_numemo() {
		return cabm_numemo;
	}

	public void setCabm_numemo(String cabm_numemo) {
		this.cabm_numemo = cabm_numemo;
	}

	public String getCabm_codplan() {
		return cabm_codplan;
	}

	public void setCabm_codplan(String cabm_codplan) {
		this.cabm_codplan = cabm_codplan;
	}

	public String getCabm_area() {
		return cabm_area;
	}

	public void setCabm_area(String cabm_area) {
		this.cabm_area = cabm_area;
	}

	public String getCabm_tipomemo() {
		return cabm_tipomemo;
	}

	public void setCabm_tipomemo(String cabm_tipomemo) {
		this.cabm_tipomemo = cabm_tipomemo;
	}

	public byte[] getArchivoPdf() {
		return archivoPdf;
	}

	public void setArchivoPdf(byte[] archivoPdf) {
		this.archivoPdf = archivoPdf;
	}

	public Integer getA() {
		return a;
	}

	public void setA(Integer a) {
		this.a = a;
	}

	public Integer getB() {
		return b;
	}

	public void setB(Integer b) {
		this.b = b;
	}

}
