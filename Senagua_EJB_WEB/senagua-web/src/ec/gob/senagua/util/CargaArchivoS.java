package ec.gob.senagua.util;

import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import ec.gob.senagua.controladores.LicenciamientoAmbientalControl;
import ec.gob.senagua.modelo.RhMcaMuestreo;
import ec.gob.senagua.modelo.RhMcaParametrosLimitesesperado;
import ec.gob.senagua.modelo.RhMcaParametrosNormavigente;
import ec.gob.senagua.modelo.RhMcaReportelaboratorio;
import ec.gob.senagua.modelo.RhMgaContaminacion;
import ec.gob.senagua.modelo.RhMgaLicenciamientoambiental;
import ec.gob.senagua.modelo.RhMgaMatrizseguimientoplanesma;
import ec.gob.senagua.modelo.RhMgaProyectomatrizseguimientoplanesma;

public class CargaArchivoS implements Serializable {

	private static final long serialVersionUID = -5758950889723629482L;

	private RhMcaParametrosNormavigente rhMcaParametrosNormavigente;
	private List<RhMcaParametrosNormavigente> rhMcaParametrosNormavigenteLst;
	private RhMcaParametrosLimitesesperado rhMcaParametrosLimitesesperado;
	private List<RhMcaParametrosLimitesesperado> rhMcaParametrosLimitesesperadoLst;
	private RhMcaReportelaboratorio rhMcaReportelaboratorio;
	private List<RhMcaReportelaboratorio> rhMcaReportelaboratorioList;
	private RhMgaLicenciamientoambiental rhMgaLicenciamientoambiental;
	private List<RhMgaLicenciamientoambiental> rhMgaLicenciamientoambientalList;
	private RhMgaMatrizseguimientoplanesma rhMgaMatrizseguimientoplanesma;
	private List<RhMgaMatrizseguimientoplanesma> rhMgaMatrizseguimientoplanesmaList;
	private LicenciamientoAmbientalControl licenciamientoAmbientalControl;
	private RhMgaContaminacion rhMgaContaminacion;
	private List<RhMgaContaminacion> rhMgaContaminacionList;
	private InputStream input;

