package alumnos.app;

public class Launch {
    public static void main(String[] args) {
        GestorDB gb = new GestorDB();
        gb.crearBaseDatos();
        gb.crearTabla();
        gb.crearAlumno(2, "antonio", "a23@gmail.com", 20);
        gb.borrarAlumno(2);
        gb.actualizarAlumno(2, "pepe", "profe", 40);
        gb.mostrarAlumnos();
    }
}
