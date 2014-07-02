package ec.gob.senagua.modelo;

import java.io.Serializable;

import javax.persistence.*;

import java.util.Date;
import java.util.List;

/**
 * The persistent class for the rh_mga_proyectomatrizseguimientoplanesma
 * database table.
 * 
 */
@Entity
@Table(name = "rh_mga_proyectomatrizseguimientoplanesma", schema = "modulos")
@SequenceGenerator(name = "modulos.rh_mga_proyectomatrizseguimientoplanesma_seq", sequenceName = "modulos.rh_mga_proyectomatrizseguimientoplanesma_seq", initialValue = 1, allocationSize = 1)
public class RhMgaProyectomatrizseguimientoplanesma implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "modulos.rh_mga_proyectomatrizseguimientoplanesma_seq")
	@Column(name = "pmz_id")
	private Integer pmzId;

	@Column(name = "pmz_consultoracargoauditoriacumplimiento")
	private String pmzConsultoracargoauditoriacumplimiento;

	@Column(name = "pmz_demarcacionhidrograficaresponsable")
	private String pmzDemarcacionhidrograficaresponsable;

	@Column(name = "pmz_estadoauditoriaambientalcumplimiento")
	private String pmzEstadoauditoriaambientalcumplimiento;

	@Temporal(TemporalType.DATE)
	@Column(name = "pmz_fechaemisionlicenciaambiental")
	private Date pmzFechaemisionlicenciaambiental;

	@Temporal(TemporalType.DATE)
	@Column(name = "pmz_fechainicioobra")
	private Date pmzFechainicioobra;

	@Column(name = "pmz_nombreproyecto")
	private String pmzNombreproyecto;

	// bi-directional many-to-one association to RhMgaMatrizseguimientoplanesma
	@OneToMany(mappedBy = "rhMgaProyectomatrizseguimientoplanesma")
	private List<RhMgaMatrizseguimientoplanesma> rhMgaMatrizseguimientoplanesmas;

	public RhMgaProyectomatrizseguimientoplanesma() {
	}

	public Integer getPmzId() {
		return this.pmzId;
	}

	public void setPmzId(Integer pmzId) {
		this.pmzId = pmzId;
	}

	public String getPmzConsultoracargoauditoriacumplimiento() {
		return this.pmzConsultoracargoauditoriacumplimiento;
	}

	public void setPmzConsultoracargoauditoriacumplimiento(
			String pmzConsultoracargoauditoriacumplimiento) {
		this.pmzConsultoracargoauditoriacumplimiento = pmzConsultoracargoauditoriacumplimiento;
	}

	public String getPmzDemarcacionhidrograficaresponsable() {
		return this.pmzDemarcacionhidrograficaresponsable;
	}

	public void setPmzDemarcacionhidrograficaresponsable(
			String pmzDemarcacionhidrograficaresponsable) {
		this.pmzDemarcacionhidrograficaresponsable = pmzDemarcacionhidrograficaresponsable;
	}

	public String getPmzEstadoauditoriaambientalcumplimiento() {
		return this.pmzEstadoauditoriaambientalcumplimiento;
	}

	public void setPmzEstadoauditoriaambientalcumplimiento(
			String pmzEstadoauditoriaambientalcumplimiento) {
		this.pmzEstadoauditoriaambientalcumplimiento = pmzEstadoauditoriaambientalcumplimiento;
	}

	public Date getPmzFechaemisionlicenciaambiental() {
		return this.pmzFechaemisionlicenciaambiental;
	}

	public void setPmzFechaemisionlicenciaambiental(
			Date pmzFechaemisionlicenciaambiental) {
		this.pmzFechaemisionlicenciaambiental = pmzFechaemisionlicenciaambiental;
	}

	public Date getPmzFechainicioobra() {
		return this.pmzFechainicioobra;
	}

	public void setPmzFechainicioobra(Date pmzFechainicioobra) {
		this.pmzFechainicioobra = pmzFechainicioobra;
	}

	public String getPmzNombreproyecto() {
		return this.pmzNombreproyecto;
	}

	public void setPmzNombreproyecto(String pmzNombreproyecto) {
		this.pmzNombreproyecto = pmzNombreproyecto;
	}

	public List<RhMgaMatrizseguimientoplanesma> getRhMgaMatrizseguimientoplanesmas() {
		return this.rhMgaMatrizseguimientoplanesmas;
	}

	public void setRhMgaMatrizseguimientoplanesmas(
			List<RhMgaMatrizseguimientoplanesma> rhMgaMatrizseguimientoplanesmas) {
		this.rhMgaMatrizseguimientoplanesmas = rhMgaMatrizseguimientoplanesmas;
	}

	public RhMgaMatrizseguimientoplanesma addRhMgaMatrizseguimientoplanesma(
			RhMgaMatrizseguimientoplanesma rhMgaMatrizseguimientoplanesma) {
		getRhMgaMatrizseguimientoplanesmas()
				.add(rhMgaMatrizseguimientoplanesma);
		rhMgaMatrizseguimientoplanesma
				.setRhMgaProyectomatrizseguimientoplanesma(this);

		return rhMgaMatrizseguimientoplanesma;
	}

	public RhMgaMatrizseguimientoplanesma removeRhMgaMatrizseguimientoplanesma(
			RhMgaMatrizseguimientoplanesma rhMgaMatrizseguimientoplanesma) {
		getRhMgaMatrizseguimientoplanesmas().remove(
				rhMgaMatrizseguimientoplanesma);
		rhMgaMatrizseguimientoplanesma
				.setRhMgaProyectomatrizseguimientoplanesma(null);

		return rhMgaMatrizseguimientoplanesma;
	}

}