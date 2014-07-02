package ec.gob.senagua.modelo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

/**
 * The persistent class for the rh_mca_comparacionreportenormalimite database
 * table.
 * 
 */
@Entity
@Table(name = "rh_mca_comparacionreportenormalimite", schema = "modulos")
@SequenceGenerator(name = "modulos.rh_mca_comparacionreportenormalimite_seq", sequenceName = "modulos.rh_mca_comparacionreportenormalimite_seq", initialValue = 1, allocationSize = 1)
public class RhMcaComparacionreportenormalimite implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "modulos.rh_mca_comparacionreportenormalimite_seq")
	@Column(name = "cmp_id")
	private Integer cmpId;

	@Temporal(TemporalType.DATE)
	@Column(name = "cmp_fechacomparacion")
	private Date cmpFechacomparacion;

	// bi-directional many-to-one association to RhMcaParametrosLimitesesperado
	@ManyToOne
	@JoinColumn(name = "lesp_id")
	private RhMcaParametrosLimitesesperado rhMcaParametrosLimitesesperado;

	// bi-directional many-to-one association to RhMcaParametrosNormavigente
	@ManyToOne
	@JoinColumn(name = "norv_id")
	private RhMcaParametrosNormavigente rhMcaParametrosNormavigente;

	// bi-directional many-to-one association to RhMcaReportelaboratorio
	@ManyToOne
	@JoinColumn(name = "rpt_id")
	private RhMcaReportelaboratorio rhMcaReportelaboratorio;

	@Transient
	private Boolean problemaLimites;

	@Transient
	private Boolean problemaNorma;

	public RhMcaComparacionreportenormalimite() {
	}

	public Integer getCmpId() {
		return this.cmpId;
	}

	public void setCmpId(Integer cmpId) {
		this.cmpId = cmpId;
	}

	public Date getCmpFechacomparacion() {
		return cmpFechacomparacion;
	}

	public void setCmpFechacomparacion(Date cmpFechacomparacion) {
		this.cmpFechacomparacion = cmpFechacomparacion;
	}

	public RhMcaParametrosLimitesesperado getRhMcaParametrosLimitesesperado() {
		return this.rhMcaParametrosLimitesesperado;
	}

	public void setRhMcaParametrosLimitesesperado(
			RhMcaParametrosLimitesesperado rhMcaParametrosLimitesesperado) {
		this.rhMcaParametrosLimitesesperado = rhMcaParametrosLimitesesperado;
	}

	public RhMcaParametrosNormavigente getRhMcaParametrosNormavigente() {
		return this.rhMcaParametrosNormavigente;
	}

	public void setRhMcaParametrosNormavigente(
			RhMcaParametrosNormavigente rhMcaParametrosNormavigente) {
		this.rhMcaParametrosNormavigente = rhMcaParametrosNormavigente;
	}

	public RhMcaReportelaboratorio getRhMcaReportelaboratorio() {
		return this.rhMcaReportelaboratorio;
	}

	public void setRhMcaReportelaboratorio(
			RhMcaReportelaboratorio rhMcaReportelaboratorio) {
		this.rhMcaReportelaboratorio = rhMcaReportelaboratorio;
	}

	public Boolean getProblemaLimites() {
		return problemaLimites;
	}

	public void setProblemaLimites(Boolean problemaLimites) {
		this.problemaLimites = problemaLimites;
	}

	public Boolean getProblemaNorma() {
		return problemaNorma;
	}

	public void setProblemaNorma(Boolean problemaNorma) {
		this.problemaNorma = problemaNorma;
	}

}