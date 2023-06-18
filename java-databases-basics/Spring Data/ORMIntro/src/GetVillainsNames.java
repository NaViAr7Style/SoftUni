import java.sql.*;

public class GetVillainsNames {

    public static void main(String[] args) throws SQLException {

        final Connection connection = Utils.getConnection();

        String query =  "SELECT " +
                            "v.name, " +
                            "COUNT(DISTINCT mv.minion_id) AS \"minions_count\" " +
                        "FROM villains AS v " +
                        "JOIN minions_villains AS mv on v.id = mv.villain_id " +
                        "GROUP BY mv.villain_id " +
                        "HAVING `minions_count` > 15 " +
                        "ORDER BY minions_count DESC;";

        final PreparedStatement preparedStatement =
                connection.prepareStatement(query);

        final ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            System.out.println(resultSet.getString("name") + " " + resultSet.getInt("minions_count"));
        }

        connection.close();
    }

}