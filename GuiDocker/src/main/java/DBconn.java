import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBconn {
    private static final String URL = "jdbc:mariadb://host.docker.internal:3306/tempdb";
    static final String USER = "root";
    private static final String PASSWORD = "example";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}