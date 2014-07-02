package ec.gob.senagua.servicios;

import javax.ejb.Local;

import ec.gob.senagua.modelo.RhMgaObjetivo;
import ec.gob.senagua.util.GenericoDAO;


@Local
public interface RhMgaObjetivoLocal extends GenericoDAO<RhMgaObjetivo, Integer>{

}
