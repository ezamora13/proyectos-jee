package ec.gob.senagua.servicios;

import java.util.List;

import javax.ejb.Local;

import ec.gob.senagua.modelo.RhMcaMuestreo;
import ec.gob.senagua.modelo.RhMcaReportelaboratorio;
import ec.gob.senagua.util.GenericoDAO;
import ec.gob.senagua.util.ObjTmpReporteMCA;

@Local
public interface RhMcaReportelaboratorioLocal extends
		GenericoDAO<RhMcaReportelaboratorio, Integer> {

	public List<RhMcaReportelaboratorio> buscarXIdFicha(Integer id);
	
	public List<RhMcaReportelaboratorio> buscarXIdFichaFechaReporte(Integer id,String fechaReporte);

	public List<String> buscarXIdFecha(Integer id);

	public List<String> buscarXidAgruparParametros(Integer id);
	
	public List<RhMcaReportelaboratorio> buscarXid_Parametro(Integer id, String parametro);
	
	public List<String> buscarParametroFechaXiDsMuestra(List<RhMcaMuestreo> rhMcaMuestreos);
	
	public List<RhMcaReportelaboratorio> buscarXiDsMuestraParametro(List<RhMcaMuestreo> rhMcaMuestreos, List<String > parametros);
		
	public List<ObjTmpReporteMCA> buscarRotulacionProyecto(Integer id);
	
	public List<String> buscarXidTablet(Integer id);
	
	public List<RhMcaReportelaboratorio> buscarXidTabletParametrosCondicionates(Integer id,List<String > parametros,Integer valor, String condicionante);
	
}
