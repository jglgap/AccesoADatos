import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class GestorBase {
    public static void crearUsuarioPermisos() {
        String usuario = "biblioClemente";
        String pass = "biblioPass123";

        String sql1 = "CREATE USER " + usuario + " IDENTIFIED BY " + pass;
        String sql2 = "GRANT CREATE SESSION, CREATE TABLE, CREATE SEQUENCE, CREATE TRIGGER, UNLIMITED TABLESPACE TO "
                + usuario;

        try (Connection conn = new ConnectionOracle().getConnDb();
                Statement stmt = conn.createStatement()) {

            stmt.execute(sql1);
            System.out.println("Usuario " + usuario + " creado.");

            stmt.execute(sql2);
            System.out.println("Permisos otorgados a " + usuario + ".");

        } catch (SQLException e) {
            System.err.println("Error al crear usuario: " + e.getMessage());

        }
    }

    public static void crearTabla() {
        String BIBLIO_USER = "biblioClemente";
       
        String sql = """
            CREATE TABLE Libro (
                idLibro     NUMBER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
                isbn        VARCHAR2(13) NOT NULL,
                titulo      VARCHAR2(255) NOT NULL,
                autor       VARCHAR2(255),
                anho        NUMBER(4),
                disponible  NUMBER(1) DEFAULT 1 CHECK (disponible IN (0,1)),
                portada     BLOB
            )
            """;
        try (Connection conn = new ConnectionOracle().getConnTable()) {
            Statement stmt = conn.createStatement();

            stmt.executeUpdate(sql);
            System.out.println("Tabla \"Libro\" creada en esquema " + BIBLIO_USER + ".");

        } catch (Exception e) {
            System.out.println("error crear tabla" + e.getMessage());
        }
    }
}
