package lecture03BSetsAndMapsAdvancedExercise;

import java.util.*;

public class P07HandsOfCards {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Map<String, Set<String>> players = new LinkedHashMap<>();

        while (!input.equals("JOKER")) {
            String[] tokens = input.split(": ");

            String name = tokens[0];
            String[] cards = tokens[1].split(", ");

            players.putIfAbsent(name, new HashSet<>());

            for (String card : cards) {
                players.get(name).add(card);
            }

            input = scanner.nextLine();
        }

        for (var player : players.entrySet()) {
            System.out.print(player.getKey() + ": ");
            int totalPoints = 0;

            for (String card : player.getValue()) {
                String power = card.substring(0, card.length() - 1);
                String type = card.substring(card.length() - 1);

                int cardPoints = getPowerValue(power) * getTypeValue(type);

                totalPoints += cardPoints;
            }

            System.out.println(totalPoints);
        }
    }

    private static int getTypeValue(String type) {
        switch (type) {
            case "S":
                return 4;
            case "H":
                return 3;
            case "D":
                return 2;
            case "C":
                return 1;
        }

        return 0;
    }

    private static int getPowerValue(String power) {
        switch (power) {
            case "2":
                return 2;
            case "3":
                return 3;
            case "4":
                return 4;
            case "5":
                return 5;
            case "6":
                return 6;
            case "7":
                return 7;
            case "8":
                return 8;
            case "9":
                return 9;
            case "10":
                return 10;
            case "J":
                return 11;
            case "Q":
                return 12;
            case "K":
                return 13;
            case "A":
                return 14;
        }

        return 0;
    };
}
