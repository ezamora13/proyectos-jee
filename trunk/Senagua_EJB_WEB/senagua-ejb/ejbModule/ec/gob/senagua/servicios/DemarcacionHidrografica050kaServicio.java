package ec.gob.senagua.servicios;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import ec.gob.senagua.modelo.gis.DemarcacionesHidrograficas050kA;
import ec.gob.senagua.util.EJBGenericoDAO;

/**
 * Session Bean implementation class RhGlbOpcionesMenuServicio
 */
@Stateless
@LocalBean
public class DemarcacionHidrografica050kaServicio extends
		EJBGenericoDAO<DemarcacionesHidrograficas050kA, Integer> implements
		DemarcacionHidrografica050kaLocal {
	/**
	 * Default constructor.
	 */
	public DemarcacionHidrografica050kaServicio() {

	}

}