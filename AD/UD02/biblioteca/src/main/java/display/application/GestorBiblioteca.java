package display.application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import display.connection.MySqlConnection;

public class GestorBiblioteca {
    private String nombreDB = "biblioRicardoS";

    public void crearBaseDeDatos(boolean borrarExistente) {
        MySqlConnection conn = new MySqlConnection();
        System.out.println("Probando conexion al servidor");
        try (Connection c = conn.getConnection()) {
            if (c != null) {
                System.out.println("Conexion establecida con el servidor");
                if (borrarExistente == true) {
                    Statement sta = c.createStatement();
                    String queryBorrado = "DROP DATABASE IF EXISTS " + nombreDB;
                    String queryCreado = "CREATE DATABASE IF NOT EXISTS " + nombreDB;
                    sta.executeUpdate(queryBorrado);
                    System.out.println("La tabla se ha borrado en caso de existir");
                    sta.executeUpdate(queryCreado);
                    System.out.println("La tabla se ha creado con el nombre " + nombreDB);
                } else {
                    System.out.println("ya esta creada");
                }
            } else {
                System.out.println("No se pudo realizar la conexion con el servidor");
            }
        } catch (Exception e) {
            System.out.println("Error inesperado " + e.getMessage());
        }

    }


    public Connection conectar(){
        try {
            return DriverManager.getConnection("jdbc:mysql://localhost:3306/biblioteca","root","root");
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }  

    }


    //getter

    public String getNombreDB() {
        return nombreDB;
    }

}
