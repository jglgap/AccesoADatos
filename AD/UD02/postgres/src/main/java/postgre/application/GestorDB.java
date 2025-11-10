package postgre.application;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import postgre.connections.PostgresConnection;

public class GestorDB {

    public void crearDB(){
        String user = ConfigLoader.get("postgresql.user");
        String DB = ConfigLoader.get("postgresql.dbName");

        try (Connection c = new PostgresConnection().getConnectionServer();
            Statement stmt = c.createStatement()) {
                String comprobar = "SELECT 1 FROM pg_database WHERE datname = '"+ DB+ "'";
                ResultSet rs = stmt.executeQuery(comprobar);
                if (!rs.next()) {
                    stmt.executeUpdate("CREATE DATABASE "+ DB + " WITH OWNER = "+ user + " ENCODING 'UTF8' TEMPLATE template0");
                    System.out.println("Se ha creado correctamente");
                }
                
        } catch (Exception e) {
            System.out.println("Problema conexion");
        }



    }

}
