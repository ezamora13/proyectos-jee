package ec.com.fopeca.webservices;

public class CalculatorWsProxy implements ec.com.fopeca.webservices.CalculatorWs {
  private String _endpoint = null;
  private ec.com.fopeca.webservices.CalculatorWs calculatorWs = null;
  
  public CalculatorWsProxy() {
    _initCalculatorWsProxy();
  }
  
  public CalculatorWsProxy(String endpoint) {
    _endpoint = endpoint;
    _initCalculatorWsProxy();
  }
  
  private void _initCalculatorWsProxy() {
    try {
      calculatorWs = (new ec.com.fopeca.webservices.CalculatorServiceLocator()).getCalculatorPort();
      if (calculatorWs != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)calculatorWs)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)calculatorWs)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (calculatorWs != null)
      ((javax.xml.rpc.Stub)calculatorWs)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public ec.com.fopeca.webservices.CalculatorWs getCalculatorWs() {
    if (calculatorWs == null)
      _initCalculatorWsProxy();
    return calculatorWs;
  }
  
  public int multiply(int arg0, int arg1) throws java.rmi.RemoteException{
    if (calculatorWs == null)
      _initCalculatorWsProxy();
    return calculatorWs.multiply(arg0, arg1);
  }
  
  public int sum(int arg0, int arg1) throws java.rmi.RemoteException{
    if (calculatorWs == null)
      _initCalculatorWsProxy();
    return calculatorWs.sum(arg0, arg1);
  }
  
  
}