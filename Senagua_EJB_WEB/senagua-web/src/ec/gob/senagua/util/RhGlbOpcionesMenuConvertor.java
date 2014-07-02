package ec.gob.senagua.util;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

import ec.gob.senagua.modelo.RhGlbOpcionesMenu;
import ec.gob.senagua.servicios.RhGlbOpcionesMenuLocal;


/**
 * 
 *
 */
@ManagedBean
public class RhGlbOpcionesMenuConvertor implements Converter {

	@EJB
	private RhGlbOpcionesMenuLocal rhGlbOpcionesMenuLocal;

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		if (value == null || value.isEmpty()) {
			return null;
		}
		int id = new Integer(value);
		return  rhGlbOpcionesMenuLocal.buscarId(id) ;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
	/*	if (value == null) {
			return null;
		}
		Integer id= ((RhGlbOpcionesMenu)value).getOpcCodigo();		
		return (id == null) ? null : id.toString();*/
		
		 if (value == null || value.equals("")) {  
	            return "";  
	        } else {  
	            return String.valueOf(((RhGlbOpcionesMenu) value).getOpcCodigo());  
	        }  
	}
	
	
	 

}