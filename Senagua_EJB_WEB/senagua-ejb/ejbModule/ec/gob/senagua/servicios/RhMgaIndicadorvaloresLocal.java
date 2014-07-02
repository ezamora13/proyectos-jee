package ec.gob.senagua.servicios;

import java.util.List;

import javax.ejb.Local;

import ec.gob.senagua.modelo.RhMgaIndicador;
import ec.gob.senagua.modelo.RhMgaIndicadorvalore;
import ec.gob.senagua.util.GenericoDAO;


@Local
public interface RhMgaIndicadorvaloresLocal extends GenericoDAO<RhMgaIndicadorvalore, Integer>{
	
	public List<RhMgaIndicadorvalore> obtenerInidcadorValorXId(RhMgaIndicador rhMgaIndicador);
	
	public List<RhMgaIndicadorvalore> obtenerIndicadorValor_IdEstado(RhMgaIndicador rhMgaIndicador);
	
	public List<RhMgaIndicadorvalore> obtenerXidObjetivo(Integer Objetivo);
	
}
