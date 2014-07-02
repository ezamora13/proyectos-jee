package ec.gob.senagua.util;

import java.io.Serializable;
import java.util.List;

public interface GenericoDAO<E, ID extends Serializable> {

	/**
	 * Todas las instancias de la entidad.
	 * @return
	 */
	public List<E> getAll();
	
	/**
	 * Busqueda de entidad asociado al id.
	 * @param id Identificador principal entidad
	 * @return
	 */
	public E buscarId(ID id);	
	
	/**
	 * Guarda o Actualiza la entidad en la base de datos.
	 * @param entidad
	 * @return
	 */
	public E makePersistent(E entidad);
	
	/**
	 * Elimina la entidad en la base de datos.
	 * @param entity
	 */
	public void makeTransient(E entidad);
}
