import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class ManejoFicheroTexto {
    public static void main(String[] args) {

        File ficheroTexto = new File("Texto.txt");
        
        int bucle = 0;
        Scanner sc = new Scanner(System.in);
        System.out.println("rompe aqui");
        while (bucle <= 3) {
            System.out.println("1.-Escribir \n 2.-Leer \n 3.-Salir");
            int option = Integer.parseInt(sc.nextLine());
            
            try {
                ficheroTexto.createNewFile();
                FicheroTexto ficheroOrigen = new FicheroTexto(ficheroTexto);
                switch (option) {
                    case 1:
                        System.out.println("Introduce el texto que quieres añadir en el fichero");
                        String texto = sc.nextLine();
                        ficheroOrigen.escribirTexto(texto);
                       
                        break;
                    case 2:
                        System.out.println("El contenido del fichero es: ");
                        ficheroOrigen.leer();

                        break;
                    
                    case 3:
                        System.out.println("Has salido del programa");
                        bucle=4;
                    default:
                        break;
                }
            } catch (IOException e) {
                // TODO: handle exception
                e.printStackTrace();
            }

        } 

    }
}
