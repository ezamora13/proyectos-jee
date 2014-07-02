package ec.gob.senagua.servicios;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.Query;

import ec.gob.senagua.modelo.RhGlbPerfil;
import ec.gob.senagua.modelo.RhGlbPermisosOpcionesMenuPerfil;
import ec.gob.senagua.util.EJBGenericoDAO;

/**
 * Session Bean implementation class RhGlbPermisosOpcionesMenuPerfilesServicio
 */
@Stateless
@LocalBean
public class RhGlbPermisosOpcionesMenuPerfilServicio extends
		EJBGenericoDAO<RhGlbPermisosOpcionesMenuPerfil, Integer> implements
		RhGlbPermisosOpcionesMenuPerfilLocal {
	RhGlbPerfilLocal perfilServicio;

	/**
	 * Default constructor.
	 */
	public RhGlbPermisosOpcionesMenuPerfilServicio() {

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<RhGlbPermisosOpcionesMenuPerfil> getAll(int codigoPerfil) {
		Query query = em
				.createQuery("from RhGlbPermisosOpcionesMenuPerfil op where op.rhGlbPerfile.pefCodigo = ? order by op.rhGlbOpcionesMenu.opcCodigo");

		// query.setParameter("codigoPerfil", codigoPerfil);
		query.setParameter(1, codigoPerfil);
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<RhGlbPermisosOpcionesMenuPerfil> getSubMenu(int codigoPerfil,
			int codigoNodo, int span) {
		// TODO rehacer el query por codigo de usuario y permiso
		Query query = em
				.createQuery("from RhGlbPermisosOpcionesMenuPerfil op where op.rhGlbPerfile.pefCodigo = :codigoPerfil and (op.rhGlbOpcionesMenu.opcCodigo > :codigo) and (op.rhGlbOpcionesMenu.opcCodigo < :codigo2) order by op.rhGlbOpcionesMenu.opcCodigo");
		query.setParameter("codigoPerfil", codigoPerfil);
		query.setParameter("codigo", codigoNodo);
		query.setParameter("codigo2", codigoNodo + span);
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<RhGlbPermisosOpcionesMenuPerfil> buscarXPerfil(
			RhGlbPerfil rhGlbPerfil) {
		Query query = em
				.createQuery("from RhGlbPermisosOpcionesMenuPerfil prm where prm.rhGlbPerfile = ? ORDER BY prm.rhGlbOpcionesMenu");
		query.setParameter(1, rhGlbPerfil);
		return query.getResultList();
	}

}