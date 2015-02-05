/**
 * CalculatorService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package ec.com.fopeca.webservices;

public interface CalculatorService extends javax.xml.rpc.Service {
    public java.lang.String getCalculatorPortAddress();

    public ec.com.fopeca.webservices.CalculatorWs getCalculatorPort() throws javax.xml.rpc.ServiceException;

    public ec.com.fopeca.webservices.CalculatorWs getCalculatorPort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
