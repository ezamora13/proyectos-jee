package ec.gob.senagua.modelo;

import java.io.Serializable;

import javax.persistence.*;

import ec.gob.senagua.modelo.RhMcaMuestreo;

import java.sql.Time;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * The persistent class for the rh_tablet_registro database table.
 * 
 */
@Entity
@Table(name = "rh_tablet_registro", schema = "modulos")
@SequenceGenerator(name = "modulos.rh_tablet_registro_seq", sequenceName = "modulos.rh_tablet_registro_seq", initialValue = 1, allocationSize = 1)
public class RhTabletRegistro implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "modulos.rh_tablet_registro_seq")
	@Column(name = "rg_id")
	private Integer rgId;

	@Column(name = "rg_altura")
	private BigDecimal rgAltura;

	@Column(name = "rg_codigoestacion")
	private String rgCodigoestacion;

	@Column(name = "rg_coordenadax")
	private BigDecimal rgCoordenadax;

	@Column(name = "rg_coordenaday")
	private BigDecimal rgCoordenaday;

	@Column(name = "rg_descripcionfactores")
	private String rgDescripcionfactores;

	@Column(name = "rg_descripcionotro")
	private String rgDescripcionotro;

	@Column(name = "rg_descripcionuso")
	private String rgDescripcionuso;

	@Column(name = "rg_fac_agricola")
	private Boolean rgFacAgricola;

	@Column(name = "rg_fac_ganadera")
	private Boolean rgFacGanadera;

	@Column(name = "rg_fac_hidrocarburifera")
	private Boolean rgFacHidrocarburifera;

	@Column(name = "rg_fac_industrial")
	private Boolean rgFacIndustrial;

	@Column(name = "rg_fac_mineria")
	private Boolean rgFacMineria;

	@Column(name = "rg_fac_ninguna")
	private Boolean rgFacNinguna;

	@Column(name = "rg_fac_otro")
	private Boolean rgFacOtro;

	
	@Column(name = "rg_fac_poblacional")
	private Boolean rgFacPoblacional;

	@Temporal(TemporalType.DATE)
	@Column(name = "rg_fecha")
	private Date rgFecha;

	@Column(name = "rg_hora")
	private Time rgHora;

	@Column(name = "rg_idcondiciionclimatica")
	private Integer rgIdcondiciionclimatica;

	@Column(name = "rg_iddemarcacion")
	private Integer rgIddemarcacion;

	@Column(name = "rg_idelaborado")
	private Integer rgIdelaborado;

	@Column(name = "rg_idestado")
	private Integer rgIdestado;

	@Column(name = "rg_idmicrocuenca")
	private Integer rgIdmicrocuenca;

	@Column(name = "rg_idparroquia")
	private Integer rgIdparroquia;

	@Column(name = "rg_idrepresentabilidad")
	private Integer rgIdrepresentabilidad;

	@Column(name = "rg_idtipoevento")
	private Integer rgIdtipoevento;

	@Column(name = "rg_idtipoficha")
	private Integer rgIdtipoficha;

	@Column(name = "rg_idusoagua")
	private Integer rgIdusoagua;

	@Column(name = "rg_latitud")
	private String rgLatitud;

	@Column(name = "rg_longitud")
	private String rgLongitud;

	@Column(name = "rg_nombreficha")
	private String rgNombreficha;

	@Column(name = "rg_nombrefuente")
	private String rgNombrefuente;

	@Column(name = "rg_numeroficha")
	private String rgNumeroficha;

	@Column(name = "rg_numeroregistrosanteriores")
	private String rgNumeroregistrosanteriores;

	@Column(name = "rg_observacionesaccesibilidad")
	private Boolean rgObservacionesaccesibilidad;

	@Column(name = "rg_observacionesmargen")
	private Boolean rgObservacionesmargen;

	@Column(name = "rg_observacionesotras")
	private String rgObservacionesotras;

	@Column(name = "rg_observacionesrepresentabilidad")
	private String rgObservacionesrepresentabilidad;

	@Column(name = "rg_observacionestomamuestra")
	private Boolean rgObservacionestomamuestra;

	@Column(name = "rg_rutaacceso")
	private String rgRutaacceso;

	@Column(name = "rg_sitiosector")
	private String rgSitiosector;

	@Column(name = "rg_tipomodulo")
	private String rgTipomodulo;

	@Column(name = "rg_unidadhidrografica")
	private Integer rgUnidadhidrografica;

	@Column(name = "rh_vertienteamazonas")
	private Boolean rhVertienteamazonas;

	@Column(name = "rg_idpuntocuenca")
	private Integer rgIdpuntocuenca;

	// bi-directional many-to-one association to RhTabletCoordenadasextra
	@OneToMany(mappedBy = "rhTabletRegistro")
	private List<RhTabletCoordenadasextra> rhTabletCoordenadasextras;

	// bi-directional many-to-one association to RhTabletFoto
	@OneToMany(mappedBy = "rhTabletRegistro")
	private List<RhTabletFoto> rhTabletFotos;

	// bi-directional many-to-many association to RhTabletInstitucione
	@ManyToMany
	@JoinTable(name = "rh_tablet_instituciones_registro", joinColumns = { @JoinColumn(name = "inr_idregisto") }, inverseJoinColumns = { @JoinColumn(name = "inr_idinstitucion") })
	private List<RhTabletInstitucione> rhTabletInstituciones;

	// bi-directional many-to-one association to RhMcaMuestreo
	@OneToMany(mappedBy = "rhTabletRegistro")
	private List<RhMcaMuestreo> rhMcaMuestreos;

	@Transient
	private String rg_provincia;
	@Transient
	private String rg_canton;
	@Transient
	private String rg_parroquia;
	@Transient
	private String rg_demarcacion;
	@Transient
	private String rg_codpfafsteter;
	@Transient
	private String rg_pfafsteter;
	@Transient
	private String rg_cuenca;
	@Transient
	private String rg_subcuenca;
	@Transient
	private String rg_microcuenca;

	public RhTabletRegistro() {
	}

	public Integer getRgId() {
		return this.rgId;
	}

	public void setRgId(Integer rgId) {
		this.rgId = rgId;
	}

	public BigDecimal getRgAltura() {
		return this.rgAltura;
	}

	public void setRgAltura(BigDecimal rgAltura) {
		this.rgAltura = rgAltura;
	}

	public String getRgCodigoestacion() {
		return this.rgCodigoestacion;
	}

	public void setRgCodigoestacion(String rgCodigoestacion) {
		this.rgCodigoestacion = rgCodigoestacion;
	}

	public BigDecimal getRgCoordenadax() {
		return this.rgCoordenadax;
	}

	public void setRgCoordenadax(BigDecimal rgCoordenadax) {
		this.rgCoordenadax = rgCoordenadax;
	}

	public BigDecimal getRgCoordenaday() {
		return this.rgCoordenaday;
	}

	public void setRgCoordenaday(BigDecimal rgCoordenaday) {
		this.rgCoordenaday = rgCoordenaday;
	}

	public String getRgDescripcionfactores() {
		return this.rgDescripcionfactores;
	}

	public void setRgDescripcionfactores(String rgDescripcionfactores) {
		this.rgDescripcionfactores = rgDescripcionfactores;
	}

	public String getRgDescripcionotro() {
		return this.rgDescripcionotro;
	}

	public void setRgDescripcionotro(String rgDescripcionotro) {
		this.rgDescripcionotro = rgDescripcionotro;
	}

	public String getRgDescripcionuso() {
		return this.rgDescripcionuso;
	}

	public void setRgDescripcionuso(String rgDescripcionuso) {
		this.rgDescripcionuso = rgDescripcionuso;
	}

	public Boolean getRgFacAgricola() {
		return this.rgFacAgricola;
	}

	public void setRgFacAgricola(Boolean rgFacAgricola) {
		this.rgFacAgricola = rgFacAgricola;
	}

	public Boolean getRgFacGanadera() {
		return this.rgFacGanadera;
	}

	public void setRgFacGanadera(Boolean rgFacGanadera) {
		this.rgFacGanadera = rgFacGanadera;
	}

	public Boolean getRgFacHidrocarburifera() {
		return this.rgFacHidrocarburifera;
	}

	public void setRgFacHidrocarburifera(Boolean rgFacHidrocarburifera) {
		this.rgFacHidrocarburifera = rgFacHidrocarburifera;
	}

	public Boolean getRgFacIndustrial() {
		return this.rgFacIndustrial;
	}

	public void setRgFacIndustrial(Boolean rgFacIndustrial) {
		this.rgFacIndustrial = rgFacIndustrial;
	}

	public Boolean getRgFacMineria() {
		return this.rgFacMineria;
	}

	public void setRgFacMineria(Boolean rgFacMineria) {
		this.rgFacMineria = rgFacMineria;
	}

	public Boolean getRgFacNinguna() {
		return this.rgFacNinguna;
	}

	public void setRgFacNinguna(Boolean rgFacNinguna) {
		this.rgFacNinguna = rgFacNinguna;
	}

	public Boolean getRgFacOtro() {
		return this.rgFacOtro;
	}

	public void setRgFacOtro(Boolean rgFacOtro) {
		this.rgFacOtro = rgFacOtro;
	}

	public Boolean getRgFacPoblacional() {
		return this.rgFacPoblacional;
	}

	public void setRgFacPoblacional(Boolean rgFacPoblacional) {
		this.rgFacPoblacional = rgFacPoblacional;
	}

	public Date getRgFecha() {
		return this.rgFecha;
	}

	public void setRgFecha(Date rgFecha) {
		this.rgFecha = rgFecha;
	}

	public Time getRgHora() {
		return this.rgHora;
	}

	public void setRgHora(Time rgHora) {
		this.rgHora = rgHora;
	}

	public Integer getRgIdcondiciionclimatica() {
		return this.rgIdcondiciionclimatica;
	}

	public void setRgIdcondiciionclimatica(Integer rgIdcondiciionclimatica) {
		this.rgIdcondiciionclimatica = rgIdcondiciionclimatica;
	}

	public Integer getRgIddemarcacion() {
		return this.rgIddemarcacion;
	}

	public void setRgIddemarcacion(Integer rgIddemarcacion) {
		this.rgIddemarcacion = rgIddemarcacion;
	}

	public Integer getRgIdelaborado() {
		return this.rgIdelaborado;
	}

	public void setRgIdelaborado(Integer rgIdelaborado) {
		this.rgIdelaborado = rgIdelaborado;
	}

	public Integer getRgIdestado() {
		return this.rgIdestado;
	}

	public void setRgIdestado(Integer rgIdestado) {
		this.rgIdestado = rgIdestado;
	}

	public Integer getRgIdmicrocuenca() {
		return this.rgIdmicrocuenca;
	}

	public void setRgIdmicrocuenca(Integer rgIdmicrocuenca) {
		this.rgIdmicrocuenca = rgIdmicrocuenca;
	}

	public Integer getRgIdparroquia() {
		return this.rgIdparroquia;
	}

	public void setRgIdparroquia(Integer rgIdparroquia) {
		this.rgIdparroquia = rgIdparroquia;
	}

	public Integer getRgIdrepresentabilidad() {
		return this.rgIdrepresentabilidad;
	}

	public void setRgIdrepresentabilidad(Integer rgIdrepresentabilidad) {
		this.rgIdrepresentabilidad = rgIdrepresentabilidad;
	}

	public Integer getRgIdtipoevento() {
		return this.rgIdtipoevento;
	}

	public void setRgIdtipoevento(Integer rgIdtipoevento) {
		this.rgIdtipoevento = rgIdtipoevento;
	}

	public Integer getRgIdtipoficha() {
		return this.rgIdtipoficha;
	}

	public void setRgIdtipoficha(Integer rgIdtipoficha) {
		this.rgIdtipoficha = rgIdtipoficha;
	}

	public Integer getRgIdusoagua() {
		return this.rgIdusoagua;
	}

	public void setRgIdusoagua(Integer rgIdusoagua) {
		this.rgIdusoagua = rgIdusoagua;
	}

	public String getRgLatitud() {
		return this.rgLatitud;
	}

	public void setRgLatitud(String rgLatitud) {
		this.rgLatitud = rgLatitud;
	}

	public String getRgLongitud() {
		return this.rgLongitud;
	}

	public void setRgLongitud(String rgLongitud) {
		this.rgLongitud = rgLongitud;
	}

	public String getRgNombreficha() {
		return this.rgNombreficha;
	}

	public void setRgNombreficha(String rgNombreficha) {
		this.rgNombreficha = rgNombreficha;
	}

	public String getRgNombrefuente() {
		return this.rgNombrefuente;
	}

	public void setRgNombrefuente(String rgNombrefuente) {
		this.rgNombrefuente = rgNombrefuente;
	}

	public String getRgNumeroficha() {
		return this.rgNumeroficha;
	}

	public void setRgNumeroficha(String rgNumeroficha) {
		this.rgNumeroficha = rgNumeroficha;
	}

	public String getRgNumeroregistrosanteriores() {
		return this.rgNumeroregistrosanteriores;
	}

	public void setRgNumeroregistrosanteriores(
			String rgNumeroregistrosanteriores) {
		this.rgNumeroregistrosanteriores = rgNumeroregistrosanteriores;
	}

	public Boolean getRgObservacionesaccesibilidad() {
		return this.rgObservacionesaccesibilidad;
	}

	public void setRgObservacionesaccesibilidad(
			Boolean rgObservacionesaccesibilidad) {
		this.rgObservacionesaccesibilidad = rgObservacionesaccesibilidad;
	}

	public Boolean getRgObservacionesmargen() {
		return this.rgObservacionesmargen;
	}

	public void setRgObservacionesmargen(Boolean rgObservacionesmargen) {
		this.rgObservacionesmargen = rgObservacionesmargen;
	}

	public String getRgObservacionesotras() {
		return this.rgObservacionesotras;
	}

	public void setRgObservacionesotras(String rgObservacionesotras) {
		this.rgObservacionesotras = rgObservacionesotras;
	}

	public String getRgObservacionesrepresentabilidad() {
		return this.rgObservacionesrepresentabilidad;
	}

	public void setRgObservacionesrepresentabilidad(
			String rgObservacionesrepresentabilidad) {
		this.rgObservacionesrepresentabilidad = rgObservacionesrepresentabilidad;
	}

	public Boolean getRgObservacionestomamuestra() {
		return this.rgObservacionestomamuestra;
	}

	public void setRgObservacionestomamuestra(Boolean rgObservacionestomamuestra) {
		this.rgObservacionestomamuestra = rgObservacionestomamuestra;
	}

	public String getRgRutaacceso() {
		return this.rgRutaacceso;
	}

	public void setRgRutaacceso(String rgRutaacceso) {
		this.rgRutaacceso = rgRutaacceso;
	}

	public String getRgSitiosector() {
		return this.rgSitiosector;
	}

	public void setRgSitiosector(String rgSitiosector) {
		this.rgSitiosector = rgSitiosector;
	}

	public String getRgTipomodulo() {
		return this.rgTipomodulo;
	}

	public void setRgTipomodulo(String rgTipomodulo) {
		this.rgTipomodulo = rgTipomodulo;
	}

	public Integer getRgUnidadhidrografica() {
		return this.rgUnidadhidrografica;
	}

	public void setRgUnidadhidrografica(Integer rgUnidadhidrografica) {
		this.rgUnidadhidrografica = rgUnidadhidrografica;
	}

	public Boolean getRhVertienteamazonas() {
		return this.rhVertienteamazonas;
	}

	public void setRhVertienteamazonas(Boolean rhVertienteamazonas) {
		this.rhVertienteamazonas = rhVertienteamazonas;
	}

	public List<RhTabletCoordenadasextra> getRhTabletCoordenadasextras() {
		return this.rhTabletCoordenadasextras;
	}

	public void setRhTabletCoordenadasextras(
			List<RhTabletCoordenadasextra> rhTabletCoordenadasextras) {
		this.rhTabletCoordenadasextras = rhTabletCoordenadasextras;
	}

	public RhTabletCoordenadasextra addRhTabletCoordenadasextra(
			RhTabletCoordenadasextra rhTabletCoordenadasextra) {
		getRhTabletCoordenadasextras().add(rhTabletCoordenadasextra);
		rhTabletCoordenadasextra.setRhTabletRegistro(this);

		return rhTabletCoordenadasextra;
	}

	public RhTabletCoordenadasextra removeRhTabletCoordenadasextra(
			RhTabletCoordenadasextra rhTabletCoordenadasextra) {
		getRhTabletCoordenadasextras().remove(rhTabletCoordenadasextra);
		rhTabletCoordenadasextra.setRhTabletRegistro(null);

		return rhTabletCoordenadasextra;
	}

	public List<RhTabletFoto> getRhTabletFotos() {
		return this.rhTabletFotos;
	}

	public void setRhTabletFotos(List<RhTabletFoto> rhTabletFotos) {
		this.rhTabletFotos = rhTabletFotos;
	}

	public RhTabletFoto addRhTabletFoto(RhTabletFoto rhTabletFoto) {
		getRhTabletFotos().add(rhTabletFoto);
		rhTabletFoto.setRhTabletRegistro(this);

		return rhTabletFoto;
	}

	public RhTabletFoto removeRhTabletFoto(RhTabletFoto rhTabletFoto) {
		getRhTabletFotos().remove(rhTabletFoto);
		rhTabletFoto.setRhTabletRegistro(null);

		return rhTabletFoto;
	}

	public List<RhTabletInstitucione> getRhTabletInstituciones() {
		return this.rhTabletInstituciones;
	}

	public void setRhTabletInstituciones(
			List<RhTabletInstitucione> rhTabletInstituciones) {
		this.rhTabletInstituciones = rhTabletInstituciones;
	}

	public List<RhMcaMuestreo> getRhMcaMuestreos() {
		return this.rhMcaMuestreos;
	}

	public void setRhMcaMuestreos(List<RhMcaMuestreo> rhMcaMuestreos) {
		this.rhMcaMuestreos = rhMcaMuestreos;
	}

	public RhMcaMuestreo addRhMcaMuestreo(RhMcaMuestreo rhMcaMuestreo) {
		getRhMcaMuestreos().add(rhMcaMuestreo);
		rhMcaMuestreo.setRhTabletRegistro(this);

		return rhMcaMuestreo;
	}

	public RhMcaMuestreo removeRhMcaMuestreo(RhMcaMuestreo rhMcaMuestreo) {
		getRhMcaMuestreos().remove(rhMcaMuestreo);
		rhMcaMuestreo.setRhTabletRegistro(null);

		return rhMcaMuestreo;
	}

	public Integer getRgIdpuntocuenca() {
		return rgIdpuntocuenca;
	}

	public void setRgIdpuntocuenca(Integer rgIdpuntocuenca) {
		this.rgIdpuntocuenca = rgIdpuntocuenca;
	}

	public String getRg_provincia() {
		return rg_provincia;
	}

	public void setRg_provincia(String rg_provincia) {
		this.rg_provincia = rg_provincia;
	}

	public String getRg_canton() {
		return rg_canton;
	}

	public void setRg_canton(String rg_canton) {
		this.rg_canton = rg_canton;
	}

	public String getRg_parroquia() {
		return rg_parroquia;
	}

	public void setRg_parroquia(String rg_parroquia) {
		this.rg_parroquia = rg_parroquia;
	}

	public String getRg_demarcacion() {
		return rg_demarcacion;
	}

	public void setRg_demarcacion(String rg_demarcacion) {
		this.rg_demarcacion = rg_demarcacion;
	}

	public String getRg_codpfafsteter() {
		return rg_codpfafsteter;
	}

	public void setRg_codpfafsteter(String rg_codpfafsteter) {
		this.rg_codpfafsteter = rg_codpfafsteter;
	}

	public String getRg_pfafsteter() {
		return rg_pfafsteter;
	}

	public void setRg_pfafsteter(String rg_pfafsteter) {
		this.rg_pfafsteter = rg_pfafsteter;
	}

	public String getRg_cuenca() {
		return rg_cuenca;
	}

	public void setRg_cuenca(String rg_cuenca) {
		this.rg_cuenca = rg_cuenca;
	}

	public String getRg_subcuenca() {
		return rg_subcuenca;
	}

	public void setRg_subcuenca(String rg_subcuenca) {
		this.rg_subcuenca = rg_subcuenca;
	}

	public String getRg_microcuenca() {
		return rg_microcuenca;
	}

	public void setRg_microcuenca(String rg_microcuenca) {
		this.rg_microcuenca = rg_microcuenca;
	}



}