package ec.gob.senagua.servicios;

import javax.ejb.Local;

import ec.gob.senagua.modelo.gis.DpaCantone;
import ec.gob.senagua.util.GenericoDAO;


@Local
public interface DpaCantoneLocal extends GenericoDAO<DpaCantone, Integer>{
	
}
