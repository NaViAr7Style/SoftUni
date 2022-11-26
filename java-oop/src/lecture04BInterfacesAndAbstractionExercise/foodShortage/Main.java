package lecture04BInterfacesAndAbstractionExercise.foodShortage;

import lecture04BInterfacesAndAbstractionExercise.interfacePerson.Citizen;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        Map<String, Buyer> buyers = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String[] tokens = scanner.nextLine().split("\\s+");

            String name = tokens[0];
            int age = Integer.parseInt(tokens[1]);
            Buyer buyer;

            if (tokens.length == 4) {
                String id = tokens[2];
                String birthDate = tokens[3];
                buyer = new Citizen(name, age, id, birthDate);
            } else {
                String group = tokens[2];
                buyer = new Rebel(name, age, group);
            }

            buyers.put(name, buyer);
        }

        String nameFromConsole = scanner.nextLine();

        while (!"End".equals(nameFromConsole)) {
            Buyer buyer = buyers.get(nameFromConsole);

            if (buyer != null) {
                buyer.buyFood();
            }

            nameFromConsole = scanner.nextLine();
        }

        int totalFood = buyers.values()
                .stream()
                .mapToInt(Buyer::getFood)
                .sum();

        System.out.println(totalFood);
    }
}
