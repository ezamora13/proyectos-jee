package ec.com.fopeca.util;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class Datasource {

	private Connection conec;
	private Connection conecOra;

	/*
	 * Para DS MySQL
	 */
	public Connection getConnection() throws SQLException {
		conec = null;
		try {
			InitialContext contex = new InitialContext();
			DataSource data = (DataSource) contex.lookup("java:/MySqlDS");
			conec = data.getConnection();
		} catch (NamingException e) {
			System.out.println(e.getMessage());
		}
		return conec;
	}

	public void closeConnection() throws SQLException {
		conec.close();
	}

	/**
	 * Oracle
	 * */
	public Connection getConnectionOra() throws SQLException {
		conec = null;
		try {
			InitialContext contex = new InitialContext();
			DataSource data = (DataSource) contex.lookup("java:/OracleDS");
			conec = data.getConnection();
		} catch (NamingException e) {
			System.out.println(e.getMessage());
		}
		return conec;
	}

	public void closeConnectionOra() throws SQLException {
		conec.close();
	}

	public Connection getConecOra() {
		return conecOra;
	}

	public void setConecOra(Connection conecOra) {
		this.conecOra = conecOra;
	}

}
