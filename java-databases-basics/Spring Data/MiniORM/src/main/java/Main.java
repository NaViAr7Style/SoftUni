import entities.User;
import orm.EntityManager;
import orm.MyConnector;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws SQLException, IllegalAccessException, InvocationTargetException, NoSuchMethodException, InstantiationException {
        MyConnector.createConnection("root", "12345", "soft_uni");

        Connection connection = MyConnector.getConnection();

        EntityManager<User> userEntityManager = new EntityManager<>(connection);
        User first = userEntityManager.findFirst(User.class, "id = 1");

        List<User> userList = new ArrayList<>();
        userEntityManager.find(User.class).forEach(userList::add);

        System.out.println();
    }
}
