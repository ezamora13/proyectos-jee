package ec.gob.senagua.servicios;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import ec.gob.senagua.modelo.TmpObtienedato;
import ec.gob.senagua.util.EJBGenericoDAO;

/**
 * Session Bean implementation class RhMcaMuestreo
 */
@Stateless
@LocalBean
public class TmpObtieneDatoServicio extends
		EJBGenericoDAO<TmpObtienedato, Integer> implements TmpObtieneDatoLocal {
	/**
	 * Default constructor.
	 */
	public TmpObtieneDatoServicio() {

	}

}