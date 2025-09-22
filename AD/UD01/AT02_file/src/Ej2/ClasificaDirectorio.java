package Ej2;

import java.io.File;
import java.io.IOException;

public class ClasificaDirectorio {
    public void segunExtension(String dir) throws IOException {
        File directorioRaiz = new File(dir);

        if (!directorioRaiz.exists() || !directorioRaiz.isDirectory()) {
            throw new IOException("No se encontró el directorio o no es válido");
        }

        File[] listaArchivos = directorioRaiz.listFiles();

        if (listaArchivos == null) return;

        for (File archivo : listaArchivos) {
            if (archivo.isFile()) {
                String nombre = archivo.getName();
                int posicionPunto = nombre.lastIndexOf(".");

                if (posicionPunto > 0 && posicionPunto < nombre.length() - 1) {
                    String extension = nombre.substring(posicionPunto + 1).toUpperCase();
                    
                    // Crear subdirectorio con el nombre de la extensión
                    File subdirectorio = new File(directorioRaiz, extension);
                    if (!subdirectorio.exists()) {
                        subdirectorio.mkdir();
                    }

                    // Nueva ruta del archivo
                    File nuevoArchivo = new File(subdirectorio, nombre);

                    // Mover el archivo
                    boolean exito = archivo.renameTo(nuevoArchivo);
                    if (!exito) {
                        System.err.println("No se pudo mover el archivo: " + nombre);
                    }
                }
            }
        }
    }
}
