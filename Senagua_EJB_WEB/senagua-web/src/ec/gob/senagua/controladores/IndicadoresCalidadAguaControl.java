package ec.gob.senagua.controladores;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.primefaces.model.chart.CartesianChartModel;
import org.primefaces.model.chart.ChartSeries;

import ec.gob.senagua.modelo.RhMcaMuestreo;
import ec.gob.senagua.modelo.RhMcaReportelaboratorio;
import ec.gob.senagua.servicios.RhMcaMuestreoLocal;
import ec.gob.senagua.servicios.RhMcaReportelaboratorioLocal;

@ManagedBean
@SessionScoped
public class IndicadoresCalidadAguaControl implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4804004392734666407L;

	@EJB
	private RhMcaMuestreoLocal rhMcaMuestreoLocal;
	@EJB
	private RhMcaReportelaboratorioLocal rhMcaReportelaboratorioLocal;

	private List<RhMcaMuestreo> rhMcaMuestreoLst;
	private List<RhMcaReportelaboratorio> rhMcaReportelaboratorios;
	private List<String> parametros;

	private CartesianChartModel model;
	private String parametro;
	private Integer idMuestreo;
	private Integer valorMaximo;

	private Boolean flag;

	@PostConstruct
	public void init() {
		rhMcaMuestreoLst = new ArrayList<RhMcaMuestreo>();
		rhMcaMuestreoLst = rhMcaMuestreoLocal.getAll();
		rhMcaReportelaboratorios = new ArrayList<RhMcaReportelaboratorio>();
		parametro = "";
		idMuestreo = 0;
		valorMaximo = 0;
		flag = false;
	}

	public void cargarParametros() {
		if (idMuestreo != 0) {
			parametros = rhMcaReportelaboratorioLocal
					.buscarXidAgruparParametros(idMuestreo);

			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,
					"Indicadores:", "Parametros Cargados..");
			FacesContext.getCurrentInstance().addMessage(null, message);
		} else {
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_WARN,
					"Indicadores:", "No existe Parametros..");
			FacesContext.getCurrentInstance().addMessage(null, message);
		}

	}

	public void graficar() {
		try {
			if (idMuestreo == 0 || parametro.isEmpty()) {
				FacesMessage message = new FacesMessage(
						FacesMessage.SEVERITY_WARN, "Indicadores:",
						"Escoja los Parametros..");
				FacesContext.getCurrentInstance().addMessage(null, message);
			} else {
				rhMcaReportelaboratorios = rhMcaReportelaboratorioLocal
						.buscarXid_Parametro(idMuestreo, parametro);
				model = new CartesianChartModel();
				ChartSeries p = new ChartSeries();
				ChartSeries p2= new ChartSeries();
				p.setLabel(parametro);
				p2.setLabel(parametro+"zxxxxzzz");
				
				for (RhMcaReportelaboratorio r : rhMcaReportelaboratorios) {
					System.out.println(r.getRptMedicion().replaceAll(",", "."));
					p.set(r.getRptFechamuestreo(),
							Double.parseDouble(r.getRptMedicion().replaceAll(
									",", ".")));
					p2.set(r.getRptFechamuestreo(),2*
							Double.parseDouble(r.getRptMedicion().replaceAll(
									",", ".")));
					
				}
				model.addSeries(p);
				model.addSeries(p2);
				flag = true;

			}

		} catch (Exception e) {
			FacesMessage message = new FacesMessage(
					FacesMessage.SEVERITY_ERROR, "Indicadores:",
					"Problemas con Datos de Reporte..");
			FacesContext.getCurrentInstance().addMessage(null, message);
		}

	}

	public List<RhMcaMuestreo> getRhMcaMuestreoLst() {
		return rhMcaMuestreoLst;
	}

	public void setRhMcaMuestreoLst(List<RhMcaMuestreo> rhMcaMuestreoLst) {
		this.rhMcaMuestreoLst = rhMcaMuestreoLst;
	}

	public Integer getIdMuestreo() {
		return idMuestreo;
	}

	public void setIdMuestreo(Integer idMuestreo) {
		this.idMuestreo = idMuestreo;
	}

	public Integer getValorMaximo() {
		return valorMaximo;
	}

	public void setValorMaximo(Integer valorMaximo) {
		this.valorMaximo = valorMaximo;
	}

	public List<RhMcaReportelaboratorio> getRhMcaReportelaboratorios() {
		return rhMcaReportelaboratorios;
	}

	public void setRhMcaReportelaboratorios(
			List<RhMcaReportelaboratorio> rhMcaReportelaboratorios) {
		this.rhMcaReportelaboratorios = rhMcaReportelaboratorios;
	}

	public List<String> getParametros() {
		return parametros;
	}

	public void setParametros(List<String> parametros) {
		this.parametros = parametros;
	}

	public String getParametro() {
		return parametro;
	}

	public void setParametro(String parametro) {
		this.parametro = parametro;
	}

	public Boolean getFlag() {
		return flag;
	}

	public void setFlag(Boolean flag) {
		this.flag = flag;
	}

	public CartesianChartModel getModel() {
		return model;
	}

	public void setModel(CartesianChartModel model) {
		this.model = model;
	}

}
