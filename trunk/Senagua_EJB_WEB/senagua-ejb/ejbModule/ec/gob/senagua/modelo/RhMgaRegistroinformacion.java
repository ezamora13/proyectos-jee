package ec.gob.senagua.modelo;

import java.io.Serializable;

import javax.persistence.*;

import java.util.Date;


/**
 * The persistent class for the rh_mga_registroinformacion database table.
 * 
 */
@Entity
@Table(name="rh_mga_registroinformacion", schema = "modulos")
@SequenceGenerator(name = "modulos.rh_mga_registroinformacion_seq", sequenceName = "modulos.rh_mga_registroinformacion_seq", initialValue = 1, allocationSize = 1)
public class RhMgaRegistroinformacion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "modulos.rh_mga_registroinformacion_seq")
	@Column(name="rg_id")
	private Integer rgId;

	@Column(name="rg_archivo")
	private byte[] rgArchivo;

	@Column(name="rg_categoria")
	private String rgCategoria;

	@Column(name="rg_centrozonal")
	private String rgCentrozonal;

	@Column(name="rg_demarcacion")
	private String rgDemarcacion;

	@Temporal(TemporalType.DATE)
	@Column(name="rg_fechacreacion")
	private Date rgFechacreacion;

	@Column(name="rg_resumen")
	private String rgResumen;

	@Column(name="rg_subcategoria")
	private String rgSubcategoria;

	@Column(name="rg_titulo")
	private String rgTitulo;

	public RhMgaRegistroinformacion() {
	}

	public Integer getRgId() {
		return this.rgId;
	}

	public void setRgId(Integer rgId) {
		this.rgId = rgId;
	}

	public byte[] getRgArchivo() {
		return this.rgArchivo;
	}

	public void setRgArchivo(byte[] rgArchivo) {
		this.rgArchivo = rgArchivo;
	}

	public String getRgCategoria() {
		return this.rgCategoria;
	}

	public void setRgCategoria(String rgCategoria) {
		this.rgCategoria = rgCategoria;
	}

	public String getRgCentrozonal() {
		return this.rgCentrozonal;
	}

	public void setRgCentrozonal(String rgCentrozonal) {
		this.rgCentrozonal = rgCentrozonal;
	}

	public String getRgDemarcacion() {
		return this.rgDemarcacion;
	}

	public void setRgDemarcacion(String rgDemarcacion) {
		this.rgDemarcacion = rgDemarcacion;
	}

	public Date getRgFechacreacion() {
		return this.rgFechacreacion;
	}

	public void setRgFechacreacion(Date rgFechacreacion) {
		this.rgFechacreacion = rgFechacreacion;
	}

	public String getRgResumen() {
		return this.rgResumen;
	}

	public void setRgResumen(String rgResumen) {
		this.rgResumen = rgResumen;
	}

	public String getRgSubcategoria() {
		return this.rgSubcategoria;
	}

	public void setRgSubcategoria(String rgSubcategoria) {
		this.rgSubcategoria = rgSubcategoria;
	}

	public String getRgTitulo() {
		return this.rgTitulo;
	}

	public void setRgTitulo(String rgTitulo) {
		this.rgTitulo = rgTitulo;
	}

}