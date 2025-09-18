package Ej1;

import java.io.File;
import java.io.FileNotFoundException;

public class App {
    public static void main(String[] args) {
        Filtrar filtrar = new Filtrar();
        try {
            filtrar.filtrar("archivos", ".txt");

            System.out.println("Filtrando con FileNameFilter");
            File directorio = new File("archivos");
            String[] ficherosDeTexto = directorio.list(new FiltrarNombre(".py"));
            for (String s : ficherosDeTexto) {
                System.out.println(s);
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}
