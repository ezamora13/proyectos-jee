package ec.gob.senagua.modelo;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * The persistent class for the tmp_obtieneFotos database table.
 * 
 */
@Entity
@Table(name = "tmp_getFotos", schema = "modulos")
@SequenceGenerator(name = "modulos.tmp_getfotos_f_id_seq", sequenceName = "modulos.tmp_getfotos_f_id_seq", initialValue = 1, allocationSize = 1)
public class TmpGetFoto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "modulos.tmp_getfotos_f_id_seq")
	private Integer f_id;
	private String f_codigo;
	private byte[] ft_archivo;

	public Integer getF_id() {
		return f_id;
	}

	public void setF_id(Integer f_id) {
		this.f_id = f_id;
	}

	public String getF_codigo() {
		return f_codigo;
	}

	public void setF_codigo(String f_codigo) {
		this.f_codigo = f_codigo;
	}

	public byte[] getFt_archivo() {
		return ft_archivo;
	}

	public void setFt_archivo(byte[] ft_archivo) {
		this.ft_archivo = ft_archivo;
	}

}