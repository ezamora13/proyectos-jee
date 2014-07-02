package ec.gob.senagua.modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the rh_glb_opciones_menu database table.
 * 
 */
@Entity
@Table(name="rh_glb_opciones_menu", schema="modulos")
@NamedQuery(name="RhGlbOpcionesMenu.findAll", query="SELECT r FROM RhGlbOpcionesMenu r")
public class RhGlbOpcionesMenu implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="opc_codigo")
	private Integer opcCodigo;

	@Column(name="opc_id")
	private Integer opcId;

	@Column(name="opc_nombre")
	private String opcNombre;

	@Column(name="opc_url")
	private String opcUrl;

	//bi-directional many-to-one association to RhGlbPermisosOpcionesMenuPerfil
	@OneToMany(mappedBy="rhGlbOpcionesMenu")
	private List<RhGlbPermisosOpcionesMenuPerfil> rhGlbPermisosOpcionesMenuPerfils;

	public RhGlbOpcionesMenu() {
	}

	public Integer getOpcCodigo() {
		return this.opcCodigo;
	}

	public void setOpcCodigo(Integer opcCodigo) {
		this.opcCodigo = opcCodigo;
	}

	public Integer getOpcId() {
		return this.opcId;
	}

	public void setOpcId(Integer opcId) {
		this.opcId = opcId;
	}

	public String getOpcNombre() {
		return this.opcNombre;
	}

	public void setOpcNombre(String opcNombre) {
		this.opcNombre = opcNombre;
	}

	public String getOpcUrl() {
		return this.opcUrl;
	}

	public void setOpcUrl(String opcUrl) {
		this.opcUrl = opcUrl;
	}

	public List<RhGlbPermisosOpcionesMenuPerfil> getRhGlbPermisosOpcionesMenuPerfils() {
		return this.rhGlbPermisosOpcionesMenuPerfils;
	}

	public void setRhGlbPermisosOpcionesMenuPerfils(List<RhGlbPermisosOpcionesMenuPerfil> rhGlbPermisosOpcionesMenuPerfils) {
		this.rhGlbPermisosOpcionesMenuPerfils = rhGlbPermisosOpcionesMenuPerfils;
	}

	public RhGlbPermisosOpcionesMenuPerfil addRhGlbPermisosOpcionesMenuPerfil(RhGlbPermisosOpcionesMenuPerfil rhGlbPermisosOpcionesMenuPerfil) {
		getRhGlbPermisosOpcionesMenuPerfils().add(rhGlbPermisosOpcionesMenuPerfil);
		rhGlbPermisosOpcionesMenuPerfil.setRhGlbOpcionesMenu(this);

		return rhGlbPermisosOpcionesMenuPerfil;
	}

	public RhGlbPermisosOpcionesMenuPerfil removeRhGlbPermisosOpcionesMenuPerfil(RhGlbPermisosOpcionesMenuPerfil rhGlbPermisosOpcionesMenuPerfil) {
		getRhGlbPermisosOpcionesMenuPerfils().remove(rhGlbPermisosOpcionesMenuPerfil);
		rhGlbPermisosOpcionesMenuPerfil.setRhGlbOpcionesMenu(null);

		return rhGlbPermisosOpcionesMenuPerfil;
	}

}