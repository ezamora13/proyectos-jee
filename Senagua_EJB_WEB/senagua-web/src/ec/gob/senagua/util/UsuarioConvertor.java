package ec.gob.senagua.util;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import ec.gob.senagua.modelo.RhGlbUsuario;
import ec.gob.senagua.servicios.RhGlbUsuarioLocal;


/**
 * 
 *
 */
@ManagedBean
public class UsuarioConvertor implements Converter {
	@EJB
	private RhGlbUsuarioLocal usuarios;

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		if (value == null || value.isEmpty()) {
			return null;
		}
		int id = new Integer(value);
		return usuarios.buscarId(id);
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value == null) {
			return null;
		}
		Integer id = ((RhGlbUsuario) value).getUsuCodigo();
		return (id == null) ? null : id.toString();
	}

}