	/**
	 * lectura de Excel a List
	 * */
	public List<RhMgaLicenciamientoambiental> leerExcelLicenciamientoAmbiental(
			InputStream inputStream) throws IOException, BiffException {
		rhMgaLicenciamientoambiental = new RhMgaLicenciamientoambiental();
		rhMgaLicenciamientoambientalList = new ArrayList<RhMgaLicenciamientoambiental>();
		try {
			// Creamos un Workbook para cargar el XLS en memoria
			Workbook workbook = Workbook.getWorkbook(inputStream);
			// Elegimos la primera hoja
			Sheet sheet = workbook.getSheet(0);
			// inicializo el objeto que leerá el valor de la celda
			Cell celdaCurso = null;
			// Obtengo el número de filas ocupadas en la hoja
			int rows = sheet.getRows();
			// Obtengo el número de columnas ocupadas en la hoja
			int cols = sheet.getColumns();
			if (cols == 24) {
				// Para efectos de ejemplo recorremos las columnas de cada fila
				for (int x = 2; x < rows; x++) {
					for (int y = 0; y < cols; y++) {
						// Obtenemos el valor de la celda de la columna Y y fila
						// X
						celdaCurso = sheet.getCell(y, x);
						if (y == 0) {
							rhMgaLicenciamientoambiental.setLic_n(Integer
									.parseInt(celdaCurso.getContents().trim()));
						}
						if (y == 1) {
							rhMgaLicenciamientoambiental
									.setLic_proyecto(celdaCurso.getContents()
											.trim());
						}
						if (y == 2) {
							rhMgaLicenciamientoambiental
									.setLic_demarcacionresponsable(celdaCurso
											.getContents().trim());
						}
						if (y == 3) {
							rhMgaLicenciamientoambiental
									.setLic_autoridadresponsable(celdaCurso
											.getContents().trim());
						}
						if (y == 4) {
							rhMgaLicenciamientoambiental
									.setLic_faseproyecto(celdaCurso
											.getContents().trim());
						}
						if (y == 5) {
							rhMgaLicenciamientoambiental
									.setLic_certificadointerseccion_oficiosolicitudcertificadointersecc(celdaCurso
											.getContents().trim());
						}
						if (y == 6) {
							rhMgaLicenciamientoambiental
									.setLic_certificadointerseccionoficiocertificadointerseccion(celdaCurso
											.getContents().trim());
						}
						if (y == 7) {
							rhMgaLicenciamientoambiental
									.setLic_certificadointerseccionintersectaconareasprotegidassino(celdaCurso
											.getContents().trim());
						}
						if (y == 8) {
							rhMgaLicenciamientoambiental
									.setLic_categorizacion_oficiosolicitudcertificadoccategorizacion(celdaCurso
											.getContents().trim());
						}
						if (y == 9) {
							rhMgaLicenciamientoambiental
									.setLic_categorizacion_oficiocategorizacionmae(celdaCurso
											.getContents().trim());
						}
						if (y == 10) {
							rhMgaLicenciamientoambiental
									.setLic_categorizacion_categoriaproyecto(celdaCurso
											.getContents().trim());
						}
						if (y == 11) {
							rhMgaLicenciamientoambiental
									.setLic_terminosreferencia_oficiosolicitudaprobaciontdrs(celdaCurso
											.getContents().trim());
						}
						if (y == 12) {
							rhMgaLicenciamientoambiental
									.setLic_terminosreferencia_oficioaprobaciontdrs(celdaCurso
											.getContents().trim());
						}
						if (y == 13) {
							rhMgaLicenciamientoambiental
									.setLic_elaboracionborradoreiaficha_ambiental_consultora(celdaCurso
											.getContents().trim());
						}
						if (y == 14) {
							rhMgaLicenciamientoambiental
									.setLic_elaboracionborradoreiaficha_ambiental_tiempoestimadoelabora(celdaCurso
											.getContents().trim());
						}
						if (y == 15) {
							rhMgaLicenciamientoambiental
									.setLic_participacionsocial_solicitudfacilidador(celdaCurso
											.getContents().trim());
						}
						if (y == 16) {
							rhMgaLicenciamientoambiental
									.setLic_participacionsocial_respuestamaesolicitudfacilitador(celdaCurso
											.getContents().trim());
						}
						if (y == 17) {
							rhMgaLicenciamientoambiental
									.setLic_participacionsocial_entregamaeinformefacilitador(celdaCurso
											.getContents().trim());
						}
						if (y == 18) {
							rhMgaLicenciamientoambiental
									.setLic_estudioimpactoambientalesiafinal_entregaesiapartesenagua(celdaCurso
											.getContents().trim());
						}
						if (y == 19) {
							rhMgaLicenciamientoambiental
									.setLic_estudioimpactoambientalesiafinal_respuestamae(celdaCurso
											.getContents().trim());
						}
						if (y == 20) {
							rhMgaLicenciamientoambiental
									.setLic_estudioimpactoambientalesiafinal_respuestaobservacionespart(celdaCurso
											.getContents().trim());
						}
						if (y == 21) {
							rhMgaLicenciamientoambiental
									.setLic_estudioimpactoambientalesiafinal_aprobacionesiapartemae(celdaCurso
											.getContents().trim());
						}
						if (y == 22) {
							rhMgaLicenciamientoambiental
									.setLic_faseemisionlicencia_pagotasas(celdaCurso
											.getContents().trim());
						}
						if (y == 23) {
							rhMgaLicenciamientoambiental
									.setLic_faseemisionlicencia_emisionlicenciaambiental(celdaCurso
											.getContents().trim());
						}

					}
					rhMgaLicenciamientoambientalList
							.add(rhMgaLicenciamientoambiental);
					rhMgaLicenciamientoambiental = new RhMgaLicenciamientoambiental();
				}
				workbook.close();
				FacesMessage message = new FacesMessage(
						FacesMessage.SEVERITY_INFO, "Carga Archivo:",
						"Excel Cargado.... ");
				FacesContext.getCurrentInstance().addMessage(null, message);
			} else {
				FacesMessage message = new FacesMessage(
						FacesMessage.SEVERITY_ERROR, "Carga Archivo:",
						"Carga Excel : Problema con Archivo Tamano "
								+ "columnas" + cols + " Filas" + rows);
				FacesContext.getCurrentInstance().addMessage(null, message);
			}
		} catch (Exception e) {
			FacesMessage message = new FacesMessage(
					FacesMessage.SEVERITY_ERROR, "Carga Archivos:",
					"Carga Excel : Error en Archivo de Carga ");
			FacesContext.getCurrentInstance().addMessage(null, message);

		}
		return rhMgaLicenciamientoambientalList;

	}

