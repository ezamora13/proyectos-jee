package ec.gob.senagua.modelo;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * The persistent class for the rh_glb_usuarios database table.
 * 
 */
@Entity
@Table(name = "rh_glb_usuarios", schema = "modulos")
@SequenceGenerator(name = "modulos.rh_glb_usuarios_usu_codigo_seq", sequenceName = "modulos.rh_glb_usuarios_usu_codigo_seq", initialValue = 1, allocationSize = 1)
public class RhGlbUsuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "usu_codigo", unique = true, nullable = false)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "modulos.rh_glb_usuarios_usu_codigo_seq")
	private Integer usuCodigo;

	@Column(name = "usu_contrasena")
	private String usuContrasena;

	@Column(name = "usu_estado")
	private Boolean usu_estado;

	@Column(name = "usu_usu_registro")
	private String usuUsuRegistro;

	@Column(name = "usu_usuario")
	private String usuUsuario;

	// bi-directional many-to-one association to RhGlbUsuPef
	@OneToMany(mappedBy = "rhGlbUsuario")
	private List<RhGlbUsuPef> rhGlbUsuPefs;

	public RhGlbUsuario() {
	}

	public Integer getUsuCodigo() {
		return this.usuCodigo;
	}

	public void setUsuCodigo(Integer usuCodigo) {
		this.usuCodigo = usuCodigo;
	}

	public String getUsuContrasena() {
		return this.usuContrasena;
	}

	public void setUsuContrasena(String usuContrasena) {
		this.usuContrasena = usuContrasena;
	}

	public String getUsuUsuRegistro() {
		return this.usuUsuRegistro;
	}

	public void setUsuUsuRegistro(String usuUsuRegistro) {
		this.usuUsuRegistro = usuUsuRegistro;
	}

	public String getUsuUsuario() {
		return this.usuUsuario;
	}

	public Boolean getUsu_estado() {
		return usu_estado;
	}

	public void setUsu_estado(Boolean usu_estado) {
		this.usu_estado = usu_estado;
	}

	public void setUsuUsuario(String usuUsuario) {
		this.usuUsuario = usuUsuario;
	}

	public List<RhGlbUsuPef> getRhGlbUsuPefs() {
		return this.rhGlbUsuPefs;
	}

	public void setRhGlbUsuPefs(List<RhGlbUsuPef> rhGlbUsuPefs) {
		this.rhGlbUsuPefs = rhGlbUsuPefs;
	}

	public RhGlbUsuPef addRhGlbUsuPef(RhGlbUsuPef rhGlbUsuPef) {
		getRhGlbUsuPefs().add(rhGlbUsuPef);
		rhGlbUsuPef.setRhGlbUsuario(this);

		return rhGlbUsuPef;
	}

	public RhGlbUsuPef removeRhGlbUsuPef(RhGlbUsuPef rhGlbUsuPef) {
		getRhGlbUsuPefs().remove(rhGlbUsuPef);
		rhGlbUsuPef.setRhGlbUsuario(null);

		return rhGlbUsuPef;
	}

}