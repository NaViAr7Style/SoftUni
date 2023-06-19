import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class RemoveVillain {

    private static final String GET_VILLAIN_NAME_BY_ID =    "SELECT name " +
                                                            "FROM villains " +
                                                            "WHERE id = ?;";

    private static final String GET_MINIONS_COUNT_BY_VILLAIN_ID =   "SELECT COUNT(*) AS minion_count " +
                                                                    "FROM minions_villains " +
                                                                    "WHERE villain_id = ?;";

    private static final String DELETE_MINIONS_VILLAINS_BY_VILLAIN_ID =  "DELETE FROM minions_villains " +
                                                                "WHERE villain_id = ?;";

    private static final String DELETE_VILLAIN_BY_ID =  "DELETE FROM villains " +
                                                        "WHERE id = ?;";

    private static final String PRINT_RELEASED_MINIONS_COUNT_FORMAT = "%d minions released\n";
    private static final String PRINT_VILLAIN_DELETE_FORMAT = "%s was deleted\n";
    private static final String PRINT_NO_SUCH_VILLAIN_FOUND = "No such villain was found";


    public static void main(String[] args) throws SQLException {

        Connection connection = Utils.getConnection();
        Scanner scanner = new Scanner(System.in);

        int villainId = Integer.parseInt(scanner.nextLine());

        PreparedStatement getVillainStatement = connection.prepareStatement(GET_VILLAIN_NAME_BY_ID);
        getVillainStatement.setInt(1, villainId);

        ResultSet villainResultSet = getVillainStatement.executeQuery();

        if (!villainResultSet.next()) {
            System.out.println(PRINT_NO_SUCH_VILLAIN_FOUND);
            connection.close();
            return;
        }

        String villainName = villainResultSet.getString("name");

        PreparedStatement minionsCountStatement = connection.prepareStatement(GET_MINIONS_COUNT_BY_VILLAIN_ID);
        minionsCountStatement.setInt(1, villainId);

        ResultSet minionsCountResultSet = minionsCountStatement.executeQuery();
        minionsCountResultSet.next();

        int minionCount = minionsCountResultSet.getInt("minion_count");

        connection.setAutoCommit(false);

        try (PreparedStatement releaseMinionsStmt = connection.prepareStatement(DELETE_MINIONS_VILLAINS_BY_VILLAIN_ID);
             PreparedStatement deleteVillainStatement = connection.prepareStatement(DELETE_VILLAIN_BY_ID)) {

            releaseMinionsStmt.setInt(1, villainId);
            releaseMinionsStmt.executeUpdate();

            deleteVillainStatement.setInt(1, villainId);
            deleteVillainStatement.executeUpdate();

            connection.commit();
            System.out.printf(PRINT_VILLAIN_DELETE_FORMAT, villainName);
            System.out.printf(PRINT_RELEASED_MINIONS_COUNT_FORMAT, minionCount);
        } catch (SQLException e) {
            e.printStackTrace();
            connection.rollback();
        }

    }

}
