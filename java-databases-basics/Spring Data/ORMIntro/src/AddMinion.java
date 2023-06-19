import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class AddMinion {

    private static final String PRINT_VILLAIN_ADD_FORMAT = "Villain %s was added to the database.\n";
    private static final String GET_VILLAIN_BY_NAME =   "SELECT id " +
                                                        "FROM villains " +
                                                        "WHERE name = ?;";
    private static final String INSERT_INTO_VILLAINS =  "INSERT INTO villains(name, evilness_factor) " +
                                                        "VALUES(?, ?);";
    private static final String EVILNESS_FACTOR = "evil";



    private static final String PRINT_TOWN_ADD_FORMAT = "Town %s was added to the database.\n";
    private static final String GET_TOWN_BY_NAME =  "SELECT id " +
                                                    "FROM towns " +
                                                    "WHERE name = ?;";
    private static final String INSERT_INTO_TOWNS = "INSERT INTO towns(name) " +
                                                    "VALUES(?);";



    private static final String GET_LAST_MINION_BY_NAME =   "SELECT id " +
                                                            "FROM minions " +
                                                            "WHERE name = ?" +
                                                            "ORDER BY id DESC " +
                                                            "LIMIT 1;";
    private static final String INSERT_INTO_MINIONS =   "INSERT INTO minions(name, age, town_id) " +
                                                        "VALUES(?, ?, ?);";
    private static final String INSERT_INTO_MINIONS_VILLAINS =    "INSERT INTO minions_villains(minion_id, villain_id) " +
                                                                  "VALUES(?, ?);";

    private static final String PRINT_MINION_TO_VILLAIN_ADD_FORMAT = "Successfully added %s to be minion of %s.\n";




    public static void main(String[] args) throws SQLException {

        final Connection connection = Utils.getConnection();
        Scanner scanner = new Scanner(System.in);

        String[] minionTokens = scanner.nextLine().split("\\s+");

        String minionName = minionTokens[1];
        int minionAge = Integer.parseInt(minionTokens[2]);
        String townName = minionTokens[3];
        String villainName = scanner.nextLine().split("\\s+")[1];

        int townId = getEntryId(connection,
                List.of(townName),
                GET_TOWN_BY_NAME,
                INSERT_INTO_TOWNS,
                PRINT_TOWN_ADD_FORMAT);

        int villainId = getEntryId(connection,
                List.of(villainName,EVILNESS_FACTOR),
                GET_VILLAIN_BY_NAME,
                INSERT_INTO_VILLAINS,
                PRINT_VILLAIN_ADD_FORMAT);

        PreparedStatement insertMinionStatement = connection.prepareStatement(INSERT_INTO_MINIONS);
        insertMinionStatement.setString(1, minionName);
        insertMinionStatement.setInt(2, minionAge);
        insertMinionStatement.setInt(3, townId);

        insertMinionStatement.executeUpdate();

        PreparedStatement lastMinion = connection.prepareStatement(GET_LAST_MINION_BY_NAME);
        lastMinion.setString(1, minionName);

        ResultSet resultSet = lastMinion.executeQuery();
        resultSet.next();

        int minionId = resultSet.getInt("id");

        PreparedStatement insertStatement = connection.prepareStatement(INSERT_INTO_MINIONS_VILLAINS);
        insertStatement.setInt(1, minionId);
        insertStatement.setInt(2, villainId);

        insertStatement.executeUpdate();

        System.out.printf(PRINT_MINION_TO_VILLAIN_ADD_FORMAT, minionName, villainName);

        connection.close();
    }

    private static int getEntryId(Connection connection, List<String> arguments, String getQuery, String insertQuery, String printFormat) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(getQuery);
        String villainName = arguments.get(0);
        statement.setString(1, villainName);


        ResultSet resultSet = statement.executeQuery();

        if (!resultSet.next()) {
            final PreparedStatement insertStatement = connection.prepareStatement(insertQuery);

            for (int i = 1; i <= arguments.size(); i++) {
                insertStatement.setString(i, arguments.get(i - 1));
            }

            insertStatement.executeUpdate();

            final ResultSet afterUpdate = statement.executeQuery();
            afterUpdate.next();

            System.out.printf(printFormat, villainName);

            return afterUpdate.getInt("id");
        }

        return resultSet.getInt("id");
    }

}
