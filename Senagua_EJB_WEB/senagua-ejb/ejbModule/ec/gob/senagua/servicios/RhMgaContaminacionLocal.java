package ec.gob.senagua.servicios;

import javax.ejb.Local;

import ec.gob.senagua.modelo.RhMgaContaminacion;
import ec.gob.senagua.util.GenericoDAO;


@Local
public interface RhMgaContaminacionLocal extends GenericoDAO<RhMgaContaminacion, Integer>{
	
}
