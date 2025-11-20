import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Launch {

    public static void prueba() {
        try (Connection conn = new ConnectionOracle().getConnectionServer()) {
            if (conn != null) {
                System.out.println("Conectado");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }



  
    public static void main(String[] args) {
        prueba();
        GestorBase gb = new GestorBase();
        gb.crearUsuarioPermisos();
        gb.crearTabla();

    }
}
