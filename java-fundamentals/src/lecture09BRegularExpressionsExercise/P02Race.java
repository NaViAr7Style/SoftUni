package lecture09BRegularExpressionsExercise;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class P02Race {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> racers = Arrays.stream(scanner.nextLine().split(", ")).collect(Collectors.toList());
        Map<String, Integer> distanceTravelled = new LinkedHashMap<>();

        for (String racer : racers) {
            distanceTravelled.put(racer, 0);
        }

        String input = scanner.nextLine();

        Pattern namePattern = Pattern.compile("[A-Za-z]+");
        Pattern distancePattern = Pattern.compile("\\d");

        while (!input.equals("end of race")) {
            Matcher nameMatcher = namePattern.matcher(input);
            StringBuilder nameBuilder = new StringBuilder();
            while (nameMatcher.find()) {
                nameBuilder.append(nameMatcher.group());
            }

            Matcher distanceMatcher = distancePattern.matcher(input);
            int distance = 0;
            while (distanceMatcher.find()) {
                distance += Integer.parseInt(distanceMatcher.group());
            }

            String currentRacer = nameBuilder.toString();

            if (distanceTravelled.containsKey(currentRacer)) {
                int currentDistance = distanceTravelled.get(currentRacer);
                distanceTravelled.put(currentRacer, currentDistance + distance);
            }

            input = scanner.nextLine();
        }

        List<String> mapToList = distanceTravelled.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                        .map(entry -> entry.getKey()).collect(Collectors.toList());

        System.out.println("1st place: " + mapToList.get(0));
        System.out.println("2nd place: " + mapToList.get(1));
        System.out.println("3rd place: " + mapToList.get(2));
    }
}
