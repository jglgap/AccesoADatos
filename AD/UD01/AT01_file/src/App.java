import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class App {

    public static void main(String[] args) {
        

        ManejoFicheros mf = new ManejoFicheros();
        try {
            File file = new File("fichero.txt");
            //mf.crearDirectorio("zcarpeta");
            //mf.crearFichero("zcarpeta/primerFichero.txt");
            //mf.borrarFichero("fichero.txt");
            mf.borrarDirectorio("zcarpeta");
            //mf.listarDirectorio("zcarpeta");
            //InfoFichero iff = new InfoFichero(file);
            //iff.mostrarInfo();
            
        } catch (FileNotFoundException f) {
            System.out.println(f.getMessage());
        } catch(IOException i){
            System.out.println(i);
        }



    }

}
