package ec.gob.senagua.modelo.gis;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;

/**
 * The persistent class for the demarcaciones_hidrograficas_050k_a database
 * table.
 * 
 */
@Entity
@Table(name = "demarcaciones_hidrograficas_050k_a", schema = "gis")
@NamedQuery(name = "DemarcacionesHidrograficas050kA.findAll", query = "SELECT d FROM DemarcacionesHidrograficas050kA d")
public class DemarcacionesHidrograficas050kA implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer gid;

	@Column(name = "__gid")
	private BigDecimal gid2;

	@Column(name = "codigo_dh")
	private String codigoDh;

	private String geom;

	@Column(name = "nombre_dh")
	private String nombreDh;

	private BigDecimal objectid;

	@Column(name = "shape_area")
	private BigDecimal shapeArea;

	@Column(name = "shape_leng")
	private BigDecimal shapeLeng;

	public DemarcacionesHidrograficas050kA() {
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

	public String getCodigoDh() {
		return codigoDh;
	}

	public void setCodigoDh(String codigoDh) {
		this.codigoDh = codigoDh;
	}

	public void setGeom(String geom) {
		this.geom = geom;
	}

	public String getGeom() {
		return geom;
	}

	public String getNombreDh() {
		return nombreDh;
	}

	public void setNombreDh(String nombreDh) {
		this.nombreDh = nombreDh;
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