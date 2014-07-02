package ec.gob.senagua.modelo.gis;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the dpa_cantones database table.
 * 
 */
@Entity
@Table(name = "dpa_cantones", schema = "gis")
@NamedQuery(name = "DpaCantone.findAll", query = "SELECT d FROM DpaCantone d")
public class DpaCantone implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer gid;

	@Column(name = "dpa_anio")
	private String dpaAnio;

	@Column(name = "dpa_canton")
	private String dpaCanton;

	@Column(name = "dpa_descan")
	private String dpaDescan;

	@Column(name = "dpa_despro")
	private String dpaDespro;

	@Column(name = "dpa_provin")
	private String dpaProvin;

	@Column(name = "dpa_valor")
	private Integer dpaValor;

	private String geom;

	public DpaCantone() {
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

	public String getDpaCanton() {
		return this.dpaCanton;
	}

	public void setDpaCanton(String dpaCanton) {
		this.dpaCanton = dpaCanton;
	}

	public String getDpaDescan() {
		return this.dpaDescan;
	}

	public void setDpaDescan(String dpaDescan) {
		this.dpaDescan = dpaDescan;
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

}