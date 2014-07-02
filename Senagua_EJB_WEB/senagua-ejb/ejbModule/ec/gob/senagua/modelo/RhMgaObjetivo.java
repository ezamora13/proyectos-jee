package ec.gob.senagua.modelo;

import java.io.Serializable;

import javax.persistence.*;

import java.util.List;


/**
 * The persistent class for the rh_mga_objetivo database table.
 * 
 */
@Entity
@Table(name="rh_mga_objetivo", schema = "modulos")
@SequenceGenerator(name = "modulos.rh_mga_objetivo_seq", sequenceName = "modulos.rh_mga_objetivo_seq", initialValue = 1, allocationSize = 1)
public class RhMgaObjetivo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "modulos.rh_mga_objetivo_seq")
	@Column(name="ob_id")
	private Integer obId;

	@Column(name="ob_nombre")
	private String obNombre;

	//bi-directional many-to-one association to RhMgaIndicador
	@OneToMany(mappedBy="rhMgaObjetivo")
	private List<RhMgaIndicador> rhMgaIndicadors;

	public RhMgaObjetivo() {
	}

	public Integer getObId() {
		return this.obId;
	}

	public void setObId(Integer obId) {
		this.obId = obId;
	}

	public String getObNombre() {
		return this.obNombre;
	}

	public void setObNombre(String obNombre) {
		this.obNombre = obNombre;
	}

	public List<RhMgaIndicador> getRhMgaIndicadors() {
		return this.rhMgaIndicadors;
	}

	public void setRhMgaIndicadors(List<RhMgaIndicador> rhMgaIndicadors) {
		this.rhMgaIndicadors = rhMgaIndicadors;
	}

	public RhMgaIndicador addRhMgaIndicador(RhMgaIndicador rhMgaIndicador) {
		getRhMgaIndicadors().add(rhMgaIndicador);
		rhMgaIndicador.setRhMgaObjetivo(this);

		return rhMgaIndicador;
	}

	public RhMgaIndicador removeRhMgaIndicador(RhMgaIndicador rhMgaIndicador) {
		getRhMgaIndicadors().remove(rhMgaIndicador);
		rhMgaIndicador.setRhMgaObjetivo(null);

		return rhMgaIndicador;
	}

}