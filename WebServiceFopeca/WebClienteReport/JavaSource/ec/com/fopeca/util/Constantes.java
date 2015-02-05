package ec.com.fopeca.util;

import java.io.Serializable;

public class Constantes implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7656168686992504277L;

	private static String _URLLOCAL = "http://localhost:8181";// /WebReport/GeneraPdf
	private static String _URLREMOTO = "http://10.10.20.130:8181";
	
	
	
	
	public static String get_URLLOCAL() {
		return _URLLOCAL;
	}
	public static void set_URLLOCAL(String _URLLOCAL) {
		Constantes._URLLOCAL = _URLLOCAL;
	}
	public static String get_URLREMOTO() {
		return _URLREMOTO;
	}
	public static void set_URLREMOTO(String _URLREMOTO) {
		Constantes._URLREMOTO = _URLREMOTO;
	}

}
