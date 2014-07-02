package ec.gob.senagua.servicios;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import ec.gob.senagua.modelo.RhMcaComparacionreportenormalimite;
import ec.gob.senagua.util.EJBGenericoDAO;

/**
 * Session Bean implementation class RhGlbOpcionesMenuServicio
 */
@Stateless
@LocalBean
public class RhMcaComparacionreportenormalimiteServicio extends
		EJBGenericoDAO<RhMcaComparacionreportenormalimite, Integer> implements
		RhMcaComparacionreportenormalimiteLocal {
	/**
	 * Default constructor.
	 */
	public RhMcaComparacionreportenormalimiteServicio() {

	}

	

}