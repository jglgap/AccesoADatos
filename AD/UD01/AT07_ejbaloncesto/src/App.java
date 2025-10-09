import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        
        Scanner sc = new Scanner(System.in);
        Clasificacion c = new Clasificacion(2);


        int cont = 0;
        while (cont< 6) {
            System.out.println("1-Añadir equipo a la clasificacion \n2-Mostrar clasificacion \n3-Cargar clasificicacion \n4-Leer clasificacion \n5-Salir del programa");
            int option = Integer.parseInt(sc.nextLine());
            switch (option) {
                case 1:
                    c.addEquipo();
                    break;
                
                case 2: 
                    System.out.println(c);
                    break;
                case 3:
                    Clasificacion.saveClasificacion(c.getEquipos());
                    break;
                case 4:
                    Clasificacion.loadClasificacion();
                    break;
                case 5:
                    cont = 6;
                default:
                    break;
            }
        }


        
    }
}
