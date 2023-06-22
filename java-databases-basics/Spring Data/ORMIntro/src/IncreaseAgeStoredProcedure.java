import java.sql.*;
import java.util.Scanner;

public class IncreaseAgeStoredProcedure {

    private static final String USP_GET_OLDER = "CALL usp_get_older(?);";

    private static final String SELECT_QUERY =  "SELECT name, age " +
                                                "FROM minions " +
                                                "WHERE id = ?;";

    public static void main(String[] args) throws SQLException {

        Scanner scanner = new Scanner(System.in);

        Connection connection = Utils.getConnection();

        int minionIdToAge = Integer.parseInt(scanner.nextLine());

        CallableStatement uspGetOlder = connection.prepareCall(USP_GET_OLDER);
        uspGetOlder.setInt(1, minionIdToAge);

        uspGetOlder.execute();

        PreparedStatement getData = connection.prepareStatement(SELECT_QUERY);
        getData.setInt(1, minionIdToAge);
        ResultSet resultSet = getData.executeQuery();

        resultSet.next();

        System.out.println(resultSet.getString("name") + " " + resultSet.getInt("age"));

        connection.close();
    }

}
