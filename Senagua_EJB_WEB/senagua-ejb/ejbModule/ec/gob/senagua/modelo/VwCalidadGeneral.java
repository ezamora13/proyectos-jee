package ec.gob.senagua.modelo;

import java.io.Serializable;

import javax.persistence.*;

import java.sql.Time;
import java.math.BigDecimal;
import java.util.Date;

/**
 * The persistent class for the vw_calidad_general database table.
 * 
 */
@Entity
@Table(name = "vw_calidad_general", schema = "modulos")
@NamedQuery(name = "VwCalidadGeneral.findAll", query = "SELECT v FROM VwCalidadGeneral v")
public class VwCalidadGeneral implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private BigDecimal altura;

	private String basura;

	private String cadaveres;

	private String canton;

	@Column(name = "cod_unid_hidrografica")
	private String codUnidHidrografica;

	@Column(name = "codigo_muestreo")
	private String codigoMuestreo;

	@Column(name = "codigo_punto")
	private String codigoPunto;

	private String combustible;

	@Column(name = "coord_este")
	private BigDecimal coordEste;

	@Column(name = "coord_norte")
	private BigDecimal coordNorte;

	private String demarcacion;

	private String despejado;

	private String domestico;

	private String escombros;

	private String excretas;

	@Temporal(TemporalType.DATE)
	@Column(name = "fecha_inspeccion")
	private Date fechaInspeccion;

	@Temporal(TemporalType.DATE)
	@Column(name = "fecha_muestreo")
	private Date fechaMuestreo;

	private String fuente;

	@Column(name = "hora_inspeccion")
	private Time horaInspeccion;

	private String industriales;

	private String lluvia;

	@Column(name = "metodo_medicion")
	private String metodoMedicion;

	@Column(name = "ms_apariencia")
	private String msApariencia;

	@Column(name = "ms_campania")
	private String msCampania;

	@Column(name = "ms_color")
	private String msColor;

	@Column(name = "ms_conductividad")
	private double msConductividad;

	@Column(name = "ms_coordinadorresponsable")
	private String msCoordinadorresponsable;

	@Column(name = "ms_medicion")
	private double msMedicion;

	@Column(name = "ms_monitoreadopor")
	private String msMonitoreadopor;

	@Column(name = "ms_observacion")
	private String msObservacion;

	@Column(name = "ms_od")
	private double msOd;

	@Column(name = "ms_odporcentaje")
	private double msOdporcentaje;

	@Column(name = "ms_olor")
	private String msOlor;

	@Column(name = "ms_ph")
	private double msPh;

	@Column(name = "ms_regsitradopor")
	private String msRegsitradopor;

	@Column(name = "ms_salinidad")
	private double msSalinidad;

	@Column(name = "ms_tagua")
	private double msTagua;

	@Column(name = "ms_tambiente")
	private double msTambiente;

	@Column(name = "ms_tds")
	private double msTds;

	@Column(name = "ms_tipo")
	private String msTipo;

	@Column(name = "ms_turbiedad")
	private double msTurbiedad;

	@Column(name = "ms_valor")
	private double msValor;

	@Column(name = "nombre_sitio")
	private String nombreSitio;

	@Column(name = "norv_anio")
	private Integer norvAnio;

	@Column(name = "norv_codigo")
	private String norvCodigo;

	@Column(name = "norv_codparametro")
	private String norvCodparametro;

	@Column(name = "norv_codtipo")
	private String norvCodtipo;

	@Column(name = "norv_estado")
	private Boolean norvEstado;

	@Column(name = "norv_parametro")
	private String norvParametro;

	@Column(name = "norv_tipo")
	private String norvTipo;

	private String nublado;

	private String parroquia;

	@Column(name = "pr_descripcion")
	private String prDescripcion;

	private String provincia;

	@Column(name = "rg_idmicrocuenca")
	private Integer rgIdmicrocuenca;

	@Column(name = "rg_idtipoevento")
	private Integer rgIdtipoevento;

	@Column(name = "rg_rutaacceso")
	private String rgRutaacceso;

	private String riesgo;

	@Column(name = "rpt_cliente")
	private String rptCliente;

	@Column(name = "rpt_estadoparametro")
	private String rptEstadoparametro;

	@Column(name = "rpt_fecha_analisis")
	private String rptFechaAnalisis;

	@Column(name = "rpt_fechaingreso")
	private String rptFechaingreso;

	@Column(name = "rpt_fechamuestreo")
	private String rptFechamuestreo;

	@Column(name = "rpt_grupo")
	private String rptGrupo;

	@Column(name = "rpt_limite_cuantificacion")
	private String rptLimiteCuantificacion;

	@Column(name = "rpt_limite_deteccion")
	private String rptLimiteDeteccion;

	@Column(name = "rpt_limitemaximopermisible")
	private String rptLimitemaximopermisible;

	@Column(name = "rpt_medicion")
	private String rptMedicion;

	@Column(name = "rpt_metodo_referencia")
	private String rptMetodoReferencia;

	@Column(name = "rpt_parametro")
	private String rptParametro;

	@Column(name = "rpt_proyecto")
	private String rptProyecto;

	@Column(name = "rpt_rango")
	private String rptRango;

	@Column(name = "rpt_rotulacioncliente")
	private String rptRotulacioncliente;

	@Column(name = "rpt_rotulaciongruentec")
	private String rptRotulaciongruentec;

	@Column(name = "rpt_tipo_muestra")
	private String rptTipoMuestra;

	@Column(name = "rpt_unidad")
	private String rptUnidad;

	private String sol;

	@Column(name = "tipo_muestra")
	private String tipoMuestra;

	@Column(name = "unidad_hidrografica")
	private String unidadHidrografica;

	private String viento;

	public VwCalidadGeneral() {
	}

	public BigDecimal getAltura() {
		return this.altura;
	}

	public void setAltura(BigDecimal altura) {
		this.altura = altura;
	}

	public String getBasura() {
		return this.basura;
	}

	public void setBasura(String basura) {
		this.basura = basura;
	}

	public String getCadaveres() {
		return this.cadaveres;
	}

	public void setCadaveres(String cadaveres) {
		this.cadaveres = cadaveres;
	}

	public String getCanton() {
		return this.canton;
	}

	public void setCanton(String canton) {
		this.canton = canton;
	}

	public String getCodUnidHidrografica() {
		return this.codUnidHidrografica;
	}

	public void setCodUnidHidrografica(String codUnidHidrografica) {
		this.codUnidHidrografica = codUnidHidrografica;
	}

	public String getCodigoMuestreo() {
		return this.codigoMuestreo;
	}

	public void setCodigoMuestreo(String codigoMuestreo) {
		this.codigoMuestreo = codigoMuestreo;
	}

	public String getCodigoPunto() {
		return this.codigoPunto;
	}

	public void setCodigoPunto(String codigoPunto) {
		this.codigoPunto = codigoPunto;
	}

	public String getCombustible() {
		return this.combustible;
	}

	public void setCombustible(String combustible) {
		this.combustible = combustible;
	}

	public BigDecimal getCoordEste() {
		return this.coordEste;
	}

	public void setCoordEste(BigDecimal coordEste) {
		this.coordEste = coordEste;
	}

	public BigDecimal getCoordNorte() {
		return this.coordNorte;
	}

	public void setCoordNorte(BigDecimal coordNorte) {
		this.coordNorte = coordNorte;
	}

	public String getDemarcacion() {
		return this.demarcacion;
	}

	public void setDemarcacion(String demarcacion) {
		this.demarcacion = demarcacion;
	}

	public String getDespejado() {
		return this.despejado;
	}

	public void setDespejado(String despejado) {
		this.despejado = despejado;
	}

	public String getDomestico() {
		return this.domestico;
	}

	public void setDomestico(String domestico) {
		this.domestico = domestico;
	}

	public String getEscombros() {
		return this.escombros;
	}

	public void setEscombros(String escombros) {
		this.escombros = escombros;
	}

	public String getExcretas() {
		return this.excretas;
	}

	public void setExcretas(String excretas) {
		this.excretas = excretas;
	}

	public Date getFechaInspeccion() {
		return this.fechaInspeccion;
	}

	public void setFechaInspeccion(Date fechaInspeccion) {
		this.fechaInspeccion = fechaInspeccion;
	}

	public Date getFechaMuestreo() {
		return this.fechaMuestreo;
	}

	public void setFechaMuestreo(Date fechaMuestreo) {
		this.fechaMuestreo = fechaMuestreo;
	}

	public String getFuente() {
		return this.fuente;
	}

	public void setFuente(String fuente) {
		this.fuente = fuente;
	}

	public Time getHoraInspeccion() {
		return this.horaInspeccion;
	}

	public void setHoraInspeccion(Time horaInspeccion) {
		this.horaInspeccion = horaInspeccion;
	}

	public String getIndustriales() {
		return this.industriales;
	}

	public void setIndustriales(String industriales) {
		this.industriales = industriales;
	}

	public String getLluvia() {
		return this.lluvia;
	}

	public void setLluvia(String lluvia) {
		this.lluvia = lluvia;
	}

	public String getMetodoMedicion() {
		return this.metodoMedicion;
	}

	public void setMetodoMedicion(String metodoMedicion) {
		this.metodoMedicion = metodoMedicion;
	}

	public String getMsApariencia() {
		return this.msApariencia;
	}

	public void setMsApariencia(String msApariencia) {
		this.msApariencia = msApariencia;
	}

	public String getMsCampania() {
		return this.msCampania;
	}

	public void setMsCampania(String msCampania) {
		this.msCampania = msCampania;
	}

	public String getMsColor() {
		return this.msColor;
	}

	public void setMsColor(String msColor) {
		this.msColor = msColor;
	}

	public double getMsConductividad() {
		return this.msConductividad;
	}

	public void setMsConductividad(double msConductividad) {
		this.msConductividad = msConductividad;
	}

	public String getMsCoordinadorresponsable() {
		return this.msCoordinadorresponsable;
	}

	public void setMsCoordinadorresponsable(String msCoordinadorresponsable) {
		this.msCoordinadorresponsable = msCoordinadorresponsable;
	}

	public double getMsMedicion() {
		return this.msMedicion;
	}

	public void setMsMedicion(double msMedicion) {
		this.msMedicion = msMedicion;
	}

	public String getMsMonitoreadopor() {
		return this.msMonitoreadopor;
	}

	public void setMsMonitoreadopor(String msMonitoreadopor) {
		this.msMonitoreadopor = msMonitoreadopor;
	}

	public String getMsObservacion() {
		return this.msObservacion;
	}

	public void setMsObservacion(String msObservacion) {
		this.msObservacion = msObservacion;
	}

	public double getMsOd() {
		return this.msOd;
	}

	public void setMsOd(double msOd) {
		this.msOd = msOd;
	}

	public double getMsOdporcentaje() {
		return this.msOdporcentaje;
	}

	public void setMsOdporcentaje(double msOdporcentaje) {
		this.msOdporcentaje = msOdporcentaje;
	}

	public String getMsOlor() {
		return this.msOlor;
	}

	public void setMsOlor(String msOlor) {
		this.msOlor = msOlor;
	}

	public double getMsPh() {
		return this.msPh;
	}

	public void setMsPh(double msPh) {
		this.msPh = msPh;
	}

	public String getMsRegsitradopor() {
		return this.msRegsitradopor;
	}

	public void setMsRegsitradopor(String msRegsitradopor) {
		this.msRegsitradopor = msRegsitradopor;
	}

	public double getMsSalinidad() {
		return this.msSalinidad;
	}

	public void setMsSalinidad(double msSalinidad) {
		this.msSalinidad = msSalinidad;
	}

	public double getMsTagua() {
		return this.msTagua;
	}

	public void setMsTagua(double msTagua) {
		this.msTagua = msTagua;
	}

	public double getMsTambiente() {
		return this.msTambiente;
	}

	public void setMsTambiente(double msTambiente) {
		this.msTambiente = msTambiente;
	}

	public double getMsTds() {
		return this.msTds;
	}

	public void setMsTds(double msTds) {
		this.msTds = msTds;
	}

	public String getMsTipo() {
		return this.msTipo;
	}

	public void setMsTipo(String msTipo) {
		this.msTipo = msTipo;
	}

	public double getMsTurbiedad() {
		return this.msTurbiedad;
	}

	public void setMsTurbiedad(double msTurbiedad) {
		this.msTurbiedad = msTurbiedad;
	}

	public double getMsValor() {
		return this.msValor;
	}

	public void setMsValor(double msValor) {
		this.msValor = msValor;
	}

	public String getNombreSitio() {
		return this.nombreSitio;
	}

	public void setNombreSitio(String nombreSitio) {
		this.nombreSitio = nombreSitio;
	}

	public Integer getNorvAnio() {
		return this.norvAnio;
	}

	public void setNorvAnio(Integer norvAnio) {
		this.norvAnio = norvAnio;
	}

	public String getNorvCodigo() {
		return this.norvCodigo;
	}

	public void setNorvCodigo(String norvCodigo) {
		this.norvCodigo = norvCodigo;
	}

	public String getNorvCodparametro() {
		return this.norvCodparametro;
	}

	public void setNorvCodparametro(String norvCodparametro) {
		this.norvCodparametro = norvCodparametro;
	}

	public String getNorvCodtipo() {
		return this.norvCodtipo;
	}

	public void setNorvCodtipo(String norvCodtipo) {
		this.norvCodtipo = norvCodtipo;
	}

	public Boolean getNorvEstado() {
		return this.norvEstado;
	}

	public void setNorvEstado(Boolean norvEstado) {
		this.norvEstado = norvEstado;
	}

	public String getNorvParametro() {
		return this.norvParametro;
	}

	public void setNorvParametro(String norvParametro) {
		this.norvParametro = norvParametro;
	}

	public String getNorvTipo() {
		return this.norvTipo;
	}

	public void setNorvTipo(String norvTipo) {
		this.norvTipo = norvTipo;
	}

	public String getNublado() {
		return this.nublado;
	}

	public void setNublado(String nublado) {
		this.nublado = nublado;
	}

	public String getParroquia() {
		return this.parroquia;
	}

	public void setParroquia(String parroquia) {
		this.parroquia = parroquia;
	}

	public String getPrDescripcion() {
		return this.prDescripcion;
	}

	public void setPrDescripcion(String prDescripcion) {
		this.prDescripcion = prDescripcion;
	}

	public String getProvincia() {
		return this.provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public Integer getRgIdmicrocuenca() {
		return this.rgIdmicrocuenca;
	}

	public void setRgIdmicrocuenca(Integer rgIdmicrocuenca) {
		this.rgIdmicrocuenca = rgIdmicrocuenca;
	}

	public Integer getRgIdtipoevento() {
		return this.rgIdtipoevento;
	}

	public void setRgIdtipoevento(Integer rgIdtipoevento) {
		this.rgIdtipoevento = rgIdtipoevento;
	}

	public String getRgRutaacceso() {
		return this.rgRutaacceso;
	}

	public void setRgRutaacceso(String rgRutaacceso) {
		this.rgRutaacceso = rgRutaacceso;
	}

	public String getRiesgo() {
		return this.riesgo;
	}

	public void setRiesgo(String riesgo) {
		this.riesgo = riesgo;
	}

	public String getRptCliente() {
		return this.rptCliente;
	}

	public void setRptCliente(String rptCliente) {
		this.rptCliente = rptCliente;
	}

	public String getRptEstadoparametro() {
		return this.rptEstadoparametro;
	}

	public void setRptEstadoparametro(String rptEstadoparametro) {
		this.rptEstadoparametro = rptEstadoparametro;
	}

	public String getRptFechaAnalisis() {
		return this.rptFechaAnalisis;
	}

	public void setRptFechaAnalisis(String rptFechaAnalisis) {
		this.rptFechaAnalisis = rptFechaAnalisis;
	}

	public String getRptFechaingreso() {
		return this.rptFechaingreso;
	}

	public void setRptFechaingreso(String rptFechaingreso) {
		this.rptFechaingreso = rptFechaingreso;
	}

	public String getRptFechamuestreo() {
		return this.rptFechamuestreo;
	}

	public void setRptFechamuestreo(String rptFechamuestreo) {
		this.rptFechamuestreo = rptFechamuestreo;
	}

	public String getRptGrupo() {
		return this.rptGrupo;
	}

	public void setRptGrupo(String rptGrupo) {
		this.rptGrupo = rptGrupo;
	}

	public String getRptLimiteCuantificacion() {
		return this.rptLimiteCuantificacion;
	}

	public void setRptLimiteCuantificacion(String rptLimiteCuantificacion) {
		this.rptLimiteCuantificacion = rptLimiteCuantificacion;
	}

	public String getRptLimiteDeteccion() {
		return this.rptLimiteDeteccion;
	}

	public void setRptLimiteDeteccion(String rptLimiteDeteccion) {
		this.rptLimiteDeteccion = rptLimiteDeteccion;
	}

	public String getRptLimitemaximopermisible() {
		return this.rptLimitemaximopermisible;
	}

	public void setRptLimitemaximopermisible(String rptLimitemaximopermisible) {
		this.rptLimitemaximopermisible = rptLimitemaximopermisible;
	}

	public String getRptMedicion() {
		return this.rptMedicion;
	}

	public void setRptMedicion(String rptMedicion) {
		this.rptMedicion = rptMedicion;
	}

	public String getRptMetodoReferencia() {
		return this.rptMetodoReferencia;
	}

	public void setRptMetodoReferencia(String rptMetodoReferencia) {
		this.rptMetodoReferencia = rptMetodoReferencia;
	}

	public String getRptParametro() {
		return this.rptParametro;
	}

	public void setRptParametro(String rptParametro) {
		this.rptParametro = rptParametro;
	}

	public String getRptProyecto() {
		return this.rptProyecto;
	}

	public void setRptProyecto(String rptProyecto) {
		this.rptProyecto = rptProyecto;
	}

	public String getRptRango() {
		return this.rptRango;
	}

	public void setRptRango(String rptRango) {
		this.rptRango = rptRango;
	}

	public String getRptRotulacioncliente() {
		return this.rptRotulacioncliente;
	}

	public void setRptRotulacioncliente(String rptRotulacioncliente) {
		this.rptRotulacioncliente = rptRotulacioncliente;
	}

	public String getRptRotulaciongruentec() {
		return this.rptRotulaciongruentec;
	}

	public void setRptRotulaciongruentec(String rptRotulaciongruentec) {
		this.rptRotulaciongruentec = rptRotulaciongruentec;
	}

	public String getRptTipoMuestra() {
		return this.rptTipoMuestra;
	}

	public void setRptTipoMuestra(String rptTipoMuestra) {
		this.rptTipoMuestra = rptTipoMuestra;
	}

	public String getRptUnidad() {
		return this.rptUnidad;
	}

	public void setRptUnidad(String rptUnidad) {
		this.rptUnidad = rptUnidad;
	}

	public String getSol() {
		return this.sol;
	}

	public void setSol(String sol) {
		this.sol = sol;
	}

	public String getTipoMuestra() {
		return this.tipoMuestra;
	}

	public void setTipoMuestra(String tipoMuestra) {
		this.tipoMuestra = tipoMuestra;
	}

	public String getUnidadHidrografica() {
		return unidadHidrografica;
	}

	public void setUnidadHidrografica(String unidadHidrografica) {
		this.unidadHidrografica = unidadHidrografica;
	}

	public String getViento() {
		return this.viento;
	}

	public void setViento(String viento) {
		this.viento = viento;
	}

}