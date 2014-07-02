package ec.gob.senagua.controladores;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import ec.gob.senagua.modelo.VwCalidadGeneral;
import ec.gob.senagua.servicios.VwCalidadGeneralLocal;

@ManagedBean
@SessionScoped
public class ReporteBusquedaParametroGeneral implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3981669892749643974L;

	@EJB
	private VwCalidadGeneralLocal vwCalidadGeneralLocal;

	private List<VwCalidadGeneral> vwCalidadGenerals;

	@PostConstruct
	public void init() {
		vwCalidadGenerals = new ArrayList<VwCalidadGeneral>();
		vwCalidadGenerals = vwCalidadGeneralLocal.getAll();

	}

	public List<VwCalidadGeneral> getVwCalidadGenerals() {
		return vwCalidadGenerals;
	}

	public void setVwCalidadGenerals(List<VwCalidadGeneral> vwCalidadGenerals) {
		this.vwCalidadGenerals = vwCalidadGenerals;
	}

}
