package ec.gob.senagua.controladores;

import java.io.Serializable;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import ec.gob.senagua.modelo.RhGlbPerfil;
import ec.gob.senagua.modelo.RhGlbUsuPef;
import ec.gob.senagua.modelo.RhGlbUsuario;
import ec.gob.senagua.servicios.RhGlbPerfilLocal;
import ec.gob.senagua.servicios.RhGlbUsuPefLocal;
import ec.gob.senagua.servicios.RhGlbUsuarioLocal;

@ManagedBean
@SessionScoped
public class UsuarioControlador implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2619281548789897806L;
	// private Logger log = Logger.getLogger(UsuarioControlador.class);

	@EJB
	private RhGlbUsuarioLocal rhGlbUsuarioLocal;
	@EJB
	private RhGlbUsuPefLocal rhGlbUsuPefLocal;
	@EJB
	private RhGlbPerfilLocal rhGlbPerfilLocal;
	@Inject
	private LoginControlador loginUsuario;

	private RhGlbUsuario rhGlbUsuario;
	private RhGlbUsuPef rhGlbUsuPef;
	private RhGlbPerfil rhGlbPerfil;
	private boolean flag;

	private List<RhGlbUsuario> rhGlbUsuarios;
	private List<RhGlbPerfil> rhGlbPerfilst;

	@PostConstruct
	public void init() {
		rhGlbUsuario = new RhGlbUsuario();
		rhGlbUsuPef = new RhGlbUsuPef();
		rhGlbPerfil = new RhGlbPerfil();
		rhGlbPerfilst = new ArrayList<RhGlbPerfil>();
		flag = false;
		rhGlbUsuarios = new ArrayList<RhGlbUsuario>();
		rhGlbUsuarios = rhGlbUsuarioLocal.buscarUsuarioOrdenadoxId();
		rhGlbPerfilst = rhGlbPerfilLocal.getAll();

	}

	/**
	 * Añadir nuevo Usuario
	 * */
	public void anadir() {
		rhGlbUsuario = new RhGlbUsuario();
		rhGlbUsuarios.add(rhGlbUsuario);

	}

	/**
	 * Guardar Registro
	 * */
	public void guardar() {
		try {

			if (rhGlbUsuario.getUsuUsuario().trim().isEmpty()
					& rhGlbUsuario.getUsuUsuario().trim().isEmpty()) {
				FacesMessage message = new FacesMessage(
						FacesMessage.SEVERITY_WARN, "Usuario:",
						"Completa la informacion del Usuario ..");
				FacesContext.getCurrentInstance().addMessage(null, message);

			} else {

				if (validarUsuarioRepite(rhGlbUsuario)) {
					FacesMessage message = new FacesMessage(
							FacesMessage.SEVERITY_WARN, "Usuario:",
							"Nombre de Usuario Repetido..");
					FacesContext.getCurrentInstance().addMessage(null, message);
				} else {
					rhGlbUsuario.setUsuContrasena(sha1(rhGlbUsuario
							.getUsuContrasena()));
					rhGlbUsuario.setUsuUsuRegistro(loginUsuario.getUserName());
					rhGlbUsuarioLocal.makePersistent(rhGlbUsuario);
					rhGlbUsuarios = rhGlbUsuarioLocal
							.buscarUsuarioOrdenadoxId();
				}
			}
		} catch (Exception e) {
			FacesMessage message = new FacesMessage(
					FacesMessage.SEVERITY_ERROR, "Usuario:",
					"Registro no Guardado..");
			FacesContext.getCurrentInstance().addMessage(null, message);
		}
	}

	/**
	 * Validar Usuario
	 * */
	public boolean validarUsuarioRepite(RhGlbUsuario rhGlbUsuario) {
		boolean repetido = false;
		for (RhGlbUsuario u : rhGlbUsuarioLocal.getAll()) {
			if (u.getUsuUsuario().trim().toUpperCase()
					.equals(rhGlbUsuario.getUsuUsuario().trim().toUpperCase())) {
				if (u.getUsuCodigo().equals(rhGlbUsuario.getUsuCodigo())) {
					repetido = false;
				} else {
					repetido = true;
				}

			}
		}
		return repetido;
	}

	/**
	 * 
	 * @param clave
	 *            String que se quiere convertir
	 * @return String digerido en sha1
	 */
	private String sha1(String clave) {
		try {
			MessageDigest md = MessageDigest.getInstance("SHA1");
			md.update(clave.getBytes());
			byte[] output = md.digest();
			return bytesToHex(output);
		} catch (Exception e) {
			System.out.println("Exception: " + e);
		}
		return "";
	}

	/**
	 * 
	 * @param b
	 *            Arreglo de Bytes que quiere ser convertido a String
	 * @return String convertido
	 */
	private String bytesToHex(byte[] b) {
		char hexDigit[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
				'a', 'b', 'b', 'b', 'e', 'f' };
		StringBuffer buf = new StringBuffer();
		for (int j = 0; j < b.length; j++) {
			buf.append(hexDigit[(b[j] >> 4) & 0x0f]);
			buf.append(hexDigit[b[j] & 0x0f]);
		}
		return buf.toString();
	}

	/**
	 * Eliminar Registro Bdd
	 * */
	public void eliminarRegistro() {
		rhGlbUsuarioLocal.makeTransient(rhGlbUsuario);
		rhGlbUsuarios = new ArrayList<RhGlbUsuario>();
		rhGlbUsuarios = rhGlbUsuarioLocal.buscarUsuarioOrdenadoxId();
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,
				"Usuario:", "Registro Eliminado");
		FacesContext.getCurrentInstance().addMessage(null, message);

	}

	/**
	 * Verificar Perfil
	 * */
	public void verificarPerfil() {

			RhGlbPerfil rhGlbPerfiletmp = new RhGlbPerfil();
			rhGlbUsuPef = new RhGlbUsuPef();
			rhGlbUsuPef = rhGlbUsuPefLocal.buscarUsuPef(rhGlbUsuario);
			if (rhGlbUsuPef.getUspId() == null) {
				rhGlbUsuPef = new RhGlbUsuPef();
				rhGlbPerfiletmp.setPefNombre("No tiene Perfil");
				rhGlbUsuPef.setRhGlbPerfile(rhGlbPerfiletmp);
			}
			System.out.println(rhGlbUsuPef.getRhGlbPerfile().getPefNombre());
		
	}

	/**
	 * Activar Perfil
	 * */
	public void activarCambioPerfil() {
		flag = true;

	}

	/**
	 * Activar Perfil
	 * */
	public void guardarCambioPerfil() {
		rhGlbUsuPef.setRhGlbUsuario(rhGlbUsuario);
		rhGlbUsuPef.setRhGlbPerfile(rhGlbPerfil);
		rhGlbUsuPef = rhGlbUsuPefLocal.makePersistent(rhGlbUsuPef);
		flag = false;
		System.out.println(rhGlbPerfil.getPefCodigo());
		System.out.println(rhGlbUsuPef.getRhGlbUsuario().getUsuUsuario());

	}

	public RhGlbUsuario getRhGlbUsuario() {
		return rhGlbUsuario;
	}

	public void setRhGlbUsuario(RhGlbUsuario rhGlbUsuario) {
		this.rhGlbUsuario = rhGlbUsuario;
	}

	public List<RhGlbUsuario> getRhGlbUsuarios() {
		return rhGlbUsuarios;
	}

	public void setRhGlbUsuarios(List<RhGlbUsuario> rhGlbUsuarios) {
		this.rhGlbUsuarios = rhGlbUsuarios;
	}

	public RhGlbUsuPef getRhGlbUsuPef() {
		return rhGlbUsuPef;
	}

	public void setRhGlbUsuPef(RhGlbUsuPef rhGlbUsuPef) {
		this.rhGlbUsuPef = rhGlbUsuPef;
	}

	public boolean isFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}

	public List<RhGlbPerfil> getRhGlbPerfilst() {
		return rhGlbPerfilst;
	}

	public void setRhGlbPerfilst(List<RhGlbPerfil> rhGlbPerfilst) {
		this.rhGlbPerfilst = rhGlbPerfilst;
	}

	public RhGlbPerfil getRhGlbPerfil() {
		return rhGlbPerfil;
	}

	public void setRhGlbPerfil(RhGlbPerfil rhGlbPerfil) {
		this.rhGlbPerfil = rhGlbPerfil;
	}

}
