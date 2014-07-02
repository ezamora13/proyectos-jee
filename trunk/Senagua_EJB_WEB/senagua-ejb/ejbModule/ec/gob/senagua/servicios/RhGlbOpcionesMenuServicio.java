package ec.gob.senagua.servicios;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.Query;

import ec.gob.senagua.modelo.RhGlbOpcionesMenu;
import ec.gob.senagua.util.EJBGenericoDAO;

/**
 * Session Bean implementation class RhGlbOpcionesMenuServicio
 */
@Stateless
@LocalBean
public class RhGlbOpcionesMenuServicio extends
		EJBGenericoDAO<RhGlbOpcionesMenu, Integer> implements
		RhGlbOpcionesMenuLocal {
	/**
	 * Default constructor.
	 */
	public RhGlbOpcionesMenuServicio() {

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<RhGlbOpcionesMenu> getAll() {
		Query query = em
				.createQuery("from RhGlbOpcionesMenu order by opcCodigo");
		return query.getResultList();
	}

	/*
	 * @SuppressWarnings("unchecked")
	 * 
	 * @Override public List<RhGlbOpcionesMenu> getPrimerNivel() { Query query =
	 * em .createQuery(
	 * "from RhGlbOpcionesMenu where opcCodigo%100 == 0 order by opcCodigo");
	 * return query.getResultList(); }
	 */

	@SuppressWarnings("unchecked")
	@Override
	public List<RhGlbOpcionesMenu> getSubMenu(int codigoNodo, int span) {
		Query query = em
				.createQuery("from RhGlbOpcionesMenu where (opcCodigo > :codigo) and (opcCodigo < :codigo2) order by opcCodigo");
		query.setParameter("codigo", codigoNodo);
		query.setParameter("codigo2", codigoNodo + span);
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<RhGlbOpcionesMenu> buscarMenuFaltate(Integer codPerfil) {

		Query query = em
				.createNativeQuery(
						"select * from modulos.rh_glb_opciones_menu where opc_codigo not in( select opc_codigo  from modulos.rh_glb_permisos_opciones_menu_perfil  prm where pef_codigo= ? ) order by opc_codigo",
						RhGlbOpcionesMenu.class);
		query.setParameter(1, codPerfil);

		return query.getResultList();
	}

}