package Ej2;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ClasificaDirectorio {
    public void segunExtension(String dir) throws IOException {
        File directorioRaiz = new File(dir);
        if (directorioRaiz.isDirectory() && directorioRaiz.exists()) {

            File[] listaArchivos = directorioRaiz.listFiles();
            List <String> listaExtensiones = new ArrayList<String>();
            for (File archivo : listaArchivos) {
                if (archivo.isFile()) {
                    String nombre = archivo.getName();
                    int posicionPunto = nombre.lastIndexOf(".");
                    if (posicionPunto > 0 && posicionPunto < nombre.length() - 1) {
                        String extension = nombre.substring(posicionPunto + 1).toUpperCase();
                        if (!listaExtensiones.contains(extension)) {
                            listaExtensiones.add(extension);
                        }

                        for (String name : listaExtensiones) {
                             File directorio = new File(directorioRaiz,name);
                             directorio.mkdir();
                             //esto no funciona
                             if (nombre.toUpperCase().endsWith(extension)) {
                               archivo.renameTo(directorio);
                             }
                        }

                        
                    }
                }
            }

        }else{
            throw new IOException("no se encontro");
        
        }

    }
}
