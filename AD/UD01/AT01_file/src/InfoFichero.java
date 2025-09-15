import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class InfoFichero {
    private File fichero;

    //constructor
    public InfoFichero(File fichero){

        this.fichero = fichero;
    
    }

    //getter & setter
    public File getFichero() {
        return fichero;
    }

    public void setFichero(File fichero) {
        this.fichero = fichero;
    }


    public void mostrarInfo() throws IOException{
        if (this.fichero.exists()) {

            System.out.println("Este es el nombre del fichero: " + this.fichero.getName() );
            System.out.println("Esta es la ruta relativa : " + this.fichero.getPath());
            System.out.println("Esta es la ruta absoluta" + this.fichero.getAbsolutePath());
            if (this.fichero.canRead()) {
                System.out.println("Este fichero tiene permiso de lectura");
            }else{
                System.out.println("Este fichero no tiene permiso de lectura");

            }
            if (this.fichero.canWrite()) {
                System.out.println("Este fichero tiene permiso de escritura");

            }else{
                System.out.println("Este fichero no tiene permiso de escritura");

            }

            System.out.println("El tamaño del fichero es de " + this.fichero.getTotalSpace());
            if (this.fichero.isFile()) {
                System.out.println("Es un fichero");
            }else{
                System.out.println("Es un directorio");
            }
        }else{
            throw new FileNotFoundException("No existe el fichero");
        }
    }

}
