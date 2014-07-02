package ec.gob.senagua.modelo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * The persistent class for the rh_mga_matrizseguimientoplanesma database table.
 * 
 */
@Entity
@Table(name = "rh_mga_matrizseguimientoplanesma", schema = "modulos")
@SequenceGenerator(name = "modulos.rh_mga_matrizseguimientoplanesma_seq", sequenceName = "modulos.rh_mga_matrizseguimientoplanesma_seq", initialValue = 1, allocationSize = 1)
public class RhMgaMatrizseguimientoplanesma implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "modulos.rh_mga_matrizseguimientoplanesma_seq")
	@Column(name = "mz_id")
	private Integer mzId;

	@Column(name = "mtz_anualcumplimiento2012")
	private String mtzAnualcumplimiento2012;

	@Column(name = "mtz_anualcumplimiento2013")
	private String mtzAnualcumplimiento2013;

	@Column(name = "mtz_porcentajecumplimiento")
	private String mtzPorcentajeCumplimiento;

	@Column(name = "mtz_mediosverificacion")
	private String mtzMediosverificacion;

	@Column(name = "mtz_n")
	private Integer mtzN;

	@Column(name = "mtz_observacion")
	private String mtzObservacion;

	@Column(name = "mtz_programas_subprogramapma")
	private String mtzProgramasSubprogramapma;

	@Column(name = "mtz_responsablecontratista")
	private String mtzResponsablecontratista;

	@Column(name = "mtz_responsablesenagua")
	private String mtzResponsablesenagua;

	// bi-directional many-to-one association to
	// RhMgaProyectomatrizseguimientoplanesma
	@ManyToOne
	@JoinColumn(name = "pmz_id")
	private RhMgaProyectomatrizseguimientoplanesma rhMgaProyectomatrizseguimientoplanesma;

	public RhMgaMatrizseguimientoplanesma() {
	}

	public Integer getMzId() {
		return mzId;
	}

	public void setMzId(Integer mzId) {
		this.mzId = mzId;
	}

	public String getMtzAnualcumplimiento2012() {
		return mtzAnualcumplimiento2012;
	}

	public void setMtzAnualcumplimiento2012(String mtzAnualcumplimiento2012) {
		this.mtzAnualcumplimiento2012 = mtzAnualcumplimiento2012;
	}

	public String getMtzAnualcumplimiento2013() {
		return mtzAnualcumplimiento2013;
	}

	public void setMtzAnualcumplimiento2013(String mtzAnualcumplimiento2013) {
		this.mtzAnualcumplimiento2013 = mtzAnualcumplimiento2013;
	}

	public String getMtzPorcentajeCumplimiento() {
		return mtzPorcentajeCumplimiento;
	}

	public void setMtzPorcentajeCumplimiento(String mtzPorcentajeCumplimiento) {
		this.mtzPorcentajeCumplimiento = mtzPorcentajeCumplimiento;
	}

	public String getMtzMediosverificacion() {
		return mtzMediosverificacion;
	}

	public void setMtzMediosverificacion(String mtzMediosverificacion) {
		this.mtzMediosverificacion = mtzMediosverificacion;
	}

	public Integer getMtzN() {
		return mtzN;
	}

	public void setMtzN(Integer mtzN) {
		this.mtzN = mtzN;
	}

	public String getMtzObservacion() {
		return mtzObservacion;
	}

	public void setMtzObservacion(String mtzObservacion) {
		this.mtzObservacion = mtzObservacion;
	}

	public String getMtzProgramasSubprogramapma() {
		return mtzProgramasSubprogramapma;
	}

	public void setMtzProgramasSubprogramapma(String mtzProgramasSubprogramapma) {
		this.mtzProgramasSubprogramapma = mtzProgramasSubprogramapma;
	}

	public String getMtzResponsablecontratista() {
		return mtzResponsablecontratista;
	}

	public void setMtzResponsablecontratista(String mtzResponsablecontratista) {
		this.mtzResponsablecontratista = mtzResponsablecontratista;
	}

	public String getMtzResponsablesenagua() {
		return mtzResponsablesenagua;
	}

	public void setMtzResponsablesenagua(String mtzResponsablesenagua) {
		this.mtzResponsablesenagua = mtzResponsablesenagua;
	}

	public RhMgaProyectomatrizseguimientoplanesma getRhMgaProyectomatrizseguimientoplanesma() {
		return rhMgaProyectomatrizseguimientoplanesma;
	}

	public void setRhMgaProyectomatrizseguimientoplanesma(
			RhMgaProyectomatrizseguimientoplanesma rhMgaProyectomatrizseguimientoplanesma) {
		this.rhMgaProyectomatrizseguimientoplanesma = rhMgaProyectomatrizseguimientoplanesma;
	}

}