package Ej3;

import java.io.File;
import java.io.IOException;

public class ManejoFicherosBinarios {



    public static void main(String[] args) {

        File ficheroOrigen = new File("ficheroOrigen.bin");
        File ficheroDestiono = new File("ficheroDestino.bin");

        FicheroBinario fb = new FicheroBinario(ficheroOrigen);


        try {
            ficheroOrigen.createNewFile();
            ficheroDestiono.createNewFile();
            fb.escribirTexto("Este es el texto origen");
            fb.leer();
            fb.copiar(ficheroOrigen, ficheroDestiono);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
