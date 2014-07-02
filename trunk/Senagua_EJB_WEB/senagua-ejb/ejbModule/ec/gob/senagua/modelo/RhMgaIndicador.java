package ec.gob.senagua.modelo;

import java.io.Serializable;

import javax.persistence.*;

import java.util.List;


/**
 * The persistent class for the rh_mga_indicador database table.
 * 
 */
@Entity
@Table(name="rh_mga_indicador", schema = "modulos")
@SequenceGenerator(name = "modulos.rh_mga_indicador_seq", sequenceName = "modulos.rh_mga_indicador_seq", initialValue = 1, allocationSize = 1)
public class RhMgaIndicador implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "modulos.rh_mga_indicador_seq")
	@Column(name="in_id")
	private Integer inId;

	@Column(name="in_demarcacion")
	private String inDemarcacion;

	@Column(name="in_detalleindicador")
	private String inDetalleindicador;

	@Column(name="in_formula")
	private String inFormula;

	@Column(name="in_periodo")
	private String inPeriodo;

	//bi-directional many-to-one association to RhMgaObjetivo
	@ManyToOne
	@JoinColumn(name="ob_id")
	private RhMgaObjetivo rhMgaObjetivo;

	//bi-directional many-to-one association to RhMgaIndicadorvalore
	@OneToMany(mappedBy="rhMgaIndicador")
	private List<RhMgaIndicadorvalore> rhMgaIndicadorvalores;

	public RhMgaIndicador() {
	}

	public Integer getInId() {
		return this.inId;
	}

	public void setInId(Integer inId) {
		this.inId = inId;
	}

	public String getInDemarcacion() {
		return this.inDemarcacion;
	}

	public void setInDemarcacion(String inDemarcacion) {
		this.inDemarcacion = inDemarcacion;
	}

	public String getInDetalleindicador() {
		return this.inDetalleindicador;
	}

	public void setInDetalleindicador(String inDetalleindicador) {
		this.inDetalleindicador = inDetalleindicador;
	}

	public String getInFormula() {
		return this.inFormula;
	}

	public void setInFormula(String inFormula) {
		this.inFormula = inFormula;
	}

	public String getInPeriodo() {
		return this.inPeriodo;
	}

	public void setInPeriodo(String inPeriodo) {
		this.inPeriodo = inPeriodo;
	}

	public RhMgaObjetivo getRhMgaObjetivo() {
		return this.rhMgaObjetivo;
	}

	public void setRhMgaObjetivo(RhMgaObjetivo rhMgaObjetivo) {
		this.rhMgaObjetivo = rhMgaObjetivo;
	}

	public List<RhMgaIndicadorvalore> getRhMgaIndicadorvalores() {
		return this.rhMgaIndicadorvalores;
	}

	public void setRhMgaIndicadorvalores(List<RhMgaIndicadorvalore> rhMgaIndicadorvalores) {
		this.rhMgaIndicadorvalores = rhMgaIndicadorvalores;
	}

	public RhMgaIndicadorvalore addRhMgaIndicadorvalore(RhMgaIndicadorvalore rhMgaIndicadorvalore) {
		getRhMgaIndicadorvalores().add(rhMgaIndicadorvalore);
		rhMgaIndicadorvalore.setRhMgaIndicador(this);

		return rhMgaIndicadorvalore;
	}

	public RhMgaIndicadorvalore removeRhMgaIndicadorvalore(RhMgaIndicadorvalore rhMgaIndicadorvalore) {
		getRhMgaIndicadorvalores().remove(rhMgaIndicadorvalore);
		rhMgaIndicadorvalore.setRhMgaIndicador(null);

		return rhMgaIndicadorvalore;
	}

}