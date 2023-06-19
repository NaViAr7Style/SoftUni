package orm;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class MyConnector {
    private static Connection connection;
    private static final String CONNECTION_URL = "jdbc:mysql://localhost:3306/%s";

    public static void createConnection(String username, String password, String dbName) throws SQLException {

        Properties userPassProps = new Properties();
        userPassProps.setProperty("user", username);
        userPassProps.setProperty("password", password);

        connection = DriverManager.getConnection(String.format(CONNECTION_URL, dbName), userPassProps);
    }

    public static Connection getConnection() {
        return  connection;
    }
}