	/**
	 * lectura de Excel a List Matriz Seguimiento
	 * */
	public List<RhMgaMatrizseguimientoplanesma> leerExcelMatrizSeguimiento(
			InputStream inputStream,
			RhMgaProyectomatrizseguimientoplanesma rhMgaProyectomatrizseguimientoplanesma)
			throws IOException, BiffException {
		rhMgaMatrizseguimientoplanesma = new RhMgaMatrizseguimientoplanesma();
		rhMgaMatrizseguimientoplanesmaList = new ArrayList<RhMgaMatrizseguimientoplanesma>();
		try {
			// Creamos un Workbook para cargar el XLS en memoria
			Workbook workbook = Workbook.getWorkbook(inputStream);
			// Elegimos la primera hoja
			Sheet sheet = workbook.getSheet(0);
			// inicializo el objeto que leerá el valor de la celda
			Cell celdaCurso = null;
			// Obtengo el número de filas ocupadas en la hoja
			int rows = sheet.getRows();
			// Obtengo el número de columnas ocupadas en la hoja
			int cols = sheet.getColumns();
			if (cols == 9) {
				// Para efectos de ejemplo recorremos las columnas de cada fila
				for (int x = 2; x < rows; x++) {
					for (int y = 0; y < cols; y++) {
						// Obtenemos el valor de la celda de la columna Y y fila
						// X
						celdaCurso = sheet.getCell(y, x);
						if (y == 0) {
							rhMgaMatrizseguimientoplanesma.setMtzN(Integer
									.parseInt(celdaCurso.getContents().trim()));
						}
						if (y == 1) {
							rhMgaMatrizseguimientoplanesma
									.setMtzProgramasSubprogramapma(celdaCurso
											.getContents().trim());
						}
						if (y == 2) {
							rhMgaMatrizseguimientoplanesma
									.setMtzPorcentajeCumplimiento(celdaCurso
											.getContents().trim());
						}
						if (y == 3) {
							rhMgaMatrizseguimientoplanesma
									.setMtzResponsablesenagua(celdaCurso
											.getContents().trim());
						}
						if (y == 4) {
							rhMgaMatrizseguimientoplanesma
									.setMtzResponsablecontratista(celdaCurso
											.getContents().trim());
						}
						if (y == 5) {
							rhMgaMatrizseguimientoplanesma
									.setMtzMediosverificacion(celdaCurso
											.getContents().trim());
						}
						if (y == 6) {
							rhMgaMatrizseguimientoplanesma
									.setMtzAnualcumplimiento2012(celdaCurso
											.getContents().trim());
						}
						if (y == 7) {
							rhMgaMatrizseguimientoplanesma
									.setMtzAnualcumplimiento2013(celdaCurso
											.getContents().trim());
						}
						if (y == 8) {
							rhMgaMatrizseguimientoplanesma
									.setMtzObservacion(celdaCurso.getContents()
											.trim());
						}
						rhMgaMatrizseguimientoplanesma
								.setRhMgaProyectomatrizseguimientoplanesma(rhMgaProyectomatrizseguimientoplanesma);

					}
					rhMgaMatrizseguimientoplanesmaList
							.add(rhMgaMatrizseguimientoplanesma);
					rhMgaMatrizseguimientoplanesma = new RhMgaMatrizseguimientoplanesma();

				}
				workbook.close();
				FacesMessage message = new FacesMessage(
						FacesMessage.SEVERITY_INFO, "Carga Archivo:",
						"Excel Cargado.... ");
				FacesContext.getCurrentInstance().addMessage(null, message);
			} else {
				FacesMessage message = new FacesMessage(
						FacesMessage.SEVERITY_ERROR, "Carga Archivos:",
						"Carga Excel : Problema con Archivo Tamano "
								+ "columnas" + cols + " Filas" + rows);
				FacesContext.getCurrentInstance().addMessage(null, message);
			}
		} catch (Exception e) {
			FacesMessage message = new FacesMessage(
					FacesMessage.SEVERITY_ERROR, "Carga Archivo:",
					"Carga Excel : Error en Archivo de Carga ");
			FacesContext.getCurrentInstance().addMessage(null, message);

		}
		return rhMgaMatrizseguimientoplanesmaList;
	}

