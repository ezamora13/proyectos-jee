package ec.gob.senagua.servicios;

import javax.ejb.Local;

import ec.gob.senagua.modelo.gis.Subcuenca;
import ec.gob.senagua.util.GenericoDAO;

@Local
public interface SubCuencaLocal extends GenericoDAO<Subcuenca, Integer> {

}
