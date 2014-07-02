package ec.gob.senagua.servicios;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.Query;

import ec.gob.senagua.modelo.RhMgaIndicador;
import ec.gob.senagua.util.EJBGenericoDAO;

/**
 * Session Bean implementation class RhGlbOpcionesMenuServicio
 */
@Stateless
@LocalBean
public class RhMgaIndicadorServicio extends
		EJBGenericoDAO<RhMgaIndicador, Integer> implements RhMgaIndicadorLocal {
	/**
	 * Default constructor.
	 */
	public RhMgaIndicadorServicio() {

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<RhMgaIndicador> obtenerIndicadorXobjetivo(Integer objetivo) {
		Query query= em.createQuery("from RhMgaIndicador i where i.rhMgaObjetivo.obId= ? ");
		query.setParameter(1, objetivo);
		return query.getResultList();
	}

	

}