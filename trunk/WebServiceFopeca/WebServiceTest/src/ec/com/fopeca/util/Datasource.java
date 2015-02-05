package ec.com.fopeca.util;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class Datasource {

    
    private Connection conec;


    /*
     * Para Ejb
     * **/
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


   


}
