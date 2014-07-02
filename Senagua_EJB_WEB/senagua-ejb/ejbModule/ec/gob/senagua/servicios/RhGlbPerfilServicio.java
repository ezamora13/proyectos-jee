package ec.gob.senagua.servicios;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import ec.gob.senagua.modelo.RhGlbPerfil;
import ec.gob.senagua.util.EJBGenericoDAO;


/**
 * Session Bean implementation class RhGlbPerfilServicio
 */
@Stateless
@LocalBean
public class RhGlbPerfilServicio extends EJBGenericoDAO<RhGlbPerfil, Integer> implements RhGlbPerfilLocal {
	/**
	 * Default constructor.
	 */
	public RhGlbPerfilServicio() {

	}

	

}