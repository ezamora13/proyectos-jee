package ec.gob.senagua.servicios;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import ec.gob.senagua.modelo.gis.DpaParroquia;
import ec.gob.senagua.util.EJBGenericoDAO;

/**
 * Session Bean implementation class RhGlbOpcionesMenuServicio
 */
@Stateless
@LocalBean
public class DpaParroquiaServicio extends EJBGenericoDAO<DpaParroquia, Integer>
		implements DpaParroquiaLocal {
	/**
	 * Default constructor.
	 */
	public DpaParroquiaServicio() {

	}

}