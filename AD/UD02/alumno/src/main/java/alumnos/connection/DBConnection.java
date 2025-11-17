package alumnos.connection;

import java.sql.Connection;

public interface DBConnection {
    Connection getConnectionServer();

    Connection getConnectionDB();
}
