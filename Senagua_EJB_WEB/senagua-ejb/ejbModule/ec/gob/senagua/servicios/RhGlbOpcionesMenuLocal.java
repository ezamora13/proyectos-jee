package ec.gob.senagua.servicios;

import java.util.List;
import javax.ejb.Local;
import ec.gob.senagua.modelo.RhGlbOpcionesMenu;
import ec.gob.senagua.util.GenericoDAO;


@Local
public interface RhGlbOpcionesMenuLocal extends GenericoDAO<RhGlbOpcionesMenu, Integer>{
	public List<RhGlbOpcionesMenu> getSubMenu(int codigoNodo, int span);
	
	public List<RhGlbOpcionesMenu> buscarMenuFaltate(Integer codPerfil  );

}
