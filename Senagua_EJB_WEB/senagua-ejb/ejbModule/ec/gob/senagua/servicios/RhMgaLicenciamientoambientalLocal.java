package ec.gob.senagua.servicios;

import java.util.List;

import javax.ejb.Local;

import ec.gob.senagua.modelo.RhMgaLicenciamientoambiental;
import ec.gob.senagua.util.GenericoDAO;


@Local
public interface RhMgaLicenciamientoambientalLocal extends GenericoDAO<RhMgaLicenciamientoambiental, Integer>{
	
	public List<RhMgaLicenciamientoambiental> buscarOrdenarId();

}
