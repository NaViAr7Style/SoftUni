import entities.User;
import orm.EntityManager;
import orm.config.Connector;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;

public class Main {

    public static void main(String[] args) throws SQLException, IllegalAccessException, InvocationTargetException, NoSuchMethodException, InstantiationException {
        Connector.createConnection("root", "12345", "soft_uni");

        Connection connection = Connector.getConnection();

        EntityManager<User> userEntityManager = new EntityManager<>(connection);
        boolean persistResult = userEntityManager.persist(new User("User", "Pass", 24, LocalDate.now()));
        User first = userEntityManager.findFirst(User.class);

        System.out.println(persistResult);
        System.out.println(first);
    }
}
