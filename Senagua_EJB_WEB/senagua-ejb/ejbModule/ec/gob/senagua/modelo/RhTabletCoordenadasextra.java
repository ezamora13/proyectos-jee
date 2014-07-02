package ec.gob.senagua.modelo;

import java.io.Serializable;

import javax.persistence.*;

import java.math.BigDecimal;


/**
 * The persistent class for the rh_tablet_coordenadasextras database table.
 * 
 */
@Entity
@Table(name="rh_tablet_coordenadasextras", schema = "modulos")
@SequenceGenerator(name = "modulos.rh_tablet_coordextra_ce_id_seq", sequenceName = "modulos.rh_tablet_coordextra_ce_id_seq", initialValue = 1, allocationSize = 1)
public class RhTabletCoordenadasextra implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "modulos.rh_tablet_coordextra_ce_id_seq")
	@Column(name="ce_id")
	private Integer ceId;

	@Column(name="ce_coodenadax")
	private BigDecimal ceCoodenadax;

	@Column(name="ce_coordenaday")
	private BigDecimal ceCoordenaday;

	@Column(name="ce_latitud")
	private String ceLatitud;

	@Column(name="ce_longitud")
	private String ceLongitud;

	//bi-directional many-to-one association to RhTabletRegistro
	@ManyToOne
	@JoinColumn(name="ce_idregistro")
	private RhTabletRegistro rhTabletRegistro;

	public RhTabletCoordenadasextra() {
	}

	public Integer getCeId() {
		return this.ceId;
	}

	public void setCeId(Integer ceId) {
		this.ceId = ceId;
	}

	public BigDecimal getCeCoodenadax() {
		return this.ceCoodenadax;
	}

	public void setCeCoodenadax(BigDecimal ceCoodenadax) {
		this.ceCoodenadax = ceCoodenadax;
	}

	public BigDecimal getCeCoordenaday() {
		return this.ceCoordenaday;
	}

	public void setCeCoordenaday(BigDecimal ceCoordenaday) {
		this.ceCoordenaday = ceCoordenaday;
	}

	public String getCeLatitud() {
		return this.ceLatitud;
	}

	public void setCeLatitud(String ceLatitud) {
		this.ceLatitud = ceLatitud;
	}

	public String getCeLongitud() {
		return this.ceLongitud;
	}

	public void setCeLongitud(String ceLongitud) {
		this.ceLongitud = ceLongitud;
	}

	public RhTabletRegistro getRhTabletRegistro() {
		return this.rhTabletRegistro;
	}

	public void setRhTabletRegistro(RhTabletRegistro rhTabletRegistro) {
		this.rhTabletRegistro = rhTabletRegistro;
	}

}