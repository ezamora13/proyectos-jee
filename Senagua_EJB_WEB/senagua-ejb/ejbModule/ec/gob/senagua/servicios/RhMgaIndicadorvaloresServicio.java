package ec.gob.senagua.servicios;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.Query;

import ec.gob.senagua.modelo.RhMgaIndicador;
import ec.gob.senagua.modelo.RhMgaIndicadorvalore;
import ec.gob.senagua.util.EJBGenericoDAO;

/**
 * Session Bean implementation class RhGlbOpcionesMenuServicio
 */
@Stateless
@LocalBean
public class RhMgaIndicadorvaloresServicio extends
		EJBGenericoDAO<RhMgaIndicadorvalore, Integer> implements
		RhMgaIndicadorvaloresLocal {
	/**
	 * Default constructor.
	 */
	public RhMgaIndicadorvaloresServicio() {

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<RhMgaIndicadorvalore> obtenerInidcadorValorXId(
			RhMgaIndicador rhMgaIndicador) {
		Query query = em
				.createQuery("from RhMgaIndicadorvalore iv where iv.rhMgaIndicador = ? ORDER BY iv.invId");
		query.setParameter(1, rhMgaIndicador);
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<RhMgaIndicadorvalore> obtenerIndicadorValor_IdEstado(
			RhMgaIndicador rhMgaIndicador) {
		Query query = em
				.createQuery("from RhMgaIndicadorvalore iv where iv.rhMgaIndicador = ? and iv.invEstado= true");
		query.setParameter(1, rhMgaIndicador);
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<RhMgaIndicadorvalore> obtenerXidObjetivo(Integer Objetivo) {
		Query query = em
				.createNativeQuery(
						"select * from modulos.rh_mga_indicadorvalores  where in_id in (select in_id from modulos.rh_mga_indicador  where ob_id = (select ob_id from  modulos.rh_mga_objetivo where ob_id= ?))",
						RhMgaIndicadorvalore.class);
		query.setParameter(1, Objetivo);
		return query.getResultList();
	}

}