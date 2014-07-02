package ec.gob.senagua.controladores;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import jxl.read.biff.BiffException;

import org.apache.commons.io.IOUtils;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;
import org.primefaces.model.UploadedFile;

import ec.gob.senagua.modelo.RhMgaRegistroinformacion;
import ec.gob.senagua.servicios.RhMgaRegistroinformacionLocal;

@ManagedBean
@SessionScoped
public class RegistroInformacionControl implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4804004392734666407L;

	@EJB
	private RhMgaRegistroinformacionLocal rhMgaRegistroinformacionLocal;

	private RhMgaRegistroinformacion rhMgaRegistroinformacion;
	private List<RhMgaRegistroinformacion> rhMgaRegistroinformacionlst;
	private InputStream in;
	private UploadedFile file;
	private boolean flagWaiting;

	@PostConstruct
	public void init() {
		rhMgaRegistroinformacion = new RhMgaRegistroinformacion();
		rhMgaRegistroinformacionlst = new ArrayList<RhMgaRegistroinformacion>();
		rhMgaRegistroinformacionlst = rhMgaRegistroinformacionLocal.getAll();
		flagWaiting = false;
	}

	/**
	 * Nuevo AnalisisReport
	 * */
	public void nuevo() {
		rhMgaRegistroinformacion = new RhMgaRegistroinformacion();
		rhMgaRegistroinformacionlst.add(rhMgaRegistroinformacion);

	}

	/**
	 * Cargar Objeto
	 * **/
	public void actualizar() {
		rhMgaRegistroinformacionlst = new ArrayList<RhMgaRegistroinformacion>();
		rhMgaRegistroinformacionlst = rhMgaRegistroinformacionLocal.getAll();
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,
				"Registro de Informacion:", "Información actualizada..");
		FacesContext.getCurrentInstance().addMessage(null, message);
	}

	/**
	 * Cancelar Carga de archivos
	 */
	public void guardar() {
		if (rhMgaRegistroinformacion.getRgFechacreacion() == null) {
			Date date = new Date();
			rhMgaRegistroinformacion.setRgFechacreacion(date);
		}

		// System.out.println();
		if (rhMgaRegistroinformacion.getRgTitulo() == null
				|| rhMgaRegistroinformacion.getRgTitulo().isEmpty()
				|| rhMgaRegistroinformacion.getRgArchivo() == null) {
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_WARN,
					"Registro de Informacion",
					"Revise la informacion antes de guardar...Titulo y Archivo..");
			FacesContext.getCurrentInstance().addMessage(null, message);
		} else {
			rhMgaRegistroinformacionLocal
					.makePersistent(rhMgaRegistroinformacion);
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,
					"Registro de Informacion", "Regitro Guardar..");
			FacesContext.getCurrentInstance().addMessage(null, message);
			flagWaiting = true;
			init();
			rhMgaRegistroinformacionlst = rhMgaRegistroinformacionLocal
					.getAll();

		}

	}

	public void validarCampoObligatorio() {

	}

	/**
	 * Descargar archivo
	 * */
	public StreamedContent getSelectedFileToDownload() {
		InputStream in = new ByteArrayInputStream(
				rhMgaRegistroinformacion.getRgArchivo());
		return new DefaultStreamedContent(in, "doc/pdf", "download_senagua.pdf");
	}

	/**
	 * upload Archivo
	 * 
	 * @throws IOException
	 * @throws BiffException
	 */
	public void handleFileUpload(FileUploadEvent event) throws BiffException {

		in = null;
		try {
			in = event.getFile().getInputstream();
			rhMgaRegistroinformacion.setRgArchivo(IOUtils.toByteArray(in));
			FacesMessage msg = new FacesMessage("Archivo:", event.getFile()
					.getFileName() + " Listo para Subir..");
			FacesContext.getCurrentInstance().addMessage(null, msg);
			// flag = false;
		} catch (IOException e) {
			FacesMessage msg = new FacesMessage("Error;", event.getFile()
					.getFileName() + " No esta Listo para cargado");
			FacesContext.getCurrentInstance().addMessage(null, msg);
			e.printStackTrace();

		}

	}

	public void eliminar() {
		rhMgaRegistroinformacionLocal.makeTransient(rhMgaRegistroinformacion);
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,
				"Registro de Informacion", "Registro eliminado con Exito..");
		FacesContext.getCurrentInstance().addMessage(null, message);
		init();
		rhMgaRegistroinformacionlst = rhMgaRegistroinformacionLocal.getAll();

	}

	public void upload() {
		if (file != null) {
			FacesMessage msg = new FacesMessage("Succesful", file.getFileName()
					+ " is uploaded.");
			FacesContext.getCurrentInstance().addMessage(null, msg);
		}
	}

	public RhMgaRegistroinformacion getRhMgaRegistroinformacion() {
		return rhMgaRegistroinformacion;
	}

	public void setRhMgaRegistroinformacion(
			RhMgaRegistroinformacion rhMgaRegistroinformacion) {
		this.rhMgaRegistroinformacion = rhMgaRegistroinformacion;
	}

	public List<RhMgaRegistroinformacion> getRhMgaRegistroinformacionlst() {
		return rhMgaRegistroinformacionlst;
	}

	public void setRhMgaRegistroinformacionlst(
			List<RhMgaRegistroinformacion> rhMgaRegistroinformacionlst) {
		this.rhMgaRegistroinformacionlst = rhMgaRegistroinformacionlst;
	}

	public InputStream getIn() {
		return in;
	}

	public void setIn(InputStream in) {
		this.in = in;
	}

	public UploadedFile getFile() {
		return file;
	}

	public void setFile(UploadedFile file) {
		this.file = file;
	}

	public boolean isFlagWaiting() {
		return flagWaiting;
	}

	public void setFlagWaiting(boolean flagWaiting) {
		this.flagWaiting = flagWaiting;
	}
}
