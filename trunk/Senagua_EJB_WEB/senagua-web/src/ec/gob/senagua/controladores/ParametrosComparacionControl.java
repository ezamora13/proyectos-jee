package ec.gob.senagua.controladores;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import ec.gob.senagua.modelo.RhMcaParametroscomparacion;
import ec.gob.senagua.servicios.RhMcaParametroscomparacionLocal;

@ManagedBean
@SessionScoped
public class ParametrosComparacionControl implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4804004392734666407L;

	@EJB
	private RhMcaParametroscomparacionLocal rhMcaParametroscomparacionLocal;

	private RhMcaParametroscomparacion rhMcaParametroscomparacion;
	private List<RhMcaParametroscomparacion> rhMcaParametroscomparacionlst;

	@PostConstruct
	public void init() {
		rhMcaParametroscomparacion = new RhMcaParametroscomparacion();
		rhMcaParametroscomparacionlst = new ArrayList<RhMcaParametroscomparacion>();
		rhMcaParametroscomparacionlst = rhMcaParametroscomparacionLocal
				.getAll();
	}

	/**
	 * Nuevo AnalisisReport
	 * */
	public void nuevoAnalisisReport() {
		// log.info("Nuevo Datos Poligino");
		// in_datosPoligono = new In_datosPoligono();
		// in_datosPoligonos.add(in_datosPoligono);
	}

	/**
	 * Cargar Objeto
	 * **/
	public void actualizar() {
		rhMcaParametroscomparacionlst = new ArrayList<RhMcaParametroscomparacion>();
		rhMcaParametroscomparacionlst = rhMcaParametroscomparacionLocal
				.getAll();
		// flag = false;
		// flagUpload = false;
	}

	/**
	 * cargar Archivos
	 * */
	public void cargarArchivos() {
		// flagUpload = true;
		// flagCancelarUpload = true;
	}

	/**
	 * Cancelar Carga de archivos
	 */
	public void cancelarCargarArchivos() {
		// flagUpload = false;
		// flagCancelarUpload = false;
	}

	public RhMcaParametroscomparacion getRhMcaParametroscomparacion() {
		return rhMcaParametroscomparacion;
	}

	public void setRhMcaParametroscomparacion(
			RhMcaParametroscomparacion rhMcaParametroscomparacion) {
		this.rhMcaParametroscomparacion = rhMcaParametroscomparacion;
	}

	public List<RhMcaParametroscomparacion> getRhMcaParametroscomparacionlst() {
		return rhMcaParametroscomparacionlst;
	}

	public void setRhMcaParametroscomparacionlst(
			List<RhMcaParametroscomparacion> rhMcaParametroscomparacionlst) {
		this.rhMcaParametroscomparacionlst = rhMcaParametroscomparacionlst;
	}

}
