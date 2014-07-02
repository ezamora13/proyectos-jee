package ec.gob.senagua.servicios;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import ec.gob.senagua.modelo.gis.UnidadesHidrograficas050kA;
import ec.gob.senagua.util.EJBGenericoDAO;

/**
 * Session Bean implementation class RhGlbOpcionesMenuServicio
 */
@Stateless
@LocalBean
public class UnidadHidrografica050kAServicio extends
		EJBGenericoDAO<UnidadesHidrograficas050kA, Integer> implements
		UnidadHidrografica050kALocal {

	
	
	/**
	 * Default constructor.
	 */
	public UnidadHidrografica050kAServicio() {

	}

}