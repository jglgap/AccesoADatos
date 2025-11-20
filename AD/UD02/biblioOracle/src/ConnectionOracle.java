import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverAction;
import java.sql.DriverManager;

public class ConnectionOracle {

        String url = "jdbc:oracle:thin:@localhost:1521/XEPDB1";
        String usuario = "admin";
        String contraseña = "admin";

 public Connection getConnectionServer(){
    try {
        Class.forName("oracle.jdbc.OracleDriver");
        return DriverManager.getConnection(url,usuario,contraseña);
    } catch (Exception e) {
        System.out.println("problemas conexion" + e.getMessage());
        return null;
    }
 }

 public Connection getConnDb(){
    
        String dbUser = "system";
        String dbPassword = "admin";
    try {
        return DriverManager.getConnection(url, dbUser, dbPassword);
    } catch (Exception e) {
        System.out.println("Error conexion");
        return null;
    }
 }

 public Connection getConnTable(){
    
        String dbUser = "biblioClemente";
        String dbPassword = "biblioPass123";
    try {
        return DriverManager.getConnection(url, dbUser, dbPassword);
    } catch (Exception e) {
        System.out.println("Error conexion");
        return null;
    }
 }
}
