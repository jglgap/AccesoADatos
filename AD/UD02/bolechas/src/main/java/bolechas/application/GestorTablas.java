package bolechas.application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.Scanner;

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

    // Gestionar cliente
    public void insertarCliente(String DNI, String nombre) {
        try (Connection c = conexionBd()) {
            String crearCliente = "INSERT INTO CLIENTE(dni,nombre) VALUES(?,?)";
            try (PreparedStatement pst = c.prepareStatement(crearCliente)) {
                pst.setString(1, DNI.toLowerCase());
                pst.setString(2, nombre);
                pst.executeUpdate();
                System.out.println("Cliente creado con exito");
            } catch (Exception e) {
                System.out.println("Problemas con la consulta");
            }

        } catch (Exception e) {
            System.out.println("ERROR inesperado");
        }

    }

    public void actualizarCliente(String DNI, String newNombre) {
        try (Connection c = conexionBd()) {
            String actualizarCliente = "UPDATE CLIENTE SET nombre = ? WHERE dni = ?";
            try (PreparedStatement pst = c.prepareStatement(actualizarCliente)) {
                pst.setString(1, newNombre);
                pst.setString(2, DNI);
                pst.executeUpdate();
                System.out.println("Actualizacion realizada correctamente");
            } catch (Exception e) {
                System.out.println("Error en la consulta");
            }
        } catch (Exception e) {
            System.out.println("ERROR inesperado");
        }

    }

    public void borrarCliente(String DNI) {
        try (Connection c = conexionBd()) {
            String borrarCliente = "DELETE FROM CLIENTE WHERE dni = ?";
            try (PreparedStatement pst = c.prepareStatement(borrarCliente)) {
                pst.setString(1, DNI);
                pst.executeUpdate();
                System.out.println("Borrado ejecutado con exito");
            } catch (Exception e) {
                System.out.println("Error en la consulta");
            }
        } catch (Exception e) {
            System.out.println("ERROR INESPERADO");
        }
    }

    public void gestionClientes(int option) {
        Scanner sc = new Scanner(System.in); 
            switch (option) {
                case 1:
                    System.out.println("Insertar DNI");
                    String DNI = sc.nextLine();
                    System.out.println("Insertar nombre");
                    String nombre = sc.nextLine();
                    insertarCliente(DNI, nombre);
                    break;
                case 2:
                    System.out.println("Insertar del cliente a actualizar");
                    String dniActualizar = sc.nextLine().toLowerCase();
                    System.out.println("Insertar nuevo nombre");
                    String nombreActualizar = sc.nextLine();
                    actualizarCliente(dniActualizar, nombreActualizar);
                    break;
                case 3:
                    System.out.println("Insertar dni del cliente a borrar");
                    String dniBorrar = sc.nextLine().toLowerCase();
                    borrarCliente(dniBorrar);
                    break;
                default:
                    break;
            }
      

    }

}
