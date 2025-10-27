package bolechas.application;

import java.sql.Connection;
import java.sql.Statement;

import bolechas.connection.MySqlConnection;

public class GestorBaseDatos {
    private String dbName = "Bolechas";

    public void CrearBaseDatos() {
        MySqlConnection conn = new MySqlConnection();
        System.out.println("Probando conexion al servidor");
        try (Connection c = conn.getConnection()) {
            if (c != null) {
                System.out.println("Conexion establecida");
                Statement sta = c.createStatement();
                String dbDrop = "DROP DATABASE IF EXISTS " + dbName;
                sta.executeUpdate(dbDrop);
                String dbCreationString = "CREATE DATABASE IF NOT EXISTS " + dbName;
                sta.executeUpdate(dbCreationString);
                System.out.println("Se ha creado correctamente la base de datos");
            } else {
                System.out.println("Problemas con la conexion");
            }
        } catch (Exception e) {
            System.out.println("Problemas inesperados");
        }
    }

    public String getDbName() {
        return dbName;
    }
}
