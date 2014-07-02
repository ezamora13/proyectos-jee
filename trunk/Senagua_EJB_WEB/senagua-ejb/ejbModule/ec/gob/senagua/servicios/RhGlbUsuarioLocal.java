package ec.gob.senagua.servicios;

import java.util.List;

import javax.ejb.Local;

import ec.gob.senagua.modelo.RhGlbUsuario;
import ec.gob.senagua.util.GenericoDAO;

@Local
public interface RhGlbUsuarioLocal extends GenericoDAO<RhGlbUsuario, Integer> {
	public RhGlbUsuario  buscarUsuario(String usuario);

	public List<RhGlbUsuario> buscarUsuarioOrdenadoxId();

}
