package bolechas.application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
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

    // Gestionar productos

    public void insertarProducto(double precio, String nombre, String descripcion) {
        try (Connection c = conexionBd()) {
            Statement sta = c.createStatement();
            ResultSet rs = sta.executeQuery("Select MAX(productoId) as maxId FROM PRODUCTO");
            int idLast = 0;
            while (rs.next()) {
                idLast = rs.getInt("maxId");
            }
            int newId = idLast + 1;
            System.out.println(newId);
            String crearProducto = "INSERT INTO PRODUCTO(productoId,nombre,descripcion,precio) VALUES(?,?,?,?)";
            try (PreparedStatement pst = c.prepareStatement(crearProducto)) {
                pst.setInt(1, newId);
                pst.setString(2, nombre);
                pst.setString(3, descripcion);
                pst.setDouble(4, precio);
                pst.executeUpdate();
                System.out.println("Creado correctamente");
            } catch (Exception e) {
                System.out.println("Error en la query");
            }
        } catch (Exception e) {
            System.out.println("ERROR inesperado");
        }
    }

    public void actualizarProducto(int id, String newNombre, String newDescripcion, double newPrecio) {
        try (Connection c = conexionBd()) {
            String actualizarProducto = "UPDATE PRODUCTO SET nombre = ?,  descripcion = ?, precio = ? WHERE productoId = ?";
            try (PreparedStatement pst = c.prepareStatement(actualizarProducto)) {
                pst.setString(1, newNombre);
                pst.setString(2, newDescripcion);
                pst.setDouble(3, newPrecio);
                pst.setInt(4, id);
                pst.executeUpdate();
                System.out.println("Actualizacion realizada correctamente");
            } catch (Exception e) {
                System.out.println("Error query");
            }
        } catch (Exception e) {
            System.out.println("ERROR inesperado");
        }
    }

    public void borrarProducto(int id) {
        try (Connection c = conexionBd()) {
            String borrarProducto = "DELETE FROM PRODUCTO WHERE productoId = ?";
            try (PreparedStatement pst = c.prepareStatement(borrarProducto)) {
                pst.setInt(1, id);
                pst.executeUpdate();
                System.out.println("Borrado realizado correctamente");
            } catch (Exception e) {
                System.out.println("Error query");
            }
        } catch (Exception e) {
            System.out.println("ERROR inesperado");
        }
    }

    public void gestionProductos(int option) {
        Scanner sc = new Scanner(System.in);
        switch (option) {
            case 1:
                System.out.println("introduce el nombre del producto");
                String nombre = sc.nextLine();
                System.out.println("Introduce la descripcion");
                String descripcion = sc.nextLine();
                System.out.println("introduce el precio");
                double precio = Double.parseDouble(sc.nextLine());
                insertarProducto(precio, nombre, descripcion);
                break;
            case 2:
                System.out.println("introduce el id del producto a actualizar");
                int id = Integer.parseInt(sc.nextLine());
                System.out.println("Introduce el nuevo nombre");
                String newNombre = sc.nextLine();
                System.out.println("introduce la nueva descripcion");
                String newDescripcion = sc.nextLine();
                System.out.println("introduce el nuevo precio");
                Double newPrecio = Double.parseDouble(sc.nextLine());
                actualizarProducto(id, newNombre, newDescripcion, newPrecio);
                break;
            case 3:
                System.out.println("introduce el id a borrar");
                int borrado = Integer.parseInt(sc.nextLine());
                borrarProducto(borrado);
            default:
                break;
        }
    }

    // Pedidos de un cliente

    public void clientePedidos(String idCliente) {
        try (Connection c = conexionBd()) {
            String getPedidosCliente = "SELECT P.idPedido,P.fecha ,P.dniCliente, P.idProducto,PR.nombre AS nombreProducto, PR.precio as precio, P.cantidad FROM PEDIDO P JOIN PRODUCTO PR ON P.idProducto = PR.productoId WHERE P.dniCliente = ?";
            try (PreparedStatement pst = c.prepareStatement(getPedidosCliente)) {
                pst.setString(1, idCliente);
                ResultSet rs = pst.executeQuery();
                while (rs.next()) {
                    System.out.println("id pedido: " + rs.getInt("idPedido") + " fecha: " + rs.getString("fecha")
                            + " dni: " + rs.getString("dniCliente") + " producto: " + rs.getString("nombreProducto") +
                            " cantidad:" + rs.getInt("cantidad") + " total: "
                            + (rs.getDouble("precio") * rs.getInt("cantidad")));
                }
            } catch (Exception e) {
                System.out.println("error en la query");
            }

        } catch (Exception e) {
            System.out.println("ERROR inesperado");
        }
    }

    public void realizarPedido(String dni, int idProducto, int cantidad) {
        try (Connection c = conexionBd()) {
            Statement sta = c.createStatement();
            ResultSet rs = sta.executeQuery("Select MAX(idPedido) as id FROM PEDIDO");
            int lastId = 0;
            while (rs.next()) {
                lastId = rs.getInt("id");
            }
            int newId = lastId + 1;
            Date fechaActual = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            String fechaFormateada = sdf.format(fechaActual);
            String crearPedido = "INSERT INTO PEDIDO(idPedido,fecha,dniCliente,idProducto,cantidad) VALUES(?,?,?,?,?)";
            try (PreparedStatement pst = c.prepareStatement(crearPedido)) {
                pst.setInt(1, newId);
                pst.setString(2, fechaFormateada);
                pst.setString(3, dni);
                pst.setInt(4, idProducto);
                pst.setInt(5, cantidad);
                pst.executeUpdate();
                System.out.println("pedido realizado");
            } catch (Exception e) {
                System.out.println("Error query");
            }

        } catch (Exception e) {
            System.out.println("ERROR inesperado");
        }
    }
}
