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

import ec.gob.senagua.modelo.RhMgaIndicador;
import ec.gob.senagua.modelo.RhMgaIndicadorvalore;
import ec.gob.senagua.modelo.RhMgaObjetivo;
import ec.gob.senagua.servicios.RhMgaIndicadorLocal;
import ec.gob.senagua.servicios.RhMgaIndicadorvaloresLocal;
import ec.gob.senagua.servicios.RhMgaObjetivoLocal;

@ManagedBean
@SessionScoped
public class IndicadoresAmbientalControl implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4804004392734666407L;

	@EJB
	private RhMgaObjetivoLocal rhMgaObjetivoLocal;
	@EJB
	private RhMgaIndicadorLocal rhMgaIndicadorLocal;
	@EJB
	private RhMgaIndicadorvaloresLocal rhMgaIndicadorvaloresLocal;

	private RhMgaObjetivo rhMgaObjetivo;
	private RhMgaIndicador rhMgaIndicador;
	private RhMgaIndicadorvalore rhMgaIndicadorvalore;
	private List<RhMgaObjetivo> rhMgaObjetivolst;
	private List<RhMgaIndicador> rhMgaIndicadorlst;
	private List<RhMgaIndicadorvalore> rhMgaIndicadorvalorelst;
	private List<String> periodoLista;
	private CartesianChartModel categoryModel;
	private ChartSeries indicador;
	private ChartSeries indicadorEsperado;

	private boolean flag;
	private boolean flagEliminar;
	private Integer id;
	private boolean flagWaiting;

	@PostConstruct
	public void init() {
		rhMgaObjetivo = new RhMgaObjetivo();
		rhMgaIndicador = new RhMgaIndicador();
		rhMgaIndicadorvalore = new RhMgaIndicadorvalore();
		rhMgaObjetivolst = new ArrayList<RhMgaObjetivo>();
		rhMgaIndicadorlst = new ArrayList<RhMgaIndicador>();
		rhMgaIndicadorvalorelst = new ArrayList<RhMgaIndicadorvalore>();
		flag = false;
		flagWaiting = false;
		flagEliminar = false;
		id = 0;
		periodoLista = new ArrayList<String>();
		listarPerido();
		rhMgaObjetivolst = rhMgaObjetivoLocal.getAll();
		flag = false;
		categoryModel = new CartesianChartModel();
		indicador = new ChartSeries();

	}

	public void listarPerido() {
		periodoLista.add("Anual");
		periodoLista.add("Semestral");
		periodoLista.add("Trimestral");
		periodoLista.add("Bimensual");
		periodoLista.add("Mensual");
	}

	/**
	 * Nuevo AnalisisReport
	 * */
	public void nuevo() {
		flag = false;
		rhMgaIndicador = new RhMgaIndicador();

		if (id == 0) {
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,
					"Actualización:", "Escoja primero un Objetivo..");
			FacesContext.getCurrentInstance().addMessage(null, message);
			rhMgaIndicadorlst = new ArrayList<RhMgaIndicador>();
		} else {
			rhMgaIndicadorlst.add(rhMgaIndicador);
		}

	}

	/**
	 * Cargar Objeto
	 * **/
	public void actualizar() {
		flag = false;
		if (id == 0) {
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,
					"Actualización:", "Escoja primero un Objetivo..");
			FacesContext.getCurrentInstance().addMessage(null, message);

			rhMgaIndicadorlst = new ArrayList<RhMgaIndicador>();
		} else {
			rhMgaIndicadorlst = rhMgaIndicadorLocal
					.obtenerIndicadorXobjetivo(id);

		}

	}

	/**
	 * Cancelar Carga de archivos
	 */
	public void guardar() {
		flag = false;
		rhMgaObjetivo = new RhMgaObjetivo();
		rhMgaObjetivo.setObId(id);
		for (RhMgaIndicador i : rhMgaIndicadorlst) {
			if (i.getRhMgaObjetivo() == null)
				i.setRhMgaObjetivo(rhMgaObjetivo);

			rhMgaIndicadorLocal.makePersistent(i);
		}
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,
				"Guardar Archivos", "Informacion Guarda con Éxito..");
		FacesContext.getCurrentInstance().addMessage(null, message);
		rhMgaIndicadorlst = rhMgaIndicadorLocal.obtenerIndicadorXobjetivo(id);

	}

	/**
	 * Carga de Indicadores
	 */

	public void cargaIndicadores() {
		if (id == 0) {
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,
					"Actualización:", "Escoja primero un Objetivo..");
			FacesContext.getCurrentInstance().addMessage(null, message);
			rhMgaIndicadorlst = new ArrayList<RhMgaIndicador>();
			flagEliminar = false;
		} else {
			rhMgaIndicadorlst = rhMgaIndicadorLocal
					.obtenerIndicadorXobjetivo(id);
			flagEliminar = true;
		}

	}

	/**
	 * Edicion de Indicadores
	 */
	public void editarIndicador() {
		flag = false;
		if (rhMgaIndicador.getInId() == null) {
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_WARN,
					"Editar Indicador:",
					"Antes de Agregar Valores Debe guardar el indicador..");
			FacesContext.getCurrentInstance().addMessage(null, message);
		} else {

			rhMgaIndicadorvalorelst = new ArrayList<RhMgaIndicadorvalore>();
			rhMgaIndicadorvalorelst = rhMgaIndicadorvaloresLocal
					.obtenerInidcadorValorXId(rhMgaIndicador);

			if (rhMgaIndicador.getInPeriodo().trim().isEmpty()) {
				FacesMessage message = new FacesMessage(
						FacesMessage.SEVERITY_INFO, "Editar Indicador:",
						"Escoja el Periodo..");
				FacesContext.getCurrentInstance().addMessage(null, message);
			} else {
				// Actualizo al nuevo Indicador
				rhMgaIndicador = rhMgaIndicadorLocal
						.makePersistent(rhMgaIndicador);
				// SI esta vacio mando a crear 12 IndiceValor
				if (rhMgaIndicadorvalorelst.size() == 0) {
					rhMgaIndicadorvalorelst = crearIndicadorValores(
							rhMgaIndicadorvalorelst.size(), rhMgaIndicador);
					for (RhMgaIndicadorvalore in : rhMgaIndicadorvalorelst) {
						rhMgaIndicadorvaloresLocal.makePersistent(in);
					}
					rhMgaIndicadorvalorelst = new ArrayList<RhMgaIndicadorvalore>();
					rhMgaIndicadorvalorelst = rhMgaIndicadorvaloresLocal
							.obtenerInidcadorValorXId(rhMgaIndicador);
				}
				if (rhMgaIndicadorvalorelst.size() == 12) {
					if (rhMgaIndicador.getInPeriodo().trim().equals("Mensual")) {
						rhMgaIndicadorvalorelst = editarIndicadorValores(12,
								rhMgaIndicadorvalorelst);
					} else if (rhMgaIndicador.getInPeriodo().trim()
							.equals("Bimensual")) {
						rhMgaIndicadorvalorelst = editarIndicadorValores(6,
								rhMgaIndicadorvalorelst);
					} else if (rhMgaIndicador.getInPeriodo().trim()
							.equals("Trimestral")) {
						rhMgaIndicadorvalorelst = editarIndicadorValores(4,
								rhMgaIndicadorvalorelst);
					} else if (rhMgaIndicador.getInPeriodo().trim()
							.equals("Semestral")) {
						rhMgaIndicadorvalorelst = editarIndicadorValores(2,
								rhMgaIndicadorvalorelst);

					} else if (rhMgaIndicador.getInPeriodo().trim()
							.equals("Anual")) {
						rhMgaIndicadorvalorelst = editarIndicadorValores(1,
								rhMgaIndicadorvalorelst);
					}
				}

			}
		}
	}

	/**
	 * Permite Crear los Indicadores si no Existe
	 */
	public List<RhMgaIndicadorvalore> crearIndicadorValores(int cantidad,
			RhMgaIndicador rhMgaIndicador) {
		List<RhMgaIndicadorvalore> rhMgaIndicadorvaloreLstTmp = new ArrayList<RhMgaIndicadorvalore>();
		if (cantidad == 0) {
			for (int i = 0; i < 12; i++) {
				rhMgaIndicadorvalore.setRhMgaIndicador(rhMgaIndicador);
				rhMgaIndicadorvalore.setInvEstado(false);
				rhMgaIndicadorvaloreLstTmp.add(i, rhMgaIndicadorvalore);
			}

		}
		return rhMgaIndicadorvaloreLstTmp;
	}

	/**
	 * edita Indicadores y le ensera al numero que corresponda
	 */
	public List<RhMgaIndicadorvalore> editarIndicadorValores(int cantidad,
			List<RhMgaIndicadorvalore> rhMgaIndicadorvalores) {
		List<RhMgaIndicadorvalore> rhMgaIndicadorvaloreLstTmp = new ArrayList<RhMgaIndicadorvalore>();
		if (cantidad == 12) {
			for (int i = 0; i < 12; i++) {
				rhMgaIndicadorvalores.get(i).setInvEstado(true);
			}
			rhMgaIndicadorvaloreLstTmp = rhMgaIndicadorvalores;
		} else if (cantidad == 6) {
			for (int i = 0; i < 12; i++) {
				rhMgaIndicadorvalores.get(i).setInvEstado(false);
			}
			rhMgaIndicadorvaloreLstTmp = rhMgaIndicadorvalores;
			for (int i = 0; i < 6; i++) {
				rhMgaIndicadorvaloreLstTmp.get(i).setInvEstado(true);
			}

		}

		else if (cantidad == 4) {
			for (int i = 0; i < 12; i++) {
				rhMgaIndicadorvalores.get(i).setInvEstado(false);
			}
			rhMgaIndicadorvaloreLstTmp = rhMgaIndicadorvalores;
			for (int i = 0; i < 4; i++) {
				rhMgaIndicadorvaloreLstTmp.get(i).setInvEstado(true);
			}

		} else if (cantidad == 2) {
			for (int i = 0; i < 12; i++) {
				rhMgaIndicadorvalores.get(i).setInvEstado(false);
			}
			rhMgaIndicadorvaloreLstTmp = rhMgaIndicadorvalores;
			for (int i = 0; i < 2; i++) {
				rhMgaIndicadorvaloreLstTmp.get(i).setInvEstado(true);
			}

		} else if (cantidad == 1) {
			for (int i = 0; i < 12; i++) {
				rhMgaIndicadorvalores.get(i).setInvEstado(false);
			}
			rhMgaIndicadorvaloreLstTmp = rhMgaIndicadorvalores;
			for (int i = 0; i < 1; i++) {
				rhMgaIndicadorvaloreLstTmp.get(i).setInvEstado(true);
			}

		}

		return rhMgaIndicadorvaloreLstTmp;
	}

	public void calculoValorReal() {
		flag = false;
		int activos = 0;
		int a = 0;
		for (RhMgaIndicadorvalore v : rhMgaIndicadorvalorelst) {
			if (v.getInvEstado().equals(true)) {
				activos++;
				if (v.getInvValoresperado() >= 1)
					a++;
			}
		}

		if (activos == a) {
			flag = true;
			for (int i = 0; i < activos; i++) {
				rhMgaIndicadorvalorelst.get(i)
						.setInvValorreal(
								(rhMgaIndicadorvalorelst.get(i)
										.getInvValoractual() * 100)
										/ rhMgaIndicadorvalorelst.get(i)
												.getInvValoresperado());
				System.out.println(rhMgaIndicadorvalorelst.get(i)
						.getInvValoractual());

			}
		}

	}

	/**
	 * Cargar Objeto
	 * **/
	public void actualizarValor() {
		calculoValorReal();
		if (flag) {
			for (RhMgaIndicadorvalore l : rhMgaIndicadorvalorelst) {
				rhMgaIndicadorvaloresLocal.makePersistent(l);
			}
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,
					"Indicador Valores", "Información Actualizada con Éxito..");
			FacesContext.getCurrentInstance().addMessage(null, message);

		} else {

			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,
					"Indicador Valores",
					"Verifique el valor de los indicadores..");
			FacesContext.getCurrentInstance().addMessage(null, message);

		}

	}

	/**
	 * Graficar Indicadores
	 * **/
	public void graficarIndicadores() {
		categoryModel = new CartesianChartModel();
		indicador = new ChartSeries();
		indicadorEsperado = new ChartSeries();

		rhMgaIndicadorvalorelst = new ArrayList<RhMgaIndicadorvalore>();
		rhMgaIndicadorvalorelst = rhMgaIndicadorvaloresLocal
				.obtenerIndicadorValor_IdEstado(rhMgaIndicador);
		indicador.setLabel("Actual");
		indicadorEsperado.setLabel("Esperado");
		for (RhMgaIndicadorvalore i : rhMgaIndicadorvalorelst) {
			indicador.set(i.getInvDescripcioparametro(), i.getInvValorreal());
			// indicadorEsperado.set(i.getInvDescripcioparametro(),i.getInvValoresperado());
			indicadorEsperado.set(i.getInvDescripcioparametro(), 100);

		}
		categoryModel.addSeries(indicador);
		categoryModel.addSeries(indicadorEsperado);
		flag = true;

	}

	/**
	 * Guardar Objetivo
	 * */
	public void guardarObjetivo() {
		rhMgaObjetivo = rhMgaObjetivoLocal.makePersistent(rhMgaObjetivo);

		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,
				"Guardar Objetivo:", "Objetivo Guardado..");
		FacesContext.getCurrentInstance().addMessage(null, message);
		rhMgaObjetivolst = new ArrayList<RhMgaObjetivo>();
		rhMgaObjetivolst = rhMgaObjetivoLocal.getAll();

	}

	/**
	 * Crear Objetivo
	 * */
	public void crearObjetivo() {
		rhMgaObjetivo = new RhMgaObjetivo();

	}

	/**
	 * Eliminar Objetivo
	 * */
	public void eliminarObjetivo() {
		List<RhMgaIndicadorvalore> mgaIndicadorvalores = new ArrayList<RhMgaIndicadorvalore>();
		if (rhMgaIndicador.getInId() == null) {
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_WARN,
					"Editar Indicador:",
					"Antes de Agregar Valores Debe guardar el indicador..");
			FacesContext.getCurrentInstance().addMessage(null, message);
		} else {
			
			for (RhMgaIndicadorvalore i : rhMgaIndicadorvaloresLocal.getAll()) {
				if(i.getRhMgaIndicador().getInId()==rhMgaIndicador.getInId() ){
					mgaIndicadorvalores.add(i);
				}
			}			
						
			for (RhMgaIndicadorvalore indv : mgaIndicadorvalores) {
				rhMgaIndicadorvaloresLocal.makeTransient(indv);
			}
			rhMgaIndicadorLocal.makeTransient(rhMgaIndicador);
			cargaIndicadores();
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_INFO,
							"Indicadores:", "Objetivo eliminado.."));

		}

	}

	/**
	 * Eliminar All Objetivo
	 * */
	public void eliminarAll() {
		List<RhMgaIndicadorvalore> mgaIndicadorvalores = new ArrayList<RhMgaIndicadorvalore>();
		List<RhMgaIndicador> mgaIndicadors = new ArrayList<RhMgaIndicador>();

		if (id == null || id == 0) {
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_WARN,
					"Eliminar Indicador:", "Escoja el Objetico a Eliminar..");
			FacesContext.getCurrentInstance().addMessage(null, message);
		} else {

			mgaIndicadorvalores = rhMgaIndicadorvaloresLocal
					.obtenerXidObjetivo(id);
			mgaIndicadors = rhMgaIndicadorLocal.obtenerIndicadorXobjetivo(id);
			// 1.-elimino indicador Valores
			for (RhMgaIndicadorvalore idva : mgaIndicadorvalores) {
				rhMgaIndicadorvaloresLocal.makeTransient(idva);

			}
			// 2.-elimino indicador
			for (RhMgaIndicador in : mgaIndicadors) {
				rhMgaIndicadorLocal.makeTransient(in);
			}

			rhMgaObjetivoLocal.makeTransient(rhMgaObjetivoLocal.buscarId(id));

			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_INFO,
							"Indicadores:", "Objetivo eliminado.."));
			init();

		}

	}

	public boolean isFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}

	public RhMgaObjetivo getRhMgaObjetivo() {
		return rhMgaObjetivo;
	}

	public void setRhMgaObjetivo(RhMgaObjetivo rhMgaObjetivo) {
		this.rhMgaObjetivo = rhMgaObjetivo;
	}

	public RhMgaIndicador getRhMgaIndicador() {
		return rhMgaIndicador;
	}

	public void setRhMgaIndicador(RhMgaIndicador rhMgaIndicador) {
		this.rhMgaIndicador = rhMgaIndicador;
	}

	public RhMgaIndicadorvalore getRhMgaIndicadorvalore() {
		return rhMgaIndicadorvalore;
	}

	public void setRhMgaIndicadorvalore(
			RhMgaIndicadorvalore rhMgaIndicadorvalore) {
		this.rhMgaIndicadorvalore = rhMgaIndicadorvalore;
	}

	public List<RhMgaObjetivo> getRhMgaObjetivolst() {
		return rhMgaObjetivolst;
	}

	public void setRhMgaObjetivolst(List<RhMgaObjetivo> rhMgaObjetivolst) {
		this.rhMgaObjetivolst = rhMgaObjetivolst;
	}

	public List<RhMgaIndicador> getRhMgaIndicadorlst() {
		return rhMgaIndicadorlst;
	}

	public void setRhMgaIndicadorlst(List<RhMgaIndicador> rhMgaIndicadorlst) {
		this.rhMgaIndicadorlst = rhMgaIndicadorlst;
	}

	public List<RhMgaIndicadorvalore> getRhMgaIndicadorvalorelst() {
		return rhMgaIndicadorvalorelst;
	}

	public void setRhMgaIndicadorvalorelst(
			List<RhMgaIndicadorvalore> rhMgaIndicadorvalorelst) {
		this.rhMgaIndicadorvalorelst = rhMgaIndicadorvalorelst;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public List<String> getPeriodoLista() {
		return periodoLista;
	}

	public void setPeriodoLista(List<String> periodoLista) {
		this.periodoLista = periodoLista;
	}

	public CartesianChartModel getCategoryModel() {
		return categoryModel;
	}

	public void setCategoryModel(CartesianChartModel categoryModel) {
		this.categoryModel = categoryModel;
	}

	public ChartSeries getIndicador() {
		return indicador;
	}

	public void setIndicador(ChartSeries indicador) {
		this.indicador = indicador;
	}

	public ChartSeries getIndicadorEsperado() {
		return indicadorEsperado;
	}

	public void setIndicadorEsperado(ChartSeries indicadorEsperado) {
		this.indicadorEsperado = indicadorEsperado;
	}

	public boolean isFlagWaiting() {
		return flagWaiting;
	}

	public void setFlagWaiting(boolean flagWaiting) {
		this.flagWaiting = flagWaiting;
	}

	public boolean isFlagEliminar() {
		return flagEliminar;
	}

	public void setFlagEliminar(boolean flagEliminar) {
		this.flagEliminar = flagEliminar;
	}

}
