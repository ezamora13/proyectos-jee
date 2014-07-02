package ec.gob.senagua.controladores;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import ec.gob.senagua.modelo.RhMcaMuestreo;
import ec.gob.senagua.modelo.RhMcaReportelaboratorio;
import ec.gob.senagua.modelo.RhTabletRegistro;
import ec.gob.senagua.modelo.TmpObtienedato;
import ec.gob.senagua.modelo.VwObtienedato;
import ec.gob.senagua.servicios.RhMcaMuestreoLocal;
import ec.gob.senagua.servicios.RhMcaReportelaboratorioLocal;
import ec.gob.senagua.servicios.RhTabletRegistroLocal;
import ec.gob.senagua.servicios.TmpObtieneDatoLocal;
import ec.gob.senagua.servicios.VwObtienedatoLocal;
import ec.gob.senagua.util.ObjTmpReporteMCA;

@ManagedBean
@SessionScoped
public class MatrizCalidadAguaControl implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4804004392734666407L;

	@EJB
	private RhTabletRegistroLocal rhTabletRegistroLocal;
	@EJB
	private RhMcaReportelaboratorioLocal rhMcaReportelaboratorioLocal;
	@EJB
	private TmpObtieneDatoLocal tmpObtieneDatoLocal;
	@EJB
	private VwObtienedatoLocal vwObtienedatoLocal;
	@EJB
	private RhMcaMuestreoLocal rhMcaMuestreoLocal;

	private List<RhTabletRegistro> rhTabletRegistroMCALts;
	private List<RhMcaMuestreo> rhMcaMuestreos;
	private RhMcaReportelaboratorio rhMcaReportelaboratorio;
	private List<ObjTmpReporteMCA> objTmpReporteMCAs;
	private VwObtienedato vwObtienedato;
	private TmpObtienedato tmpObtienedato;
	private List<VwObtienedato> vwObtienedatos;
	private RhTabletRegistro rhTabletRegistro;

	@PostConstruct
	public void init() {
		rhTabletRegistroMCALts = new ArrayList<RhTabletRegistro>();
		vwObtienedato = new VwObtienedato();
		tmpObtienedato = new TmpObtienedato();
		vwObtienedatos = new ArrayList<VwObtienedato>();
		rhMcaReportelaboratorio = new RhMcaReportelaboratorio();
		objTmpReporteMCAs = new ArrayList<ObjTmpReporteMCA>();
		rhMcaMuestreos = new ArrayList<RhMcaMuestreo>();

		// Recuperar Ubicacion Fuente
		rhTabletRegistroMCALts = recuperarUbicacionFuente(rhTabletRegistroLocal
				.buscarXtipoFicha("MCA"));

		// // Recuperar Datos de Reportes;
		// rhTabletRegistroMCALts =
		// recuperarDatosReporte(rhTabletRegistroMCALts);

	}

	/**
	 * Recuperacion de Ubicacion geografia - GIS
	 * */
	public List<RhTabletRegistro> recuperarUbicacionFuente(
			List<RhTabletRegistro> rhTabletRegistros) {
		for (RhTabletRegistro rg : rhTabletRegistros) {
			tmpObtienedato = new TmpObtienedato();
			tmpObtienedato = tmpObtieneDatoLocal.buscarId(1);
			tmpObtienedato.setCoordenadaX(rg.getRgCoordenadax());
			tmpObtienedato.setCoordenadaY(rg.getRgCoordenaday());
			tmpObtienedato.setEsCalidadagua(true);
			tmpObtienedato = tmpObtieneDatoLocal.makePersistent(tmpObtienedato);
			vwObtienedatos = vwObtienedatoLocal.getAll();
			vwObtienedato = vwObtienedatos.get(0);
			if (vwObtienedato == null) {
				System.out.println("no hay datos");
			} else {
				rg.setRg_provincia(vwObtienedato.getProvincia());
				rg.setRg_canton(vwObtienedato.getCanton());
				rg.setRgIdparroquia(vwObtienedato.getCodparroquia());
				rg.setRg_parroquia(vwObtienedato.getParroquia());
				rg.setRgIddemarcacion(vwObtienedato.getCoddemarcacion());
				rg.setRg_demarcacion(vwObtienedato.getDemarcacion());
				rg.setRg_codpfafsteter(vwObtienedato.getCodpfafsteter());
				rg.setRg_pfafsteter(vwObtienedato.getPfafsteter());
				rg.setRg_cuenca(vwObtienedato.getCuenca());
				rg.setRg_subcuenca(vwObtienedato.getSubcuenca());
				rg.setRgIdmicrocuenca(vwObtienedato.getCodmicrocuenca());
				rg.setRgIdmicrocuenca(vwObtienedato.getCodmicrocuenca());
				rg.setRg_microcuenca(vwObtienedato.getMicrocuenca());
			}
		}
		return rhTabletRegistros;
	}

	/**
	 * Recuoera informacion de Datos reporte
	 * 
	 * **/
	public List<RhTabletRegistro> recuperarDatosReporte(
			List<RhTabletRegistro> rhTabletRegistroMCALts) {

		for (RhTabletRegistro r : rhTabletRegistroMCALts) {
			objTmpReporteMCAs = rhMcaReportelaboratorioLocal
					.buscarRotulacionProyecto(r.getRgId());
		}
		return null;
	}

	/**
	 * Ver la ficha de Monitoreo
	 * */
	public void fichaMonitoreo() {
		rhMcaMuestreos = rhMcaMuestreoLocal.buscarXiD(rhTabletRegistro);

	}

	public List<RhTabletRegistro> getRhTabletRegistroMCALts() {
		return rhTabletRegistroMCALts;
	}

	public void setRhTabletRegistroMCALts(
			List<RhTabletRegistro> rhTabletRegistroMCALts) {
		this.rhTabletRegistroMCALts = rhTabletRegistroMCALts;
	}

	public VwObtienedato getVwObtienedato() {
		return vwObtienedato;
	}

	public void setVwObtienedato(VwObtienedato vwObtienedato) {
		this.vwObtienedato = vwObtienedato;
	}

	public TmpObtienedato getTmpObtienedato() {
		return tmpObtienedato;
	}

	public void setTmpObtienedato(TmpObtienedato tmpObtienedato) {
		this.tmpObtienedato = tmpObtienedato;
	}

	public List<VwObtienedato> getVwObtienedatos() {
		return vwObtienedatos;
	}

	public void setVwObtienedatos(List<VwObtienedato> vwObtienedatos) {
		this.vwObtienedatos = vwObtienedatos;
	}

	public RhMcaReportelaboratorio getRhMcaReportelaboratorio() {
		return rhMcaReportelaboratorio;
	}

	public void setRhMcaReportelaboratorio(
			RhMcaReportelaboratorio rhMcaReportelaboratorio) {
		this.rhMcaReportelaboratorio = rhMcaReportelaboratorio;
	}

	public List<ObjTmpReporteMCA> getObjTmpReporteMCAs() {
		return objTmpReporteMCAs;
	}

	public void setObjTmpReporteMCAs(List<ObjTmpReporteMCA> objTmpReporteMCAs) {
		this.objTmpReporteMCAs = objTmpReporteMCAs;
	}

	public List<RhMcaMuestreo> getRhMcaMuestreos() {
		return rhMcaMuestreos;
	}

	public void setRhMcaMuestreos(List<RhMcaMuestreo> rhMcaMuestreos) {
		this.rhMcaMuestreos = rhMcaMuestreos;
	}

	public RhTabletRegistro getRhTabletRegistro() {
		return rhTabletRegistro;
	}

	public void setRhTabletRegistro(RhTabletRegistro rhTabletRegistro) {
		this.rhTabletRegistro = rhTabletRegistro;
	}

}
