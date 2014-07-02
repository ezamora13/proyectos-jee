package ec.gob.senagua.modelo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * The persistent class for the rh_glb_usuarios database table.
 * 
 */
@Entity
@Table(name = "rh_mga_contaminacion", schema = "modulos")
@SequenceGenerator(name = "modulos.rh_mga_contaminacion_seq", sequenceName = "modulos.rh_mga_contaminacion_seq", initialValue = 1, allocationSize = 1)
public class RhMgaContaminacion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "modulos.rh_mga_contaminacion_seq")
	@Column(name = "con_id")
	private Integer conId;

	@Column(name = "con_demarcacionhidrografica")
	private String conDemarcacionhidrografica;

	@Column(name = "con_evento")
	private String conEvento;

	@Column(name = "con_fechainspeccion")
	private String conFechainspeccion;

	@Column(name = "con_codigoficha")
	private String conCodigoficha;

	@Column(name = "con_codigoinforme")
	private String conCodigoinforme;

	@Column(name = "con_fechainforme")
	private String conFechainforme;

	public Integer getConId() {
		return conId;
	}

	public void setConId(Integer conId) {
		this.conId = conId;
	}

	public String getConDemarcacionhidrografica() {
		return conDemarcacionhidrografica;
	}

	public void setConDemarcacionhidrografica(String conDemarcacionhidrografica) {
		this.conDemarcacionhidrografica = conDemarcacionhidrografica;
	}

	public String getConEvento() {
		return conEvento;
	}

	public void setConEvento(String conEvento) {
		this.conEvento = conEvento;
	}

	public String getConFechainspeccion() {
		return conFechainspeccion;
	}

	public void setConFechainspeccion(String conFechainspeccion) {
		this.conFechainspeccion = conFechainspeccion;
	}

	public String getConCodigoficha() {
		return conCodigoficha;
	}

	public void setConCodigoficha(String conCodigoficha) {
		this.conCodigoficha = conCodigoficha;
	}

	public String getConCodigoinforme() {
		return conCodigoinforme;
	}

	public void setConCodigoinforme(String conCodigoinforme) {
		this.conCodigoinforme = conCodigoinforme;
	}

	public String getConFechainforme() {
		return conFechainforme;
	}

	public void setConFechainforme(String conFechainforme) {
		this.conFechainforme = conFechainforme;
	}

}