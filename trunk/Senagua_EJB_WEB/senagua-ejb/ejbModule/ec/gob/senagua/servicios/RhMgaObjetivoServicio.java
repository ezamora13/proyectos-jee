package ec.gob.senagua.servicios;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import ec.gob.senagua.modelo.RhMgaObjetivo;
import ec.gob.senagua.util.EJBGenericoDAO;


/**
 * Session Bean implementation class RhGlbPerfilServicio
 */
@Stateless
@LocalBean
public class RhMgaObjetivoServicio extends EJBGenericoDAO<RhMgaObjetivo, Integer> implements RhMgaObjetivoLocal {
	/**
	 * Default constructor.
	 */
	public RhMgaObjetivoServicio() {

	}

	

}