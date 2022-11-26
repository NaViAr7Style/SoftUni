package lecture03ASetsAndMapsAdvancedLab;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class P02SoftUniParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Set<String> reservations = new TreeSet<>();

        while (!input.equals("PARTY")) {
            reservations.add(input);

            input = scanner.nextLine();
        }

        input = scanner.nextLine();

        while (!input.equals("END")) {
            reservations.remove(input);

            input = scanner.nextLine();
        }

        System.out.println(reservations.size());

        for (String guest : reservations) {
            System.out.println(guest);
        }
    }
}