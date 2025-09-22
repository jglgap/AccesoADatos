package Ej3;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FicheroBinario {

    private File fichero;

    public FicheroBinario(File file){
        this.fichero = file;
    }

    public File getFichero() {
        return fichero;
    }

    public void setFichero(File fichero) {
        this.fichero = fichero;
    }


    public void escribirTexto(String texto) throws IOException{
        FileOutputStream file = new FileOutputStream(this.getFichero());
        BufferedOutputStream buffer = new BufferedOutputStream(file);

        buffer.write(texto.getBytes());

        buffer.close();
        file.close();
    }
    public void leer() throws IOException{
        FileInputStream file= new FileInputStream(this.getFichero());
        BufferedInputStream buffer = new BufferedInputStream(file);

        byte b;
        
        while ((b = (byte)buffer.read()) !=-1) {
            System.out.printf("%c",b,b);
        }
        buffer.close();
        file.close();


    }
    public void copiar(File ficheroBinario , File ficheroDestino) throws IOException{

        FileInputStream origen = new FileInputStream(ficheroBinario);
        BufferedInputStream bufferRead = new BufferedInputStream(origen);

        FileOutputStream destino = new FileOutputStream(ficheroDestino);
        BufferedOutputStream bufferWrite = new BufferedOutputStream(destino);
 
        byte b;

        while ((b = (byte) bufferRead.read()) !=-1) {
            bufferWrite.write(b);
        }

        bufferRead.close();
        origen.close();
        bufferWrite.close();
        destino.close();

    }

}
