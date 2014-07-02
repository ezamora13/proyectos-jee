package ec.gob.senagua.controladores;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import org.primefaces.context.RequestContext;

import ec.gob.senagua.modelo.RhGlbOpcionesMenu;
import ec.gob.senagua.modelo.RhGlbPerfil;
import ec.gob.senagua.modelo.RhGlbPermiso;
import ec.gob.senagua.modelo.RhGlbPermisosOpcionesMenuPerfil;
import ec.gob.senagua.servicios.RhGlbOpcionesMenuLocal;
import ec.gob.senagua.servicios.RhGlbPerfilLocal;
import ec.gob.senagua.servicios.RhGlbPermisosOpcionesMenuPerfilLocal;
import ec.gob.senagua.util.MessagesUtil;

@ViewScoped
@ManagedBean
public class PerfilControlador {

	@EJB
	private RhGlbPerfilLocal rhPerfilLocal;
	@EJB
	private RhGlbPermisosOpcionesMenuPerfilLocal rhGlbPermisosOpcionesMenuPerfilLocal;
	@EJB
	private RhGlbOpcionesMenuLocal rhGlbOpcionesMenuLocal;

	@Inject
	private LoginControlador loginUsuario;

	private RhGlbPerfil perfil;
	private List<RhGlbPerfil> perfiles = new ArrayList<RhGlbPerfil>();
	private List<RhGlbPermisosOpcionesMenuPerfil> rhGlbPermisosOpcionesMenuPerfilLst;
	private RhGlbPermisosOpcionesMenuPerfil rhGlbPermisosOpcionesMenuPerfil;
	private List<RhGlbOpcionesMenu> rhGlbOpcionesMenuLst;
	private List<String> RhGlbOpcionesMenuLstCodS;

	private List<String> opcMenu;
	private Boolean flag;

	@PostConstruct
	public void init() {
		perfiles = new ArrayList<RhGlbPerfil>();
		perfiles = rhPerfilLocal.getAll();
		rhGlbPermisosOpcionesMenuPerfilLst = new ArrayList<RhGlbPermisosOpcionesMenuPerfil>();
		rhGlbOpcionesMenuLst = new ArrayList<RhGlbOpcionesMenu>();
		RhGlbOpcionesMenuLstCodS = new ArrayList<String>();
		rhGlbPermisosOpcionesMenuPerfil = new RhGlbPermisosOpcionesMenuPerfil();
		opcMenu = new ArrayList<String>();
		flag = false;
	}

	public void preRenderView() {
		if (perfil == null) {
			perfil = new RhGlbPerfil();
		}
		perfiles = new ArrayList<RhGlbPerfil>();
		perfiles.add(perfil);
	}

	public String guardarRhGlbPerfil() {
		try {
			/*
			 * Se settea el USUARIO responsable de realizar la transaccion en la
			 * BDD el valor se toma de la session activa
			 */
			perfil.setPefUsuRegistro(loginUsuario.getUserName());
			if (perfil.getPefCodigo() != null) {
				// El usuario actualiza un perfil
				rhPerfilLocal.makePersistent(perfil);
			} else {
				// El usuario crea un nuevo perfil
				rhPerfilLocal.makePersistent(perfil);
			}
			MessagesUtil.addFlashMessage("Perfil " + perfil.getPefNombre()
					+ "guardado");
		} catch (Exception e) {
			RequestContext.getCurrentInstance().execute(
					"popup_error_formulario.show()");
		}
		RequestContext.getCurrentInstance().execute("dlg.show()");
		return "";
	}

