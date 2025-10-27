package bolechas.connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class MySqlConnection implements DBConnection{

    private String url = "jdbc:mysql://localhost:3306/";

    @Override
    public Connection getConnection() {
       try {
        return DriverManager.getConnection(url, "root", "root");
       }catch (Exception e) {
        System.out.println("Error al conectar con el servidor");
        return null;
        }

    }

    public String getUrl() {
        return url;
    }
    public void setUrl(String url) {
        this.url = url;
    }

}
