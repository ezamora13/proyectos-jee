package ec.gob.senagua.servicios;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import ec.gob.senagua.modelo.RhMcaParametroscomparacion;
import ec.gob.senagua.util.EJBGenericoDAO;


/**
 * Session Bean implementation class RhGlbOpcionesMenuServicio
 */
@Stateless
@LocalBean
public class RhMcaParametroscomparacionServicio extends EJBGenericoDAO<RhMcaParametroscomparacion, Integer> implements RhMcaParametroscomparacionLocal {
	/**
	 * Default constructor.
	 */
	public RhMcaParametroscomparacionServicio() {

	}

	
}