	/**
	 * lectura de Excel a List Contaminacion
	 * */
	public List<RhMgaContaminacion> leerExcelContaminacion(
			InputStream inputStream) throws IOException, BiffException {
		rhMgaContaminacion = new RhMgaContaminacion();
		rhMgaContaminacionList = new ArrayList<RhMgaContaminacion>();
		try {
			// Creamos un Workbook para cargar el XLS en memoria
			Workbook workbook = Workbook.getWorkbook(inputStream);
			// Elegimos la primera hoja
			Sheet sheet = workbook.getSheet(0);
			// inicializo el objeto que leerá el valor de la celda
			Cell celdaCurso = null;
			// Obtengo el número de filas ocupadas en la hoja
			int rows = sheet.getRows();
			// Obtengo el número de columnas ocupadas en la hoja
			int cols = sheet.getColumns();
			if (cols == 6) {
				// Para efectos de ejemplo recorremos las columnas de cada fila
				for (int x = 1; x < rows; x++) {
					for (int y = 0; y < cols; y++) {
						// Obtenemos el valor de la celda de la columna Y y fila
						// X
						celdaCurso = sheet.getCell(y, x);
						if (y == 0) {
							rhMgaContaminacion
									.setConDemarcacionhidrografica(celdaCurso
											.getContents().trim());
						}
						if (y == 1) {
							rhMgaContaminacion.setConEvento(celdaCurso
									.getContents().trim());
						}
						if (y == 2) {
							rhMgaContaminacion.setConFechainspeccion(celdaCurso
									.getContents().trim());
						}
						if (y == 3) {
							rhMgaContaminacion.setConCodigoficha(celdaCurso
									.getContents().trim());
						}
						if (y == 4) {
							rhMgaContaminacion.setConCodigoinforme(celdaCurso
									.getContents().trim());
						}
						if (y == 5) {
							rhMgaContaminacion.setConFechainforme(celdaCurso
									.getContents().trim());
						}

					}
					rhMgaContaminacionList.add(rhMgaContaminacion);
					rhMgaContaminacion = new RhMgaContaminacion();
				}
				workbook.close();
				FacesMessage message = new FacesMessage(
						FacesMessage.SEVERITY_INFO, "Carga Archivo:",
						"Excel Cargado.... ");
				FacesContext.getCurrentInstance().addMessage(null, message);
			} else {
				FacesMessage message = new FacesMessage(
						FacesMessage.SEVERITY_ERROR, "Carga Archivos:",
						"Carga Excel : Problema con Archivo Tamano "
								+ "columnas" + cols + " Filas" + rows);
				FacesContext.getCurrentInstance().addMessage(null, message);
			}
		} catch (Exception e) {
			FacesMessage message = new FacesMessage(
					FacesMessage.SEVERITY_ERROR, "Carga Archivo:",
					"Carga Excel : Error en Archivo de Carga ");
			FacesContext.getCurrentInstance().addMessage(null, message);

		}
		return rhMgaContaminacionList;
	}

