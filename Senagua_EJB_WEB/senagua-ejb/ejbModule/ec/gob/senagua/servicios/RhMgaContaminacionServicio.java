package ec.gob.senagua.servicios;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import ec.gob.senagua.modelo.RhMgaContaminacion;
import ec.gob.senagua.util.EJBGenericoDAO;

/**
 * Session Bean implementation class RhGlbOpcionesMenuServicio
 */
@Stateless
@LocalBean
public class RhMgaContaminacionServicio extends
		EJBGenericoDAO<RhMgaContaminacion, Integer> implements
		RhMgaContaminacionLocal {
	/**
	 * Default constructor.
	 */
	public RhMgaContaminacionServicio() {

	}

	

}