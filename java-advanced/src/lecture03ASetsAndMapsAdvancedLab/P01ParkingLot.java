package lecture03ASetsAndMapsAdvancedLab;

import java.util.*;

public class P01ParkingLot {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Set<String> parkingLot = new LinkedHashSet<>();

        while (!input.equals("END")) {
            String[] tokens = input.split(", ");
            String command = tokens[0];
            String registration = tokens[1];

            switch (command) {
                case "IN":
                    parkingLot.add(registration);
                    break;
                case "OUT":
                    parkingLot.remove(registration);
                    break;
            }

            input = scanner.nextLine();
        }

        if (parkingLot.isEmpty()) {
            System.out.println("Parking Lot is Empty");
        } else {
            for (String car : parkingLot) {
                System.out.println(car);
            }
        }
    }
}