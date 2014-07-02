package ec.gob.senagua.modelo.gis;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the dpa_provincias database table.
 * 
 */
@Entity
@Table(name = "dpa_provincias", schema = "gis")
@NamedQuery(name = "DpaProvincia.findAll", query = "SELECT d FROM DpaProvincia d")
public class DpaProvincia implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer gid;

	@Column(name = "dpa_anio")
	private String dpaAnio;

	@Column(name = "dpa_despro")
	private String dpaDespro;

	@Column(name = "dpa_provin")
	private String dpaProvin;

	@Column(name = "dpa_valor")
	private Integer dpaValor;

	private String geom;

	@Column(name = "pee_codigo")
	private String peeCodigo;

	@Column(name = "rei_codigo")
	private String reiCodigo;

	@Column(name = "ren_codigo")
	private String renCodigo;

	public DpaProvincia() {
	}

	public Integer getGid() {
		return this.gid;
	}

	public void setGid(Integer gid) {
		this.gid = gid;
	}

	public String getDpaAnio() {
		return this.dpaAnio;
	}

	public void setDpaAnio(String dpaAnio) {
		this.dpaAnio = dpaAnio;
	}

	public String getDpaDespro() {
		return this.dpaDespro;
	}

	public void setDpaDespro(String dpaDespro) {
		this.dpaDespro = dpaDespro;
	}

	public String getDpaProvin() {
		return this.dpaProvin;
	}

	public void setDpaProvin(String dpaProvin) {
		this.dpaProvin = dpaProvin;
	}

	public Integer getDpaValor() {
		return this.dpaValor;
	}

	public void setDpaValor(Integer dpaValor) {
		this.dpaValor = dpaValor;
	}

	public String getGeom() {
		return geom;
	}

	public void setGeom(String geom) {
		this.geom = geom;
	}

	public String getPeeCodigo() {
		return this.peeCodigo;
	}

	public void setPeeCodigo(String peeCodigo) {
		this.peeCodigo = peeCodigo;
	}

	public String getReiCodigo() {
		return this.reiCodigo;
	}

	public void setReiCodigo(String reiCodigo) {
		this.reiCodigo = reiCodigo;
	}

	public String getRenCodigo() {
		return this.renCodigo;
	}

	public void setRenCodigo(String renCodigo) {
		this.renCodigo = renCodigo;
	}

}