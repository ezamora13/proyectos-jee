package ec.gob.senagua.servicios;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.Query;

import ec.gob.senagua.modelo.RhMcaMuestreo;
import ec.gob.senagua.modelo.RhMcaReportelaboratorio;
import ec.gob.senagua.util.EJBGenericoDAO;
import ec.gob.senagua.util.ObjTmpReporteMCA;

/**
 * Session Bean implementation class RhGlbOpcionesMenuServicio
 */
@Stateless
@LocalBean
public class RhMcaReportelaboratorioServicio extends
		EJBGenericoDAO<RhMcaReportelaboratorio, Integer> implements
		RhMcaReportelaboratorioLocal {
	/**
	 * Default constructor.
	 */
	public RhMcaReportelaboratorioServicio() {

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<RhMcaReportelaboratorio> buscarXIdFichaFechaReporte(Integer id,
			String fechaReporte) {
		// TODO Auto-generated method stub
		Query query = em
				.createQuery("from RhMcaReportelaboratorio rp where rp.rhMcaMuestreo.msId = ? and rp.rptFechamuestreo= ? order by rp.rptId");
		query.setParameter(1, id);
		query.setParameter(2, fechaReporte);
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<String> buscarXIdFecha(Integer id) {
		Query query = em
				.createQuery("Select r.rptFechamuestreo  from RhMcaReportelaboratorio r where r.rhMcaMuestreo.msId= ? group by r.rptFechamuestreo ");
		query.setParameter(1, id);
		if (query.getResultList().size() == 0) {
			return null;
		} else {
			return query.getResultList();
		}

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<RhMcaReportelaboratorio> buscarXIdFicha(Integer id) {
		// TODO Auto-generated method stub
		Query query = em
				.createQuery("from RhMcaReportelaboratorio rp where rp.rhMcaMuestreo.msId = ?  order by rp.rptId");
		query.setParameter(1, id);

		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<String> buscarXidAgruparParametros(Integer id) {
		Query query = em
				.createQuery("select  r.rptParametro from RhMcaReportelaboratorio r where r.rhMcaMuestreo.msId   = ? group by r.rptParametro");
		query.setParameter(1, id);
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<RhMcaReportelaboratorio> buscarXid_Parametro(Integer id,
			String parametro) {
		Query query = em
				.createQuery("from RhMcaReportelaboratorio r where r.rhMcaMuestreo.msId= ? and r.rptParametro=?");
		query.setParameter(1, id);
		query.setParameter(2, parametro);
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<String> buscarParametroFechaXiDsMuestra(
			List<RhMcaMuestreo> rhMcaMuestreos) {
		List<Integer> clausulaIN = new ArrayList<Integer>();
		for (RhMcaMuestreo m : rhMcaMuestreos) {
			clausulaIN.add(m.getMsId());
		}

		Query query = em
				.createNativeQuery("select rpt_parametro from modulos.rh_mca_reportelaboratorio  where ms_id in( :clausulaIN ) group by rpt_parametro");
		query.setParameter("clausulaIN", clausulaIN);
		return query.getResultList();

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<RhMcaReportelaboratorio> buscarXiDsMuestraParametro(
			List<RhMcaMuestreo> rhMcaMuestreos, List<String> parametros) {
		List<Integer> clausulaIN = new ArrayList<Integer>();
		for (RhMcaMuestreo m : rhMcaMuestreos) {
			clausulaIN.add(m.getMsId());
		}

		Query query = em
				.createNativeQuery(
						"select * from modulos.rh_mca_reportelaboratorio  where ms_id in( :clausulaIN ) and rpt_parametro in(:parametros)",
						RhMcaReportelaboratorio.class);
		query.setParameter("clausulaIN", clausulaIN);
		query.setParameter("parametros", parametros);
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ObjTmpReporteMCA> buscarRotulacionProyecto(Integer id) {
		Query query = em
				.createNativeQuery("select rpt_rotulacioncliente,rpt_proyecto from modulos.rh_mca_reportelaboratorio  where ms_id = ? group by rpt_rotulacioncliente , rpt_proyecto");
		query.setParameter(1, id);
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<String> buscarXidTablet(Integer id) {
		Query query = em
				.createNativeQuery("select rpt.rpt_parametro from modulos.rh_mca_reportelaboratorio rpt where rpt.ms_id in (select ms_id from modulos.rh_mca_muestreo m where rg_id = ?) group by  rpt.rpt_parametro");
		query.setParameter(1, id);
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<RhMcaReportelaboratorio> buscarXidTabletParametrosCondicionates(
			Integer id, List<String> parametros, Integer valor,
			String condicionante) {
		List<RhMcaReportelaboratorio> reportelaboratorios = new ArrayList<RhMcaReportelaboratorio>();
		try {
			Query query = em
					.createNativeQuery(
							"select * from modulos.rh_mca_reportelaboratorio rpt where rpt.ms_id in (select ms_id from modulos.rh_mca_muestreo m where rg_id = :id ) and rpt.rpt_parametro in(:parametros) and cast (replace( rpt.rpt_medicion,',','.') AS double precision ) "
									+ condicionante + " :valor",
							RhMcaReportelaboratorio.class);
			query.setParameter("id", id);
			query.setParameter("parametros", parametros);
			query.setParameter("valor", valor);

			reportelaboratorios = query.getResultList();
		} catch (Exception e) {
			reportelaboratorios = new ArrayList<RhMcaReportelaboratorio>();
		}

		return reportelaboratorios;

	}
}