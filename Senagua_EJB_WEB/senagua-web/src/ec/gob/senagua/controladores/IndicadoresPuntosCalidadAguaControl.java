package ec.gob.senagua.controladores;

import java.awt.Color;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;
import org.primefaces.model.chart.CartesianChartModel;

import ec.gob.senagua.modelo.RhMcaMuestreo;
import ec.gob.senagua.modelo.RhMcaReportelaboratorio;
import ec.gob.senagua.servicios.RhMcaMuestreoLocal;
import ec.gob.senagua.servicios.RhMcaReportelaboratorioLocal;

@ManagedBean
@SessionScoped
public class IndicadoresPuntosCalidadAguaControl implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4804004392734666407L;

	@EJB
	private RhMcaMuestreoLocal rhMcaMuestreoLocal;
	@EJB
	private RhMcaReportelaboratorioLocal rhMcaReportelaboratorioLocal;

	private List<RhMcaMuestreo> rhMcaMuestreoLst;
	List<RhMcaMuestreo> mcaMuestreostmp;

	private List<RhMcaReportelaboratorio> rhMcaReportelaboratorios;
	private List<String> parametros;

	private CartesianChartModel model;

	private Integer idMuestreo;
	private Integer valorMaximo;

	private List<String> selectedPuntos;
	private List<String> selectedParametros;
	private List<String> muestreo;
	private StreamedContent chartImage;

	private Boolean flag;
	private Boolean flagGrafico;
	private InputStream inputStream;

	private Boolean flagTets = false;

	@PostConstruct
	public void init() {
		rhMcaMuestreoLst = new ArrayList<RhMcaMuestreo>();
		rhMcaReportelaboratorios = new ArrayList<RhMcaReportelaboratorio>();
		muestreo = new ArrayList<String>();
		selectedPuntos = new ArrayList<String>();
		selectedParametros = new ArrayList<String>();
		mcaMuestreostmp = new ArrayList<RhMcaMuestreo>();

		rhMcaMuestreoLst = rhMcaMuestreoLocal.getAll();
		for (RhMcaMuestreo m : rhMcaMuestreoLst) {
			muestreo.add(m.getMsCodigo());
		}

		idMuestreo = 0;
		valorMaximo = 0;
		flag = false;
		flagGrafico = false;

		chartImage = null;

		// /

	}

	/**
	 * Consulta los parametros a graficar
	 * */
	public void consultarParametros() {
		if (selectedPuntos.size() == 0 || selectedPuntos.size() > 3
				|| selectedParametros.size() == 0) {
			FacesMessage message = new FacesMessage(
					FacesMessage.SEVERITY_ERROR, "Indicadores:",
					"Escoja al menos 1 muestra hasta 3 o un parametro a graficar ..");
			FacesContext.getCurrentInstance().addMessage(null, message);
		} else {
			rhMcaReportelaboratorios = rhMcaReportelaboratorioLocal
					.buscarXiDsMuestraParametro(mcaMuestreostmp,
							selectedParametros);
			flagGrafico = true;

		}
	}

	public void graficar() {
		chartImage = new DefaultStreamedContent();
		File cFile = null;
		inputStream = null;

		try {
			flagGrafico = true;
			// Creando el Grafico
			JFreeChart chart = ChartFactory.createBarChart3D(
					"Grafica Indicadores", "Fecha Muestro", "Medición", dataset(),
					PlotOrientation.VERTICAL, true, true, false);
			chart.setBackgroundPaint(Color.cyan);
			chart.getTitle().setPaint(Color.black);
			CategoryPlot p = chart.getCategoryPlot();
			p.setRangeGridlinePaint(Color.red);
			// Mostrar Grafico
			cFile = new File("archivo");
			ChartUtilities.saveChartAsPNG(cFile, chart, 1000, 1000);
			inputStream = new FileInputStream(cFile);

			chartImage = new DefaultStreamedContent(new FileInputStream(cFile),
					"image/png");

		} catch (IOException e) {
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR,
							"Indicadores:", "Problemas con Datos ..."));
		}

	}

	public StreamedContent getSelectedFileLImpiar() {

		return null;
	}

	/**
	 * Descargar archivo 
	 * */
	public StreamedContent getSelectedFile() {
		graficar();
		return new DefaultStreamedContent(inputStream, "image/png",
				"Senagua_Grafica");
	}

	private DefaultCategoryDataset dataset() {
		try {

			DefaultCategoryDataset dataset = new DefaultCategoryDataset();
			for (RhMcaReportelaboratorio rpt : rhMcaReportelaboratorios) {
				dataset.setValue(
						Double.parseDouble(rpt.getRptMedicion().replaceAll(",",
								".")), rpt.getRptParametro(),
						rpt.getRptFechamuestreo());

				System.out.println(rpt.getRptMedicion() + " - "
						+ rpt.getRptParametro() + " - "
						+ rpt.getRptFechamuestreo());
			}

			// dataset.setValue(8, "yy", "Lunes");
			// dataset.setValue(7, "xx", "Lunes");
			return dataset;
		} catch (Exception e) {
			return null;
		}

	}

	/**
	 * Seleccion Parametro
	 * */
	public void escogerParametro() {

		if (selectedPuntos.size() == 0 || selectedPuntos.size() > 3) {
			FacesMessage message = new FacesMessage(
					FacesMessage.SEVERITY_ERROR, "Indicadores:",
					"Escoja al menos 1 hasta 3 Codigos..");
			FacesContext.getCurrentInstance().addMessage(null, message);
		} else {
			if (selectedPuntos.size() == 1) {
				for (RhMcaMuestreo r1 : rhMcaMuestreoLocal.getAll()) {
					if (r1.getMsCodigo().equals(selectedPuntos.get(0))) {
						mcaMuestreostmp.add(r1);
					}

				}
			}

			if (selectedPuntos.size() == 2) {
				for (RhMcaMuestreo r2 : rhMcaMuestreoLocal.getAll()) {
					if (r2.getMsCodigo().equals(selectedPuntos.get(0))) {
						mcaMuestreostmp.add(r2);
					}
					if (r2.getMsCodigo().equals(selectedPuntos.get(1))) {
						mcaMuestreostmp.add(r2);
					}

				}
			}
			if (selectedPuntos.size() == 3) {
				for (RhMcaMuestreo r3 : rhMcaMuestreoLocal.getAll()) {
					if (r3.getMsCodigo().equals(selectedPuntos.get(0))) {
						mcaMuestreostmp.add(r3);
					}
					if (r3.getMsCodigo().equals(selectedPuntos.get(1))) {
						mcaMuestreostmp.add(r3);
					}
					if (r3.getMsCodigo().equals(selectedPuntos.get(2))) {
						mcaMuestreostmp.add(r3);
					}

				}
			}
			parametros = rhMcaReportelaboratorioLocal
					.buscarParametroFechaXiDsMuestra(mcaMuestreostmp);
			flag = true;
			flagGrafico = false;

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

	public List<String> getSelectedPuntos() {
		return selectedPuntos;
	}

	public void setSelectedPuntos(List<String> selectedPuntos) {
		this.selectedPuntos = selectedPuntos;
	}

	public List<String> getMuestreo() {
		return muestreo;
	}

	public void setMuestreo(List<String> muestreo) {
		this.muestreo = muestreo;
	}

	public List<String> getSelectedParametros() {
		return selectedParametros;
	}

	public void setSelectedParametros(List<String> selectedParametros) {
		this.selectedParametros = selectedParametros;
	}

	public StreamedContent getChartImage() {
		return chartImage;
	}

	public void setChartImage(StreamedContent chartImage) {
		this.chartImage = chartImage;
	}

	public Boolean getFlagGrafico() {
		return flagGrafico;
	}

	public void setFlagGrafico(Boolean flagGrafico) {
		this.flagGrafico = flagGrafico;
	}

	public List<RhMcaMuestreo> getMcaMuestreostmp() {
		return mcaMuestreostmp;
	}

	public void setMcaMuestreostmp(List<RhMcaMuestreo> mcaMuestreostmp) {
		this.mcaMuestreostmp = mcaMuestreostmp;
	}

	public Boolean getFlagTets() {
		return flagTets;
	}

	public void setFlagTets(Boolean flagTets) {
		this.flagTets = flagTets;
	}

	public InputStream getInputStream() {
		return inputStream;
	}

	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}

}
