package ec.gob.senagua.servicios;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.Query;

import ec.gob.senagua.modelo.RhMcaParametrosNormavigente;
import ec.gob.senagua.util.EJBGenericoDAO;

/**
 * Session Bean implementation class RhGlbOpcionesMenuServicio
 */
@Stateless
@LocalBean
public class RhMcaParametrosNormavigenteServicio extends
		EJBGenericoDAO<RhMcaParametrosNormavigente, Integer> implements
		RhMcaParametrosNormavigenteLocal {
	/**
	 * Default constructor.
	 */
	public RhMcaParametrosNormavigenteServicio() {

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<RhMcaParametrosNormavigente> buscaEstadoTrue() {
		// TODO Auto-generated method stub
		Query query = em
				.createQuery("from RhMcaParametrosNormavigente n where n.norvEstado= true order by n.norvId");
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<String> buscarAnios() {
		Query query = em
				.createQuery("select n.norvAnio from RhMcaParametrosNormavigente n  GROUP BY n.norvAnio order by n.norvAnio ");
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<String> buscarTipo() {
		Query query = em
				.createQuery("select n.norvTipo from RhMcaParametrosNormavigente n where n.norvEstado=true GROUP BY n.norvTipo  order by n.norvTipo");
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<RhMcaParametrosNormavigente> buscar_AnioTipo(Integer anio,
			String tipo) {
		Query query = em.createQuery("from RhMcaParametrosNormavigente n where n.norvAnio=?1 and n.norvTipo =?2");
		query.setParameter(1, anio);
		query.setParameter(2, tipo);
		return query.getResultList();
	}

}