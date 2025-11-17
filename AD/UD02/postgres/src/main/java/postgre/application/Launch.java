package postgre.application;

import java.sql.Connection;

import postgre.connections.PostgresConnection;

public class Launch {

    public static void main(String[] args) {
        GestorDB gb = new GestorDB();
        gb.crearDB();
        gb.crearTabla();
        gb.crearAlumno(2, "PAblo", "a23@hotmail.com", 23);
        gb.borrarAlumno(2);
        gb.actualizarAlumno(2, "Antonio", "a24@gmail.com", 16);
        gb.mostrarAlumnos();
    }
    
}
