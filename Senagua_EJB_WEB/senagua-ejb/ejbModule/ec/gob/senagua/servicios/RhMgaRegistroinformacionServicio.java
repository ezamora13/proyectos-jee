package ec.gob.senagua.servicios;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import ec.gob.senagua.modelo.RhMgaRegistroinformacion;
import ec.gob.senagua.util.EJBGenericoDAO;

/**
 * Session Bean implementation class RhGlbOpcionesMenuServicio
 */
@Stateless
@LocalBean
public class RhMgaRegistroinformacionServicio extends
		EJBGenericoDAO<RhMgaRegistroinformacion, Integer> implements
		RhMgaRegistroinformacionLocal {
	/**
	 * Default constructor.
	 */
	public RhMgaRegistroinformacionServicio() {

	}

}