package ec.gob.senagua.modelo;

import java.io.Serializable;

import javax.persistence.*;


/**
 * The persistent class for the rh_glb_permisos_opciones_menu_perfil database table.
 * 
 */
@Entity
@Table(name="rh_glb_permisos_opciones_menu_perfil", schema="modulos")
@SequenceGenerator(name = "modulos.rh_glb_permisos_opciones_menu_perfiles_pem_codigo_seq", sequenceName = "modulos.rh_glb_permisos_opciones_menu_perfiles_pem_codigo_seq", initialValue = 1, allocationSize = 1)
public class RhGlbPermisosOpcionesMenuPerfil implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "modulos.rh_glb_permisos_opciones_menu_perfiles_pem_codigo_seq")
	@Column(name="pem_codigo")
	private Integer pemCodigo;

	@Column(name="pem_estado_registro")
	private Boolean pemEstadoRegistro;

	@Column(name="pem_usu_registro")
	private String pemUsuRegistro;

	//bi-directional many-to-one association to RhGlbOpcionesMenu
	@ManyToOne
	@JoinColumn(name="opc_codigo")
	private RhGlbOpcionesMenu rhGlbOpcionesMenu;

	//bi-directional many-to-one association to RhGlbPerfile
	@ManyToOne
	@JoinColumn(name="pef_codigo")
	private RhGlbPerfil rhGlbPerfile;

	//bi-directional many-to-one association to RhGlbPermiso
	@ManyToOne
	@JoinColumn(name="per_codigo")
	private RhGlbPermiso rhGlbPermiso;

	public RhGlbPermisosOpcionesMenuPerfil() {
	}

	public Integer getPemCodigo() {
		return this.pemCodigo;
	}

	public void setPemCodigo(Integer pemCodigo) {
		this.pemCodigo = pemCodigo;
	}

	public Boolean getPemEstRegistro() {
		return this.pemEstadoRegistro;
	}

	public void setPemEstRegistro(Boolean pemEstRegistro) {
		this.pemEstadoRegistro = pemEstRegistro;
	}


	public String getPemUsuRegistro() {
		return this.pemUsuRegistro;
	}

	public void setPemUsuRegistro(String pemUsuRegistro) {
		this.pemUsuRegistro = pemUsuRegistro;
	}

	public RhGlbOpcionesMenu getRhGlbOpcionesMenu() {
		return this.rhGlbOpcionesMenu;
	}

	public void setRhGlbOpcionesMenu(RhGlbOpcionesMenu rhGlbOpcionesMenu) {
		this.rhGlbOpcionesMenu = rhGlbOpcionesMenu;
	}

	public RhGlbPerfil getRhGlbPerfile() {
		return this.rhGlbPerfile;
	}

	public void setRhGlbPerfile(RhGlbPerfil rhGlbPerfile) {
		this.rhGlbPerfile = rhGlbPerfile;
	}

	public RhGlbPermiso getRhGlbPermiso() {
		return this.rhGlbPermiso;
	}

	public void setRhGlbPermiso(RhGlbPermiso rhGlbPermiso) {
		this.rhGlbPermiso = rhGlbPermiso;
	}

}