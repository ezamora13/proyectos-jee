package ec.gob.senagua.modelo;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * The persistent class for the rh_mca_reportelaboratorio database table.
 * 
 */
@Entity
@Table(name = "rh_mca_reportelaboratorio", schema = "modulos")
@SequenceGenerator(name = "modulos.rh_mca_reportelaboratorio_seq", sequenceName = "modulos.rh_mca_reportelaboratorio_seq", initialValue = 1, allocationSize = 1)
public class RhMcaReportelaboratorio implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "modulos.rh_mca_reportelaboratorio_seq")
	@Column(name = "rpt_id")
	private Integer rptId;

	@Column(name="rpt_cliente")
	private String rptCliente;

	@Column(name="rpt_estadoparametro")
	private String rptEstadoparametro;

	@Column(name="rpt_fecha_analisis")
	private String rptFechaAnalisis;

	@Column(name="rpt_fechaingreso")
	private String rptFechaingreso;

	@Column(name="rpt_fechamuestreo")
	private String rptFechamuestreo;

	@Column(name="rpt_grupo")
	private String rptGrupo;

	@Column(name="rpt_limite_cuantificacion")
	private String rptLimiteCuantificacion;

	@Column(name="rpt_limite_deteccion")
	private String rptLimiteDeteccion;

	@Column(name="rpt_limitemaximopermisible")
	private String rptLimitemaximopermisible;

	@Column(name="rpt_medicion")
	private String rptMedicion;

	@Column(name="rpt_metodo_referencia")
	private String rptMetodoReferencia;

	@Column(name="rpt_parametro")
	private String rptParametro;

	@Column(name="rpt_proyecto")
	private String rptProyecto;

	@Column(name="rpt_rango")
	private String rptRango;

	@Column(name="rpt_rotulacioncliente")
	private String rptRotulacioncliente;

	@Column(name="rpt_rotulaciongruentec")
	private String rptRotulaciongruentec;

	@Column(name="rpt_tipo_muestra")
	private String rptTipoMuestra;

	@Column(name="rpt_unidad")
	private String rptUnidad;

	//bi-directional many-to-one association to RhMcaComparacionreportenormalimite
	@OneToMany(mappedBy="rhMcaReportelaboratorio")
	private List<RhMcaComparacionreportenormalimite> rhMcaComparacionreportenormalimites;

	//bi-directional many-to-one association to RhMcaMuestreo
	@ManyToOne
	@JoinColumn(name="ms_id")
	private RhMcaMuestreo rhMcaMuestreo;

	public RhMcaReportelaboratorio() {
	}

	public Integer getRptId() {
		return this.rptId;
	}

	public void setRptId(Integer rptId) {
		this.rptId = rptId;
	}

	public String getRptCliente() {
		return this.rptCliente;
	}

	public void setRptCliente(String rptCliente) {
		this.rptCliente = rptCliente;
	}

	public String getRptEstadoparametro() {
		return this.rptEstadoparametro;
	}

	public void setRptEstadoparametro(String rptEstadoparametro) {
		this.rptEstadoparametro = rptEstadoparametro;
	}

	public String getRptFechaAnalisis() {
		return this.rptFechaAnalisis;
	}

	public void setRptFechaAnalisis(String rptFechaAnalisis) {
		this.rptFechaAnalisis = rptFechaAnalisis;
	}

	public String getRptFechaingreso() {
		return this.rptFechaingreso;
	}

	public void setRptFechaingreso(String rptFechaingreso) {
		this.rptFechaingreso = rptFechaingreso;
	}

	public String getRptFechamuestreo() {
		return this.rptFechamuestreo;
	}

	public void setRptFechamuestreo(String rptFechamuestreo) {
		this.rptFechamuestreo = rptFechamuestreo;
	}

	public String getRptGrupo() {
		return this.rptGrupo;
	}

	public void setRptGrupo(String rptGrupo) {
		this.rptGrupo = rptGrupo;
	}

	public String getRptLimiteCuantificacion() {
		return this.rptLimiteCuantificacion;
	}

	public void setRptLimiteCuantificacion(String rptLimiteCuantificacion) {
		this.rptLimiteCuantificacion = rptLimiteCuantificacion;
	}

	public String getRptLimiteDeteccion() {
		return this.rptLimiteDeteccion;
	}

	public void setRptLimiteDeteccion(String rptLimiteDeteccion) {
		this.rptLimiteDeteccion = rptLimiteDeteccion;
	}

	public String getRptLimitemaximopermisible() {
		return this.rptLimitemaximopermisible;
	}

	public void setRptLimitemaximopermisible(String rptLimitemaximopermisible) {
		this.rptLimitemaximopermisible = rptLimitemaximopermisible;
	}

	public String getRptMedicion() {
		return this.rptMedicion;
	}

	public void setRptMedicion(String rptMedicion) {
		this.rptMedicion = rptMedicion;
	}

	public String getRptMetodoReferencia() {
		return this.rptMetodoReferencia;
	}

	public void setRptMetodoReferencia(String rptMetodoReferencia) {
		this.rptMetodoReferencia = rptMetodoReferencia;
	}

	public String getRptParametro() {
		return this.rptParametro;
	}

	public void setRptParametro(String rptParametro) {
		this.rptParametro = rptParametro;
	}

	public String getRptProyecto() {
		return this.rptProyecto;
	}

	public void setRptProyecto(String rptProyecto) {
		this.rptProyecto = rptProyecto;
	}

	public String getRptRango() {
		return this.rptRango;
	}

	public void setRptRango(String rptRango) {
		this.rptRango = rptRango;
	}

	public String getRptRotulacioncliente() {
		return this.rptRotulacioncliente;
	}

	public void setRptRotulacioncliente(String rptRotulacioncliente) {
		this.rptRotulacioncliente = rptRotulacioncliente;
	}

	public String getRptRotulaciongruentec() {
		return this.rptRotulaciongruentec;
	}

	public void setRptRotulaciongruentec(String rptRotulaciongruentec) {
		this.rptRotulaciongruentec = rptRotulaciongruentec;
	}

	public String getRptTipoMuestra() {
		return this.rptTipoMuestra;
	}

	public void setRptTipoMuestra(String rptTipoMuestra) {
		this.rptTipoMuestra = rptTipoMuestra;
	}

	public String getRptUnidad() {
		return this.rptUnidad;
	}

	public void setRptUnidad(String rptUnidad) {
		this.rptUnidad = rptUnidad;
	}

	public List<RhMcaComparacionreportenormalimite> getRhMcaComparacionreportenormalimites() {
		return this.rhMcaComparacionreportenormalimites;
	}

	public void setRhMcaComparacionreportenormalimites(List<RhMcaComparacionreportenormalimite> rhMcaComparacionreportenormalimites) {
		this.rhMcaComparacionreportenormalimites = rhMcaComparacionreportenormalimites;
	}

	public RhMcaComparacionreportenormalimite addRhMcaComparacionreportenormalimite(RhMcaComparacionreportenormalimite rhMcaComparacionreportenormalimite) {
		getRhMcaComparacionreportenormalimites().add(rhMcaComparacionreportenormalimite);
		rhMcaComparacionreportenormalimite.setRhMcaReportelaboratorio(this);

		return rhMcaComparacionreportenormalimite;
	}

	public RhMcaComparacionreportenormalimite removeRhMcaComparacionreportenormalimite(RhMcaComparacionreportenormalimite rhMcaComparacionreportenormalimite) {
		getRhMcaComparacionreportenormalimites().remove(rhMcaComparacionreportenormalimite);
		rhMcaComparacionreportenormalimite.setRhMcaReportelaboratorio(null);

		return rhMcaComparacionreportenormalimite;
	}

	public RhMcaMuestreo getRhMcaMuestreo() {
		return this.rhMcaMuestreo;
	}

	public void setRhMcaMuestreo(RhMcaMuestreo rhMcaMuestreo) {
		this.rhMcaMuestreo = rhMcaMuestreo;
	}


	

}