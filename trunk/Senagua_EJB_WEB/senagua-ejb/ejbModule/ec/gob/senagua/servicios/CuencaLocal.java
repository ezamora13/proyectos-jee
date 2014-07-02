package ec.gob.senagua.servicios;

import javax.ejb.Local;

import ec.gob.senagua.modelo.gis.Cuenca;
import ec.gob.senagua.util.GenericoDAO;


@Local
public interface CuencaLocal extends GenericoDAO<Cuenca, Integer>{
	

}
