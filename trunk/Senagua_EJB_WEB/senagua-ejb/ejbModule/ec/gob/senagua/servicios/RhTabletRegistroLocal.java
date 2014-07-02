package ec.gob.senagua.servicios;

import java.util.List;

import javax.ejb.Local;

import ec.gob.senagua.modelo.RhTabletRegistro;
import ec.gob.senagua.util.GenericoDAO;


@Local
public interface RhTabletRegistroLocal extends GenericoDAO<RhTabletRegistro, Integer>{

	public List<RhTabletRegistro> buscarXtipoFicha(String tipoModulo);
	
	public List<RhTabletRegistro> buscarRegistroParaMonitoreo();

}
