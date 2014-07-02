package ec.gob.senagua.servicios;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.Query;

import ec.gob.senagua.modelo.RhGlbUsuario;
import ec.gob.senagua.util.EJBGenericoDAO;

/**
 * Session Bean implementation class RhGlbUsuarioServicio
 */
@Stateless
@LocalBean
public class RhGlbUsuarioServicio extends EJBGenericoDAO<RhGlbUsuario, Integer>
		implements RhGlbUsuarioLocal {
	/**
	 * Default constructor.
	 */
	public RhGlbUsuarioServicio() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public RhGlbUsuario buscarUsuario(String usuario) {
		Query query = em.createQuery("from  RhGlbUsuario u where u.usuUsuario = :usuario");
		query.setParameter("usuario", usuario);
		return (RhGlbUsuario) query.getSingleResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<RhGlbUsuario> buscarUsuarioOrdenadoxId() {
		Query query = em
				.createQuery("from RhGlbUsuario u ORDER BY u.usuCodigo ");
		return query.getResultList();
	}

}