package ec.gob.senagua.servicios;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.Query;

import ec.gob.senagua.modelo.RhMcaParametrosLimitesesperado;
import ec.gob.senagua.util.EJBGenericoDAO;

/**
 * Session Bean implementation class RhGlbOpcionesMenuServicio
 */
@Stateless
@LocalBean
public class RhMcaParametrosLimitesesperadoServicio extends
		EJBGenericoDAO<RhMcaParametrosLimitesesperado, Integer> implements
		RhMcaParametrosLimitesesperadoLocal {
	/**
	 * Default constructor.
	 */
	public RhMcaParametrosLimitesesperadoServicio() {

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<RhMcaParametrosLimitesesperado> buscaEstadoTrue() {
		Query query = em
				.createQuery("from RhMcaParametrosLimitesesperado l where l.lespEstado=true order by l.lespId");
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<String> buscarProvincias() {
		Query query = em
				.createQuery("Select lim.lespDemarcacion from RhMcaParametrosLimitesesperado  lim where lim.lespEstado=true GROUP BY lim.lespDemarcacion order by lim.lespDemarcacion");
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<String> buscarActividad() {
		Query query = em
				.createQuery("Select lim.lespActividad from RhMcaParametrosLimitesesperado  lim where lim.lespEstado=true GROUP BY lim.lespActividad order by lim.lespActividad");
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<RhMcaParametrosLimitesesperado> buscar_DemaracionLimite(
			String demarcacion, String actividad) {
		Query query = em.createQuery("from RhMcaParametrosLimitesesperado l where l.lespDemarcacion=?1 and l.lespActividad =?2");
		query.setParameter(1, demarcacion);
		query.setParameter(2, actividad);
		return query.getResultList();
	}

}