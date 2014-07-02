package ec.gob.senagua.servicios;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import ec.gob.senagua.modelo.RhParametroSistema;
import ec.gob.senagua.util.EJBGenericoDAO;


/**
 * Session Bean implementation class RhGlbOpcionesMenuServicio
 */
@Stateless
@LocalBean
public class RhParametroSistemaServicio extends EJBGenericoDAO<RhParametroSistema, Integer> implements RhParametroSistemaLocal {
	/**
	 * Default constructor.
	 */
	public RhParametroSistemaServicio() {

	}

	
}