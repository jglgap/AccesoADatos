package display.application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import display.connection.MySqlConnection;

public class GestorLibro {

    public void crearTabla() {
        MySqlConnection conn = new MySqlConnection();
        GestorBiblioteca gb = new GestorBiblioteca();

        conn.setUrl(conn.getUrl() + gb.getNombreDB());
        System.out.println("probando conexion a bd");
        try (Connection c = conn.getConnection()) {
            if (c != null) {
                Statement sta = c.createStatement();
                String queryCreate = "CREATE TABLE IF NOT EXISTS libro(libroID int PRIMARY KEY,titulo varchar(250) NOT NULL,autor varchar(250),anoPublicacion int NOT NULL,ISBN varchar(250) NOT NULL)";
                if (sta.executeUpdate(queryCreate) != 0) {
                    System.out.println("No se ha podido crear la tabla");
                } else {
                    System.out.println("Se ha creado correctamente la tabla Libro");
                }
            } else {
                System.out.println("Error en la conexion");
            }
        } catch (Exception e) {
            System.out.println("Error inesperado" + e.getMessage());
        }

    }

    public void crearLibro() {
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
                    pst.setInt(4, 2023);
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

    public void getLibros() {
        MySqlConnection conn = new MySqlConnection();
        GestorBiblioteca gb = new GestorBiblioteca();
        conn.setUrl(conn.getUrl() + gb.getNombreDB());

        try (Connection c = conn.getConnection()) {
            if (c != null) {
                Statement sta = c.createStatement();
                ResultSet rs = sta.executeQuery("SELECT titulo from libro");
                while (rs.next()) {
                    System.out.println(rs.getString("titulo"));
                }
            } else {
                System.out.println("Error de conexion");
            }

        } catch (Exception e) {
            System.out.println("Error inesperado");
        }
    }

    public void getLibrosByAutor(String authorName) {
        MySqlConnection conn = new MySqlConnection();
        GestorBiblioteca gb = new GestorBiblioteca();
        conn.setUrl(conn.getUrl() + gb.getNombreDB());

        try (Connection c = conn.getConnection()) {
            if (c != null) {

                try (PreparedStatement pst = c.prepareStatement("SELECT titulo FROM libro WHERE autor = ?")) {
                    pst.setString(1, authorName);
                    ResultSet rs = pst.executeQuery();
                    while (rs.next()) {
                        System.out.println(rs.getString("titulo"));
                    }
                } catch (Exception e) {
                    System.out.println("Error en la consulta");
                }

            } else {
                System.out.println("Error de conexion");
            }

        } catch (Exception e) {
            System.out.println("Error inesperado");
        }

    }

    public void getLibrosByHigherYear(int year) {
        MySqlConnection conn = new MySqlConnection();
        GestorBiblioteca gb = new GestorBiblioteca();
        conn.setUrl(conn.getUrl() + gb.getNombreDB());

        try (Connection c = conn.getConnection()) {
            if (c != null) {

                try (PreparedStatement pst = c.prepareStatement("SELECT titulo FROM libro WHERE anoPublicacion > ?")) {
                    pst.setInt(1, year);
                    ResultSet rs = pst.executeQuery();
                    while (rs.next()) {
                        System.out.println(rs.getString("titulo"));
                    }
                } catch (Exception e) {
                    System.out.println("Error en la consulta");
                }

            } else {
                System.out.println("Error de conexion");
            }

        } catch (Exception e) {
            System.out.println("Error inesperado");
        }

    }

    public void setNewTitle(int libroID, String newTitle){
        MySqlConnection conn = new MySqlConnection();
        GestorBiblioteca gb = new GestorBiblioteca();
        conn.setUrl(conn.getUrl() + gb.getNombreDB());

        try (Connection c = conn.getConnection()) {
            if (c != null) {
                String updateTitle = "UPDATE libro SET titulo = ? WHERE libroId = ? ";
                try (PreparedStatement pst = c.prepareStatement(updateTitle)) {
                    pst.setString(1, newTitle);
                    pst.setInt(2, libroID);
                    pst.executeUpdate();

                    System.out.println("El titulo del libro se ha actualizado");

                } catch (Exception e) {
                    System.out.println("ERROR en la consulta");
                }

            } else {
                System.out.println("Error en la conexion");
            }
        } catch (Exception e) {
            System.out.println("ERROR inesperado");
        }

    }

    public void setNewAuthorName(int libroID, String authorName){
        MySqlConnection conn = new MySqlConnection();
        GestorBiblioteca gb = new GestorBiblioteca();
        conn.setUrl(conn.getUrl() + gb.getNombreDB());

        try (Connection c = conn.getConnection()) {
            if (c != null) {
                String updateAuthorName = "UPDATE libro SET autor = ? WHERE libroId = ?";
                try (PreparedStatement pst = c.prepareStatement(updateAuthorName)) {
                    pst.setString(1, authorName);
                    pst.setInt(2, libroID);
                    pst.executeUpdate();
                    System.out.println("Nombre actulizado correctamente");
                } catch (Exception e) {
                    System.out.println("ERROR en la consulta");
                }

            } else {
                System.out.println("Error en la conexion");
            }
        } catch (Exception e) {
            System.out.println("ERROR inesperado");
        }

    }

    public void setNewPubYear(int libroID, int year){
        MySqlConnection conn = new MySqlConnection();
        GestorBiblioteca gb = new GestorBiblioteca();
        conn.setUrl(conn.getUrl() + gb.getNombreDB());

        try (Connection c = conn.getConnection()) {
            if (c != null) {
                String updateYearQuery = "UPDATE libro SET anoPublicacion = ? WHERE libroId = ?";    
                try (PreparedStatement pst = c.prepareStatement(updateYearQuery)) {
                    pst.setInt(1, year);
                    pst.setInt(2, libroID);
                    pst.executeUpdate();
                    System.out.println("Año del libro modificado correctamente");
                } catch (Exception e) {
                    System.out.println("Error en la modificacion");
                }

            } else {
                System.out.println("Error en la conexion");
            }
        } catch (Exception e) {
            System.out.println("ERROR inesperado");
        }

    }

    public void deleteLibro(int libroID){
        MySqlConnection conn = new MySqlConnection();
        GestorBiblioteca gb = new GestorBiblioteca();
        conn.setUrl(conn.getUrl() + gb.getNombreDB());

        try (Connection c = conn.getConnection()) {
            if (c != null) {
                String deleteBookQuery = "DELETE FROM libro WHERE libroID = ? ";
                try (PreparedStatement pst  = c.prepareStatement(deleteBookQuery)) {
                    pst.setInt(1, libroID);
                    pst.executeUpdate();
                } catch (Exception e) {
                    System.out.println("Error en el borrado");
                }

            }else{
                System.out.println("Error en la conexion");
            }
        } catch (Exception e) {
            System.out.println("ERROR inesperado");
        }

    }

    public void deleteLibrosByYear(int year){
        MySqlConnection conn = new MySqlConnection();
        GestorBiblioteca gb = new GestorBiblioteca();
        conn.setUrl(conn.getUrl() + gb.getNombreDB());
        try (Connection c = conn.getConnection()) {
            if (c != null) {
            try (PreparedStatement pst = c.prepareStatement("DELETE FROM libro WHERE anoPublicacion < ?")) {
                pst.setInt(1, year);
                pst.executeUpdate();
                System.out.println("Borrado realizado correctamente");
            } catch (Exception e) {
                System.out.println("ERROR en el borrado");
            }
                


            } else {
                System.out.println("Error en conexion");
            }
        } catch (Exception e) {
            System.out.println("ERROR inesperado");
        }

    }

    public void deleteAll(){
          MySqlConnection conn = new MySqlConnection();
        GestorBiblioteca gb = new GestorBiblioteca();
        conn.setUrl(conn.getUrl() + gb.getNombreDB());
        try (Connection c = conn.getConnection()) {
            if (c != null) {
            try (PreparedStatement pst = c.prepareStatement("TRUNCATE TABLE libro ")) {
                pst.executeUpdate();
                System.out.println("Borrado realizado correctamente");
            } catch (Exception e) {
                System.out.println("ERROR en el borrado");
            }

            } else {
                System.out.println("Error en conexion");
            }
        } catch (Exception e) {
            System.out.println("ERROR inesperado");
        }
    }

}
