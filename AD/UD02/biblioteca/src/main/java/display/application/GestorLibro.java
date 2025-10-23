package display.application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import display.connection.MySqlConnection;

public class GestorLibro {

    
   

    public void crearTabla(){
        MySqlConnection conn = new MySqlConnection();
        GestorBiblioteca gb = new GestorBiblioteca();
        
        conn.setUrl(conn.getUrl() + gb.getNombreDB());
        System.out.println("probando conexion a bd");
        try (Connection c = conn.getConnection()) {
            if (c != null) {
                Statement sta = c.createStatement();
                String queryCreate = "CREATE TABLE IF NOT EXISTS libro(libroID int PRIMARY KEY,titulo varchar(250) NOT NULL,autor varchar(250),anoPublicacion int NOT NULL,ISBN varchar(250) NOT NULL)";
                if (sta.executeUpdate(queryCreate) != 0 ) {
                    System.out.println("No se ha podido crear la tabla");
                } else {
                    System.out.println("Se ha creado correctamente la tabla Libro");
                }
            }else{
                System.out.println("Error en la conexion");
            }
        } catch (Exception e) {
            System.out.println("Error inesperado" + e.getMessage());
        }


    }

    public void crearLibro(){
        MySqlConnection conn = new MySqlConnection();
        GestorBiblioteca gb = new GestorBiblioteca();
        conn.setUrl(conn.getUrl() + gb.getNombreDB());
        try (Connection c = conn.getConnection()) {
            if (c != null) {
                Statement sta = c.createStatement();
                ResultSet rs = sta.executeQuery("SELECT MAX(libroID) AS maxID FROM libro");
                int idLast = 0;
                while (rs.next()) {
                    idLast = rs.getInt("maxID");
                }
                int newId = idLast + 1;

                String insertquery = "INSERT INTO libro VALUES(?,?,?,?,?)";
                try (PreparedStatement pst = c.prepareStatement(insertquery)) {
                    pst.setInt(1, newId);
                    pst.setString(2, "Juan");
                    pst.setString(3, "La clase embruada");
                    pst.setString(4, "2023");
                    pst.setString(5, "777777777777777");
                    pst.executeUpdate();
                    System.out.println("Registro añadido correctamente");                
                } catch (Exception e) {
                    System.out.println("ERROR AL AÑADIR REGISTRO");
                }
            } else {
                System.out.println("Error en la conexion");
            }
        } catch (Exception e) {
            System.out.println("Error inesperado " + e.getMessage());
        }

    }



}
