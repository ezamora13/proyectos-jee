package ec.gob.senagua.controladores;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;

import ec.gob.senagua.modelo.RhGlbPermisosOpcionesMenuPerfil;
import ec.gob.senagua.servicios.RhGlbPermisosOpcionesMenuPerfilLocal;

@Named
public class OpcionesPorPerfilControlador {
	private List<RhGlbPermisosOpcionesMenuPerfil> opciones;

	@EJB
	private RhGlbPermisosOpcionesMenuPerfilLocal opcionesServicio;

	public OpcionesPorPerfilControlador() {
	}

	@PostConstruct
	public void init() {
		// TODO: Ahorita se muestran tooooodas las opciones hay que jalar solo
		// por el perfil
		opciones = opcionesServicio.getAll();
	}

	public List<RhGlbPermisosOpcionesMenuPerfil> getOpciones() {
		return opciones;
	}

}