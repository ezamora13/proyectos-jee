package ec.gob.senagua.servicios;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import ec.gob.senagua.modelo.gis.DpaProvincia;
import ec.gob.senagua.util.EJBGenericoDAO;

/**
 * Session Bean implementation class RhGlbOpcionesMenuServicio
 */
@Stateless
@LocalBean
public class DpaProvinciaServicio extends EJBGenericoDAO<DpaProvincia, Integer>
		implements DpaProvinciaLocal {
	/**
	 * Default constructor.
	 */
	public DpaProvinciaServicio() {

	}

}