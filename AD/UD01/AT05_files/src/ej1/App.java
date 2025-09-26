package ej1;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class App {
    public static void main(String[] args) throws Exception {
        
        Path ficheroOrigen = Paths.get("dir","origen.txt");
        Path ficheroDestino = Paths.get("dir","copia.txt");

        CopiaFichero cf = new CopiaFichero();
        try {
            cf.copiar(ficheroOrigen, ficheroDestino);
        } catch (IOException e) {
            e.printStackTrace();
        }



    }
}
