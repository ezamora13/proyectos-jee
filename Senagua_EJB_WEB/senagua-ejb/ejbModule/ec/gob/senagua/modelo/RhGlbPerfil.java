package ec.gob.senagua.modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;

/**
 * The persistent class for the rh_glb_perfiles database table.
 * 
 */
@Entity
@Table(name = "rh_glb_perfiles", schema = "modulos")
@NamedQuery(name = "RhGlbPerfile.findAll", query = "SELECT r FROM RhGlbPerfil r")
public class RhGlbPerfil implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "pef_codigo")
	private Integer pefCodigo;

	@Column(name = "pef_estado")
	private Boolean pef_estado;

	@Column(name = "pef_nombre")
	private String pefNombre;

	@Column(name = "pef_usu_registro")
	private String pefUsuRegistro;

	// bi-directional many-to-one association to RhGlbUsuPef
	@OneToMany(mappedBy = "rhGlbPerfile")
	private List<RhGlbUsuPef> rhGlbUsuPefs;

	// bi-directional many-to-one association to RhGlbPermisosOpcionesMenuPerfil
	@OneToMany(mappedBy = "rhGlbPerfile")
	private List<RhGlbPermisosOpcionesMenuPerfil> rhGlbPermisosOpcionesMenuPerfils;

	public RhGlbPerfil() {
	}

	public Integer getPefCodigo() {
		return this.pefCodigo;
	}

	public void setPefCodigo(Integer pefCodigo) {
		this.pefCodigo = pefCodigo;
	}

	public void setPef_estado(Boolean pef_estado) {
		this.pef_estado = pef_estado;
	}

	public Boolean getPef_estado() {
		return pef_estado;
	}

	public String getPefNombre() {
		return this.pefNombre;
	}

	public void setPefNombre(String pefNombre) {
		this.pefNombre = pefNombre;
	}

	public String getPefUsuRegistro() {
		return this.pefUsuRegistro;
	}

	public void setPefUsuRegistro(String pefUsuRegistro) {
		this.pefUsuRegistro = pefUsuRegistro;
	}

	public List<RhGlbUsuPef> getRhGlbUsuPefs() {
		return this.rhGlbUsuPefs;
	}

	public void setRhGlbUsuPefs(List<RhGlbUsuPef> rhGlbUsuPefs) {
		this.rhGlbUsuPefs = rhGlbUsuPefs;
	}

	public RhGlbUsuPef addRhGlbUsuPef(RhGlbUsuPef rhGlbUsuPef) {
		getRhGlbUsuPefs().add(rhGlbUsuPef);
		rhGlbUsuPef.setRhGlbPerfile(this);

		return rhGlbUsuPef;
	}

	public RhGlbUsuPef removeRhGlbUsuPef(RhGlbUsuPef rhGlbUsuPef) {
		getRhGlbUsuPefs().remove(rhGlbUsuPef);
		rhGlbUsuPef.setRhGlbPerfile(null);

		return rhGlbUsuPef;
	}

	public List<RhGlbPermisosOpcionesMenuPerfil> getRhGlbPermisosOpcionesMenuPerfils() {
		return this.rhGlbPermisosOpcionesMenuPerfils;
	}

	public void setRhGlbPermisosOpcionesMenuPerfils(
			List<RhGlbPermisosOpcionesMenuPerfil> rhGlbPermisosOpcionesMenuPerfils) {
		this.rhGlbPermisosOpcionesMenuPerfils = rhGlbPermisosOpcionesMenuPerfils;
	}

	public RhGlbPermisosOpcionesMenuPerfil addRhGlbPermisosOpcionesMenuPerfil(
			RhGlbPermisosOpcionesMenuPerfil rhGlbPermisosOpcionesMenuPerfil) {
		getRhGlbPermisosOpcionesMenuPerfils().add(
				rhGlbPermisosOpcionesMenuPerfil);
		rhGlbPermisosOpcionesMenuPerfil.setRhGlbPerfile(this);

		return rhGlbPermisosOpcionesMenuPerfil;
	}

	public RhGlbPermisosOpcionesMenuPerfil removeRhGlbPermisosOpcionesMenuPerfil(
			RhGlbPermisosOpcionesMenuPerfil rhGlbPermisosOpcionesMenuPerfil) {
		getRhGlbPermisosOpcionesMenuPerfils().remove(
				rhGlbPermisosOpcionesMenuPerfil);
		rhGlbPermisosOpcionesMenuPerfil.setRhGlbPerfile(null);

		return rhGlbPermisosOpcionesMenuPerfil;
	}

}