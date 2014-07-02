package ec.gob.senagua.servicios;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.Query;

import ec.gob.senagua.modelo.RhMgaMatrizseguimientoplanesma;
import ec.gob.senagua.modelo.RhMgaProyectomatrizseguimientoplanesma;
import ec.gob.senagua.util.EJBGenericoDAO;


/**
 * Session Bean implementation class RhGlbOpcionesMenuServicio
 */
@Stateless
@LocalBean
public class RhMgaMatrizseguimientoplanesmaServicio extends EJBGenericoDAO<RhMgaMatrizseguimientoplanesma, Integer> implements RhMgaMatrizseguimientoplanesmaLocal {
	/**
	 * Default constructor.
	 */
	public RhMgaMatrizseguimientoplanesmaServicio() {

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<RhMgaMatrizseguimientoplanesma> buscarOrdenarId(RhMgaProyectomatrizseguimientoplanesma rhMgaProyectomatrizseguimientoplanesma) {
		Query  query= em.createQuery("from RhMgaMatrizseguimientoplanesma m where m.rhMgaProyectomatrizseguimientoplanesma= ? order by m.mtzN");
		query.setParameter(1, rhMgaProyectomatrizseguimientoplanesma);
		return query.getResultList();
	}

	
}