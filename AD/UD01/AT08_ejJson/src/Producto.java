public class Producto {

    private String nome;
    private double prezo;
    private boolean disponible;
    private String[]categorias;
    private int stock;
    private String descripcion;
    private Proveedor proveedor;


    public Producto(String nombre, double prezo, boolean disponible, String[] categorias, int stock, String descripcion, Proveedor proveedor){
        this.nome = nombre;
        this.prezo = prezo;
        this.disponible = disponible;
        this.categorias =  categorias;
        this.stock = stock;
        this.descripcion = descripcion;
        this.proveedor = proveedor;

    }


    @Override
    public String toString() {
        String copyCategory = "";
        for (int i = 0; i < this.categorias.length; i++) {
            copyCategory = copyCategory + " "+ this.categorias[i] + " " ;
        }
        return "nombre: " + this.nome + " prezo: " + this.prezo + " disponible: " + this.disponible + " categorias: " + copyCategory + 
        " stock: " + this.stock + " descripcion: " + this.descripcion + this.proveedor.getNombre();
    }

}
