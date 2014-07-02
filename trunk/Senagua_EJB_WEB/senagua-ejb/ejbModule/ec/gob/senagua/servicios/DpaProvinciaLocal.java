package ec.gob.senagua.servicios;

import javax.ejb.Local;

import ec.gob.senagua.modelo.gis.DpaProvincia;
import ec.gob.senagua.util.GenericoDAO;


@Local
public interface DpaProvinciaLocal extends GenericoDAO<DpaProvincia, Integer>{
	

}
