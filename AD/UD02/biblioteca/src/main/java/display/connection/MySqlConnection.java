package display.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySqlConnection implements DBConnection{

    @Override
    public Connection getConnection() {
        String url = "jdbc:mysql://localhost:3306/";
        try {
            return DriverManager.getConnection(url,"root","root");  
        } catch (SQLException e) {
            System.out.println("Error al conectar al servidor");
            return null;
        }
        
    }

    
}
