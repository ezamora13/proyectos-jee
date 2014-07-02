package ec.gob.senagua.modelo;

import java.io.Serializable;

import javax.persistence.*;


/**
 * The persistent class for the vw_obtienedatos database table.
 * 
 */
@Entity
@Table(name="vw_obtienedatos", schema = "modulos")
@NamedQuery(name="VwObtienedato.findAll", query="SELECT v FROM VwObtienedato v")
public class VwObtienedato implements Serializable {
	private static final long serialVersionUID = 1L;

	private String canton;

	private Integer coddemarcacion;

	@Id
	private String codficha;

	private Integer codmicrocuenca;

	private Integer codparroquia;

	private String codpfafsteter;

	private String cuenca;

	private String demarcacion;

	private String microcuenca;

	private String parroquia;

	private String pfafsteter;

	private String provincia;

	private String subcuenca;

	public VwObtienedato() {
	}

	public String getCanton() {
		return this.canton;
	}

	public void setCanton(String canton) {
		this.canton = canton;
	}

	public Integer getCoddemarcacion() {
		return this.coddemarcacion;
	}

	public void setCoddemarcacion(Integer coddemarcacion) {
		this.coddemarcacion = coddemarcacion;
	}

	public String getCodficha() {
		return this.codficha;
	}

	public void setCodficha(String codficha) {
		this.codficha = codficha;
	}

	public Integer getCodmicrocuenca() {
		return this.codmicrocuenca;
	}

	public void setCodmicrocuenca(Integer codmicrocuenca) {
		this.codmicrocuenca = codmicrocuenca;
	}

	public Integer getCodparroquia() {
		return this.codparroquia;
	}

	public void setCodparroquia(Integer codparroquia) {
		this.codparroquia = codparroquia;
	}

	public String getCodpfafsteter() {
		return this.codpfafsteter;
	}

	public void setCodpfafsteter(String codpfafsteter) {
		this.codpfafsteter = codpfafsteter;
	}

	public String getCuenca() {
		return this.cuenca;
	}

	public void setCuenca(String cuenca) {
		this.cuenca = cuenca;
	}

	public String getDemarcacion() {
		return this.demarcacion;
	}

	public void setDemarcacion(String demarcacion) {
		this.demarcacion = demarcacion;
	}

	public String getMicrocuenca() {
		return this.microcuenca;
	}

	public void setMicrocuenca(String microcuenca) {
		this.microcuenca = microcuenca;
	}

	public String getParroquia() {
		return this.parroquia;
	}

	public void setParroquia(String parroquia) {
		this.parroquia = parroquia;
	}

	public String getPfafsteter() {
		return this.pfafsteter;
	}

	public void setPfafsteter(String pfafsteter) {
		this.pfafsteter = pfafsteter;
	}

	public String getProvincia() {
		return this.provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public String getSubcuenca() {
		return this.subcuenca;
	}

	public void setSubcuenca(String subcuenca) {
		this.subcuenca = subcuenca;
	}

}