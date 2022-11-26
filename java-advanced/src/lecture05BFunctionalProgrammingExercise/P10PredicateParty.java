package lecture05BFunctionalProgrammingExercise;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class P10PredicateParty {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        List<String> guests = Arrays.stream(scanner.nextLine().split("\\s+")).collect(Collectors.toList());

        String input = scanner.nextLine();

        while (!input.equals("Party!")) {
            String[] tokens = input.split("\\s+");

            String command = tokens[0];
            String filterType = tokens[1];
            String parameter = tokens[2];

            Predicate<String> filterToApply = getPredicate(filterType, parameter);

            switch (command) {
                case "Double":
                    for (int i = 0; i < guests.size(); i++) {
                        String currentGuest = guests.get(i);

                        if (filterToApply.test(currentGuest)) {
                            guests.add(i, currentGuest);
                            i++;
                        }
                    }
                    break;
                case "Remove":
                    guests.removeIf(filterToApply);
                    break;
            }

            input = scanner.nextLine();
        }

        if (guests.isEmpty()) {
            System.out.println("Nobody is going to the party!");
        } else {
            Collections.sort(guests);
            String guestList = String.join(", ", guests);
            System.out.println(guestList + " are going to the party!");
        }
    }

    private static Predicate<String> getPredicate(String filterType, String parameter) {

        switch (filterType) {
            case "StartsWith":
                return s -> s.startsWith(parameter);
            case "EndsWith":
                return s -> s.endsWith(parameter);
            case "Length":
                return s -> s.length() == Integer.parseInt(parameter);
        }

        return null;
    }
}