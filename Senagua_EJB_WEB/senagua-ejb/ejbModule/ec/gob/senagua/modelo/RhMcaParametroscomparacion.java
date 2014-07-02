package ec.gob.senagua.modelo;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


/**
 * The persistent class for the rh_mca_parametroscomparacion database table.
 * 
 */
@Entity
@Table(name="rh_mca_parametroscomparacion", schema = "modulos")
@SequenceGenerator(name = "modulos.rh_mca_parametroscomparacion_seq", sequenceName = "modulos.rh_mca_parametroscomparacion_seq", initialValue = 1, allocationSize = 1)
public class RhMcaParametroscomparacion implements Serializable {
	private static final long serialVersionUID = 1L;


	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "modulos.rh_mca_parametroscomparacion_seq")
	@Column(name="prm_codigo")
	private Integer prmCodigo;

	@Column(name="prm_lmptulmaagricultura")
	private Integer prmLmptulmaagricultura;

	@Column(name="prm_parametrodescripcion")
	private String prmParametrodescripcion;

	@Column(name="prm_tipo")
	private String prmTipo;

	@Column(name="prm_tipoparametro")
	private String prmTipoparametro;

	@Column(name="prm_unidad")
	private String prmUnidad;

	@Column(name="prm_valoresmax")
	private BigDecimal prmValoresmax;

	@Column(name="prm_valoresmino")
	private BigDecimal prmValoresmino;

	public RhMcaParametroscomparacion() {
	}

	public Integer getPrmCodigo() {
		return this.prmCodigo;
	}

	public void setPrmCodigo(Integer prmCodigo) {
		this.prmCodigo = prmCodigo;
	}

	public Integer getPrmLmptulmaagricultura() {
		return this.prmLmptulmaagricultura;
	}

	public void setPrmLmptulmaagricultura(Integer prmLmptulmaagricultura) {
		this.prmLmptulmaagricultura = prmLmptulmaagricultura;
	}

	public String getPrmParametrodescripcion() {
		return this.prmParametrodescripcion;
	}

	public void setPrmParametrodescripcion(String prmParametrodescripcion) {
		this.prmParametrodescripcion = prmParametrodescripcion;
	}

	public String getPrmTipo() {
		return this.prmTipo;
	}

	public void setPrmTipo(String prmTipo) {
		this.prmTipo = prmTipo;
	}

	public String getPrmTipoparametro() {
		return this.prmTipoparametro;
	}

	public void setPrmTipoparametro(String prmTipoparametro) {
		this.prmTipoparametro = prmTipoparametro;
	}

	public String getPrmUnidad() {
		return this.prmUnidad;
	}

	public void setPrmUnidad(String prmUnidad) {
		this.prmUnidad = prmUnidad;
	}

	public BigDecimal getPrmValoresmax() {
		return this.prmValoresmax;
	}

	public void setPrmValoresmax(BigDecimal prmValoresmax) {
		this.prmValoresmax = prmValoresmax;
	}

	public BigDecimal getPrmValoresmino() {
		return this.prmValoresmino;
	}

	public void setPrmValoresmino(BigDecimal prmValoresmino) {
		this.prmValoresmino = prmValoresmino;
	}

}