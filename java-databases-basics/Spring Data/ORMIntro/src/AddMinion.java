import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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

    private static final String PRINT_MINION_TO_VILLAIN_ADD_FORMAT = "Successfully added %s to be minion of %s.\n";




    public static void main(String[] args) throws SQLException {

        Scanner scanner = new Scanner(System.in);

        String[] minionTokens = scanner.nextLine().split("\\s+");

        String minionName = minionTokens[1];
        int minionAge = Integer.parseInt(minionTokens[2]);
        String townName = minionTokens[3];
        String villainName = scanner.nextLine().split("\\s+")[1];

        final Connection connection = Utils.getConnection();

        PreparedStatement statement = connection.prepareStatement(GET_VILLAIN_BY_NAME);
        statement.setString(1, villainName);

        ResultSet resultSet = statement.executeQuery();

        if (!resultSet.next()) {
            final PreparedStatement statement1 = connection.prepareStatement(INSERT_INTO_VILLAINS);
            statement1.setString(1, villainName);
            statement1.setString(2, EVILNESS_FACTOR);

            statement1.executeUpdate();

            resultSet = statement.executeQuery();

            System.out.printf(PRINT_VILLAIN_ADD_FORMAT, villainName);

            
        }

        connection.close();
    }

}
