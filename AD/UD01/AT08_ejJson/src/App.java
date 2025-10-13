public class App {
    public static void main(String[] args) throws Exception {
        
        Producto p = new Producto("Pera", 4, false, new String[]{"args","bbbb"}, 3, "Aaa");
        Producto p1 = new Producto("Mesa",300,true,new String[]{"zzzzzz"},12,"eto e mesa");
        GestorProductos gp = new GestorProductos();
       gp.listaProductos.add(p1);
        gp.listaProductos.add(p);
        gp.almacenar();
        gp.leerJson();
    }
}
