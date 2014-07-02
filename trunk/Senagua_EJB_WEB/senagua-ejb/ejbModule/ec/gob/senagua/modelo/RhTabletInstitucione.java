package ec.gob.senagua.modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;

/**
 * The persistent class for the rh_tablet_instituciones database table.
 * 
 */
@Entity
@Table(name = "rh_tablet_instituciones", schema = "modulos")
@NamedQuery(name = "RhTabletInstitucione.findAll", query = "SELECT r FROM RhTabletInstitucione r")
public class RhTabletInstitucione implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "RH_TABLET_INSTITUCIONES_INID_GENERATOR")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "RH_TABLET_INSTITUCIONES_INID_GENERATOR")
	@Column(name = "in_id")
	private Integer inId;

	@Column(name = "in_contacto")
	private String inContacto;

	@Column(name = "in_nombreinstitucion")
	private String inNombreinstitucion;

	@Column(name = "in_responsable")
	private String inResponsable;

	// bi-directional many-to-many association to RhTabletRegistro
	@ManyToMany(mappedBy = "rhTabletInstituciones")
	private List<RhTabletRegistro> rhTabletRegistros;

	public RhTabletInstitucione() {
	}

	public Integer getInId() {
		return this.inId;
	}

	public void setInId(Integer inId) {
		this.inId = inId;
	}

	public String getInContacto() {
		return this.inContacto;
	}

	public void setInContacto(String inContacto) {
		this.inContacto = inContacto;
	}

	public String getInNombreinstitucion() {
		return this.inNombreinstitucion;
	}

	public void setInNombreinstitucion(String inNombreinstitucion) {
		this.inNombreinstitucion = inNombreinstitucion;
	}

	public String getInResponsable() {
		return this.inResponsable;
	}

	public void setInResponsable(String inResponsable) {
		this.inResponsable = inResponsable;
	}

	public List<RhTabletRegistro> getRhTabletRegistros() {
		return this.rhTabletRegistros;
	}

	public void setRhTabletRegistros(List<RhTabletRegistro> rhTabletRegistros) {
		this.rhTabletRegistros = rhTabletRegistros;
	}

}