package lecture03ASetsAndMapsAdvancedLab;

import java.util.*;

public class P07CitiesByContinentAndCountry {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Map<String, Map<String, List<String>>> worldMap = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {
            String[] tokens = scanner.nextLine().split("\\s+");

            String continent = tokens[0];
            String country = tokens[1];
            String city = tokens[2];

            worldMap.putIfAbsent(continent, new LinkedHashMap<>());
            worldMap.get(continent).putIfAbsent(country, new ArrayList<>());
            worldMap.get(continent).get(country).add(city);
        }

//        worldMap.entrySet().stream()
//                .forEach(entry -> {
//                    System.out.println(entry.getKey() + ":");
//                    entry.getValue().entrySet().stream()
//                            .forEach(innerEntry -> {
//                                String cities = String.join(", ", innerEntry.getValue());
//                                System.out.println(" " + innerEntry.getKey() + " -> " + cities);
//                            });
//                });


        for (Map.Entry<String, Map<String, List<String>>> continents : worldMap.entrySet()) {
            String continent = continents.getKey();
            System.out.println(continent + ":");

            for (Map.Entry<String, List<String>> countries : worldMap.get(continent).entrySet()) {
                String country = countries.getKey();

                String cities = String.join(", ", worldMap.get(continent).get(country));
                System.out.println(" " + country + " -> " + cities);
            }
        }
    }
}