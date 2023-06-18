import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public enum Utils {
    ;

    static Connection getConnection() throws SQLException {
        final Properties props = new Properties();
        props.setProperty(Constants.USER_KEY, Constants.USERNAME);
        props.setProperty(Constants.PASSWORD_KEY, Constants.PASSWORD_VALUE);

        return DriverManager
                .getConnection(Constants.JDBC_MYSQL_URL, props);
    }

}
