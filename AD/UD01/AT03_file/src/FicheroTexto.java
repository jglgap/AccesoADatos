import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FicheroTexto {

    private File fichero;

    public FicheroTexto(File file){
        this.fichero =  file; 
    }

    public void setFichero(File fichero) {
        this.fichero = fichero;
    }
    public File getFichero() {
        return fichero;
    }


    public void escribirTexto(String texto) throws IOException{
        FileWriter file = new FileWriter(this.getFichero(),true);
        BufferedWriter buffer = new BufferedWriter(file);

        buffer.write(texto);
        buffer.newLine();
        buffer.close();
        file.close();

    }

    public void leer() throws IOException{
        FileReader file = new FileReader(this.getFichero());
        BufferedReader buffer = new BufferedReader(file);
        
        String line = buffer.readLine();
        while (line != null) {
            System.out.println(line);
            line = buffer.readLine();
        }

        buffer.close();
        file.close();
    }
}
