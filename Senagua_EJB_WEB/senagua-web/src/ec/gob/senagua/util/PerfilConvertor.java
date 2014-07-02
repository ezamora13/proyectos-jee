package ec.gob.senagua.util;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import ec.gob.senagua.modelo.RhGlbPerfil;
import ec.gob.senagua.servicios.RhGlbPerfilLocal;


/**
 * 
 *
 */
@ManagedBean
public class PerfilConvertor implements Converter {
	@EJB
	private RhGlbPerfilLocal perfiles;

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		if (value == null || value.isEmpty()) {
			return null;
		}
		int id = new Integer(value);
		return perfiles.buscarId(id);
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value == null) {
			return null;
		}
		Integer id = ((RhGlbPerfil) value).getPefCodigo();
		return (id == null) ? null : id.toString();
	}

}