package ec.gob.senagua.modelo;

import java.io.Serializable;

import javax.persistence.*;


/**
 * The persistent class for the rh_mca_parametros_normavigente database table.
 * 
 */
@Entity
@Table(name="rh_mca_parametros_normavigente" , schema = "modulos")
@SequenceGenerator(name = "modulos.rh_mca_parametros_normavigente_seq", sequenceName = "modulos.rh_mca_parametros_normavigente_seq", initialValue = 1, allocationSize = 1)
public class RhMcaParametrosNormavigente implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "modulos.rh_mca_parametros_normavigente_seq")
	@Column(name="norv_id")
	private Integer norvId;

	@Column(name="norv_anio")
	private Integer norvAnio;

	@Column(name="norv_codigo")
	private String norvCodigo;

	@Column(name="norv_codparametro")
	private String norvCodparametro;

	@Column(name="norv_codtipo")
	private String norvCodtipo;

	@Column(name="norv_estado")
	private Boolean norvEstado;

	@Column(name="norv_limitemaximopermisible")
	private String norvLimitemaximopermisible;

	@Column(name="norv_parametro")
	private String norvParametro;

	@Column(name="norv_tipo")
	private String norvTipo;

	@Column(name="norv_unidad")
	private String norvUnidad;

	public RhMcaParametrosNormavigente() {
	}

	public Integer getNorvId() {
		return this.norvId;
	}

	public void setNorvId(Integer norvId) {
		this.norvId = norvId;
	}

	public Integer getNorvAnio() {
		return this.norvAnio;
	}

	public void setNorvAnio(Integer norvAnio) {
		this.norvAnio = norvAnio;
	}

	public String getNorvCodigo() {
		return this.norvCodigo;
	}

	public void setNorvCodigo(String norvCodigo) {
		this.norvCodigo = norvCodigo;
	}

	public String getNorvCodparametro() {
		return this.norvCodparametro;
	}

	public void setNorvCodparametro(String norvCodparametro) {
		this.norvCodparametro = norvCodparametro;
	}

	public String getNorvCodtipo() {
		return this.norvCodtipo;
	}

	public void setNorvCodtipo(String norvCodtipo) {
		this.norvCodtipo = norvCodtipo;
	}

	public Boolean getNorvEstado() {
		return this.norvEstado;
	}

	public void setNorvEstado(Boolean norvEstado) {
		this.norvEstado = norvEstado;
	}

	public String getNorvLimitemaximopermisible() {
		return this.norvLimitemaximopermisible;
	}

	public void setNorvLimitemaximopermisible(String norvLimitemaximopermisible) {
		this.norvLimitemaximopermisible = norvLimitemaximopermisible;
	}

	public String getNorvParametro() {
		return this.norvParametro;
	}

	public void setNorvParametro(String norvParametro) {
		this.norvParametro = norvParametro;
	}

	public String getNorvTipo() {
		return this.norvTipo;
	}

	public void setNorvTipo(String norvTipo) {
		this.norvTipo = norvTipo;
	}

	public String getNorvUnidad() {
		return this.norvUnidad;
	}

	public void setNorvUnidad(String norvUnidad) {
		this.norvUnidad = norvUnidad;
	}

}