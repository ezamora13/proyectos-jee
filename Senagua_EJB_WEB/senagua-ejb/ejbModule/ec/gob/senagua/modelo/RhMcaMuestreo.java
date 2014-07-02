package ec.gob.senagua.modelo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * The persistent class for the rh_mca_muestreo database table.
 * 
 */
@Entity
@Table(name = "rh_mca_muestreo", schema = "modulos")
@SequenceGenerator(name = "modulos.rh_mca_muestreo_seq", sequenceName = "modulos.rh_mca_muestreo_seq", initialValue = 1, allocationSize = 1)
public class RhMcaMuestreo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "modulos.rh_mca_muestreo_seq")
	@Column(name = "ms_id")
	private Integer msId;

	@Column(name = "ms_apariencia")
	private String msApariencia;

	@Column(name = "ms_basura")
	private Boolean msBasura;

	@Column(name = "ms_cadaveres")
	private Boolean msCadaveres;

	@Column(name = "ms_campania")
	private String msCampania;

	@Column(name = "ms_codigo")
	private String msCodigo;

	@Column(name = "ms_color")
	private String msColor;

	@Column(name = "ms_combustible")
	private Boolean msCombustible;

	@Column(name = "ms_conductividad")
	private Double msConductividad;

	@Column(name = "ms_coordinadorresponsable")
	private String msCoordinadorresponsable;

	@Column(name = "ms_despejado")
	private Boolean msDespejado;

	@Column(name = "ms_domestico")
	private Boolean msDomestico;

	@Column(name = "ms_escombros")
	private Boolean msEscombros;

	@Column(name = "ms_excretas")
	private Boolean msExcretas;

	@Temporal(TemporalType.DATE)
	@Column(name = "ms_fecha")
	private Date msFecha;

	@Column(name = "ms_iddemarcacion")
	private Integer msIddemarcacion;

	@Column(name = "ms_idriego")
	private Integer msIdriego;

	@Column(name = "ms_idtipomuestra")
	private Integer msIdtipomuestra;

	@Column(name = "ms_industriales")
	private Boolean msIndustriales;

	@Column(name = "ms_lluvia")
	private Boolean msLluvia;

	@Column(name = "ms_medicion")
	private Double msMedicion;

	@Column(name = "ms_metodomedicion")
	private Integer msMetodomedicion;

	@Column(name = "ms_monitoreadopor")
	private String msMonitoreadopor;

	@Column(name = "ms_nublado")
	private Boolean msNublado;

	@Column(name = "ms_observacion")
	private String msObservacion;

	@Column(name = "ms_od")
	private Double msOd;

	@Column(name = "ms_odporcentaje")
	private Double msOdporcentaje;

	@Column(name = "ms_olor")
	private String msOlor;

	@Column(name = "ms_ph")
	private Double msPh;

	@Column(name = "ms_regsitradopor")
	private String msRegsitradopor;

	@Column(name = "ms_salinidad")
	private Double msSalinidad;

	@Column(name = "ms_sol")
	private Boolean msSol;

	@Column(name = "ms_tagua")
	private Double msTagua;

	@Column(name = "ms_tambiente")
	private Double msTambiente;

	@Column(name = "ms_tds")
	private Double msTds;

	@Column(name = "ms_tipo")
	private String msTipo;

	@Column(name = "ms_turbiedad")
	private Double msTurbiedad;

	@Column(name = "ms_valor")
	private Double msValor;

	@Column(name = "ms_viento")
	private Boolean msViento;

	@Column(name = "rg_numeroficha")
	private String rgNumeroficha;

	// bi-directional many-to-one association to RhTabletRegistro
	@ManyToOne
	@JoinColumn(name = "rg_id")
	private RhTabletRegistro rhTabletRegistro;

	// bi-directional many-to-one association to RhMcaReportelaboratorio
	@OneToMany(mappedBy = "rhMcaMuestreo")
	private List<RhMcaReportelaboratorio> rhMcaReportelaboratorios;

	public RhMcaMuestreo() {
	}

	public Integer getMsId() {
		return msId;
	}

	public void setMsId(Integer msId) {
		this.msId = msId;
	}

	public String getMsApariencia() {
		return msApariencia;
	}

	public void setMsApariencia(String msApariencia) {
		this.msApariencia = msApariencia;
	}

	public Boolean getMsBasura() {
		return msBasura;
	}

	public void setMsBasura(Boolean msBasura) {
		this.msBasura = msBasura;
	}

	public Boolean getMsCadaveres() {
		return msCadaveres;
	}

	public void setMsCadaveres(Boolean msCadaveres) {
		this.msCadaveres = msCadaveres;
	}

	public String getMsCampania() {
		return msCampania;
	}

	public void setMsCampania(String msCampania) {
		this.msCampania = msCampania;
	}

	public String getMsCodigo() {
		return msCodigo;
	}

	public void setMsCodigo(String msCodigo) {
		this.msCodigo = msCodigo;
	}

	public String getMsColor() {
		return msColor;
	}

	public void setMsColor(String msColor) {
		this.msColor = msColor;
	}

	public Boolean getMsCombustible() {
		return msCombustible;
	}

	public void setMsCombustible(Boolean msCombustible) {
		this.msCombustible = msCombustible;
	}

	public Double getMsConductividad() {
		return msConductividad;
	}

	public void setMsConductividad(Double msConductividad) {
		this.msConductividad = msConductividad;
	}

	public String getMsCoordinadorresponsable() {
		return msCoordinadorresponsable;
	}

	public void setMsCoordinadorresponsable(String msCoordinadorresponsable) {
		this.msCoordinadorresponsable = msCoordinadorresponsable;
	}

	public Boolean getMsDespejado() {
		return msDespejado;
	}

	public void setMsDespejado(Boolean msDespejado) {
		this.msDespejado = msDespejado;
	}

	public Boolean getMsDomestico() {
		return msDomestico;
	}

	public void setMsDomestico(Boolean msDomestico) {
		this.msDomestico = msDomestico;
	}

	public Boolean getMsEscombros() {
		return msEscombros;
	}

	public void setMsEscombros(Boolean msEscombros) {
		this.msEscombros = msEscombros;
	}

	public Boolean getMsExcretas() {
		return msExcretas;
	}

	public void setMsExcretas(Boolean msExcretas) {
		this.msExcretas = msExcretas;
	}

	public Date getMsFecha() {
		return msFecha;
	}

	public void setMsFecha(Date msFecha) {
		this.msFecha = msFecha;
	}

	public Integer getMsIddemarcacion() {
		return msIddemarcacion;
	}

	public void setMsIddemarcacion(Integer msIddemarcacion) {
		this.msIddemarcacion = msIddemarcacion;
	}

	public Integer getMsIdriego() {
		return msIdriego;
	}

	public void setMsIdriego(Integer msIdriego) {
		this.msIdriego = msIdriego;
	}

	public Integer getMsIdtipomuestra() {
		return msIdtipomuestra;
	}

	public void setMsIdtipomuestra(Integer msIdtipomuestra) {
		this.msIdtipomuestra = msIdtipomuestra;
	}

	public Boolean getMsIndustriales() {
		return msIndustriales;
	}

	public void setMsIndustriales(Boolean msIndustriales) {
		this.msIndustriales = msIndustriales;
	}

	public Boolean getMsLluvia() {
		return msLluvia;
	}

	public void setMsLluvia(Boolean msLluvia) {
		this.msLluvia = msLluvia;
	}

	public Double getMsMedicion() {
		return msMedicion;
	}

	public void setMsMedicion(Double msMedicion) {
		this.msMedicion = msMedicion;
	}

	public Integer getMsMetodomedicion() {
		return msMetodomedicion;
	}

	public void setMsMetodomedicion(Integer msMetodomedicion) {
		this.msMetodomedicion = msMetodomedicion;
	}

	public String getMsMonitoreadopor() {
		return msMonitoreadopor;
	}

	public void setMsMonitoreadopor(String msMonitoreadopor) {
		this.msMonitoreadopor = msMonitoreadopor;
	}

	public Boolean getMsNublado() {
		return msNublado;
	}

	public void setMsNublado(Boolean msNublado) {
		this.msNublado = msNublado;
	}

	public String getMsObservacion() {
		return msObservacion;
	}

	public void setMsObservacion(String msObservacion) {
		this.msObservacion = msObservacion;
	}

	public Double getMsOd() {
		return msOd;
	}

	public void setMsOd(Double msOd) {
		this.msOd = msOd;
	}

	public Double getMsOdporcentaje() {
		return msOdporcentaje;
	}

	public void setMsOdporcentaje(Double msOdporcentaje) {
		this.msOdporcentaje = msOdporcentaje;
	}

	public String getMsOlor() {
		return msOlor;
	}

	public void setMsOlor(String msOlor) {
		this.msOlor = msOlor;
	}

	public Double getMsPh() {
		return msPh;
	}

	public void setMsPh(Double msPh) {
		this.msPh = msPh;
	}

	public String getMsRegsitradopor() {
		return msRegsitradopor;
	}

	public void setMsRegsitradopor(String msRegsitradopor) {
		this.msRegsitradopor = msRegsitradopor;
	}

	public Double getMsSalinidad() {
		return msSalinidad;
	}

	public void setMsSalinidad(Double msSalinidad) {
		this.msSalinidad = msSalinidad;
	}

	public Boolean getMsSol() {
		return msSol;
	}

	public void setMsSol(Boolean msSol) {
		this.msSol = msSol;
	}

	public Double getMsTagua() {
		return msTagua;
	}

	public void setMsTagua(Double msTagua) {
		this.msTagua = msTagua;
	}

	public Double getMsTambiente() {
		return msTambiente;
	}

	public void setMsTambiente(Double msTambiente) {
		this.msTambiente = msTambiente;
	}

	public Double getMsTds() {
		return msTds;
	}

	public void setMsTds(Double msTds) {
		this.msTds = msTds;
	}

	public String getMsTipo() {
		return msTipo;
	}

	public void setMsTipo(String msTipo) {
		this.msTipo = msTipo;
	}

	public Double getMsTurbiedad() {
		return msTurbiedad;
	}

	public void setMsTurbiedad(Double msTurbiedad) {
		this.msTurbiedad = msTurbiedad;
	}

	public Double getMsValor() {
		return msValor;
	}

	public void setMsValor(Double msValor) {
		this.msValor = msValor;
	}

	public Boolean getMsViento() {
		return msViento;
	}

	public void setMsViento(Boolean msViento) {
		this.msViento = msViento;
	}

	public String getRgNumeroficha() {
		return rgNumeroficha;
	}

	public void setRgNumeroficha(String rgNumeroficha) {
		this.rgNumeroficha = rgNumeroficha;
	}

	public RhTabletRegistro getRhTabletRegistro() {
		return rhTabletRegistro;
	}

	public void setRhTabletRegistro(RhTabletRegistro rhTabletRegistro) {
		this.rhTabletRegistro = rhTabletRegistro;
	}

	public List<RhMcaReportelaboratorio> getRhMcaReportelaboratorios() {
		return rhMcaReportelaboratorios;
	}

	public void setRhMcaReportelaboratorios(
			List<RhMcaReportelaboratorio> rhMcaReportelaboratorios) {
		this.rhMcaReportelaboratorios = rhMcaReportelaboratorios;
	}

}