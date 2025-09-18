package Ej2;

import java.io.File;

public class ClasificaDirectorio {
    public void segunExtension(String dir){
        File directorioRaiz = new File(dir);
        if (directorioRaiz.isDirectory() && directorioRaiz.exists()) {
            String[] listaArchivos = directorioRaiz.list();
            for (String archivo : listaArchivos) {
                
            }
        }

    }
}
