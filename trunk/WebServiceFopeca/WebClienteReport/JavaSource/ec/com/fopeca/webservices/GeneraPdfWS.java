/**
 * GeneraPdfWS.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package ec.com.fopeca.webservices;

public interface GeneraPdfWS extends java.rmi.Remote {
    public byte[] generarPDF() throws java.rmi.RemoteException;
    public byte[] generarPdfRgen0001(java.lang.String cabm_codemp, java.lang.String cabm_numemo, java.lang.String cabm_codplan, java.lang.String cabm_area, java.lang.String cabm_tipomemo) throws java.rmi.RemoteException;
}
