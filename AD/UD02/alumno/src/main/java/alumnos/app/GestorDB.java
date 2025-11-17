package alumnos.app;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import alumnos.connection.MySqlConnection;

/**
 * GestorDB es una clase encargada de realizar operaciones de gestión sobre la
 * base de datos de alumnos. Proporciona métodos para crear la base de datos,
 * crear la tabla de alumnos y realizar operaciones CRUD (crear, leer, 
 * actualizar y eliminar) sobre los registros de alumnos.
 *
 * Esta clase utiliza la clase {@link MySqlConnection} para obtener las 
 * conexiones necesarias a la base de datos o al servidor MySQL.
 */
public class GestorDB {

    /**
     * Crea la base de datos cuyo nombre se obtiene desde el archivo de 
     * configuración mediante {@link ConfigLoader}.
     * <p>
     * Si la base de datos ya existe, el servidor MySQL generará una excepción.
     * </p>
     */
    public void crearBaseDatos() {
        String nombreDB = ConfigLoader.get("sql.dbname");
        try (Connection c = new MySqlConnection().getConnectionServer()) {
            String queryDB = "CREATE DATABASE " + nombreDB;
            Statement sta = c.createStatement();
            sta.executeUpdate(queryDB);
            System.out.println("Base de datos creada correctamente");
        } catch (Exception e) {
            System.out.println("Error crear base de datos: " + e.getMessage());
        }
    }

    /**
     * Crea la tabla Alumno dentro de la base de datos previamente creada.
     * <p>
     * La tabla incluye los campos: Id, nombre, email y edad.
     * </p>
     * <p>
     * Si la tabla ya existe, se producirá una excepción.
     * </p>
     */
    public void crearTabla() {
        try (Connection c = new MySqlConnection().getConnectionDB();
             Statement sta = c.createStatement()) {

            sta.executeUpdate(
                "CREATE TABLE Alumno(" +
                "Id int PRIMARY KEY, " +
                "nombre varchar(250) NOT NULL, " +
                "email varchar(250) NOT NULL, " +
                "edad int NOT NULL)"
            );
            System.out.println("Se ha creado correctamente");
        } catch (Exception e) {
            System.out.println("Error crear tabla: " + e.getMessage());
        }
    }

    /**
     * Inserta un nuevo alumno en la tabla Alumno.
     *
     * @param id     Identificador único del alumno.
     * @param nombre Nombre completo del alumno.
     * @param email  Correo electrónico del alumno.
     * @param edad   Edad del alumno.
     */
    public void crearAlumno(int id, String nombre, String email, int edad) {
        String queryInsertar = "INSERT INTO Alumno(Id, nombre, email, edad) VALUES(?,?,?,?)";
        try (Connection c = new MySqlConnection().getConnectionDB();
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
     * @param id Identificador del alumno que se desea eliminar.
     */
    public void borrarAlumno(int id) {
        String queryBorrar = "DELETE FROM Alumno WHERE Id = ?";
        try (Connection c = new MySqlConnection().getConnectionDB();
             PreparedStatement sta = c.prepareStatement(queryBorrar)) {

            sta.setInt(1, id);
            sta.executeUpdate();
            System.out.println("Se ha borrado correctamente el alumno");
        } catch (Exception e) {
            System.out.println("Error borrar alumno: " + e.getMessage());
        }
    }

    /**
     * Actualiza los datos de un alumno existente en la tabla Alumno.
     *
     * @param id     Identificador del alumno a actualizar.
     * @param nombre Nuevo nombre del alumno.
     * @param email  Nuevo correo electrónico del alumno.
     * @param edad   Nueva edad del alumno.
     */
    public void actualizarAlumno(int id, String nombre, String email, int edad) {
        String queryActualizar = "UPDATE Alumno SET nombre = ?, email = ?, edad = ? WHERE Id = ?";
        try (Connection c = new MySqlConnection().getConnectionDB();
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
     * Muestra en consola todos los alumnos almacenados en la tabla Alumno.
     * <p>
     * Recupera todos los registros y los imprime con sus respectivos campos.
     * </p>
     */
    public void mostrarAlumnos() {
        try (Connection c = new MySqlConnection().getConnectionDB();
             Statement sta = c.createStatement()) {

            System.out.println("Alumnos:");
            ResultSet rs = sta.executeQuery("SELECT * FROM Alumno");

            while (rs.next()) {
                System.out.println(
                    "ID: " + rs.getInt("Id") +
                    " nombre: " + rs.getString("nombre") +
                    " email: " + rs.getString("email") +
                    " edad: " + rs.getInt("edad")
                );
            }
        } catch (Exception e) {
            System.out.println("Error mostrar alumnos: " + e.getMessage());
        }
    }
}