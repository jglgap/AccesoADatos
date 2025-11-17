package alumnos.connection;

import java.sql.Connection;
import java.sql.DriverManager;

import alumnos.app.ConfigLoader;

public class MySqlConnection implements DBConnection{
    private String urlServer =  ConfigLoader.get("sql.urlInicial");
    private String urluser = ConfigLoader.get("sql.user");
    private String urlPass = ConfigLoader.get("sql.pass");
    @Override
    public Connection getConnectionServer() {
        try {
            return DriverManager.getConnection(urlServer,urluser,urlPass);
        } catch (Exception e) {
            System.out.println("problemas en la conexion");
            return null;
        }
    }

    @Override
    public Connection getConnectionDB() {
         try {
            return DriverManager.getConnection(ConfigLoader.get("sql.route"),urluser,urlPass);
        } catch (Exception e) {
            System.out.println("problemas en la conexion a la base de datos");
            return null;
        }
    }
    
}
