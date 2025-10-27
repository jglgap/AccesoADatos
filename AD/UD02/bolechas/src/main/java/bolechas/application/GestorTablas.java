package bolechas.application;

import java.sql.Connection;
import java.sql.Statement;

import bolechas.connection.MySqlConnection;

public class GestorTablas {

    public Connection conexionBd() {
        MySqlConnection conn = new MySqlConnection();
        GestorBaseDatos gb = new GestorBaseDatos();
        conn.setUrl(conn.getUrl() + gb.getDbName());
        return conn.getConnection();
    }

    public void crearTablaProducto() {

        try (Connection c = conexionBd()) {
            if (c != null) {
                Statement sta = c.createStatement();
                String tablaProducto = "CREATE TABLE IF NOT EXISTS PRODUCTO(productoId int PRIMARY KEY, nombre varchar (250),descripcion varchar(250), precio double)";
                sta.executeUpdate(tablaProducto);
                System.out.println("Se ha creado la tabla PRODUCTO");
            } else {
                System.out.println("Problema conexion");
            }
        } catch (Exception e) {
            System.out.println("ERROR inesperado");
        }

    }

    public void crearTablaCliente() {
        try (Connection c = conexionBd()) {
            if (c != null) {
                Statement sta = c.createStatement();
                String tablaCliente = "CREATE TABLE IF NOT EXISTS CLIENTE(dni varchar(250) PRIMARY KEY, nombre varchar(250))";
                sta.executeUpdate(tablaCliente);
                System.out.println("Se ha creado la tabla CLIENTE");
            } else {
                System.out.println("Problema conexion");
            }
        } catch (Exception e) {
            System.out.println("ERROR inesperado");
        }
    }

    public void crearTablaPedido() {
        try (Connection c = conexionBd()) {
            Statement sta = c.createStatement();
            String tablaPedido = "CREATE TABLE IF NOT EXISTS PEDIDO(idPedido int PRIMARY KEY, fecha varchar(250), dniCliente varchar(250)  REFERENCES CLIENTE(dni), idProducto int  REFERENCES PRODUCTO(productoId), cantidad int)";
            sta.executeUpdate(tablaPedido);
            System.out.println("Se ha creado la tabla PEDIDO");
        } catch (Exception e) {
            System.out.println("ERROR inesperado");
        }
    }

    public void inicializarTablas() {
        crearTablaProducto();
        crearTablaCliente();
        crearTablaPedido();
    }
}
