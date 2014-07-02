package ec.gob.senagua.modelo;

import java.io.Serializable;

import javax.persistence.*;


/**
 * The persistent class for the rh_mca_parametros_limitesesperados database table.
 * 
 */
@Entity
@Table(name="rh_mca_parametros_limitesesperados" , schema = "modulos")
@SequenceGenerator(name = "modulos.rh_mca_parametros_limitesesperados_seq", sequenceName = "modulos.rh_mca_parametros_limitesesperados_seq", initialValue = 1, allocationSize = 1)
public class RhMcaParametrosLimitesesperado implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "modulos.rh_mca_parametros_limitesesperados_seq")
	@Column(name="lesp_id")
	private Integer lespId;

	@Column(name="lesp_actividad")
	private String lespActividad;

	@Column(name="lesp_anio")
	private Integer lespAnio;

	@Column(name="lesp_codactividad")
	private String lespCodactividad;

	@Column(name="lesp_coddemarcacion")
	private String lespCoddemarcacion;

	@Column(name="lesp_codigo")
	private String lespCodigo;

	@Column(name="lesp_codparametro")
	private String lespCodparametro;

	@Column(name="lesp_demarcacion")
	private String lespDemarcacion;

	@Column(name="lesp_estado")
	private Boolean lespEstado;

	@Column(name="lesp_max")
	private String lespMax;

	@Column(name="lesp_min")
	private String lespMin;

	@Column(name="lesp_parametro")
	private String lespParametro;

	@Column(name="lesp_unidad")
	private String lespUnidad;

	public RhMcaParametrosLimitesesperado() {
	}

	public Integer getLespId() {
		return this.lespId;
	}

	public void setLespId(Integer lespId) {
		this.lespId = lespId;
	}

	public String getLespActividad() {
		return this.lespActividad;
	}

	public void setLespActividad(String lespActividad) {
		this.lespActividad = lespActividad;
	}

	public Integer getLespAnio() {
		return this.lespAnio;
	}

	public void setLespAnio(Integer lespAnio) {
		this.lespAnio = lespAnio;
	}

	public String getLespCodactividad() {
		return this.lespCodactividad;
	}

	public void setLespCodactividad(String lespCodactividad) {
		this.lespCodactividad = lespCodactividad;
	}

	public String getLespCoddemarcacion() {
		return this.lespCoddemarcacion;
	}

	public void setLespCoddemarcacion(String lespCoddemarcacion) {
		this.lespCoddemarcacion = lespCoddemarcacion;
	}

	public String getLespCodigo() {
		return this.lespCodigo;
	}

	public void setLespCodigo(String lespCodigo) {
		this.lespCodigo = lespCodigo;
	}

	public String getLespCodparametro() {
		return this.lespCodparametro;
	}

	public void setLespCodparametro(String lespCodparametro) {
		this.lespCodparametro = lespCodparametro;
	}

	public String getLespDemarcacion() {
		return this.lespDemarcacion;
	}

	public void setLespDemarcacion(String lespDemarcacion) {
		this.lespDemarcacion = lespDemarcacion;
	}

	public Boolean getLespEstado() {
		return this.lespEstado;
	}

	public void setLespEstado(Boolean lespEstado) {
		this.lespEstado = lespEstado;
	}

	public String getLespMax() {
		return this.lespMax;
	}

	public void setLespMax(String lespMax) {
		this.lespMax = lespMax;
	}

	public String getLespMin() {
		return this.lespMin;
	}

	public void setLespMin(String lespMin) {
		this.lespMin = lespMin;
	}

	public String getLespParametro() {
		return this.lespParametro;
	}

	public void setLespParametro(String lespParametro) {
		this.lespParametro = lespParametro;
	}

	public String getLespUnidad() {
		return this.lespUnidad;
	}

	public void setLespUnidad(String lespUnidad) {
		this.lespUnidad = lespUnidad;
	}

}