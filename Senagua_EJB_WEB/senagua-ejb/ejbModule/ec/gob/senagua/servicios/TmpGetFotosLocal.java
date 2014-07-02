package ec.gob.senagua.servicios;

import javax.ejb.Local;

import ec.gob.senagua.modelo.TmpGetFoto;
import ec.gob.senagua.util.GenericoDAO;

@Local
public interface TmpGetFotosLocal extends GenericoDAO<TmpGetFoto, Integer> {

	public TmpGetFoto buscarCod(String cod);
}
