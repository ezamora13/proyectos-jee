package ec.gob.senagua.servicios;

import javax.ejb.Local;

import ec.gob.senagua.modelo.gis.DpaParroquia;
import ec.gob.senagua.util.GenericoDAO;


@Local
public interface DpaParroquiaLocal extends GenericoDAO<DpaParroquia, Integer>{
	

}
