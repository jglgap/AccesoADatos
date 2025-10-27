package bolechas.application;

import java.util.Scanner;

public class Launch {
    public static void main(String[] args) {
    
    Scanner sc = new Scanner(System.in);
    int iterator = 0;
    while (iterator != 9) {
        System.out.println("1-a \n2-b \n3-c \n4-d");
        int option = Integer.parseInt(sc.nextLine());
    switch (option) {
        case 1:
            GestorBaseDatos gb = new GestorBaseDatos();
            gb.CrearBaseDatos();
            break;
        case 2:
            GestorTablas gt = new GestorTablas();
            gt.inicializarTablas();;
            break;
        case 3:
            System.out.println("C");
            break;
        default:
            break;
    }


    }


    }
}
