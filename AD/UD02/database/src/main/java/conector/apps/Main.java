package conector.apps;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import conector.conexiones.DBConnection;
import conector.conexiones.MySqlConnection;

public class Main {


    private static void testConnection(DBConnection dbConnection,String dbName){
        System.out.println("Probando conexion con " + dbName + "....");
        try (Connection conn = dbConnection.getConnection()) {
            if (conn != null) {
                System.out.println("Conexion establecida con " + dbName + "\n");
                Statement sta =  conn.createStatement();
                ResultSet res = sta.executeQuery("Select * from USERS");


            }else{

                System.out.println("No se pudo establecer la conexion con " + dbName);
            }
        } catch (Exception e) {
            System.out.println("Error inesperado" + e.getMessage());
        }
    }
    public static void main(String[] args) {
        MySqlConnection dbconnection = new MySqlConnection();
        testConnection(dbconnection, "testdb");
    }
}