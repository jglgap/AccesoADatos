import java.util.ArrayList;

public class App {
    public static void main(String[] args) throws Exception {
        
        Proveedor proveedor1 = new Proveedor("Juan", "696696696");
        Proveedor proveedor2 = new Proveedor("Antonio", "969969969");


        Producto prod1 = new Producto("Jamon iberico", 15.49, true, new String[]{"Comida","España "},154, "La mejor paleta", proveedor1);
        Producto prod2 = new Producto("Cable USB", 2.50, false, new String[]{"tecnologia","materiales"}, 5, "cable de 1m", proveedor2);
    

        ArrayList<Producto> listaProductos = new ArrayList<>();
        listaProductos.add(prod2);
        listaProductos.add(prod1);

        GestorProductos.guardarProductos(listaProductos);
        GestorProductos.mostrarProductos();
        ArrayList<Producto> productosCargados= GestorProductos.cargarProductos();
        for (Producto producto : productosCargados) {
            System.out.println(producto);
        }
    } 

}
