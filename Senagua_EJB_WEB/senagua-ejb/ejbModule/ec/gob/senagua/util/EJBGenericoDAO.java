package ec.gob.senagua.util;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

public abstract class EJBGenericoDAO<E, ID extends Serializable> implements
		GenericoDAO<E, ID> {

	@PersistenceContext
	protected EntityManager em;
	private Class<E> entidadTipo;

	@SuppressWarnings("unchecked")
	public EJBGenericoDAO() {
		this.entidadTipo = (Class<E>) (((ParameterizedType) getClass()
				.getGenericSuperclass()).getActualTypeArguments()[0]);
	}

	@Override
	public E buscarId(ID id) {
		return em.find(this.entidadTipo, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<E> getAll() {
		Query query = em.createQuery("from " + this.entidadTipo.getName());
		return query.getResultList();
	}

	@Override
	public E makePersistent(E entidad) {
		return em.merge(entidad);
	}

	@Override
	public void makeTransient(E entidad) {
		E entityTemp = em.merge(entidad);
		em.remove(entityTemp);
	}

}
