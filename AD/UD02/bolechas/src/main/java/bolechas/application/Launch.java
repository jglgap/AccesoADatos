package bolechas.application;

import java.util.Scanner;

public class Launch {
    public static void main(String[] args) {
        GestorBaseDatos gb = new GestorBaseDatos();
        GestorTablas gt = new GestorTablas();
        Scanner sc = new Scanner(System.in);
        int iterator = 0;
        while (iterator != 9) {
            System.out.println("1-a \n2-b \n3-c \n4-d");
            int option = Integer.parseInt(sc.nextLine());
            switch (option) {
                case 1:

                    gb.CrearBaseDatos();
                    break;
                case 2:

                    gt.inicializarTablas();
                    
                    break;
                case 3:
                    System.out.println("1-Crear cliente \n" + "2-Actualizar cliente\n" + "3-Eliminar cliente");
                    int opt = Integer.parseInt(sc.nextLine());
                    gt.gestionClientes(opt);
                    break;
                default:
                    break;
            }

        }

    }
}
