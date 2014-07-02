package ec.gob.senagua.controladores;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import ec.gob.senagua.modelo.RhMcaComparacionreportenormalimite;
import ec.gob.senagua.servicios.RhMcaComparacionreportenormalimiteLocal;

@ManagedBean
@SessionScoped
public class SeguimientoMatrizCalidadAguaControl implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4804004392734666407L;

	@EJB
	private RhMcaComparacionreportenormalimiteLocal rhMcaComparacionreportenormalimiteLocal;

	private RhMcaComparacionreportenormalimite rhMcaComparacionreportenormalimite;
	private List<RhMcaComparacionreportenormalimite> rhMcaComparacionreportenormalimiteLst;

	@PostConstruct
	public void init() {
		rhMcaComparacionreportenormalimite = new RhMcaComparacionreportenormalimite();
		rhMcaComparacionreportenormalimiteLst = new ArrayList<RhMcaComparacionreportenormalimite>();
		rhMcaComparacionreportenormalimiteLst=rhMcaComparacionreportenormalimiteLocal.getAll();

	}

	public RhMcaComparacionreportenormalimite getRhMcaComparacionreportenormalimite() {
		return rhMcaComparacionreportenormalimite;
	}

	public void setRhMcaComparacionreportenormalimite(
			RhMcaComparacionreportenormalimite rhMcaComparacionreportenormalimite) {
		this.rhMcaComparacionreportenormalimite = rhMcaComparacionreportenormalimite;
	}

	public List<RhMcaComparacionreportenormalimite> getRhMcaComparacionreportenormalimiteLst() {
		return rhMcaComparacionreportenormalimiteLst;
	}

	public void setRhMcaComparacionreportenormalimiteLst(
			List<RhMcaComparacionreportenormalimite> rhMcaComparacionreportenormalimiteLst) {
		this.rhMcaComparacionreportenormalimiteLst = rhMcaComparacionreportenormalimiteLst;
	}

}
