package postgre.connections;

import java.sql.Connection;

public interface DBConnection {
    Connection getConnection();
    Connection getConnectionServer();
}
