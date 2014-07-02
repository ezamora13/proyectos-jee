package ec.gob.senagua.servicios;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import ec.gob.senagua.modelo.gis.Cuenca;
import ec.gob.senagua.util.EJBGenericoDAO;

/**
 * Session Bean implementation class RhGlbOpcionesMenuServicio
 */
@Stateless
@LocalBean
public class CuencaServicio extends EJBGenericoDAO<Cuenca, Integer> implements
		CuencaLocal {
	/**
	 * Default constructor.
	 */
	public CuencaServicio() {

	}

}