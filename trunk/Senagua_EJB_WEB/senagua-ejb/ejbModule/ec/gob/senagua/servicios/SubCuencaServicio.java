package ec.gob.senagua.servicios;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import ec.gob.senagua.modelo.gis.Subcuenca;
import ec.gob.senagua.util.EJBGenericoDAO;

/**
 * Session Bean implementation class RhGlbOpcionesMenuServicio
 */
@Stateless
@LocalBean
public class SubCuencaServicio extends
		EJBGenericoDAO<Subcuenca, Integer> implements SubCuencaLocal {
	/**
	 * Default constructor.
	 */
	public SubCuencaServicio() {

	}

}