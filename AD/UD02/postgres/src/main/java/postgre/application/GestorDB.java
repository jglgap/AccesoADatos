package postgre.application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import postgre.connections.PostgresConnection;

/**
 * Clase GestorDB encargada de gestionar la creación de la base de datos,
 * creación de tablas y operaciones CRUD sobre la tabla Alumno.
 * Utiliza conexiones a PostgreSQL obtenidas desde la clase PostgresConnection.
 */
public class GestorDB {

    String DB = ConfigLoader.get("postgresql.dbName");

    /**
     * Crea la base de datos especificada en el archivo de configuración,
     * siempre y cuando no exista ya en el servidor PostgreSQL.
     * 
     * Muestra un mensaje por consola si la base de datos se crea correctamente o
     * si ocurre un problema de conexión.
     */
    public void crearDB() {
        String user = ConfigLoader.get("postgresql.user");

        try (Connection c = new PostgresConnection().getConnectionServer();
                Statement stmt = c.createStatement()) {
            String comprobar = "SELECT 1 FROM pg_database WHERE datname = '" + DB + "'";
            ResultSet rs = stmt.executeQuery(comprobar);
            if (!rs.next()) {
                stmt.executeUpdate(
                        "CREATE DATABASE " + DB + " WITH OWNER = " + user + " ENCODING 'UTF8' TEMPLATE template0");
                System.out.println("Se ha creado correctamente");
            }

        } catch (Exception e) {
            System.out.println("Problema conexion");
        }

    }

    /**
     * Crea la tabla Alumno dentro de la base de datos actual.
     * 
     * La tabla contiene los campos:
     * Id (PRIMARY KEY), nombre, email y edad.
     * 
     * Muestra un mensaje indicando si la tabla se creó correctamente o si ocurrió un
     * error.
     */
    public void crearTabla() {
        try (Connection c = new PostgresConnection().getConnection();
                Statement sta = c.createStatement()) {
            sta.executeUpdate(
                    "CREATE TABLE Alumno(Id int PRIMARY KEY, nombre varchar(250) NOT NULL, email varchar(250) NOT NULL, edad int NOT NULL)");
            System.out.println("Se ha creado correctamente");
        } catch (Exception e) {
            System.out.println("Error crear tabla: " + e.getMessage());
        }
    }

    /**
     * Inserta un nuevo registro en la tabla Alumno.
     * 
     * @param id     Identificador único del alumno.
     * @param nombre Nombre completo del alumno.
     * @param email  Dirección de correo del alumno.
     * @param edad   Edad del alumno.
     * 
     * Muestra un mensaje indicando si el alumno fue creado correctamente
     * o si ocurrió un error.
     */
    public void crearAlumno(int id, String nombre, String email, int edad) {
        String queryInsertar = "INSERT INTO Alumno(Id, nombre, email, edad) VALUES(?,?,?,?)";
        try (Connection c = new PostgresConnection().getConnection();
                PreparedStatement sta = c.prepareStatement(queryInsertar)) {
            sta.setInt(1, id);
            sta.setString(2, nombre);
            sta.setString(3, email);
            sta.setInt(4, edad);
            sta.executeUpdate();
            System.out.println("Se ha creado correctamente el alumno");
        } catch (Exception e) {
            System.out.println("Error crear alumno: " + e.getMessage());
        }

    }

    /**
     * Elimina un alumno de la tabla Alumno según su identificador.
     * 
     * @param id Identificador único del alumno a eliminar.
     * 
     * Muestra un mensaje indicando si el alumno fue borrado correctamente
     * o si ocurrió un error.
     */
    public void borrarAlumno(int id) {
        String queryBorrar = "DELETE FROM Alumno WHERE Id= ?";
        try (Connection c = new PostgresConnection().getConnection();
                PreparedStatement sta = c.prepareStatement(queryBorrar)) {
            sta.setInt(1, id);
            sta.executeUpdate();
            System.out.println("Se ha borrado correctamente el alumno");
        } catch (Exception e) {
            System.out.println("Error borrar alumno: " + e.getMessage());
        }
    }

    /**
     * Actualiza los datos de un alumno existente en la base de datos.
     * 
     * @param id     Identificador del alumno que se desea actualizar.
     * @param nombre Nuevo nombre del alumno.
     * @param email  Nuevo email del alumno.
     * @param edad   Nueva edad del alumno.
     * 
     * Muestra un mensaje indicando si la actualización fue exitosa
     * o si ocurrió un error.
     */
    public void actualizarAlumno(int id, String nombre, String email, int edad) {
        String queryActualizar = "UPDATE Alumno SET nombre = ?,  email = ?, edad = ? WHERE Id = ?";
        try (Connection c = new PostgresConnection().getConnection();
                PreparedStatement sta = c.prepareStatement(queryActualizar)) {
            sta.setString(1, nombre);
            sta.setString(2, email);
            sta.setInt(3, edad);
            sta.setInt(4, id);
            sta.executeUpdate();
            System.out.println("Se ha actualizado correctamente el alumno");
        } catch (Exception e) {
            System.out.println("Error actualizar alumno: " + e.getMessage());
        }
    }

    /**
     * Muestra por consola todos los alumnos almacenados en la tabla Alumno.
     * 
     * Recupera cada registro mediante una consulta SELECT y los imprime uno por uno,
     * mostrando ID, nombre, email y edad.
     * 
     * Muestra un mensaje en caso de error al realizar la consulta.
     */
    public void mostrarAlumnos() {
        try (Connection c = new PostgresConnection().getConnection();
                Statement sta = c.createStatement()) {
            System.out.println("Alumnos: ");
            ResultSet rs = sta.executeQuery("SELECT * FROM Alumno");
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("Id") + " nombre: " + rs.getString("nombre") + " email: "
                        + rs.getString("email") + " edad: " + rs.getInt("edad"));
            }

        } catch (Exception e) {
            System.out.println("Error mostrar alumnos: " + e.getMessage());
        }
    }

}

