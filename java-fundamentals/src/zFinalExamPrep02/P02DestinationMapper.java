package zFinalExamPrep02;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P02DestinationMapper {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Pattern pattern = Pattern.compile("([=\\/])([A-Z][A-Za-z]{2,})\\1");
        Matcher matcher = pattern.matcher(input);

        List<String> destinations = new ArrayList<>();
        int travelPoints = 0;

        while (matcher.find()) {
            String destination = matcher.group(2);

            destinations.add(destination);
            travelPoints += destination.length();
        }

        System.out.println("Destinations: " + destinations.toString().replaceAll("[\\[\\]]", ""));
        System.out.println("Travel Points: " + travelPoints);
    }
}
