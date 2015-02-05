package ec.com.fopeca.util;



import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.net.URL;
import java.util.Properties;

import javax.ejb.embeddable.EJBContainer;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import org.jboss.samples.webservices.CalculatorWs;
import org.junit.BeforeClass;
import org.junit.Test;


public class TestWebService {

	@BeforeClass
	public static void setUp() throws Exception {
		Properties properties = new Properties();
		properties.setProperty("openejb.embedded.remotable", "true");
		// properties.setProperty("httpejbd.print", "true");
		// properties.setProperty("httpejbd.indent.xml", "true");
		EJBContainer.createEJBContainer(properties);
		System.out.println("Test");
	}

	@Test
	public void test() throws Exception {
		Service calculatorService = Service.create(new URL(
				"http://localhost:8181/WebServiceTest/CalculatorService/Calculator?wsdl"), new QName(
				"http://fopeca.com.ec/wsdl", "CalculatorService"));

		assertNotNull(calculatorService);

		CalculatorWs calculator = calculatorService.getPort(CalculatorWs.class);
		assertEquals(10, calculator.sum(4, 6));
		assertEquals(12, calculator.multiply(3, 4));
	}

	// public static void main(String[] args) {
	// // TODO Auto-generated method stub
	//
	// }

}
