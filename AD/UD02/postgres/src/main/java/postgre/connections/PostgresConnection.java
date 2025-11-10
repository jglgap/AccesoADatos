package postgre.connections;

import java.io.ObjectInputFilter.Config;
import java.sql.Connection;
import java.sql.DriverManager;

import postgre.application.ConfigLoader;

public class PostgresConnection implements DBConnection{

    @Override
    public Connection getConnectionServer() {
        String url = ConfigLoader.get("postgresql.urlInicial");
        try {
            return DriverManager.getConnection(url, ConfigLoader.get("postgresql.user"), ConfigLoader.get("postgresql.password"));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Connection getConnection() {
        String url = ConfigLoader.get("postgresql.urlInicial") + ConfigLoader.get("postgresql.dbName");
        try {
            return DriverManager.getConnection(url, ConfigLoader.get("postgresql.user"), ConfigLoader.get("postgresql.password"));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        
    }

}
