package lecture03BSetsAndMapsAdvancedExercise;

import java.util.*;

public class P09PopulationCounter {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Map<String, Long> worldPopulation = new LinkedHashMap<>();
        Map<String, Map<String, Long>> populationByCity = new LinkedHashMap<>();

        while (!input.equals("report")) {
            String[] tokens = input.split("\\|");

            String country = tokens[1];
            String city = tokens[0];
            long population = Integer.parseInt(tokens[2]);

            worldPopulation.putIfAbsent(country, 0L);
            populationByCity.putIfAbsent(country, new LinkedHashMap<>());

            long currentCountryPopulation = worldPopulation.get(country);

            worldPopulation.replace(country, population + currentCountryPopulation);
            populationByCity.get(country).put(city, population);

            input = scanner.nextLine();
        }

        Set<Map.Entry<String, Long>> countrySet = worldPopulation.entrySet();

        List<Map.Entry<String, Long>> countries = new ArrayList<>(countrySet);

        countries.sort((o1, o2) -> o2.getValue().compareTo(o1.getValue()));

        for (var country : countries) {
            System.out.printf("%s (total population: %d)%n", country.getKey(), country.getValue());

            Set<Map.Entry<String, Long>> citySet = populationByCity.get(country.getKey()).entrySet();

            List<Map.Entry<String, Long>> cities = new ArrayList<>(citySet);

            cities.sort((o1, o2) -> o2.getValue().compareTo(o1.getValue()));

            for (var city : cities) {
                System.out.printf("=>%s: %d%n", city.getKey(), city.getValue());
            }
        }
    }
}