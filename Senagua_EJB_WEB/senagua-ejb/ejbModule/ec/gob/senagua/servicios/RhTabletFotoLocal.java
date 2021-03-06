package ec.gob.senagua.servicios;

import java.util.List;

import javax.ejb.Local;

import ec.gob.senagua.modelo.RhTabletFoto;
import ec.gob.senagua.modelo.RhTabletRegistro;
import ec.gob.senagua.util.GenericoDAO;

@Local
public interface RhTabletFotoLocal extends GenericoDAO<RhTabletFoto, Integer> {

	public List<RhTabletFoto> buscarXidTabletRegitro(
			RhTabletRegistro rhTabletRegistro);
}
