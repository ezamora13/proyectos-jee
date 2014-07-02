package ec.gob.senagua.reportes;

import java.io.PrintStream;
import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;


public class DatasourceSenagua {

	private final PrintStream out1 = System.out;

	private Connection  connection;
	/**
	 * Obtiene una conexion segun el data source especificado
	 * @return connection 
	 * @throws SQLException 
	 */
	public Connection getConnection() throws SQLException {
	    connection = null;
	    try {
	        InitialContext context = new InitialContext();
	        DataSource dataSource = (DataSource) context.lookup("java:/SenaguaDS");
	        connection = dataSource.getConnection();
	    } catch (NamingException e) {
	    	out1.println(e.getMessage());
	    } 
	    return connection;
	 }	
	
	/**
	 * Cierra la coneccion que habia sido abierta.
	 * @throws SQLException 
	 */
	public void closeConnection() throws SQLException {
		connection.close();
	}

}
