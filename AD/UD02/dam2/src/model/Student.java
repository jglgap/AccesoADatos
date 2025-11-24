package model;

/**
 * Clase que representa a un estudiante dentro del sistema.
 * Contiene los datos básicos como identificación, nombre,
 * apellidos, edad y correo electrónico.
 */
public class Student {
	private String id;
	private String nombre;
	private String apellidos;
	private int edad;
	private String email;

	/**
	 * Constructor con parámetros.
	 * Permite crear un estudiante con todos sus datos inicializados.
	 *
	 * @param id identificador del estudiante
	 * @param name nombre del estudiante
	 * @param surname apellidos del estudiante
	 * @param age edad del estudiante
	 * @param email correo electrónico del estudiante
	 */
	public Student(String id, String name, String surname, int age, String email) {
		super();
		this.id = id;
		this.nombre = name;
		this.apellidos = surname;
		this.edad = age;
		this.email = email;
	}

	/**
	 * Constructor vacío.
	 * Permite crear un objeto Student sin valores iniciales.
	 */
	public Student() {

	}

	/**
	 * Obtiene el identificador del estudiante.
	 *
	 * @return id del estudiante
	 */
	public String getId() {
		return id;
	}

	/**
	 * Establece el identificador del estudiante.
	 *
	 * @param id nuevo identificador del estudiante
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * Obtiene el nombre del estudiante.
	 *
	 * @return nombre del estudiante
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Establece el nombre del estudiante.
	 *
	 * @param name nuevo nombre del estudiante
	 */
	public void setNombre(String name) {
		this.nombre = name;
	}

	/**
	 * Obtiene los apellidos del estudiante.
	 *
	 * @return apellidos del estudiante
	 */
	public String getApellidos() {
		return apellidos;
	}

	/**
	 * Establece los apellidos del estudiante.
	 *
	 * @param surname nuevos apellidos del estudiante
	 */
	public void setApellidos(String surname) {
		this.apellidos = surname;
	}

	/**
	 * Obtiene la edad del estudiante.
	 *
	 * @return edad del estudiante
	 */
	public int getEdad() {
		return edad;
	}

	/**
	 * Establece la edad del estudiante.
	 *
	 * @param age nueva edad del estudiante
	 */
	public void setEdad(int age) {
		this.edad = age;
	}

	/**
	 * Establece el correo electrónico del estudiante.
	 *
	 * @param email nuevo correo electrónico del estudiante
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Obtiene el correo electrónico del estudiante.
	 *
	 * @return email del estudiante
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Devuelve una representación en texto del estudiante
	 * con todos sus datos principales.
	 *
	 * @return información del estudiante en formato String
	 */
	@Override
	public String toString() {
		return "Student id: " + id + "\n" +
				"Student name: " + nombre + "\n" +
				"Student surname: " + apellidos + "\n" +
				"Student age: " + edad + "\n" +
				"Student email: " + email + "\n";
	}
}