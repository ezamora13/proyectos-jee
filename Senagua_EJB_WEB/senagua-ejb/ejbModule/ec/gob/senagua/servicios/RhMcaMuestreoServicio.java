package ec.gob.senagua.servicios;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.Query;

import ec.gob.senagua.modelo.RhMcaMuestreo;
import ec.gob.senagua.modelo.RhTabletRegistro;
import ec.gob.senagua.util.EJBGenericoDAO;

/**
 * Session Bean implementation class RhMcaMuestreo
 */
@Stateless
@LocalBean
public class RhMcaMuestreoServicio extends
		EJBGenericoDAO<RhMcaMuestreo, Integer> implements RhMcaMuestreoLocal {
	/**
	 * Default constructor.
	 */
	public RhMcaMuestreoServicio() {

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<RhMcaMuestreo> obtenerOrderXiD() {
		Query query = em.createQuery("from RhMcaMuestreo m  Order By m.msId");
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<RhMcaMuestreo> buscarXiD(RhTabletRegistro registro) {
		Query query = em
				.createQuery("from RhMcaMuestreo m  where m.rhTabletRegistro = ? Order By m.msId");
		query.setParameter(1, registro);
		return query.getResultList();
	}

}