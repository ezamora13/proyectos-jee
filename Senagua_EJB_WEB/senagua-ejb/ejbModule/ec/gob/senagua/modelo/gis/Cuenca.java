package ec.gob.senagua.modelo.gis;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;

/**
 * The persistent class for the cuencas database table.
 * 
 */
@Entity
@Table(name = "cuencas", schema = "gis")
@NamedQuery(name = "Cuenca.findAll", query = "SELECT c FROM Cuenca c")
public class Cuenca implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer gid;

	private BigDecimal area;

	@Column(name = "cod_cuenc")
	private String codCuenc;

	@Column(name = "cod_sist")
	private String codSist;

	private String cuenca;

	private String geom;

	private BigDecimal hectares;

	private BigDecimal perimeter;

	private String sistema;

	private String vertiente;

	public Cuenca() {
	}

	public Integer getGid() {
		return this.gid;
	}

	public void setGid(Integer gid) {
		this.gid = gid;
	}

	public BigDecimal getArea() {
		return this.area;
	}

	public void setArea(BigDecimal area) {
		this.area = area;
	}

	public String getCodCuenc() {
		return this.codCuenc;
	}

	public void setCodCuenc(String codCuenc) {
		this.codCuenc = codCuenc;
	}

	public String getCodSist() {
		return this.codSist;
	}

	public void setCodSist(String codSist) {
		this.codSist = codSist;
	}

	public String getCuenca() {
		return this.cuenca;
	}

	public void setCuenca(String cuenca) {
		this.cuenca = cuenca;
	}

	public String getGeom() {
		return geom;
	}

	public void setGeom(String geom) {
		this.geom = geom;
	}

	public BigDecimal getHectares() {
		return this.hectares;
	}

	public void setHectares(BigDecimal hectares) {
		this.hectares = hectares;
	}

	public BigDecimal getPerimeter() {
		return this.perimeter;
	}

	public void setPerimeter(BigDecimal perimeter) {
		this.perimeter = perimeter;
	}

	public String getSistema() {
		return this.sistema;
	}

	public void setSistema(String sistema) {
		this.sistema = sistema;
	}

	public String getVertiente() {
		return this.vertiente;
	}

	public void setVertiente(String vertiente) {
		this.vertiente = vertiente;
	}

}