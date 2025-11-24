package model;

import java.util.ArrayList;

import gui.StudentsView;

public class AppStudents {
	private ManageStudents manager;
	private StudentsView view;

	/**
	 * Constructor de la clase que crea la vista y el managere
	 */
	public AppStudents() {
		this.manager = new ManageStudents();
		this.view = new StudentsView(this);
		this.view.setVisible(true);
	}

	/**
	 * Inserta un estudiante
	 * @param id
	 * @param name
	 * @param surname
	 * @param age
	 * @param email
	 */
	public void enrollStudent(String id, String name, String surname, int age, String email) {
		Student student = new Student(id, name, surname, age, email);
		boolean inserted = manager.addStudent(student);
		if (inserted) {
			view.showMessage("ESTUDIANTE MATRICULADO CORRECTAMENTE.");
			view.clear();
			view.addStudent(id, name, surname, age, email);

		} else {
			view.showMessage("NO SE HA PODIDO MATRICULAR AL ESTUDIANTE.");
		}
	}

	/**
	 * Borra el estudiante
	 * @param id
	 */
	public void dropStudent(String id) {
		boolean deleted = manager.deleteStudent(id);
		if (deleted) {
			view.showMessage("SE HA BORRADO CON ÉXITO AL ESTUDIANTE.");
			view.refresh();
		} else {
			view.showMessage("NO SE HA PODIDO DESMATRICULAR AL ESTUDIANTE.");
		}
	}

	/**
	 * actualiza un estudiante
	 * @param id
	 * @param name
	 * @param surname
	 * @param age
	 * @param email
	 */
	public void updateStudent(String id, String name, String surname, int age, String email) {
		Student student = new Student(id, name, surname, age, email);
		boolean modified = manager.modifyStudent(student);
		if (modified) {
			view.showMessage("SE HA ACTUALIZADO CON ÉXITO AL ESTUDIANTE.");
			view.refresh();
		} else {
			view.showMessage("NO SE HA PODIDO ACTUALIZAR AL ESTUDIANTE.");
		}
	}

	/**
	 * Muestra los estudiantes
	 */
	public void showAllStudents() {
		ArrayList<Student> students = manager.getStudentsList();
		for (Student student : students) {
			view.addStudent(student.getId(), student.getNombre(), student.getApellidos(), student.getEdad(), student.getEmail());
		}
	}
}
