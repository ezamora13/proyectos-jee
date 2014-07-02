package ec.gob.senagua.servicios;

import java.util.List;

import javax.ejb.Local;

import ec.gob.senagua.modelo.RhMcaMuestreo;
import ec.gob.senagua.modelo.RhTabletRegistro;
import ec.gob.senagua.util.GenericoDAO;

@Local
public interface RhMcaMuestreoLocal extends GenericoDAO<RhMcaMuestreo, Integer> {

	public List<RhMcaMuestreo> obtenerOrderXiD();

	public List<RhMcaMuestreo> buscarXiD(RhTabletRegistro registro);

}
