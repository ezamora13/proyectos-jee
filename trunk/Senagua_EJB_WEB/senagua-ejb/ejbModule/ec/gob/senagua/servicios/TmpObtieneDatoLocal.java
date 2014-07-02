package ec.gob.senagua.servicios;

import javax.ejb.Local;

import ec.gob.senagua.modelo.TmpObtienedato;
import ec.gob.senagua.util.GenericoDAO;


@Local
public interface TmpObtieneDatoLocal extends GenericoDAO<TmpObtienedato, Integer>{


}
