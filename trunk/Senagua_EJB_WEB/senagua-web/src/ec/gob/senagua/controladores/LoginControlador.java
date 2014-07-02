package ec.gob.senagua.controladores;

import java.io.IOException;
import java.io.Serializable;
import java.security.MessageDigest;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import ec.gob.senagua.modelo.RhGlbPerfil;
import ec.gob.senagua.modelo.RhGlbUsuario;
import ec.gob.senagua.servicios.RhGlbUsuPefLocal;
import ec.gob.senagua.servicios.RhGlbUsuarioLocal;

@SessionScoped
@Named
public class LoginControlador implements Serializable {
	private static final long serialVersionUID = 7965455427888195913L;

	/*
	 * @EJB private RhGlbUsuarioLocal rhGlbUsuarioLocal;
	 */
	@EJB
	private RhGlbUsuarioLocal rhGlbUsuarioLocal;
	@EJB
	private RhGlbUsuPefLocal rhGlbUsuPefLocal;

	private String userName;
	private String password;
	private Integer perfil;
	private RhGlbUsuario rhGlbUsuario;
	private RhGlbPerfil rhGlbPerfil;

	public String entrar() {
		String retorno = "fail";
		System.out.println("USUARIO ---> " + getUserName());
		System.out.println("CLAVE ---> " + sha1(getPassword()));
		setRhGlbUsuario(rhGlbUsuarioLocal.buscarUsuario(getUserName()));
		try {
			System.out.println("CLAVE BDD ---> "
					+ rhGlbUsuario.getUsuContrasena());
			if ((rhGlbUsuario.getUsuContrasena().equals(sha1(getPassword())))) {
				// Jalar perfil desde la base
				rhGlbPerfil = rhGlbUsuPefLocal.buscarPerfilxUsuario(rhGlbUsuario);
				perfil = rhGlbPerfil.getPefCodigo();
				retorno = "success";
				System.out.println("Usuario Aceptado!! ---> "
						+ rhGlbUsuario.getUsuUsuario());
			} else {
				System.out.println("Acceso Denegado!! ---> "
						+ rhGlbUsuario.getUsuUsuario());
			}
		} catch (Exception e) {
			/*
			 * if ((getPassword().equalsIgnoreCase("admin") && getUserName()
			 * .equalsIgnoreCase("admin"))) { retorno = "success"; }
			 */
			System.out.println(e.getMessage());
			System.out.println("Usuario Desconocido!! ---> " + getUserName());
		}
		return retorno;
	}

	public boolean isLoggedIn() {
		boolean retorno = false;
		// if (rhGlbUsuarioList.get(0).getUsuCodigo() != null)
		if (rhGlbUsuario.getUsuCodigo() != 0)
			retorno = true;
		return retorno;
	}

	public void logOut() throws IOException {
		FacesContext.getCurrentInstance().getExternalContext()
				.invalidateSession();
		FacesContext.getCurrentInstance().getExternalContext()
				.redirect("../public/login.xhtml");
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
			// sha1tmp();
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

	public int getPerfil() {
		return perfil;
	}

	public void setPerfil(int perfil) {
		this.perfil = perfil;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	

	public RhGlbUsuario getRhGlbUsuario() {
		return rhGlbUsuario;
	}

	public void setRhGlbUsuario(RhGlbUsuario rhGlbUsuario) {
		this.rhGlbUsuario = rhGlbUsuario;
	}

	public RhGlbPerfil getRhGlbPerfil() {
		return rhGlbPerfil;
	}

	public void setRhGlbPerfil(RhGlbPerfil rhGlbPerfil) {
		this.rhGlbPerfil = rhGlbPerfil;
	}

}