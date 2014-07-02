package ec.gob.senagua.modelo;

import java.io.Serializable;

import javax.persistence.*;

import java.math.BigDecimal;


/**
 * The persistent class for the tmp_obtienedatos database table.
 * 
 */
@Entity
@Table(name="tmp_obtienedatos" , schema = "modulos")
@SequenceGenerator(name = "modulos.tmp_obtienedatos_od_id_seq", sequenceName = "modulos.tmp_obtienedatos_od_id_seq", initialValue = 1, allocationSize = 1)
public class TmpObtienedato implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "modulos.tmp_obtienedatos_od_id_seq")
	@Column(name="od_id")
	private Integer odId;

	@Column(name="coordenada_x")
	private BigDecimal coordenadaX;

	@Column(name="coordenada_y")
	private BigDecimal coordenadaY;

	@Column(name="es_calidadagua")
	private Boolean esCalidadagua;

	public TmpObtienedato() {
	}

	public Integer getOdId() {
		return this.odId;
	}

	public void setOdId(Integer odId) {
		this.odId = odId;
	}

	public BigDecimal getCoordenadaX() {
		return this.coordenadaX;
	}

	public void setCoordenadaX(BigDecimal coordenadaX) {
		this.coordenadaX = coordenadaX;
	}

	public BigDecimal getCoordenadaY() {
		return this.coordenadaY;
	}

	public void setCoordenadaY(BigDecimal coordenadaY) {
		this.coordenadaY = coordenadaY;
	}

	public Boolean getEsCalidadagua() {
		return this.esCalidadagua;
	}

	public void setEsCalidadagua(Boolean esCalidadagua) {
		this.esCalidadagua = esCalidadagua;
	}

}