package ec.gob.senagua.modelo;

import java.io.Serializable;

import javax.persistence.*;

/**
 * The persistent class for the rh_tablet_fotos database table.
 * 
 */
@Entity
@Table(name = "rh_tablet_fotos", schema = "modulos")
@SequenceGenerator(name = "modulos.rh_tablet_fotos_seq", sequenceName = "modulos.rh_tablet_fotos_seq", initialValue = 1, allocationSize = 1)
public class RhTabletFoto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "modulos.rh_tablet_fotos_seq")
	@Column(name = "ft_id")
	private Integer ftId;

	@Column(name = "ft_descripcion")
	private String ftDescripcion;

	@Column(name = "ft_nombre")
	private String ftNombre;

	@Column(name = "ft_archivo")
	private byte[] ftArchivo;

	// bi-directional many-to-one association to RhTabletRegistro
	@ManyToOne
	@JoinColumn(name = "rg_id")
	private RhTabletRegistro rhTabletRegistro;

	public RhTabletFoto() {
	}

	public Integer getFtId() {
		return this.ftId;
	}

	public void setFtId(Integer ftId) {
		this.ftId = ftId;
	}

	public String getFtDescripcion() {
		return this.ftDescripcion;
	}

	public void setFtDescripcion(String ftDescripcion) {
		this.ftDescripcion = ftDescripcion;
	}

	public String getFtNombre() {
		return this.ftNombre;
	}

	public void setFtNombre(String ftNombre) {
		this.ftNombre = ftNombre;
	}

	public RhTabletRegistro getRhTabletRegistro() {
		return this.rhTabletRegistro;
	}

	public void setRhTabletRegistro(RhTabletRegistro rhTabletRegistro) {
		this.rhTabletRegistro = rhTabletRegistro;
	}

	public byte[] getFtArchivo() {
		return ftArchivo;
	}

	public void setFtArchivo(byte[] ftArchivo) {
		this.ftArchivo = ftArchivo;
	}

}