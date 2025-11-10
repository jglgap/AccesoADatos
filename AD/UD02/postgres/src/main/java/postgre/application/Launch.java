package postgre.application;

import java.sql.Connection;

import postgre.connections.PostgresConnection;

public class Launch {

    public static void prueba(){
        PostgresConnection pg = new PostgresConnection();
        try (Connection c = pg.getConnectionServer()) {
            if (c != null) {
                System.out.println("we are in");
            }
        } catch (Exception e) {
            System.out.println("error");
        }
    }

    public static void main(String[] args) {
        GestorDB gb = new GestorDB();
        gb.crearDB();
        prueba();
    }
    
}
