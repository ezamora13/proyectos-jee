package ec.gob.senagua.servicios;

import javax.ejb.Local;

import ec.gob.senagua.modelo.RhParametroSistema;
import ec.gob.senagua.util.GenericoDAO;


@Local
public interface RhParametroSistemaLocal extends GenericoDAO<RhParametroSistema, Integer>{
	

}
