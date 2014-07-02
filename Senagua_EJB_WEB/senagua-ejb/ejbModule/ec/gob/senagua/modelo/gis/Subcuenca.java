package ec.gob.senagua.modelo.gis;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the subcuencas database table.
 * 
 */
@Entity
@Table(name = "subcuencas", schema = "gis")
@NamedQuery(name = "Subcuenca.findAll", query = "SELECT s FROM Subcuenca s")
public class Subcuenca implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer gid;

	private double acres;

	private double area;

	@Column(name = "cod_cuenc")
	private String codCuenc;

	@Column(name = "cod_sist")
	private String codSist;

	@Column(name = "codigo_sub")
	private String codigoSub;

	private String cuenca;

	@Column(name = "first_prov")
	private String firstProv;

	private String geom;

	private double hectares;

	private double perimeter;

	private String sistema;

	private String subcuencas;

	public Subcuenca() {
	}

	public Integer getGid() {
		return this.gid;
	}

	public void setGid(Integer gid) {
		this.gid = gid;
	}

	public double getAcres() {
		return this.acres;
	}

	public void setAcres(double acres) {
		this.acres = acres;
	}

	public double getArea() {
		return this.area;
	}

	public void setArea(double area) {
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

	public String getCodigoSub() {
		return this.codigoSub;
	}

	public void setCodigoSub(String codigoSub) {
		this.codigoSub = codigoSub;
	}

	public String getCuenca() {
		return this.cuenca;
	}

	public void setCuenca(String cuenca) {
		this.cuenca = cuenca;
	}

	public String getFirstProv() {
		return this.firstProv;
	}

	public void setFirstProv(String firstProv) {
		this.firstProv = firstProv;
	}

	public String getGeom() {
		return geom;
	}

	public void setGeom(String geom) {
		this.geom = geom;
	}

	public double getHectares() {
		return this.hectares;
	}

	public void setHectares(double hectares) {
		this.hectares = hectares;
	}

	public double getPerimeter() {
		return this.perimeter;
	}

	public void setPerimeter(double perimeter) {
		this.perimeter = perimeter;
	}

	public String getSistema() {
		return this.sistema;
	}

	public void setSistema(String sistema) {
		this.sistema = sistema;
	}

	public String getSubcuencas() {
		return this.subcuencas;
	}

	public void setSubcuencas(String subcuencas) {
		this.subcuencas = subcuencas;
	}

}