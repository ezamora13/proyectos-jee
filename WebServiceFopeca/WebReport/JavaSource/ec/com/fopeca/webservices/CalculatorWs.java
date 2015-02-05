package ec.com.fopeca.webservices;

import javax.jws.WebService;

@WebService()
public interface CalculatorWs {

	public int sum(int add1, int add2);

	public int multiply(int mul1, int mul2);

}
