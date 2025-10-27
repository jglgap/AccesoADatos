package bolechas.application;

public class Cliente {
    private String dni;
    private String nombre;

    public Cliente(String DNI, String nombre){
        this.dni = dni;
        this.nombre = nombre;
    }


    public String getDni() {
        return dni;
    }
    public String getNombre() {
        return nombre;
    }

    @Override
    public String toString() {
        return "DNI: " + getDni() + "Nombre: " + getNombre();
    }


}
