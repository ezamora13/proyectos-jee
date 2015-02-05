package ec.com.fopeca.webservices;

public class GeneraPdfWSProxy implements ec.com.fopeca.webservices.GeneraPdfWS {
  private String _endpoint = null;
  private ec.com.fopeca.webservices.GeneraPdfWS generaPdfWS = null;
  
  public GeneraPdfWSProxy() {
    _initGeneraPdfWSProxy();
  }
  
  public GeneraPdfWSProxy(String endpoint) {
    _endpoint = endpoint;
    _initGeneraPdfWSProxy();
  }
  
  private void _initGeneraPdfWSProxy() {
    try {
      generaPdfWS = (new ec.com.fopeca.webservices.GeneraPdfServiceLocator()).getGeneraPdfPort();
      if (generaPdfWS != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)generaPdfWS)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)generaPdfWS)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (generaPdfWS != null)
      ((javax.xml.rpc.Stub)generaPdfWS)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public ec.com.fopeca.webservices.GeneraPdfWS getGeneraPdfWS() {
    if (generaPdfWS == null)
      _initGeneraPdfWSProxy();
    return generaPdfWS;
  }
  
  public byte[] generarPDF() throws java.rmi.RemoteException{
    if (generaPdfWS == null)
      _initGeneraPdfWSProxy();
    return generaPdfWS.generarPDF();
  }
  
  public byte[] generarPdfRgen0001(java.lang.String cabm_codemp, java.lang.String cabm_numemo, java.lang.String cabm_codplan, java.lang.String cabm_area, java.lang.String cabm_tipomemo) throws java.rmi.RemoteException{
    if (generaPdfWS == null)
      _initGeneraPdfWSProxy();
    return generaPdfWS.generarPdfRgen0001(cabm_codemp, cabm_numemo, cabm_codplan, cabm_area, cabm_tipomemo);
  }
  
  
}