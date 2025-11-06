package bolechas.application;

import java.util.Scanner;

public class Launch {
    public static void main(String[] args) {
        GestorBaseDatos gb = new GestorBaseDatos();
        GestorTablas gt = new GestorTablas();
        Scanner sc = new Scanner(System.in);
        int iterator = 0;
        while (iterator != 9) {
            System.out.println("1-Crear base de Datos \n2-Crear Tablas \n3-Gestionar Cliente \n4-Gestionar Producto \n5-Ver pedidos del cliente " + 
                                "\n6-Realizar pedido");
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
                case 4:
                    System.out.println("1-Crear producto \n" + "2-Actualizar producto\n" + "3-Eliminar producto");
                    int choose = Integer.parseInt(sc.nextLine());
                    gt.gestionProductos(choose);
                    break;
                case 5: 
                    System.out.println("introduce el dni del cliente");
                    gt.clientePedidos(sc.nextLine());
                    break;
                case 6:
                    System.out.println("Introduce dni");
                    String dni = sc.nextLine();
                    System.out.println("Introduce id del producto a comprar");
                    int idProducto = Integer.parseInt(sc.nextLine());
                    System.out.println("Introduce la cantidad");
                    int cantidad = Integer.parseInt(sc.nextLine());
                    gt.realizarPedido(dni, idProducto, cantidad);
                    break;
                case 7:
                    System.out.println("Introduce el id del pedido");
                    gt.pedidoJson(Integer.parseInt(sc.nextLine()));
                    break;
                default:
                    break;
            }

        }

    }
}
