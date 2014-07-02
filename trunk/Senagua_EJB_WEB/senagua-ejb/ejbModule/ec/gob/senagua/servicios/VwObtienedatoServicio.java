package ec.gob.senagua.servicios;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import ec.gob.senagua.modelo.VwObtienedato;
import ec.gob.senagua.util.EJBGenericoDAO;

/**
 * Session Bean implementation class VwObtienedato
 */
@Stateless
@LocalBean
public class VwObtienedatoServicio extends
		EJBGenericoDAO<VwObtienedato, Integer> implements VwObtienedatoLocal {
	/**
	 * Default constructor.
	 */
	public VwObtienedatoServicio() {

	}

}