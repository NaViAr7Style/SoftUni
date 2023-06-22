import java.sql.*;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class IncreaseMinionsAge {

    private static final String PRINT_ALL_MINIONS_QUERY = "SELECT `name`, age FROM minions;";

    private static final String UPDATE_MINIONS_FROM_ID_LIST =   "UPDATE minions " +
                                                                "SET age = age + 1, `name` = LOWER(`name`) " +
                                                                "WHERE id in (";

    public static void main(String[] args) throws SQLException {

        Scanner scanner = new Scanner(System.in);

        Connection connection = Utils.getConnection();

        List<String> minionIds = Arrays.stream(scanner.nextLine().split(" ")).toList();
        String ids = String.join(", ", minionIds);

        PreparedStatement statement = connection.prepareStatement(UPDATE_MINIONS_FROM_ID_LIST + ids + ");");
        statement.executeUpdate();

        PreparedStatement outputStmt = connection.prepareStatement(PRINT_ALL_MINIONS_QUERY);
        ResultSet resultSet = outputStmt.executeQuery();

        while (resultSet.next()) {
            String name = resultSet.getString("name");
            int age = resultSet.getInt("age");
            System.out.println(name + " " + age);
        }

        connection.close();
    }

}
