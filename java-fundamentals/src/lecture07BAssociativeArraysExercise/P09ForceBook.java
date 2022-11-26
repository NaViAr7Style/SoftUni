package lecture07BAssociativeArraysExercise;

import java.util.*;

public class P09ForceBook {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        Map<String, List<String>> map = new LinkedHashMap<>();

        while (!input.equals("Lumpawaroo")) {
            String team;
            String player;

            if (input.contains("|")) {
                team = input.split(" \\| ")[0];
                player = input.split(" \\| ")[1];

                if (!map.containsKey(team)) {
                    map.put(team, new ArrayList<>());
                    map.get(team).add(player);
                } else {
                    boolean playerExists = false;

                    for (Map.Entry<String, List<String>> entry : map.entrySet()) {
                        if (entry.getValue().contains(player)) {
                            playerExists = true;
                            break;
                        }
                    }

                    if (!playerExists) {
                        map.get(team).add(player);
                    }
                }
            } else if (input.contains("->")) {
                team = input.split(" -> ")[1];
                player = input.split(" -> ")[0];

                for (Map.Entry<String, List<String>> entry : map.entrySet()) {
                    entry.getValue().remove(player);
                }

                if (!map.containsKey(team)) {
                    map.put(team, new ArrayList<>());
                }

                map.get(team).add(player);

                System.out.printf("%s joins the %s side!%n", player, team);
            }

            input = scanner.nextLine();
        }

        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            if (!entry.getValue().isEmpty()) {
                System.out.printf("Side: %s, Members: %d%n", entry.getKey(), entry.getValue().size());

                for (String forceUser : entry.getValue()) {
                    System.out.println("! " + forceUser);
                }
            }
        }
    }
}
