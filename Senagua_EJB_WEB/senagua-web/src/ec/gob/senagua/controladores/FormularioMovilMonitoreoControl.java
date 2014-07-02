package ec.gob.senagua.controladores;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import ec.gob.senagua.modelo.RhMcaMuestreo;
import ec.gob.senagua.modelo.RhTabletRegistro;
import ec.gob.senagua.servicios.RhMcaMuestreoLocal;
import ec.gob.senagua.servicios.RhTabletRegistroLocal;

@ManagedBean
@SessionScoped
public class FormularioMovilMonitoreoControl implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2619281548789897806L;

	@EJB
	private RhMcaMuestreoLocal rhMcaMuestreoLocal;
	@EJB
	private RhTabletRegistroLocal rhTabletRegistroLocal;

	private RhMcaMuestreo rhMcaMuestreo;
	private List<RhMcaMuestreo> rhMcaMuestreos;
	private List<RhTabletRegistro> rhTabletRegistros;

	private boolean flagWaiting;

	@PostConstruct
	public void init() {
		rhMcaMuestreo = new RhMcaMuestreo();
		rhMcaMuestreos = new ArrayList<RhMcaMuestreo>();
		rhTabletRegistros = new ArrayList<RhTabletRegistro>();
		rhMcaMuestreos = rhMcaMuestreoLocal.getAll();
		flagWaiting = false;

	}

	/**
	 * Permite ingresar regitros que se encuentren en la tablet BDD registro
	 * 
	 * 
	 * */
	public void anadir() {
		rhTabletRegistros = new ArrayList<RhTabletRegistro>();
		rhMcaMuestreo = new RhMcaMuestreo();
		rhTabletRegistros = rhTabletRegistroLocal.buscarRegistroParaMonitoreo();
		if (rhTabletRegistros != null) {
			for (RhTabletRegistro r : rhTabletRegistros) {
				rhMcaMuestreo.setMsCodigo("Muestreo - COD");
				rhMcaMuestreo.setRhTabletRegistro(r);
				rhMcaMuestreoLocal.makePersistent(rhMcaMuestreo);
			}
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,
					"Ficha Monitoreo:", "Datos Ingresados..");
			FacesContext.getCurrentInstance().addMessage(null, message);
			rhMcaMuestreos = rhMcaMuestreoLocal.getAll();

		} else {
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_WARN,
					"Ficha Monitoreo:", "No existe datos por ingresar..");
			FacesContext.getCurrentInstance().addMessage(null, message);

		}
	}

	public void actualizarMuestra() {
		rhMcaMuestreoLocal.makePersistent(rhMcaMuestreo);
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,
				"Ficha Monitoreo:", "Datos Ingresados..");
		FacesContext.getCurrentInstance().addMessage(null, message);
		rhMcaMuestreos = rhMcaMuestreoLocal.getAll();
	}

	/**
	 * Guarda el objeto
	 * */
	public void guardarMonitoreo() {
		try {
			System.out.println("toy aca");

			rhMcaMuestreo = rhMcaMuestreoLocal.makePersistent(rhMcaMuestreo);
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_INFO,
							"Ficha Monitoreo:", "Registro guardado .."));
			flagWaiting = true;
			rhMcaMuestreos = rhMcaMuestreoLocal.getAll();
			flagWaiting = false;

		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR,
							"Ficha Monitoreo:",
							"Problemas al guardado Registro.."));
		}

	}

	/**
	 * Guarda el objeto
	 * */
	public void guardar() {
		System.out.println("verrr");

	}

	public RhMcaMuestreo getRhMcaMuestreo() {
		return rhMcaMuestreo;
	}

	public void setRhMcaMuestreo(RhMcaMuestreo rhMcaMuestreo) {
		this.rhMcaMuestreo = rhMcaMuestreo;
	}

	public List<RhMcaMuestreo> getRhMcaMuestreos() {
		return rhMcaMuestreos;
	}

	public void setRhMcaMuestreos(List<RhMcaMuestreo> rhMcaMuestreos) {
		this.rhMcaMuestreos = rhMcaMuestreos;
	}

	public List<RhTabletRegistro> getRhTabletRegistros() {
		return rhTabletRegistros;
	}

	public void setRhTabletRegistros(List<RhTabletRegistro> rhTabletRegistros) {
		this.rhTabletRegistros = rhTabletRegistros;
	}

	public boolean isFlagWaiting() {
		return flagWaiting;
	}

	public void setFlagWaiting(boolean flagWaiting) {
		this.flagWaiting = flagWaiting;
	}

}