	/**
	 * lectura de Excel a List Reportes Gruntec
	 * */
	public List<RhMcaReportelaboratorio> leerExcelReporteGruntec(
			InputStream inputStream, RhMcaMuestreo rhMcaMuestreo)
			throws IOException, BiffException {
		rhMcaReportelaboratorio = new RhMcaReportelaboratorio();
		rhMcaReportelaboratorioList = new ArrayList<RhMcaReportelaboratorio>();
		try {
			// Creamos un Workbook para cargar el XLS en memoria
			Workbook workbook = Workbook.getWorkbook(inputStream);
			// Elegimos la primera hoja
			Sheet sheet = workbook.getSheet(0);
			// inicializo el objeto que leerá el valor de la celda
			Cell celdaCurso = null;
			// Obtengo el número de filas ocupadas en la hoja
			int rows = sheet.getRows();
			// Obtengo el número de columnas ocupadas en la hoja
			int cols = sheet.getColumns();
			if (cols == 18) {
				// Para efectos de ejemplo recorremos las columnas de cada fila
				for (int x = 1; x < rows; x++) {
					for (int y = 0; y < cols; y++) {
						// Obtenemos el valor de la celda de la columna Y y fila
						// X
						celdaCurso = sheet.getCell(y, x);
						if (y == 0) {
							rhMcaReportelaboratorio
									.setRptRotulaciongruentec(celdaCurso
											.getContents().trim());
						}
						if (y == 1) {
							rhMcaReportelaboratorio
									.setRptRotulacioncliente(celdaCurso
											.getContents().trim());
						}
						if (y == 2) {
							rhMcaReportelaboratorio.setRptProyecto(celdaCurso
									.getContents().trim());
						}
						if (y == 3) {
							rhMcaReportelaboratorio
									.setRptFechamuestreo(celdaCurso
											.getContents().trim());
						}
						if (y == 4) {
							rhMcaReportelaboratorio
									.setRptFechaingreso(celdaCurso
											.getContents().trim());
						}
						if (y == 5) {
							rhMcaReportelaboratorio.setRptGrupo(celdaCurso
									.getContents().trim());
						}
						if (y == 6) {
							rhMcaReportelaboratorio.setRptParametro(celdaCurso
									.getContents().trim());
						}
						if (y == 7) {
							rhMcaReportelaboratorio.setRptMedicion(celdaCurso
									.getContents().trim());
						}
						if (y == 8) {
							rhMcaReportelaboratorio.setRptUnidad(celdaCurso
									.getContents().trim());
						}
						if (y == 9) {
							rhMcaReportelaboratorio
									.setRptFechaAnalisis(celdaCurso
											.getContents().trim());
						}
						if (y == 10) {
							rhMcaReportelaboratorio
									.setRptLimiteDeteccion(celdaCurso
											.getContents().trim());
						}
						if (y == 11) {
							rhMcaReportelaboratorio
									.setRptLimiteCuantificacion(celdaCurso
											.getContents().trim());
						}
						if (y == 12) {
							rhMcaReportelaboratorio
									.setRptMetodoReferencia(celdaCurso
											.getContents().trim());
						}
						if (y == 13) {
							rhMcaReportelaboratorio.setRptCliente(celdaCurso
									.getContents().trim());
						}
						if (y == 14) {
							rhMcaReportelaboratorio
									.setRptTipoMuestra(celdaCurso.getContents()
											.trim());
						}
						if (y == 15) {
							rhMcaReportelaboratorio
									.setRptLimitemaximopermisible(celdaCurso
											.getContents().trim());
						}
						if (y == 16) {
							rhMcaReportelaboratorio.setRptRango(celdaCurso
									.getContents().trim());
						}
						if (y == 17) {
							rhMcaReportelaboratorio
									.setRptEstadoparametro(celdaCurso
											.getContents().trim());
						}
						rhMcaReportelaboratorio.setRhMcaMuestreo(rhMcaMuestreo);

					}
					rhMcaReportelaboratorioList.add(rhMcaReportelaboratorio);
					rhMcaReportelaboratorio = new RhMcaReportelaboratorio();
				}
				workbook.close();
				FacesMessage message = new FacesMessage(
						FacesMessage.SEVERITY_INFO, "Carga Archivo:",
						"Excel Cargado.... ");
				FacesContext.getCurrentInstance().addMessage(null, message);
			} else {
				FacesMessage message = new FacesMessage(
						FacesMessage.SEVERITY_ERROR, "Carga Archivos:",
						"Carga Excel : Problema con Archivo Tamano "
								+ "columnas" + cols + " Filas" + rows);
				FacesContext.getCurrentInstance().addMessage(null, message);
			}
		} catch (Exception e) {
			FacesMessage message = new FacesMessage(
					FacesMessage.SEVERITY_ERROR, "Carga Archivo:",
					"Carga Excel : Error en Archivo de Carga ");
			FacesContext.getCurrentInstance().addMessage(null, message);

		}
		return rhMcaReportelaboratorioList;
	}

