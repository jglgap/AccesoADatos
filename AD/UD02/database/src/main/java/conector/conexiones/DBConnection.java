package conector.conexiones;

import java.sql.Connection;

public interface DBConnection {
    Connection getConnection();
}
