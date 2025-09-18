package Ej1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Filtrar {
    public void filtrar(String ruta, String extension) throws FileNotFoundException{
        File directorio = new File(ruta);

        if (directorio.isDirectory() && directorio.exists()) {
            String[] listOfFiles = directorio.list();
            List<String> filteredList = new ArrayList<>();
                for (String entry : listOfFiles) {
                    if (entry.endsWith(extension)) {
                        filteredList.add(entry);
                    }
                }

            System.out.println("Los ficheros con extension " + extension + " en el directorio " + ruta + " son:");
            for (String s : filteredList) {
                System.out.println(s);
            }

        }else{
                throw new FileNotFoundException("no se encontro el directorio");
        }
    }
}
