package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import conexiones.MySQLConnection;

public class ManageStudents {


	/**
	 * metodo para añadir un registro a la tabla estudiante
	 * @param student
	 * @return false si no se puede añadir, true en caso de que si
	 */
	public boolean addStudent(Student student) {
		try(Connection connection = new MySQLConnection().getConnection()) {
			String sql = "INSERT INTO estudiante VALUES (?,?,?,?,?)";
			
			PreparedStatement sentence = connection.prepareStatement(sql);
			sentence.setString(1, student.getId());
			sentence.setString(2, student.getNombre());
			sentence.setString(3, student.getApellidos());
			sentence.setInt(4, student.getEdad());
			sentence.setString(5, student.getEmail());
			int rows = sentence.executeUpdate();
			
			return rows > 0;
		} catch (SQLException e) {
			return false;
		}
	}

	/**
	 * Consigue un registro de estudiante segun el id
	 * @param id
	 * @return null en caso de no existir, en caso de que si devuelve un objeto estudiante
	 */
	public Student getStudent(String id) {
		try(Connection connection = new MySQLConnection().getConnection()) {
			String sql = "SELECT * FROM estudiante WHERE id LIKE ?";
			
			PreparedStatement query = connection.prepareStatement(sql);
			query.setString(1, id);
			ResultSet result = query.executeQuery();
			Student student = new Student();
			while (result.next()) {
				student.setId(result.getString("id"));
				student.setNombre(result.getString("nombre"));
				student.setApellidos(result.getString("apellidos"));
				student.setEdad(result.getInt("edad"));
				student.setEmail(result.getString("email"));
			}
			return student;
		} catch (SQLException e) {
			return null;
		}
	}


	/**
	 * Borra un estudiante de la base de datos
	 * @param id
	 * @return true si se elimina, false si no se elimina
	 */
	public boolean deleteStudent(String id) {
		try(Connection connection = new MySQLConnection().getConnection()) {
			String sql = "DELETE FROM estudiante WHERE id=?";
			
			PreparedStatement query = connection.prepareStatement(sql);
			query.setString(1, id);
			int deletedRow = query.executeUpdate();
			
			return deletedRow == 1;
		} catch (SQLException e) {
			return false;
		}
	}

	/**
	 * Actualiza los campos de un estudiante
	 * @param student
	 * @return true si se actualiza
	 */
	public boolean modifyStudent(Student student) {
		try(Connection connection = new MySQLConnection().getConnection()) {
			String sql = "UPDATE estudiante SET nombre=?, apellidos=?, edad=?,email=?" + " WHERE id=?";
			
			PreparedStatement sentence = connection.prepareStatement(sql);
			sentence.setString(1, student.getNombre());
			sentence.setString(2, student.getApellidos());
			sentence.setInt(3, student.getEdad());
			sentence.setString(4, student.getEmail());
			sentence.setString(5, student.getId());
			int rowsUpdated = sentence.executeUpdate();
			
			return rowsUpdated == 1;
		} catch (SQLException e) {
			return false;
		}
	}

	/**
	 * Consigue todos los registros de la tabla estudiante
	 * @return arraylist de estudiantes
	 */
	public ArrayList<Student> getStudentsList() {
		try(Connection connection = new MySQLConnection().getConnection()) {
			String sql = "SELECT * FROM estudiante";
			
			Statement query = connection.createStatement();
			ResultSet result = query.executeQuery(sql);
			ArrayList<Student> students = new ArrayList<Student>();
			while (result.next()) {
				Student student = new Student();
				student.setId(result.getString("id"));
				student.setNombre(result.getString("nombre"));
				student.setApellidos(result.getString("apellidos"));
				student.setEdad(result.getInt("edad"));
				student.setEmail(result.getString("email"));
				students.add(student);
			}
			return students;
		} catch (SQLException e) {
			return null;
		}
	}
}