	/**
	 * lectura de Excel a List Limites esperados
	 * */
	public List<RhMcaParametrosLimitesesperado> leerExcelLimitesEsperados(
			InputStream inputStream) throws IOException, BiffException {
		rhMcaParametrosLimitesesperado = new RhMcaParametrosLimitesesperado();
		rhMcaParametrosLimitesesperadoLst = new ArrayList<RhMcaParametrosLimitesesperado>();
		try {
			// Creamos un Workbook para cargar el XLS en memoria
			Workbook workbook = Workbook.getWorkbook(inputStream);
			// Elegimos la primera hoja
			Sheet sheet = workbook.getSheet(0);
			// inicializo el objeto que leerá el valor de la celda
			Cell celdaCurso = null;
			// Obtengo el número de filas ocupadas en la hoja
			int rows = sheet.getRows();
			// Obtengo el número de columnas ocupadas en la hoja
			int cols = sheet.getColumns();
			if (cols == 12) {
				// Para efectos de ejemplo recorremos las columnas de cada fila
				for (int x = 1; x < rows; x++) {
					for (int y = 0; y < cols; y++) {
						// Obtenemos el valor de la celda de la columna Y y fila
						// X
						celdaCurso = sheet.getCell(y, x);
						if (y == 0) {
							rhMcaParametrosLimitesesperado.setLespAnio(Integer
									.parseInt(celdaCurso.getContents().trim()));
						}
						if (y == 1) {
							rhMcaParametrosLimitesesperado.setLespEstado(true);
							// Boolean.valueOf(celdaCurso.getContents().trim()
						}
						if (y == 2) {
							rhMcaParametrosLimitesesperado
									.setLespCoddemarcacion(celdaCurso
											.getContents().trim());
						}
						if (y == 3) {
							rhMcaParametrosLimitesesperado
									.setLespDemarcacion(celdaCurso
											.getContents().trim());
						}
						if (y == 4) {
							rhMcaParametrosLimitesesperado
									.setLespCodactividad(celdaCurso
											.getContents().trim());
						}
						if (y == 5) {
							rhMcaParametrosLimitesesperado
									.setLespActividad(celdaCurso.getContents()
											.trim());
						}
						if (y == 6) {
							rhMcaParametrosLimitesesperado
									.setLespCodparametro(celdaCurso
											.getContents().trim());
						}
						if (y == 7) {
							rhMcaParametrosLimitesesperado
									.setLespParametro(celdaCurso.getContents()
											.trim());
						}
						if (y == 8) {
							rhMcaParametrosLimitesesperado
									.setLespCodigo(celdaCurso.getContents()
											.trim());
						}
						if (y == 9) {
							rhMcaParametrosLimitesesperado
									.setLespUnidad(celdaCurso.getContents()
											.trim());
						}
						if (y == 10) {
							rhMcaParametrosLimitesesperado
									.setLespMax(celdaCurso.getContents().trim());
						}
						if (y == 11) {
							rhMcaParametrosLimitesesperado
									.setLespMin(celdaCurso.getContents().trim());
						}
						// rhMcaParametrosLimitesesperado

					}
					rhMcaParametrosLimitesesperadoLst
							.add(rhMcaParametrosLimitesesperado);
					rhMcaParametrosLimitesesperado = new RhMcaParametrosLimitesesperado();
				}
				workbook.close();
				FacesMessage message = new FacesMessage(
						FacesMessage.SEVERITY_INFO, "Carga Archivo:",
						"Excel Cargado.... ");
				FacesContext.getCurrentInstance().addMessage(null, message);
			} else {
				FacesMessage message = new FacesMessage(
						FacesMessage.SEVERITY_ERROR, "Carga Archivos:",
						"Carga Excel : Problema con Archivo Tamano "
								+ "columnas" + cols + " Filas" + rows);
				FacesContext.getCurrentInstance().addMessage(null, message);
			}
		} catch (Exception e) {
			FacesMessage message = new FacesMessage(
					FacesMessage.SEVERITY_ERROR, "Carga Archivo:",
					"Carga Excel : Error en Archivo de Carga ");
			FacesContext.getCurrentInstance().addMessage(null, message);

		}
		return rhMcaParametrosLimitesesperadoLst;
	}

