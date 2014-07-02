package ec.gob.senagua.modelo;

import java.io.Serializable;

import javax.persistence.*;


/**
 * The persistent class for the rh_glb_usu_pef database table.
 * 
 */
@Entity
@Table(name="rh_glb_usu_pef", schema="modulos")
@SequenceGenerator(name = "modulos.rh_glb_usu_pef_seq", sequenceName = "modulos.rh_glb_usu_pef_seq", initialValue = 1, allocationSize = 1)
public class RhGlbUsuPef implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "modulos.rh_glb_usu_pef_seq")
	@Column(name="usp_id")
	private Integer uspId;

	//bi-directional many-to-one association to RhGlbPerfile
	@ManyToOne
	@JoinColumn(name="pef_codigo")
	private RhGlbPerfil rhGlbPerfile;

	//bi-directional many-to-one association to RhGlbUsuario
	@ManyToOne
	@JoinColumn(name="usu_codigo")
	private RhGlbUsuario rhGlbUsuario;

	public RhGlbUsuPef() {
	}

	public Integer getUspId() {
		return this.uspId;
	}

	public void setUspId(Integer uspId) {
		this.uspId = uspId;
	}

	public RhGlbPerfil getRhGlbPerfile() {
		return this.rhGlbPerfile;
	}

	public void setRhGlbPerfile(RhGlbPerfil rhGlbPerfile) {
		this.rhGlbPerfile = rhGlbPerfile;
	}

	public RhGlbUsuario getRhGlbUsuario() {
		return this.rhGlbUsuario;
	}

	public void setRhGlbUsuario(RhGlbUsuario rhGlbUsuario) {
		this.rhGlbUsuario = rhGlbUsuario;
	}

}