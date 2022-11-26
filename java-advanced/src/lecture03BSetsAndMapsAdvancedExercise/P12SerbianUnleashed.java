package lecture03BSetsAndMapsAdvancedExercise;

import java.util.*;

public class P12SerbianUnleashed {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Map<String, Map<String, Integer>> venues = new LinkedHashMap<>();

        while (!input.equals("End")) {
            String[] getSinger = input.split(" @");

            String[] tokens;

            String venue;
            String singer;
            int ticketPrice = 0;
            int audienceCount = 0;

            try {

                singer = getSinger[0];
                tokens = getSinger[1].split(" ");
                audienceCount = Integer.parseInt(tokens[tokens.length - 1]);
                ticketPrice = Integer.parseInt(tokens[tokens.length - 2]);

            } catch (Exception e) {

                input = scanner.nextLine();
                continue;

            }

            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < tokens.length - 2; i++) {
                sb.append(tokens[i]).append(" ");
            }

            venue = sb.substring(0, sb.length() - 1);

            venues.putIfAbsent(venue, new LinkedHashMap<>());
            venues.get(venue).putIfAbsent(singer, 0);

            int previousRevenue = venues.get(venue).get(singer);
            int currentRevenue = audienceCount * ticketPrice;

            venues.get(venue).replace(singer, previousRevenue + currentRevenue);

            input = scanner.nextLine();
        }

        for (var venue : venues.entrySet()) {
            System.out.println(venue.getKey());

            Set<Map.Entry<String, Integer>> entries = venue.getValue().entrySet();

            List<Map.Entry<String, Integer>> singers = new ArrayList<>(entries);

            singers.sort(((o1, o2) -> o2.getValue().compareTo(o1.getValue())));

            for (var singer : singers) {
                System.out.printf("#  %s -> %d%n", singer.getKey(), singer.getValue());
            }
        }
    }
}