package ec.gob.senagua.servicios;

import java.util.List;

import javax.ejb.Local;

import ec.gob.senagua.modelo.RhMcaParametrosNormavigente;
import ec.gob.senagua.util.GenericoDAO;


@Local
public interface RhMcaParametrosNormavigenteLocal extends GenericoDAO<RhMcaParametrosNormavigente, Integer>{
	
	public List<RhMcaParametrosNormavigente> buscaEstadoTrue();
	
	public List<String> buscarAnios();

	public List<String> buscarTipo();
	
	public List<RhMcaParametrosNormavigente> buscar_AnioTipo(
			Integer anio, String tipo);
}
