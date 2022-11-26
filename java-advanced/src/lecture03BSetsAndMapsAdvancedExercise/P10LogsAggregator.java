package lecture03BSetsAndMapsAdvancedExercise;

import java.util.*;

public class P10LogsAggregator {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Map<String, List<String>> userIps = new TreeMap<>();
        Map<String, Integer> sessionDurations = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String[] tokens = scanner.nextLine().split(" ");

            String user = tokens[1];
            String ipAddress = tokens[0];
            int duration = Integer.parseInt(tokens[2]);

            userIps.putIfAbsent(user, new ArrayList<>());
            userIps.get(user).add(ipAddress);

            sessionDurations.putIfAbsent(user, 0);

            int currentDuration = sessionDurations.get(user);
            sessionDurations.replace(user, currentDuration + duration);
        }

        for (var user : userIps.entrySet()) {
            System.out.printf("%s: %d ", user.getKey(), sessionDurations.get(user.getKey()));

            Set<String> ipAddresses = new TreeSet<>(user.getValue());

            System.out.println(ipAddresses);
        }
    }
}