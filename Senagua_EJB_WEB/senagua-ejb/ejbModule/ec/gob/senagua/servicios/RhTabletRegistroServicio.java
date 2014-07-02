package ec.gob.senagua.servicios;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.Query;

import ec.gob.senagua.modelo.RhTabletRegistro;
import ec.gob.senagua.util.EJBGenericoDAO;

/**
 * Session Bean implementation class RhTabletRegistroServicio
 */
@Stateless
@LocalBean
public class RhTabletRegistroServicio extends
		EJBGenericoDAO<RhTabletRegistro, Integer> implements
		RhTabletRegistroLocal {
	/**
	 * Default constructor.
	 */
	public RhTabletRegistroServicio() {

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<RhTabletRegistro> buscarXtipoFicha(String tipoModulo) {
		Query query = em
				.createQuery("from RhTabletRegistro t where t.rgTipomodulo= ? Order by t.rgId");
		query.setParameter(1, tipoModulo);
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<RhTabletRegistro> buscarRegistroParaMonitoreo() {
		Query query = em
				.createNativeQuery(
						"select * from modulos.rh_tablet_registro where rg_id not in (select rg_id from modulos.rh_mca_muestreo ) and rg_tipomodulo= 'MCA'",
						RhTabletRegistro.class);
		return query.getResultList();
	}

}