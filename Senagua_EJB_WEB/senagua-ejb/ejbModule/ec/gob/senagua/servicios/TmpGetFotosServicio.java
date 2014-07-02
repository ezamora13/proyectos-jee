package ec.gob.senagua.servicios;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.Query;

import ec.gob.senagua.modelo.TmpGetFoto;
import ec.gob.senagua.util.EJBGenericoDAO;

/**
 * Session Bean implementation class RhMcaMuestreo
 */
@Stateless
@LocalBean
public class TmpGetFotosServicio extends EJBGenericoDAO<TmpGetFoto, Integer>
		implements TmpGetFotosLocal {
	/**
	 * Default constructor.
	 */
	public TmpGetFotosServicio() {

	}

	@Override
	public TmpGetFoto buscarCod(String cod) {
		Query query = em.createQuery("from TmpGetFoto f where f.f_codigo=?");
		query.setParameter(1, cod);
		return (TmpGetFoto) query.getSingleResult();
	}

}