public class Proveedor {

    private String nombre;
    private String telefono;

    public Proveedor(String nombre, String telefono){
        this.nombre = nombre;
        this.telefono = telefono;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    @Override
    public String toString() {
        return "Nombre: " + getNombre() + " telefono: " + getTelefono();
    }
}
