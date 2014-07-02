package ec.gob.senagua.servicios;

import javax.ejb.Local;

import ec.gob.senagua.modelo.VwCalidadGeneral;
import ec.gob.senagua.util.GenericoDAO;


@Local
public interface VwCalidadGeneralLocal extends GenericoDAO<VwCalidadGeneral, Integer>{


}
