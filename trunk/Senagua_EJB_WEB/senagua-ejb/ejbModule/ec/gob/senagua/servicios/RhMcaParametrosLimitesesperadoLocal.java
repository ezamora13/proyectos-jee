package ec.gob.senagua.servicios;

import java.util.List;

import javax.ejb.Local;

import ec.gob.senagua.modelo.RhMcaParametrosLimitesesperado;
import ec.gob.senagua.util.GenericoDAO;

@Local
public interface RhMcaParametrosLimitesesperadoLocal extends
		GenericoDAO<RhMcaParametrosLimitesesperado, Integer> {

	public List<RhMcaParametrosLimitesesperado> buscaEstadoTrue();

	public List<String> buscarProvincias();

	public List<String> buscarActividad();

	public List<RhMcaParametrosLimitesesperado> buscar_DemaracionLimite(
			String demarcacion, String actividad);
}
