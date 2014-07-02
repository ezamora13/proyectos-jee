package ec.gob.senagua.servicios;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import ec.gob.senagua.modelo.VwCalidadGeneral;
import ec.gob.senagua.util.EJBGenericoDAO;

/**
 * Session Bean implementation class VwObtienedato
 */
@Stateless
@LocalBean
public class VwCalidadGeneralServicio extends
		EJBGenericoDAO<VwCalidadGeneral, Integer> implements
		VwCalidadGeneralLocal {
	/**
	 * Default constructor.
	 */
	public VwCalidadGeneralServicio() {

	}

}