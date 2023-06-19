import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PrintAllMinionNames {

    private static final String GET_ALL_MINIONS =   "SELECT name " +
                                                    "FROM minions;";

    public static void main(String[] args) throws SQLException {

        Connection connection = Utils.getConnection();
        PreparedStatement statement = connection.prepareStatement(GET_ALL_MINIONS, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

        ResultSet resultSet = statement.executeQuery();

        int minionCount = 0;

        while (resultSet.next()) {
            minionCount++;
        }

        for (int i = 1; i <= minionCount / 2; i++) {
            resultSet.absolute(i);
            System.out.println(resultSet.getString("name"));
            resultSet.absolute(-i);
            System.out.println(resultSet.getString("name"));
        }

        if (minionCount % 2 != 0) {
            resultSet.absolute(minionCount / 2 + 1);
            System.out.println(resultSet.getString("name"));
        }

    }

}
