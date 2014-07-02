package ec.gob.senagua.servicios;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.Query;

import ec.gob.senagua.modelo.RhTabletFoto;
import ec.gob.senagua.modelo.RhTabletRegistro;
import ec.gob.senagua.util.EJBGenericoDAO;

/**
 * Session Bean implementation class RhMcaMuestreo
 */
@Stateless
@LocalBean
public class RhTabletFotoServicio extends EJBGenericoDAO<RhTabletFoto, Integer>
		implements RhTabletFotoLocal {
	/**
	 * Default constructor.
	 */
	public RhTabletFotoServicio() {

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<RhTabletFoto> buscarXidTabletRegitro(
			RhTabletRegistro rhTabletRegistro) {
		Query query = em.createQuery("from RhTabletFoto f where f.rhTabletRegistro = ?");
		query.setParameter(1, rhTabletRegistro);
		return query.getResultList();
	}

}