package lecture05BFunctionalProgrammingExercise;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class P11ThePartyReservationFilterModule {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        List<String> guests = Arrays.stream(scanner.nextLine().split("\\s+")).collect(Collectors.toList());

        Set<String> filters = new HashSet<>();

        String input = scanner.nextLine();

        while (!input.equals("Print")) {
            String[] tokens = input.split(";");

            String command = tokens[0];
            String filter = tokens[1] + ";" + tokens[2];

            switch (command) {
                case "Add filter":
                    filters.add(filter);
                    break;
                case "Remove filter":
                    filters.remove(filter);
                    break;
            }

            input = scanner.nextLine();
        }

        filters.forEach(filter -> {
            Predicate<String> filterToApply = getPredicate(filter);
            guests.removeIf(filterToApply);
        });

        guests.forEach(guest -> System.out.print(guest + " "));
    }

    private static Predicate<String> getPredicate(String filter) {
        String[] tokens = filter.split(";");

        String filterType = tokens[0];
        String parameter = tokens[1];

        switch (filterType) {
            case "Starts with":
                return s -> s.startsWith(parameter);
            case "Ends with":
                return s -> s.endsWith(parameter);
            case "Length":
                return s -> s.length() == Integer.parseInt(parameter);
            case "Contains":
                return s -> s.contains(parameter);
        }

        return null;
    }
}