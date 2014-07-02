package ec.gob.senagua.modelo;

import java.io.Serializable;

import javax.persistence.*;

/**
 * The persistent class for the rh_mga_licenciamientoambiental database table.
 * 
 */
@Entity
@Table(name = "rh_mga_licenciamientoambiental", schema = "modulos")
@SequenceGenerator(name = "modulos.rh_mga_licenciamientoambiental_seq", sequenceName = "modulos.rh_mga_licenciamientoambiental_seq", initialValue = 1, allocationSize = 1)
public class RhMgaLicenciamientoambiental implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "modulos.rh_mga_licenciamientoambiental_seq")
	@Column(name = "lic_id")
	private Integer licId;

	@Column(name = "lic_n")
	private Integer lic_n;

	@Column(name = "lic_proyecto")
	private String lic_proyecto;

	@Column(name = "lic_demarcacionresponsable")
	private String lic_demarcacionresponsable;

	@Column(name = "lic_autoridadresponsable")
	private String lic_autoridadresponsable;

	@Column(name = "lic_faseproyecto")
	private String lic_faseproyecto;

	@Column(name = "lic_certificadointerseccion_oficiosolicitudcertificadointersecc")
	private String lic_certificadointerseccion_oficiosolicitudcertificadointersecc;

	@Column(name = "lic_certificadointerseccionoficiocertificadointerseccion")
	private String lic_certificadointerseccionoficiocertificadointerseccion;

	@Column(name = "lic_certificadointerseccionintersectaconareasprotegidassino")
	private String lic_certificadointerseccionintersectaconareasprotegidassino;

	@Column(name = "lic_categorizacion_oficiosolicitudcertificadoccategorizacion")
	private String lic_categorizacion_oficiosolicitudcertificadoccategorizacion;

	@Column(name = "lic_categorizacion_oficiocategorizacionmae")
	private String lic_categorizacion_oficiocategorizacionmae;

	@Column(name = "lic_categorizacion_categoriaproyecto")
	private String lic_categorizacion_categoriaproyecto;

	@Column(name = "lic_terminosreferencia_oficiosolicitudaprobaciontdrs")
	private String lic_terminosreferencia_oficiosolicitudaprobaciontdrs;

	@Column(name = "lic_terminosreferencia_oficioaprobaciontdrs")
	private String lic_terminosreferencia_oficioaprobaciontdrs;

	@Column(name = "lic_elaboracionborradoreiaficha_ambiental_consultora")
	private String lic_elaboracionborradoreiaficha_ambiental_consultora;

	@Column(name = "lic_elaboracionborradoreiaficha_ambiental_tiempoestimadoelabora")
	private String lic_elaboracionborradoreiaficha_ambiental_tiempoestimadoelabora;

	@Column(name = "lic_participacionsocial_solicitudfacilidador")
	private String lic_participacionsocial_solicitudfacilidador;

	@Column(name = "lic_participacionsocial_respuestamaesolicitudfacilitador")
	private String lic_participacionsocial_respuestamaesolicitudfacilitador;

	@Column(name = "lic_participacionsocial_entregamaeinformefacilitador")
	private String lic_participacionsocial_entregamaeinformefacilitador;

	@Column(name = "lic_estudioimpactoambientalesiafinal_entregaesiapartesenagua")
	private String lic_estudioimpactoambientalesiafinal_entregaesiapartesenagua;

	@Column(name = "lic_estudioimpactoambientalesiafinal_respuestamae")
	private String lic_estudioimpactoambientalesiafinal_respuestamae;

	@Column(name = "lic_estudioimpactoambientalesiafinal_respuestaobservacionespart")
	private String lic_estudioimpactoambientalesiafinal_respuestaobservacionespart;

	@Column(name = "lic_estudioimpactoambientalesiafinal_aprobacionesiapartemae")
	private String lic_estudioimpactoambientalesiafinal_aprobacionesiapartemae;

	@Column(name = "lic_faseemisionlicencia_pagotasas")
	private String lic_faseemisionlicencia_pagotasas;

	@Column(name = "lic_faseemisionlicencia_emisionlicenciaambiental")
	private String lic_faseemisionlicencia_emisionlicenciaambiental;

	public RhMgaLicenciamientoambiental() {
	}

	public Integer getLicId() {
		return licId;
	}

	public void setLicId(Integer licId) {
		this.licId = licId;
	}

	public Integer getLic_n() {
		return lic_n;
	}

	public void setLic_n(Integer lic_n) {
		this.lic_n = lic_n;
	}

	public String getLic_proyecto() {
		return lic_proyecto;
	}

	public void setLic_proyecto(String lic_proyecto) {
		this.lic_proyecto = lic_proyecto;
	}

	public String getLic_demarcacionresponsable() {
		return lic_demarcacionresponsable;
	}

	public void setLic_demarcacionresponsable(String lic_demarcacionresponsable) {
		this.lic_demarcacionresponsable = lic_demarcacionresponsable;
	}

	public String getLic_autoridadresponsable() {
		return lic_autoridadresponsable;
	}

	public void setLic_autoridadresponsable(String lic_autoridadresponsable) {
		this.lic_autoridadresponsable = lic_autoridadresponsable;
	}

	public String getLic_faseproyecto() {
		return lic_faseproyecto;
	}

	public void setLic_faseproyecto(String lic_faseproyecto) {
		this.lic_faseproyecto = lic_faseproyecto;
	}

	public String getLic_certificadointerseccion_oficiosolicitudcertificadointersecc() {
		return lic_certificadointerseccion_oficiosolicitudcertificadointersecc;
	}

	public void setLic_certificadointerseccion_oficiosolicitudcertificadointersecc(
			String lic_certificadointerseccion_oficiosolicitudcertificadointersecc) {
		this.lic_certificadointerseccion_oficiosolicitudcertificadointersecc = lic_certificadointerseccion_oficiosolicitudcertificadointersecc;
	}

	public String getLic_certificadointerseccionoficiocertificadointerseccion() {
		return lic_certificadointerseccionoficiocertificadointerseccion;
	}

	public void setLic_certificadointerseccionoficiocertificadointerseccion(
			String lic_certificadointerseccionoficiocertificadointerseccion) {
		this.lic_certificadointerseccionoficiocertificadointerseccion = lic_certificadointerseccionoficiocertificadointerseccion;
	}

	public String getLic_certificadointerseccionintersectaconareasprotegidassino() {
		return lic_certificadointerseccionintersectaconareasprotegidassino;
	}

	public void setLic_certificadointerseccionintersectaconareasprotegidassino(
			String lic_certificadointerseccionintersectaconareasprotegidassino) {
		this.lic_certificadointerseccionintersectaconareasprotegidassino = lic_certificadointerseccionintersectaconareasprotegidassino;
	}

	public String getLic_categorizacion_oficiosolicitudcertificadoccategorizacion() {
		return lic_categorizacion_oficiosolicitudcertificadoccategorizacion;
	}

	public void setLic_categorizacion_oficiosolicitudcertificadoccategorizacion(
			String lic_categorizacion_oficiosolicitudcertificadoccategorizacion) {
		this.lic_categorizacion_oficiosolicitudcertificadoccategorizacion = lic_categorizacion_oficiosolicitudcertificadoccategorizacion;
	}

	public String getLic_categorizacion_oficiocategorizacionmae() {
		return lic_categorizacion_oficiocategorizacionmae;
	}

	public void setLic_categorizacion_oficiocategorizacionmae(
			String lic_categorizacion_oficiocategorizacionmae) {
		this.lic_categorizacion_oficiocategorizacionmae = lic_categorizacion_oficiocategorizacionmae;
	}

	public String getLic_categorizacion_categoriaproyecto() {
		return lic_categorizacion_categoriaproyecto;
	}

	public void setLic_categorizacion_categoriaproyecto(
			String lic_categorizacion_categoriaproyecto) {
		this.lic_categorizacion_categoriaproyecto = lic_categorizacion_categoriaproyecto;
	}

	public String getLic_terminosreferencia_oficiosolicitudaprobaciontdrs() {
		return lic_terminosreferencia_oficiosolicitudaprobaciontdrs;
	}

	public void setLic_terminosreferencia_oficiosolicitudaprobaciontdrs(
			String lic_terminosreferencia_oficiosolicitudaprobaciontdrs) {
		this.lic_terminosreferencia_oficiosolicitudaprobaciontdrs = lic_terminosreferencia_oficiosolicitudaprobaciontdrs;
	}

	public String getLic_terminosreferencia_oficioaprobaciontdrs() {
		return lic_terminosreferencia_oficioaprobaciontdrs;
	}

	public void setLic_terminosreferencia_oficioaprobaciontdrs(
			String lic_terminosreferencia_oficioaprobaciontdrs) {
		this.lic_terminosreferencia_oficioaprobaciontdrs = lic_terminosreferencia_oficioaprobaciontdrs;
	}

	public String getLic_elaboracionborradoreiaficha_ambiental_consultora() {
		return lic_elaboracionborradoreiaficha_ambiental_consultora;
	}

	public void setLic_elaboracionborradoreiaficha_ambiental_consultora(
			String lic_elaboracionborradoreiaficha_ambiental_consultora) {
		this.lic_elaboracionborradoreiaficha_ambiental_consultora = lic_elaboracionborradoreiaficha_ambiental_consultora;
	}

	public String getLic_elaboracionborradoreiaficha_ambiental_tiempoestimadoelabora() {
		return lic_elaboracionborradoreiaficha_ambiental_tiempoestimadoelabora;
	}

	public void setLic_elaboracionborradoreiaficha_ambiental_tiempoestimadoelabora(
			String lic_elaboracionborradoreiaficha_ambiental_tiempoestimadoelabora) {
		this.lic_elaboracionborradoreiaficha_ambiental_tiempoestimadoelabora = lic_elaboracionborradoreiaficha_ambiental_tiempoestimadoelabora;
	}

	public String getLic_participacionsocial_solicitudfacilidador() {
		return lic_participacionsocial_solicitudfacilidador;
	}

	public void setLic_participacionsocial_solicitudfacilidador(
			String lic_participacionsocial_solicitudfacilidador) {
		this.lic_participacionsocial_solicitudfacilidador = lic_participacionsocial_solicitudfacilidador;
	}

	public String getLic_participacionsocial_respuestamaesolicitudfacilitador() {
		return lic_participacionsocial_respuestamaesolicitudfacilitador;
	}

	public void setLic_participacionsocial_respuestamaesolicitudfacilitador(
			String lic_participacionsocial_respuestamaesolicitudfacilitador) {
		this.lic_participacionsocial_respuestamaesolicitudfacilitador = lic_participacionsocial_respuestamaesolicitudfacilitador;
	}

	public String getLic_participacionsocial_entregamaeinformefacilitador() {
		return lic_participacionsocial_entregamaeinformefacilitador;
	}

	public void setLic_participacionsocial_entregamaeinformefacilitador(
			String lic_participacionsocial_entregamaeinformefacilitador) {
		this.lic_participacionsocial_entregamaeinformefacilitador = lic_participacionsocial_entregamaeinformefacilitador;
	}

	public String getLic_estudioimpactoambientalesiafinal_entregaesiapartesenagua() {
		return lic_estudioimpactoambientalesiafinal_entregaesiapartesenagua;
	}

	public void setLic_estudioimpactoambientalesiafinal_entregaesiapartesenagua(
			String lic_estudioimpactoambientalesiafinal_entregaesiapartesenagua) {
		this.lic_estudioimpactoambientalesiafinal_entregaesiapartesenagua = lic_estudioimpactoambientalesiafinal_entregaesiapartesenagua;
	}

	public String getLic_estudioimpactoambientalesiafinal_respuestamae() {
		return lic_estudioimpactoambientalesiafinal_respuestamae;
	}

	public void setLic_estudioimpactoambientalesiafinal_respuestamae(
			String lic_estudioimpactoambientalesiafinal_respuestamae) {
		this.lic_estudioimpactoambientalesiafinal_respuestamae = lic_estudioimpactoambientalesiafinal_respuestamae;
	}

	public String getLic_estudioimpactoambientalesiafinal_respuestaobservacionespart() {
		return lic_estudioimpactoambientalesiafinal_respuestaobservacionespart;
	}

	public void setLic_estudioimpactoambientalesiafinal_respuestaobservacionespart(
			String lic_estudioimpactoambientalesiafinal_respuestaobservacionespart) {
		this.lic_estudioimpactoambientalesiafinal_respuestaobservacionespart = lic_estudioimpactoambientalesiafinal_respuestaobservacionespart;
	}

	public String getLic_estudioimpactoambientalesiafinal_aprobacionesiapartemae() {
		return lic_estudioimpactoambientalesiafinal_aprobacionesiapartemae;
	}

	public void setLic_estudioimpactoambientalesiafinal_aprobacionesiapartemae(
			String lic_estudioimpactoambientalesiafinal_aprobacionesiapartemae) {
		this.lic_estudioimpactoambientalesiafinal_aprobacionesiapartemae = lic_estudioimpactoambientalesiafinal_aprobacionesiapartemae;
	}

	public String getLic_faseemisionlicencia_pagotasas() {
		return lic_faseemisionlicencia_pagotasas;
	}

	public void setLic_faseemisionlicencia_pagotasas(
			String lic_faseemisionlicencia_pagotasas) {
		this.lic_faseemisionlicencia_pagotasas = lic_faseemisionlicencia_pagotasas;
	}

	public String getLic_faseemisionlicencia_emisionlicenciaambiental() {
		return lic_faseemisionlicencia_emisionlicenciaambiental;
	}

	public void setLic_faseemisionlicencia_emisionlicenciaambiental(
			String lic_faseemisionlicencia_emisionlicenciaambiental) {
		this.lic_faseemisionlicencia_emisionlicenciaambiental = lic_faseemisionlicencia_emisionlicenciaambiental;
	}

}