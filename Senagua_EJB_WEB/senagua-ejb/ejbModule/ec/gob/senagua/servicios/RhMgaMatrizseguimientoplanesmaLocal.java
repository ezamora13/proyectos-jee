package ec.gob.senagua.servicios;

import java.util.List;

import javax.ejb.Local;

import ec.gob.senagua.modelo.RhMgaMatrizseguimientoplanesma;
import ec.gob.senagua.modelo.RhMgaProyectomatrizseguimientoplanesma;
import ec.gob.senagua.util.GenericoDAO;

@Local
public interface RhMgaMatrizseguimientoplanesmaLocal extends
		GenericoDAO<RhMgaMatrizseguimientoplanesma, Integer> {

	public List<RhMgaMatrizseguimientoplanesma> buscarOrdenarId(RhMgaProyectomatrizseguimientoplanesma rhMgaProyectomatrizseguimientoplanesma);
}
