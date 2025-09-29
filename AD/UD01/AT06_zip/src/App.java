import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {


        CrearZip cz = new CrearZip();
        ExtraerZip ez = new ExtraerZip();
        Scanner sc  = new Scanner(System.in);
        int numero = 0;
        while (numero < 3) {
            System.out.println("1-Comprimir");
            int option = Integer.parseInt(sc.nextLine());
            switch (option) {
                case 1:
                    System.out.println("Esta es la funcion de comprimir");
                    System.out.println("Escribe el nombre de la carpeta comprimida (recuerda añadir .zip al final)");
                    String nombreZip = sc.nextLine();
                    System.out.println("Introduce el numero de ficheros que quieres comprimir");
                    int numeroDeEscaner = Integer.parseInt(sc.nextLine());
                    List<String> nombreFicheros = new ArrayList<>();
                    for (int i = 0; i < numeroDeEscaner; i++) {
                        System.out.println("nombre del fichero");
                        nombreFicheros.add("ficheros/" + sc.nextLine());
                    }
                    try {
                        cz.comprimir(nombreZip, nombreFicheros);
                    } catch (FileNotFoundException e) {
                        e.getMessage();
                    }


                    break;
                case 2:
                    System.out.println("Esta es la funcion de extraer");
                    System.out.println("introduce el nombre del fichero zip que quieres descompirmir");
                    String fichZip = sc.nextLine();
                    System.out.println("introduce el nombre de la carpeta destino");
                    String destino = sc.nextLine();
                    ez.descomprimir(fichZip, destino);

                    
                    break;
                case 3:
                    numero = 4;
                default:
                    break;
            }
        }



    }
}