	/**
	 * lectura de Excel a List Norma Vigente
	 * */
	public List<RhMcaParametrosNormavigente> leerExcelNormaVigente(
			InputStream inputStream) throws IOException, BiffException {
		rhMcaParametrosNormavigente = new RhMcaParametrosNormavigente();
		rhMcaParametrosNormavigenteLst = new ArrayList<RhMcaParametrosNormavigente>();
		try {
			// Creamos un Workbook para cargar el XLS en memoria
			Workbook workbook = Workbook.getWorkbook(inputStream);
			// Elegimos la primera hoja
			Sheet sheet = workbook.getSheet(0);
			// inicializo el objeto que leerá el valor de la celda
			Cell celdaCurso = null;
			// Obtengo el número de filas ocupadas en la hoja
			int rows = sheet.getRows();
			// Obtengo el número de columnas ocupadas en la hoja
			int cols = sheet.getColumns();
			if (cols == 9) {
				// Para efectos de ejemplo recorremos las columnas de cada fila
				for (int x = 1; x < rows; x++) {
					for (int y = 0; y < cols; y++) {
						// Obtenemos el valor de la celda de la columna Y y fila
						// X
						celdaCurso = sheet.getCell(y, x);
						if (y == 0) {
							rhMcaParametrosNormavigente.setNorvAnio(Integer
									.parseInt(celdaCurso.getContents().trim()));
						}
						if (y == 1) {
							rhMcaParametrosNormavigente.setNorvEstado(true);
							// Boolean.valueOf(celdaCurso.getContents().trim()
						}
						if (y == 2) {
							rhMcaParametrosNormavigente
									.setNorvCodtipo(celdaCurso.getContents()
											.trim());
						}

						if (y == 3) {
							rhMcaParametrosNormavigente.setNorvTipo(celdaCurso
									.getContents().trim());
						}

						if (y == 4) {
							rhMcaParametrosNormavigente
									.setNorvCodparametro(celdaCurso
											.getContents().trim());
						}

						if (y == 5) {
							rhMcaParametrosNormavigente
									.setNorvParametro(celdaCurso.getContents()
											.trim());
						}
						if (y == 6) {
							rhMcaParametrosNormavigente
									.setNorvCodigo(celdaCurso.getContents()
											.trim());
						}
						if (y == 7) {
							rhMcaParametrosNormavigente
									.setNorvUnidad(celdaCurso.getContents()
											.trim());
						}
						if (y == 8) {
							rhMcaParametrosNormavigente
									.setNorvLimitemaximopermisible(celdaCurso
											.getContents().trim());
						}

					}
					rhMcaParametrosNormavigenteLst
							.add(rhMcaParametrosNormavigente);
					rhMcaParametrosNormavigente = new RhMcaParametrosNormavigente();
				}
				workbook.close();
				FacesMessage message = new FacesMessage(
						FacesMessage.SEVERITY_INFO, "Carga Archivo:",
						"Excel Cargado.... ");
				FacesContext.getCurrentInstance().addMessage(null, message);
			} else {
				FacesMessage message = new FacesMessage(
						FacesMessage.SEVERITY_ERROR, "Carga Archivos:",
						"Carga Excel : Problema con Archivo Tamano "
								+ "columnas" + cols + " Filas" + rows);
				FacesContext.getCurrentInstance().addMessage(null, message);
			}
		} catch (Exception e) {
			FacesMessage message = new FacesMessage(
					FacesMessage.SEVERITY_ERROR, "Carga Archivo:",
					"Carga Excel : Error en Archivo de Carga ");
			FacesContext.getCurrentInstance().addMessage(null, message);

		}
		return rhMcaParametrosNormavigenteLst;
	}

