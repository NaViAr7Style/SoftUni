package lecture03BSetsAndMapsAdvancedExercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P08UserLogs {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Map<String, Map<String, Integer>> users = new TreeMap<>();

        Pattern pattern = Pattern.compile("IP=(\\S+) message=\\S+ user=(\\S+)");

        while (!input.equals("end")) {
            Matcher matcher = pattern.matcher(input);

            String ipAddress = matcher.group(1);
            String userName = matcher.group(2);

            users.putIfAbsent(userName, new LinkedHashMap<>());
            users.get(userName).putIfAbsent(ipAddress, 0);

            int ipQueriesCount = users.get(userName).get(ipAddress);
            users.get(userName).replace(ipAddress, ipQueriesCount + 1);

            input = scanner.nextLine();
        }

        for (var user : users.entrySet()) {
            System.out.println(user.getKey() + ":");
            StringBuilder sb = new StringBuilder();

            for (var ip : user.getValue().entrySet()) {
                sb.append(String.format("%s => %d, ", ip.getKey(), ip.getValue()));
            }

            String output = sb.substring(0, sb.length() - 2);
            System.out.println(output + ".");
        }
    }
}