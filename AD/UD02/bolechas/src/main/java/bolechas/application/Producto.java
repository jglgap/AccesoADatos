package bolechas.application;

public class Producto {
    private int idProducto;
    private double precio;
    private String nombre;
    private String descripcion;

    public Producto(int id, double precio, String nombre, String descripcion){
        this.idProducto = id;
        this.precio = precio;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }
    public String getNombre() {
        return nombre;
    }
    public int getIdProducto() {
        return idProducto;
    }
    public double getPrecio() {
        return precio;
    }
    @Override
    public String toString() {
        return  "ID: " + getIdProducto() + "Nombre: " + getNombre() + "Precio: " + getPrecio() + "Descripcion: " + getDescripcion();
    }
}
