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

import ec.gob.senagua.modelo.RhMcaComparacionreportenormalimite;
import ec.gob.senagua.modelo.RhMcaMuestreo;
import ec.gob.senagua.modelo.RhMcaParametrosLimitesesperado;
import ec.gob.senagua.modelo.RhMcaParametrosNormavigente;
import ec.gob.senagua.modelo.RhMcaReportelaboratorio;
import ec.gob.senagua.modelo.RhTabletRegistro;
import ec.gob.senagua.servicios.RhMcaComparacionreportenormalimiteLocal;
import ec.gob.senagua.servicios.RhMcaMuestreoLocal;
import ec.gob.senagua.servicios.RhMcaParametrosLimitesesperadoLocal;
import ec.gob.senagua.servicios.RhMcaParametrosNormavigenteLocal;
import ec.gob.senagua.servicios.RhMcaReportelaboratorioLocal;
import ec.gob.senagua.servicios.RhTabletRegistroLocal;

@ManagedBean
@SessionScoped
public class AnalisisReporteControl implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4804004392734666407L;

	@EJB
	private RhMcaReportelaboratorioLocal rhMcaReportelaboratorioLocal;
	@EJB
	private RhTabletRegistroLocal rhTabletRegistroLocal;
	@EJB
	private RhMcaParametrosLimitesesperadoLocal rhMcaParametrosLimitesesperadoLocal;
	@EJB
	private RhMcaParametrosNormavigenteLocal rhMcaParametrosNormavigenteLocal;
	@EJB
	private RhMcaComparacionreportenormalimiteLocal rhMcaComparacionreportenormalimiteLocal;
	@EJB
	private RhMcaMuestreoLocal rhMcaMuestreoLocal;

	private Integer idMuestreo;
	private String demarcacion;
	private List<String> demarcacioList;
	private String actividad;
	private List<String> actividadList;
	private Integer anio;
	private List<String> anioList;
	private String tipo;
	private List<String> tipoList;
	private RhTabletRegistro rhTabletRegistro;
	private List<RhTabletRegistro> rhTabletRegistroLst;
	private List<RhMcaMuestreo> rhMcaMuestreoLst;
	private List<RhMcaParametrosLimitesesperado> rhMcaParametrosLimitesesperadoList;
	private List<RhMcaParametrosNormavigente> rhMcaParametrosNormavigentelst;
	private RhMcaReportelaboratorio rhMcaReportelaboratorio;
	private List<RhMcaReportelaboratorio> rhMcaReportelaboratorioList;
	private RhMcaComparacionreportenormalimite rhMcaComparacionreportenormalimite;
	private List<RhMcaComparacionreportenormalimite> rhMcaComparacionreportenormalimiteLst;
	private List<String> reportelaboratorioFechaLst;

	private Boolean flag;
	private String fechaReporte;

	@PostConstruct
	public void init() {
		idMuestreo = 0;
		demarcacion = new String();
		demarcacioList = new ArrayList<String>();
		actividad = new String();
		actividadList = new ArrayList<String>();
		anio = 0;
		anioList = new ArrayList<String>();
		tipo = new String();
		tipoList = new ArrayList<String>();
		rhTabletRegistro = new RhTabletRegistro();
		rhTabletRegistroLst = new ArrayList<RhTabletRegistro>();
		rhMcaReportelaboratorio = new RhMcaReportelaboratorio();
		rhMcaReportelaboratorioList = new ArrayList<RhMcaReportelaboratorio>();
		rhMcaParametrosLimitesesperadoList = new ArrayList<RhMcaParametrosLimitesesperado>();
		rhMcaParametrosNormavigentelst = new ArrayList<RhMcaParametrosNormavigente>();
		rhMcaComparacionreportenormalimite = new RhMcaComparacionreportenormalimite();
		rhMcaComparacionreportenormalimiteLst = new ArrayList<RhMcaComparacionreportenormalimite>();
		rhMcaMuestreoLst = new ArrayList<RhMcaMuestreo>();
		reportelaboratorioFechaLst = new ArrayList<String>();
		fechaReporte = new String();
		//
		rhMcaMuestreoLst = rhMcaMuestreoLocal.obtenerOrderXiD();
		demarcacioList = rhMcaParametrosLimitesesperadoLocal.buscarProvincias();
		actividadList = rhMcaParametrosLimitesesperadoLocal.buscarActividad();
		anioList = rhMcaParametrosNormavigenteLocal.buscarAnios();
		tipoList = rhMcaParametrosNormavigenteLocal.buscarTipo();
		flag = false;
	}

	/**
	 * Consulta comparacion con reportes LImite
	 * */
	public void consultaComparacionLimites() {
		rhMcaComparacionreportenormalimiteLst = new ArrayList<RhMcaComparacionreportenormalimite>();
		if (idMuestreo == 0 || fechaReporte.isEmpty()
				|| demarcacion.trim().isEmpty() || actividad.trim().isEmpty()) {
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,
					"Análisis Reporte", "Escoja todos los Parametros");
			FacesContext.getCurrentInstance().addMessage(null, message);

		} else {
			rhMcaReportelaboratorioList = rhMcaReportelaboratorioLocal
					.buscarXIdFichaFechaReporte(idMuestreo, fechaReporte);
			rhMcaParametrosLimitesesperadoList = rhMcaParametrosLimitesesperadoLocal
					.buscar_DemaracionLimite(demarcacion.trim(),
							actividad.trim());
			for (RhMcaReportelaboratorio r : rhMcaReportelaboratorioList) {
				rhMcaComparacionreportenormalimite = new RhMcaComparacionreportenormalimite();
				rhMcaComparacionreportenormalimite
						.setRhMcaReportelaboratorio(r);
				// rhMcaComparacionreportenormalimite
				// .setRhMcaParametrosNormavigente(consultaParametroNorma(r));
				rhMcaComparacionreportenormalimite
						.setRhMcaParametrosLimitesesperado(consultaParametroLimites(r));
				rhMcaComparacionreportenormalimiteLst
						.add(rhMcaComparacionreportenormalimite);
			}

			rhMcaComparacionreportenormalimiteLst = validacionLimitesEsperados(rhMcaComparacionreportenormalimiteLst);
		}
	}

	/**
	 * Consulta comparacion con reportes Norma- Limites
	 * */
	public void consultaComparacionNorma() {

		if (rhMcaComparacionreportenormalimiteLst.size() == 0) {
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,
					"Análisis Reporte", "Primero debe Comparar los limites");
			FacesContext.getCurrentInstance().addMessage(null, message);
		} else {
			if (anio == 0 || tipo.isEmpty()) {
				FacesMessage message = new FacesMessage(
						FacesMessage.SEVERITY_INFO, "Análisis Reporte",
						"Escoja todos los Parametros *:");
				FacesContext.getCurrentInstance().addMessage(null, message);

			} else {
				rhMcaParametrosNormavigentelst = rhMcaParametrosNormavigenteLocal
						.buscar_AnioTipo(anio, tipo);
				for (RhMcaComparacionreportenormalimite compara : rhMcaComparacionreportenormalimiteLst) {
					compara.setRhMcaParametrosNormavigente(consultaParametroNorma(compara
							.getRhMcaReportelaboratorio()));

				}
				rhMcaComparacionreportenormalimiteLst = validacionNorma(rhMcaComparacionreportenormalimiteLst);
				System.out.println("Chequeo-----");

			}

		}

	}

	/**
	 * Consulta Parametro en Norma
	 * */
	public RhMcaParametrosNormavigente consultaParametroNorma(
			RhMcaReportelaboratorio reporte) {
		System.out.println(reporte.getRptParametro());
		RhMcaParametrosNormavigente tmp = new RhMcaParametrosNormavigente();
		for (RhMcaParametrosNormavigente n : rhMcaParametrosNormavigentelst) {
			if (n.getNorvParametro().trim().toUpperCase()
					.equals(reporte.getRptParametro().trim().toUpperCase())) {
				System.out.println(reporte.getRptParametro());
				System.out.println("---"
						+ n.getNorvParametro().trim().toUpperCase());
				tmp = n;
			}

		}
		return tmp;
	}

	/**
	 * Consulta Parametro en Limites
	 * */
	public RhMcaParametrosLimitesesperado consultaParametroLimites(
			RhMcaReportelaboratorio reporte) {
		RhMcaParametrosLimitesesperado tmp = new RhMcaParametrosLimitesesperado();
		for (RhMcaParametrosLimitesesperado l : rhMcaParametrosLimitesesperadoList) {
			if (l.getLespParametro().trim().toUpperCase()
					.equals(reporte.getRptParametro().trim().toUpperCase())) {
				tmp = l;
			}

		}
		return tmp;
	}

	/**
	 * Consulta Parametro en Limites
	 * */
	public void cargarFechas() {
		if (idMuestreo == 0) {
			flag = false;
		} else {
			flag = true;
			reportelaboratorioFechaLst = rhMcaReportelaboratorioLocal
					.buscarXIdFecha(idMuestreo);
		}

	}

	/**
	 * Validar Problemas con Limites Unidad Maximo y Minimo
	 * */
	public List<RhMcaComparacionreportenormalimite> validacionLimitesEsperados(
			List<RhMcaComparacionreportenormalimite> rhMcaComparacionreportenormalimiteLst) {
		Double max = 0.0, min = 0.0, v = 0.0;

		for (RhMcaComparacionreportenormalimite c : rhMcaComparacionreportenormalimiteLst) {
			try {

				if (!c.getRhMcaReportelaboratorio()
						.getRptUnidad()
						.trim()
						.toUpperCase()
						.equals(c.getRhMcaParametrosLimitesesperado()
								.getLespUnidad().trim().toUpperCase())) {
					System.out.println(c.getRhMcaReportelaboratorio()
							.getRptUnidad().trim().toUpperCase());
					System.out.println(c.getRhMcaParametrosLimitesesperado()
							.getLespUnidad().trim().toUpperCase());
					c.setProblemaLimites(true);
					System.out.println(c.getProblemaLimites());
				} else {
					c.setProblemaLimites(false);
				}
				v = Double.parseDouble(c.getRhMcaReportelaboratorio()
						.getRptMedicion().replaceAll(",", "."));
				max = Double.parseDouble(c.getRhMcaParametrosLimitesesperado()
						.getLespMax().replaceAll(",", "."));
				min = Double.parseDouble(c.getRhMcaParametrosLimitesesperado()
						.getLespMin().replaceAll(",", "."));
				System.out.println(v + " ");
				System.out.println(max + " ");
				System.out.println(min);
				if (max >= v || min <= v) {
					c.setProblemaLimites(true);
					System.out.println(true);
				} else {
					c.setProblemaLimites(false);
				}

			} catch (Exception e) {
				System.out.println("null");
			}
		}
		return rhMcaComparacionreportenormalimiteLst;
	}

	/**
	 * Validar Problemas con Limites Unidad Maximo y Minimo
	 * */
	public List<RhMcaComparacionreportenormalimite> validacionNorma(
			List<RhMcaComparacionreportenormalimite> rhMcaComparacionreportenormalimiteLst) {
		Double lim = 0.0, v = 0.0;

		for (RhMcaComparacionreportenormalimite c : rhMcaComparacionreportenormalimiteLst) {
			try {
				if (!c.getRhMcaReportelaboratorio()
						.getRptUnidad()
						.trim()
						.toUpperCase()
						.equals(c.getRhMcaParametrosNormavigente()
								.getNorvUnidad().trim().toUpperCase())) {
					System.out.println(c.getRhMcaReportelaboratorio()
							.getRptUnidad().trim().toUpperCase());
					System.out.println(c.getRhMcaParametrosNormavigente()
							.getNorvUnidad().trim().toUpperCase());
					c.setProblemaNorma(true);
					System.out.println(c.getProblemaLimites());
				} else {
					c.setProblemaNorma(false);
				}
				v = Double.parseDouble(c.getRhMcaReportelaboratorio()
						.getRptMedicion().replaceAll(",", "."));
				lim = Double.parseDouble(c.getRhMcaParametrosNormavigente()
						.getNorvLimitemaximopermisible().replaceAll(",", "."));
				System.out.println(v + " ");
				System.out.println(lim + " ");

				if (v > lim) {
					c.setProblemaNorma(true);
					System.out.println(true);
				} else {
					c.setProblemaNorma(false);
				}

			} catch (Exception e) {
				System.out.println("null");
			}
		}
		return rhMcaComparacionreportenormalimiteLst;
	}

	public void guardar() {
		if (rhMcaComparacionreportenormalimiteLst.size() == 0) {
			FacesMessage message = new FacesMessage(
					FacesMessage.SEVERITY_ERROR, "Análisis Reporte:",
					"Realize primero las comparaciones");
			FacesContext.getCurrentInstance().addMessage(null, message);
		} else {

			// RhMcaComparacionreportenormalimite c= new
			// RhMcaComparacionreportenormalimite();
			// RhMcaReportelaboratorio r= new RhMcaReportelaboratorio();
			// r.setRptId(1);
			// c.setRhMcaReportelaboratorio(r);
			// rhMcaComparacionreportenormalimiteLocal.makePersistent(c);

			for (RhMcaComparacionreportenormalimite comp : rhMcaComparacionreportenormalimiteLst) {
				if (comp.getRhMcaParametrosLimitesesperado().getLespId() == null
						|| comp.getRhMcaParametrosLimitesesperado() == null) {
					comp.setRhMcaParametrosLimitesesperado(null);
				}
				if (comp.getRhMcaParametrosNormavigente() == null
						|| comp.getRhMcaParametrosNormavigente().getNorvId() == null) {
					comp.setRhMcaParametrosNormavigente(null);
				}
				rhMcaComparacionreportenormalimiteLocal.makePersistent(comp);

			}
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,
					"Análisis Reporte:", "Análisis Guardado ");
			FacesContext.getCurrentInstance().addMessage(null, message);
		}

	}

	public String getDemarcacion() {
		return demarcacion;
	}

	public void setDemarcacion(String demarcacion) {
		this.demarcacion = demarcacion;
	}

	public List<String> getDemarcacioList() {
		return demarcacioList;
	}

	public void setDemarcacioList(List<String> demarcacioList) {
		this.demarcacioList = demarcacioList;
	}

	public String getActividad() {
		return actividad;
	}

	public void setActividad(String actividad) {
		this.actividad = actividad;
	}

	public List<String> getActividadList() {
		return actividadList;
	}

	public void setActividadList(List<String> actividadList) {
		this.actividadList = actividadList;
	}

	public List<String> getAnioList() {
		return anioList;
	}

	public void setAnioList(List<String> anioList) {
		this.anioList = anioList;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public List<String> getTipoList() {
		return tipoList;
	}

	public void setTipoList(List<String> tipoList) {
		this.tipoList = tipoList;
	}

	public RhTabletRegistro getRhTabletRegistro() {
		return rhTabletRegistro;
	}

	public void setRhTabletRegistro(RhTabletRegistro rhTabletRegistro) {
		this.rhTabletRegistro = rhTabletRegistro;
	}

	public List<RhTabletRegistro> getRhTabletRegistroLst() {
		return rhTabletRegistroLst;
	}

	public void setRhTabletRegistroLst(
			List<RhTabletRegistro> rhTabletRegistroLst) {
		this.rhTabletRegistroLst = rhTabletRegistroLst;
	}

	public List<RhMcaParametrosLimitesesperado> getRhMcaParametrosLimitesesperadoList() {
		return rhMcaParametrosLimitesesperadoList;
	}

	public void setRhMcaParametrosLimitesesperadoList(
			List<RhMcaParametrosLimitesesperado> rhMcaParametrosLimitesesperadoList) {
		this.rhMcaParametrosLimitesesperadoList = rhMcaParametrosLimitesesperadoList;
	}

	public RhMcaReportelaboratorio getRhMcaReportelaboratorio() {
		return rhMcaReportelaboratorio;
	}

	public void setRhMcaReportelaboratorio(
			RhMcaReportelaboratorio rhMcaReportelaboratorio) {
		this.rhMcaReportelaboratorio = rhMcaReportelaboratorio;
	}

	public List<RhMcaReportelaboratorio> getRhMcaReportelaboratorioList() {
		return rhMcaReportelaboratorioList;
	}

	public void setRhMcaReportelaboratorioList(
			List<RhMcaReportelaboratorio> rhMcaReportelaboratorioList) {
		this.rhMcaReportelaboratorioList = rhMcaReportelaboratorioList;
	}

	public List<RhMcaParametrosNormavigente> getRhMcaParametrosNormavigentelst() {
		return rhMcaParametrosNormavigentelst;
	}

	public void setRhMcaParametrosNormavigentelst(
			List<RhMcaParametrosNormavigente> rhMcaParametrosNormavigentelst) {
		this.rhMcaParametrosNormavigentelst = rhMcaParametrosNormavigentelst;
	}

	public Integer getAnio() {
		return anio;
	}

	public void setAnio(Integer anio) {
		this.anio = anio;
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

	public Boolean getFlag() {
		return flag;
	}

	public void setFlag(Boolean flag) {
		this.flag = flag;
	}

	public List<String> getReportelaboratorioFechaLst() {
		return reportelaboratorioFechaLst;
	}

	public void setReportelaboratorioFechaLst(
			List<String> reportelaboratorioFechaLst) {
		this.reportelaboratorioFechaLst = reportelaboratorioFechaLst;
	}

	public String getFechaReporte() {
		return fechaReporte;
	}

	public void setFechaReporte(String fechaReporte) {
		this.fechaReporte = fechaReporte;
	}

}
