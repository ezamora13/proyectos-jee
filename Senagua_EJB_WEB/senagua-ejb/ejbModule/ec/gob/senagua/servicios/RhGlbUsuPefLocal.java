package ec.gob.senagua.servicios;

import javax.ejb.Local;

import ec.gob.senagua.modelo.RhGlbPerfil;
import ec.gob.senagua.modelo.RhGlbUsuPef;
import ec.gob.senagua.modelo.RhGlbUsuario;
import ec.gob.senagua.util.GenericoDAO;

@Local
public interface RhGlbUsuPefLocal extends GenericoDAO<RhGlbUsuPef, Integer> {

	public RhGlbPerfil buscarPerfilxUsuario(RhGlbUsuario usuario);

	public RhGlbUsuPef buscarUsuPef(RhGlbUsuario usuario);

}
