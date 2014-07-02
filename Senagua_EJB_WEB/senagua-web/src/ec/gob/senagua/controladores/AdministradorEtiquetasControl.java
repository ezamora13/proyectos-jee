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

import ec.gob.senagua.modelo.RhParametroSistema;
import ec.gob.senagua.servicios.RhParametroSistemaLocal;

@ManagedBean
@SessionScoped
public class AdministradorEtiquetasControl implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4804004392734666407L;

	@EJB
	private RhParametroSistemaLocal rhParametroSistemaLocal;

	private RhParametroSistema rhParametroSistema;
	private List<RhParametroSistema> rhParametroSistemas;
	private List<RhParametroSistema> rhParametroSistemaMenus;
	private Integer id;
	private Boolean flag;
	private Boolean flagWaiting;

	@PostConstruct
	public void init() {
		rhParametroSistemas = new ArrayList<RhParametroSistema>();
		rhParametroSistema = new RhParametroSistema();
		flagWaiting = false;
		flag = false;
		setId(0);
		rhParametroSistemaMenus = new ArrayList<RhParametroSistema>();

		//
		cargarCommbos();

	}

	/**
	 * Carga combos de acuerdo a etiquetas
	 * 142;"Menu Licenciamiento Ambiental";"";
	 * 129;"Menu Seguimiento del Plan de Manejo Ambiental";"";
	 * 121;"Menu Contaminacion Ambiental";"";
	 * 
	 * */
	public void cargarCommbos() {
		flag = false;
		rhParametroSistemas = new ArrayList<RhParametroSistema>();
		for (RhParametroSistema p : rhParametroSistemaLocal.getAll()) {
			if (p.getPrId() == 121) {
				rhParametroSistemas.add(p);
			}
			if (p.getPrId() == 129) {
				rhParametroSistemas.add(p);
			}
			if (p.getPrId() == 142) {
				rhParametroSistemas.add(p);
			}

		}

		for (RhParametroSistema pe : rhParametroSistemas) {
			System.out.println(pe.getPrDescripcion());
		}
	}

	/**
	 * Carga Datos Menu
	 * */
	public void cargarDatosMenu() {
		flag = false;

		rhParametroSistemaMenus = new ArrayList<RhParametroSistema>();
		for (RhParametroSistema pr : rhParametroSistemaLocal.getAll()) {
			if (!(pr.getPrPadre() == null)) {
				if (pr.getPrPadre().equals(id)) {
					rhParametroSistemaMenus.add(pr);
				}
			}

		}
		if (rhParametroSistemaMenus.size() > 0) {
			flag = true;
		}

	}

	public void guardar() {
		try {
			flagWaiting = true;
			for (RhParametroSistema bdd : rhParametroSistemaMenus) {
				rhParametroSistemaLocal.makePersistent(bdd);
			}

			FacesContext.getCurrentInstance()
					.addMessage(
							null,
							new FacesMessage(FacesMessage.SEVERITY_INFO,
									"Parametrizacion Menu:",
									"Registros Actualizados.."));
			cargarDatosMenu();
			flagWaiting = false;
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR,
							"Parametrizacion Menu:",
							"Problema al Guardar Regitro.."));
		}
	}

	public List<RhParametroSistema> getRhParametroSistemas() {
		return rhParametroSistemas;
	}

	public void setRhParametroSistemas(
			List<RhParametroSistema> rhParametroSistemas) {
		this.rhParametroSistemas = rhParametroSistemas;
	}

	public RhParametroSistema getRhParametroSistema() {
		return rhParametroSistema;
	}

	public void setRhParametroSistema(RhParametroSistema rhParametroSistema) {
		this.rhParametroSistema = rhParametroSistema;
	}

	public Boolean getFlagWaiting() {
		return flagWaiting;
	}

	public void setFlagWaiting(Boolean flagWaiting) {
		this.flagWaiting = flagWaiting;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public List<RhParametroSistema> getRhParametroSistemaMenus() {
		return rhParametroSistemaMenus;
	}

	public void setRhParametroSistemaMenus(
			List<RhParametroSistema> rhParametroSistemaMenus) {
		this.rhParametroSistemaMenus = rhParametroSistemaMenus;
	}

	public Boolean getFlag() {
		return flag;
	}

	public void setFlag(Boolean flag) {
		this.flag = flag;
	}

}
