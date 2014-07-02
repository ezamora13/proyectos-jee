package ec.gob.senagua.servicios;

import java.util.List;

import javax.ejb.Local;

import ec.gob.senagua.modelo.RhMgaIndicador;
import ec.gob.senagua.util.GenericoDAO;


@Local
public interface RhMgaIndicadorLocal extends GenericoDAO<RhMgaIndicador, Integer>{
	
	public List<RhMgaIndicador> obtenerIndicadorXobjetivo(Integer objetivo);

}
