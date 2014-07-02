package ec.gob.senagua.servicios;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;


import javax.persistence.Query;

import ec.gob.senagua.modelo.RhMgaLicenciamientoambiental;
import ec.gob.senagua.util.EJBGenericoDAO;


/**
 * Session Bean implementation class Rh_mga_licenciamientoambientalServicio
 */
@Stateless
@LocalBean
public class RhMgaLicenciamientoambientalServicio extends EJBGenericoDAO<RhMgaLicenciamientoambiental, Integer> implements RhMgaLicenciamientoambientalLocal {
	/**
	 * Default constructor.
	 */
	public RhMgaLicenciamientoambientalServicio() {

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<RhMgaLicenciamientoambiental> buscarOrdenarId() {
		Query query = em.createQuery("from RhMgaLicenciamientoambiental lic Order By lic.lic_n ");		
		return query.getResultList();
	}

	
}