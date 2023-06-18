import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class GetMinionNames {

    public static void main(String[] args) throws SQLException {

        Scanner scanner = new Scanner(System.in);

        final Connection connection = Utils.getConnection();

        String minionsQuery =   "SELECT DISTINCT " +
                                    "m.name, " +
                                    "m.age " +
                                "FROM minions_villains AS mv " +
                                "LEFT JOIN minions AS m ON m.id = mv.minion_id " +
                                "WHERE mv.villain_id = ?;";

        String villainQuery =   "SELECT `name` " +
                                "FROM villains " +
                                "WHERE id = ?;";

        final PreparedStatement minionStmt =
                connection.prepareStatement(minionsQuery);

        final PreparedStatement villainStmt =
                connection.prepareStatement(villainQuery);

        int villainId = Integer.parseInt(scanner.nextLine());

        minionStmt.setInt(1, villainId);
        villainStmt.setInt(1, villainId);

        final ResultSet minionResultSet = minionStmt.executeQuery();
        final ResultSet villainResultSet = villainStmt.executeQuery();

        if (villainResultSet.next()) {
            System.out.printf("Villain: %s\n", villainResultSet.getString("name"));

            int counter = 0;
            while (minionResultSet.next()) {
                counter++;
                System.out.printf("%d. %s %d\n",
                        counter,
                        minionResultSet.getString("name"),
                        minionResultSet.getInt("age"));
            }

        } else {
            System.out.printf("No villain with ID %d exists in the database.\n", villainId);
        }

        connection.close();
    }

}
