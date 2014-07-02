package ec.gob.senagua.servicios;

import java.util.List;

import javax.ejb.Local;

import ec.gob.senagua.modelo.RhGlbPerfil;
import ec.gob.senagua.modelo.RhGlbPermisosOpcionesMenuPerfil;
import ec.gob.senagua.util.GenericoDAO;

@Local
public interface RhGlbPermisosOpcionesMenuPerfilLocal extends
		GenericoDAO<RhGlbPermisosOpcionesMenuPerfil, Integer> {
	public List<RhGlbPermisosOpcionesMenuPerfil> getAll(int codigoPerfil);

	public List<RhGlbPermisosOpcionesMenuPerfil> getSubMenu(int codigoPerfil,
			int codigoNodo, int span);

	public List<RhGlbPermisosOpcionesMenuPerfil> buscarXPerfil(
			RhGlbPerfil rhGlbPerfil);

}