	/**
	 * Permite Eliminar el Perfil
	 * */
	public void eliminar() {
		rhGlbPermisosOpcionesMenuPerfilLocal
				.makeTransient(rhGlbPermisosOpcionesMenuPerfil);
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,
				"Perfiles", "Registro eliminado.. Nivel de Acceso");
		FacesContext.getCurrentInstance().addMessage(null, message);
		rhGlbPermisosOpcionesMenuPerfilLst = rhGlbPermisosOpcionesMenuPerfilLocal
				.buscarXPerfil(perfil);

	}

	public String delete() {
		try {
			rhPerfilLocal.makeTransient(perfil);
		} catch (Exception e1) {
			RequestContext.getCurrentInstance().execute(
					"popup_error_eliminacion.show()");
		}
		RequestContext.getCurrentInstance().execute("popup_borrado.hide()");
		RequestContext
				.getCurrentInstance()
				.execute(
						"sendPage('null', '../private/adminSNIRH/perfil/perfil.xhtml', 'deploy');");
		return "";
	}

	public void nivelAcceso() {
		rhGlbPermisosOpcionesMenuPerfilLst = rhGlbPermisosOpcionesMenuPerfilLocal
				.buscarXPerfil(perfil);
		flag = true;

	}

	public void anadirNivelAcceso() {
		RhGlbPermisosOpcionesMenuPerfil rhGlbPermisosOpcionesMenuPerfil = new RhGlbPermisosOpcionesMenuPerfil();
		RhGlbOpcionesMenu rhGlbOpcionesMenu = new RhGlbOpcionesMenu();
		RhGlbPermiso rhGlbPermiso = new RhGlbPermiso();
		System.out.println(perfil.getPefNombre());
		if (RhGlbOpcionesMenuLstCodS.size() != 0) {
			for (String cod : RhGlbOpcionesMenuLstCodS) {
				System.out.println(cod);
				rhGlbOpcionesMenu.setOpcCodigo(Integer.valueOf(cod));
				rhGlbPermiso.setPerCodigo(1);
				rhGlbPermisosOpcionesMenuPerfil.setRhGlbPerfile(perfil);
				rhGlbPermisosOpcionesMenuPerfil
						.setRhGlbOpcionesMenu(rhGlbOpcionesMenu);
				rhGlbPermisosOpcionesMenuPerfil.setRhGlbPermiso(rhGlbPermiso);
				rhGlbPermisosOpcionesMenuPerfil.setPemEstRegistro(true);
				rhGlbPermisosOpcionesMenuPerfil.setPemUsuRegistro(loginUsuario
						.getUserName());

				rhGlbPermisosOpcionesMenuPerfilLocal
						.makePersistent(rhGlbPermisosOpcionesMenuPerfil);
				rhGlbPermisosOpcionesMenuPerfil = new RhGlbPermisosOpcionesMenuPerfil();
			}
			rhGlbOpcionesMenuLst = rhGlbOpcionesMenuLocal
					.buscarMenuFaltate(perfil.getPefCodigo());

		}

	}

	/**
	 * Añadir nuevo Usuario
	 * */
	public void anadir() {
		perfil = new RhGlbPerfil();
		perfiles.add(perfil);

	}

	public void buscarNivelAcceso() {
		rhGlbOpcionesMenuLst = rhGlbOpcionesMenuLocal.buscarMenuFaltate(perfil
				.getPefCodigo());

	}

	public String cancel() {
		return "home.xhtml?faces-redirect=true";
	}

	public RhGlbPerfil getPerfil() {
		return perfil;
	}

	public void setPerfil(RhGlbPerfil perfil) {
		this.perfil = perfil;
	}

	public List<RhGlbPerfil> getPerfiles() {
		return perfiles;
	}

	public void setPerfiles(List<RhGlbPerfil> perfiles) {
		this.perfiles = perfiles;
	}

	public RhGlbPerfilLocal getPerfilServicio() {
		return rhPerfilLocal;
	}

	public void setPerfilServicio(RhGlbPerfilLocal perfilServicio) {
		this.rhPerfilLocal = perfilServicio;
	}

	public List<RhGlbPermisosOpcionesMenuPerfil> getRhGlbPermisosOpcionesMenuPerfilLst() {
		return rhGlbPermisosOpcionesMenuPerfilLst;
	}

	public void setRhGlbPermisosOpcionesMenuPerfilLst(
			List<RhGlbPermisosOpcionesMenuPerfil> rhGlbPermisosOpcionesMenuPerfilLst) {
		this.rhGlbPermisosOpcionesMenuPerfilLst = rhGlbPermisosOpcionesMenuPerfilLst;
	}

	public Boolean getFlag() {
		return flag;
	}

	public void setFlag(Boolean flag) {
		this.flag = flag;
	}

	public List<RhGlbOpcionesMenu> getRhGlbOpcionesMenuLst() {
		return rhGlbOpcionesMenuLst;
	}

	public void setRhGlbOpcionesMenuLst(
			List<RhGlbOpcionesMenu> rhGlbOpcionesMenuLst) {
		this.rhGlbOpcionesMenuLst = rhGlbOpcionesMenuLst;
	}

	public List<String> getOpcMenu() {
		return opcMenu;
	}

	public void setOpcMenu(List<String> opcMenu) {
		this.opcMenu = opcMenu;
	}

	public List<String> getRhGlbOpcionesMenuLstCodS() {
		return RhGlbOpcionesMenuLstCodS;
	}

	public void setRhGlbOpcionesMenuLstCodS(
			List<String> rhGlbOpcionesMenuLstCodS) {
		RhGlbOpcionesMenuLstCodS = rhGlbOpcionesMenuLstCodS;
	}

	public RhGlbPermisosOpcionesMenuPerfil getRhGlbPermisosOpcionesMenuPerfil() {
		return rhGlbPermisosOpcionesMenuPerfil;
	}

	public void setRhGlbPermisosOpcionesMenuPerfil(
			RhGlbPermisosOpcionesMenuPerfil rhGlbPermisosOpcionesMenuPerfil) {
		this.rhGlbPermisosOpcionesMenuPerfil = rhGlbPermisosOpcionesMenuPerfil;
	}

}