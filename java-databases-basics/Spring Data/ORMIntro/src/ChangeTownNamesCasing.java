import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ChangeTownNamesCasing {
    private static final String UPDATE_QUERY =  "UPDATE towns " +
                                                "SET `name` = UPPER(`name`) " +
                                                "WHERE country = ?;";

    private static final String SELECT_QUERY =  "SELECT `name` " +
                                                "FROM towns " +
                                                "WHERE country = ?;";

    public static void main(String[] args) throws SQLException {

        Scanner scanner = new Scanner(System.in);

        Connection connection = Utils.getConnection();

        String countryToUpdate = scanner.nextLine();

        PreparedStatement updateStmt = connection.prepareStatement(UPDATE_QUERY);
        updateStmt.setString(1, countryToUpdate);
        updateStmt.executeUpdate();

        PreparedStatement selectStmt = connection.prepareStatement(SELECT_QUERY);
        selectStmt.setString(1, countryToUpdate);

        ResultSet resultSet = selectStmt.executeQuery();
        List<String> townsUpdated = new ArrayList<>();

        while (resultSet.next()) {
            townsUpdated.add(resultSet.getString("name"));
        }

        if (townsUpdated.isEmpty()) {
            System.out.println("No town names were affected.");
        } else {
            String townOutput = String.join(", ", townsUpdated);
            System.out.printf("%d town names were affected.\n[%s]\n", townsUpdated.size(), townOutput);
        }

        connection.close();
    }

}
