package conector.conexiones;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import conector.apps.ConfigLoader;

public class MySqlConnection implements DBConnection{

    // private final static String url = "jdbc:mysql://localhost:3306/testdb";
    // private final static String user = "usuario";
    // private final static String password = "usuario123";

    @Override
    public Connection getConnection() {
        String url = ConfigLoader.get("mysql.url");
        String user = ConfigLoader.get("mysql.user");
        String password = ConfigLoader.get("mysql.password");
        try {
            return DriverManager.getConnection(url, user, password);  
        } catch (SQLException e) {
            System.out.println("Error conectando a sql");
            return null;
        }
    }

}
