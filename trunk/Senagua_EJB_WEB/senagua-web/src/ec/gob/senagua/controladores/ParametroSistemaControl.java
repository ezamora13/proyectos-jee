package ec.gob.senagua.controladores;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import ec.gob.senagua.modelo.RhParametroSistema;
import ec.gob.senagua.servicios.RhParametroSistemaLocal;

@ManagedBean
@SessionScoped
public class ParametroSistemaControl implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4804004392734666407L;

	@EJB
	private RhParametroSistemaLocal rhParametroSistemaLocal;

	private RhParametroSistema rhParametroSistema;

	private RhParametroSistema rhParametroSistemaMCA;

	@PostConstruct
	public void init() {
		rhParametroSistema = new RhParametroSistema();
		rhParametroSistemaMCA = new RhParametroSistema();
		rhParametroSistema = cargarParametroSigGestionAmbiental();
		rhParametroSistemaMCA = cargarParametroSigCalidadAgua();
	}

	/**
	 * Parametro sistema MGASIG GIS Gestion
	 * */
	public RhParametroSistema cargarParametroSigGestionAmbiental() {
		for (RhParametroSistema p : rhParametroSistemaLocal.getAll()) {

			if (!(p.getPrCodigo() == null)) {
				if (p.getPrCodigo().equals("MGASIG")) {
					rhParametroSistema = p;
				}
			}
		}

		return rhParametroSistema;
	}

	/**
	 * Parametro sistema MCASIG GIS Calidad
	 * */
	public RhParametroSistema cargarParametroSigCalidadAgua() {
		for (RhParametroSistema p : rhParametroSistemaLocal.getAll()) {
			if (!(p.getPrCodigo() == null)) {
				if (p.getPrCodigo().equals("MCASIG")) {
					rhParametroSistemaMCA = p;
				}
			}
		}
		return rhParametroSistemaMCA;
	}

	public RhParametroSistema getRhParametroSistema() {
		return rhParametroSistema;
	}

	public void setRhParametroSistema(RhParametroSistema rhParametroSistema) {
		this.rhParametroSistema = rhParametroSistema;
	}

	public RhParametroSistema getRhParametroSistemaMCA() {
		return rhParametroSistemaMCA;
	}

	public void setRhParametroSistemaMCA(
			RhParametroSistema rhParametroSistemaMCA) {
		this.rhParametroSistemaMCA = rhParametroSistemaMCA;
	}

}
