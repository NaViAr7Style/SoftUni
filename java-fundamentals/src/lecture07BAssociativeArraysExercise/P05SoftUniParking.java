package lecture07BAssociativeArraysExercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class P05SoftUniParking {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        Map<String, String> parkingUsers = new LinkedHashMap<>();

        for (int i = 1; i <= n; i++) {
            String[] input = scanner.nextLine().split(" ");
            String user = input[1];

            switch (input[0]) {
                case "register":
                    String licensePlate = input[2];

                    if (parkingUsers.containsKey(user)) {
                        System.out.printf("ERROR: already registered with plate number %s%n", parkingUsers.get(user));
                    } else {
                        parkingUsers.put(user, licensePlate);
                        System.out.printf("%s registered %s successfully%n", user, licensePlate);
                    }
                    break;
                case "unregister":

                    if (!parkingUsers.containsKey(user)) {
                        System.out.printf("ERROR: user %s not found%n", user);
                    } else {
                        parkingUsers.remove(user);
                        System.out.printf("%s unregistered successfully%n", user);
                    }
                    break;
            }
        }

        for (Map.Entry<String, String> entry : parkingUsers.entrySet()) {
            System.out.println(entry.getKey() + " => " + entry.getValue());
        }
    }
}
