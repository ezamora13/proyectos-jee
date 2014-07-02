package ec.gob.senagua.modelo;

import java.io.Serializable;

import javax.persistence.*;

/**
 * The persistent class for the rh_mga_indicadorvalores database table.
 * 
 */
@Entity
@Table(name = "rh_mga_indicadorvalores", schema = "modulos")
@SequenceGenerator(name = "modulos.rh_mga_indicadorvalores_seq", sequenceName = "modulos.rh_mga_indicadorvalores_seq", initialValue = 1, allocationSize = 1)
public class RhMgaIndicadorvalore implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "modulos.rh_mga_indicadorvalores_seq")
	@Column(name = "inv_id")
	private Integer invId;

	@Column(name = "inv_descripcioparametro")
	private String invDescripcioparametro;

	@Column(name = "inv_valoractual")
	private Integer invValoractual;

	@Column(name = "inv_valoresperado")
	private Integer invValoresperado;

	@Column(name = "inv_valorreal")
	private Integer invValorreal;

	// bi-directional many-to-one association to RhMgaIndicador
	@ManyToOne
	@JoinColumn(name = "in_id")
	private RhMgaIndicador rhMgaIndicador;

	@Column(name = "inv_estado")
	private Boolean invEstado;

	public RhMgaIndicadorvalore() {
	}

	public Integer getInvId() {
		return this.invId;
	}

	public void setInvId(Integer invId) {
		this.invId = invId;
	}

	public String getInvDescripcioparametro() {
		return this.invDescripcioparametro;
	}

	public void setInvDescripcioparametro(String invDescripcioparametro) {
		this.invDescripcioparametro = invDescripcioparametro;
	}

	public Integer getInvValoractual() {
		return this.invValoractual;
	}

	public void setInvValoractual(Integer invValoractual) {
		this.invValoractual = invValoractual;
	}

	public Integer getInvValoresperado() {
		return this.invValoresperado;
	}

	public void setInvValoresperado(Integer invValoresperado) {
		this.invValoresperado = invValoresperado;
	}

	public Integer getInvValorreal() {
		return this.invValorreal;
	}

	public void setInvValorreal(Integer invValorreal) {
		this.invValorreal = invValorreal;
	}

	public RhMgaIndicador getRhMgaIndicador() {
		return this.rhMgaIndicador;
	}

	public void setRhMgaIndicador(RhMgaIndicador rhMgaIndicador) {
		this.rhMgaIndicador = rhMgaIndicador;
	}

	public Boolean getInvEstado() {
		return invEstado;
	}

	public void setInvEstado(Boolean invEstado) {
		this.invEstado = invEstado;
	}

}