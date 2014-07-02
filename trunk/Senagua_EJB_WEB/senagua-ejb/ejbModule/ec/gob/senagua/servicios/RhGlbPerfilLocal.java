package ec.gob.senagua.servicios;

import javax.ejb.Local;

import ec.gob.senagua.modelo.RhGlbPerfil;
import ec.gob.senagua.util.GenericoDAO;


@Local
public interface RhGlbPerfilLocal extends GenericoDAO<RhGlbPerfil, Integer>{

}
