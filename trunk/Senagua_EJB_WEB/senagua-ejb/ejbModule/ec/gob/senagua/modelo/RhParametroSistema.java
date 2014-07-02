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
 * The persistent class for the rh_parametro_sistema database table.
 * 
 */
@Entity
@Table(name="rh_parametro_sistema" , schema = "modulos")
@SequenceGenerator(name = "modulos.rh_parametrosistema_pr_id_seq", sequenceName = "modulos.rh_parametrosistema_pr_id_seq", initialValue = 1, allocationSize = 1)
public class RhParametroSistema implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "modulos.rh_parametrosistema_pr_id_seq")
	@Column(name="pr_id")
	private Integer prId;

	@Column(name="pr_codigo")
	private String prCodigo;

	@Column(name="pr_descripcion")
	private String prDescripcion;

	@Column(name="pr_padre")
	private Integer prPadre;

	public RhParametroSistema() {
	}

	public Integer getPrId() {
		return this.prId;
	}

	public void setPrId(Integer prId) {
		this.prId = prId;
	}

	public String getPrCodigo() {
		return this.prCodigo;
	}

	public void setPrCodigo(String prCodigo) {
		this.prCodigo = prCodigo;
	}

	public String getPrDescripcion() {
		return this.prDescripcion;
	}

	public void setPrDescripcion(String prDescripcion) {
		this.prDescripcion = prDescripcion;
	}

	public Integer getPrPadre() {
		return this.prPadre;
	}

	public void setPrPadre(Integer prPadre) {
		this.prPadre = prPadre;
	}

}