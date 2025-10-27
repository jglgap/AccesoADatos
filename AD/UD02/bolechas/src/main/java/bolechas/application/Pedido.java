package bolechas.application;

public class Pedido {
    private int idPedido;
    private String fecha;
    private String dniCliente;
    private int idProducto;
    private int cantidad;


    public Pedido(int idPedido, String fecha, String dniCliente, int idProducto, int cantidad){
        this.idPedido = idPedido;
        this.fecha = fecha;
        this.dniCliente = dniCliente;
        this.idProducto = idProducto;
        this.cantidad = cantidad;
    }

    public int getIdPedido() {
        return idPedido;
    }
    public String getFecha() {
        return fecha;
    }
    public String getDniCliente() {
        return dniCliente;
    }
    public int getIdProducto() {
        return idProducto;
    }
    public int getCantidad() {
        return cantidad;
    }
    

    @Override
    public String toString() {
        return "idPedido: " + getIdPedido() + "fecha: "+ getFecha() + "dniCliente: "
        + getDniCliente() + "idProducto: " + getIdProducto() + "cantidad: " + cantidad;
    }


}
