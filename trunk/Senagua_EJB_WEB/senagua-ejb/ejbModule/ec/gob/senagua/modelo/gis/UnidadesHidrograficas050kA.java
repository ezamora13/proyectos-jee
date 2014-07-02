package ec.gob.senagua.modelo.gis;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;

/**
 * The persistent class for the unidades_hidrograficas_050k_a database table.
 * 
 */
@Entity
@Table(name = "unidades_hidrograficas_050k_a", schema = "gis")
@NamedQuery(name = "UnidadesHidrograficas050kA.findAll", query = "SELECT u FROM UnidadesHidrograficas050kA u")
public class UnidadesHidrograficas050kA implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer gid;

	@Column(name = "__gid")
	private BigDecimal gid2;

	@Column(name = "area_km2")
	private BigDecimal areaKm2;

	private String geom;

	@Column(name = "nivel_1")
	private String nivel1;

	@Column(name = "nivel_2")
	private String nivel2;

	@Column(name = "nivel_3")
	private String nivel3;

	@Column(name = "nivel_4")
	private String nivel4;

	@Column(name = "nivel_5")
	private String nivel5;

	@Column(name = "nivel5_dig")
	private String nivel5Dig;

	@Column(name = "nombre_1")
	private String nombre1;

	@Column(name = "nombre_2")
	private String nombre2;

	@Column(name = "nombre_3")
	private String nombre3;

	@Column(name = "nombre_4")
	private String nombre4;

	@Column(name = "nombre_5")
	private String nombre5;

	private BigDecimal objectid;

	@Column(name = "shape_area")
	private BigDecimal shapeArea;

	@Column(name = "shape_leng")
	private BigDecimal shapeLeng;

	public UnidadesHidrograficas050kA() {
	}

	public Integer getGid() {
		return gid;
	}

	public void setGid(Integer gid) {
		this.gid = gid;
	}

	public BigDecimal getGid2() {
		return gid2;
	}

	public void setGid2(BigDecimal gid2) {
		this.gid2 = gid2;
	}

	public BigDecimal getAreaKm2() {
		return areaKm2;
	}

	public void setAreaKm2(BigDecimal areaKm2) {
		this.areaKm2 = areaKm2;
	}

	public String getGeom() {
		return geom;
	}

	public void setGeom(String geom) {
		this.geom = geom;
	}

	public String getNivel1() {
		return nivel1;
	}

	public void setNivel1(String nivel1) {
		this.nivel1 = nivel1;
	}

	public String getNivel2() {
		return nivel2;
	}

	public void setNivel2(String nivel2) {
		this.nivel2 = nivel2;
	}

	public String getNivel3() {
		return nivel3;
	}

	public void setNivel3(String nivel3) {
		this.nivel3 = nivel3;
	}

	public String getNivel4() {
		return nivel4;
	}

	public void setNivel4(String nivel4) {
		this.nivel4 = nivel4;
	}

	public String getNivel5() {
		return nivel5;
	}

	public void setNivel5(String nivel5) {
		this.nivel5 = nivel5;
	}

	public String getNivel5Dig() {
		return nivel5Dig;
	}

	public void setNivel5Dig(String nivel5Dig) {
		this.nivel5Dig = nivel5Dig;
	}

	public String getNombre1() {
		return nombre1;
	}

	public void setNombre1(String nombre1) {
		this.nombre1 = nombre1;
	}

	public String getNombre2() {
		return nombre2;
	}

	public void setNombre2(String nombre2) {
		this.nombre2 = nombre2;
	}

	public String getNombre3() {
		return nombre3;
	}

	public void setNombre3(String nombre3) {
		this.nombre3 = nombre3;
	}

	public String getNombre4() {
		return nombre4;
	}

	public void setNombre4(String nombre4) {
		this.nombre4 = nombre4;
	}

	public String getNombre5() {
		return nombre5;
	}

	public void setNombre5(String nombre5) {
		this.nombre5 = nombre5;
	}

	public BigDecimal getObjectid() {
		return objectid;
	}

	public void setObjectid(BigDecimal objectid) {
		this.objectid = objectid;
	}

	public BigDecimal getShapeArea() {
		return shapeArea;
	}

	public void setShapeArea(BigDecimal shapeArea) {
		this.shapeArea = shapeArea;
	}

	public BigDecimal getShapeLeng() {
		return shapeLeng;
	}

	public void setShapeLeng(BigDecimal shapeLeng) {
		this.shapeLeng = shapeLeng;
	}

}