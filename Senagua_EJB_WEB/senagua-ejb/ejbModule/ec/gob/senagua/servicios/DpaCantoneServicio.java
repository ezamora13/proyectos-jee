package ec.gob.senagua.servicios;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import ec.gob.senagua.modelo.gis.DpaCantone;
import ec.gob.senagua.util.EJBGenericoDAO;

/**
 * Session Bean implementation class RhGlbOpcionesMenuServicio
 */
@Stateless
@LocalBean
public class DpaCantoneServicio extends EJBGenericoDAO<DpaCantone, Integer>
		implements DpaCantoneLocal {
	/**
	 * Default constructor.
	 */
	public DpaCantoneServicio() {

	}

}