	public InputStream getInput() {
		return input;
	}

	public void setInput(InputStream input) {
		this.input = input;
	}

	public RhMgaLicenciamientoambiental getRhMgaLicenciamientoambiental() {
		return rhMgaLicenciamientoambiental;
	}

	public void setRhMgaLicenciamientoambiental(
			RhMgaLicenciamientoambiental rhMgaLicenciamientoambiental) {
		this.rhMgaLicenciamientoambiental = rhMgaLicenciamientoambiental;
	}

	public LicenciamientoAmbientalControl getLicenciamientoAmbientalControl() {
		return licenciamientoAmbientalControl;
	}

	public void setLicenciamientoAmbientalControl(
			LicenciamientoAmbientalControl licenciamientoAmbientalControl) {
		this.licenciamientoAmbientalControl = licenciamientoAmbientalControl;
	}

	public RhMgaMatrizseguimientoplanesma getRhMgaMatrizseguimientoplanesma() {
		return rhMgaMatrizseguimientoplanesma;
	}

	public void setRhMgaMatrizseguimientoplanesma(
			RhMgaMatrizseguimientoplanesma rhMgaMatrizseguimientoplanesma) {
		this.rhMgaMatrizseguimientoplanesma = rhMgaMatrizseguimientoplanesma;
	}

	public List<RhMgaMatrizseguimientoplanesma> getRhMgaMatrizseguimientoplanesmaList() {
		return rhMgaMatrizseguimientoplanesmaList;
	}

	public void setRhMgaMatrizseguimientoplanesmaList(
			List<RhMgaMatrizseguimientoplanesma> rhMgaMatrizseguimientoplanesmaList) {
		this.rhMgaMatrizseguimientoplanesmaList = rhMgaMatrizseguimientoplanesmaList;
	}

	public RhMgaContaminacion getRhMgaContaminacion() {
		return rhMgaContaminacion;
	}

	public void setRhMgaContaminacion(RhMgaContaminacion rhMgaContaminacion) {
		this.rhMgaContaminacion = rhMgaContaminacion;
	}

	public List<RhMgaContaminacion> getRhMgaContaminacionList() {
		return rhMgaContaminacionList;
	}

	public void setRhMgaContaminacionList(
			List<RhMgaContaminacion> rhMgaContaminacionList) {
		this.rhMgaContaminacionList = rhMgaContaminacionList;
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

	public RhMcaParametrosLimitesesperado getRhMcaParametrosLimitesesperado() {
		return rhMcaParametrosLimitesesperado;
	}

	public void setRhMcaParametrosLimitesesperado(
			RhMcaParametrosLimitesesperado rhMcaParametrosLimitesesperado) {
		this.rhMcaParametrosLimitesesperado = rhMcaParametrosLimitesesperado;
	}

	public List<RhMcaParametrosLimitesesperado> getRhMcaParametrosLimitesesperadoLst() {
		return rhMcaParametrosLimitesesperadoLst;
	}

	public void setRhMcaParametrosLimitesesperadoLst(
			List<RhMcaParametrosLimitesesperado> rhMcaParametrosLimitesesperadoLst) {
		this.rhMcaParametrosLimitesesperadoLst = rhMcaParametrosLimitesesperadoLst;
	}

	public RhMcaParametrosNormavigente getRhMcaParametrosNormavigente() {
		return rhMcaParametrosNormavigente;
	}

	public void setRhMcaParametrosNormavigente(
			RhMcaParametrosNormavigente rhMcaParametrosNormavigente) {
		this.rhMcaParametrosNormavigente = rhMcaParametrosNormavigente;
	}

	public List<RhMcaParametrosNormavigente> getRhMcaParametrosNormavigenteLst() {
		return rhMcaParametrosNormavigenteLst;
	}

	public void setRhMcaParametrosNormavigenteLst(
			List<RhMcaParametrosNormavigente> rhMcaParametrosNormavigenteLst) {
		this.rhMcaParametrosNormavigenteLst = rhMcaParametrosNormavigenteLst;
	}

}
