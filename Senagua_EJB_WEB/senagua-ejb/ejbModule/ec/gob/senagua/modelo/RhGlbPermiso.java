package ec.gob.senagua.modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the rh_glb_permisos database table.
 * 
 */
@Entity
@Table(name="rh_glb_permisos", schema="modulos")
@NamedQuery(name="RhGlbPermiso.findAll", query="SELECT r FROM RhGlbPermiso r")
public class RhGlbPermiso implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="per_codigo")
	private Integer perCodigo;

	@Column(name="per_id")
	private Integer perId;

	@Column(name="per_nombre")
	private String perNombre;

	//bi-directional many-to-one association to RhGlbPermisosOpcionesMenuPerfil
	@OneToMany(mappedBy="rhGlbPermiso")
	private List<RhGlbPermisosOpcionesMenuPerfil> rhGlbPermisosOpcionesMenuPerfils;

	public RhGlbPermiso() {
	}

	public Integer getPerCodigo() {
		return this.perCodigo;
	}

	public void setPerCodigo(Integer perCodigo) {
		this.perCodigo = perCodigo;
	}

	public Integer getPerId() {
		return this.perId;
	}

	public void setPerId(Integer perId) {
		this.perId = perId;
	}

	public String getPerNombre() {
		return this.perNombre;
	}

	public void setPerNombre(String perNombre) {
		this.perNombre = perNombre;
	}

	public List<RhGlbPermisosOpcionesMenuPerfil> getRhGlbPermisosOpcionesMenuPerfils() {
		return this.rhGlbPermisosOpcionesMenuPerfils;
	}

	public void setRhGlbPermisosOpcionesMenuPerfils(List<RhGlbPermisosOpcionesMenuPerfil> rhGlbPermisosOpcionesMenuPerfils) {
		this.rhGlbPermisosOpcionesMenuPerfils = rhGlbPermisosOpcionesMenuPerfils;
	}

	public RhGlbPermisosOpcionesMenuPerfil addRhGlbPermisosOpcionesMenuPerfil(RhGlbPermisosOpcionesMenuPerfil rhGlbPermisosOpcionesMenuPerfil) {
		getRhGlbPermisosOpcionesMenuPerfils().add(rhGlbPermisosOpcionesMenuPerfil);
		rhGlbPermisosOpcionesMenuPerfil.setRhGlbPermiso(this);

		return rhGlbPermisosOpcionesMenuPerfil;
	}

	public RhGlbPermisosOpcionesMenuPerfil removeRhGlbPermisosOpcionesMenuPerfil(RhGlbPermisosOpcionesMenuPerfil rhGlbPermisosOpcionesMenuPerfil) {
		getRhGlbPermisosOpcionesMenuPerfils().remove(rhGlbPermisosOpcionesMenuPerfil);
		rhGlbPermisosOpcionesMenuPerfil.setRhGlbPermiso(null);

		return rhGlbPermisosOpcionesMenuPerfil;
	}

}