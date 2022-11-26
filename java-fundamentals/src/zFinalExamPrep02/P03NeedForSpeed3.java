package zFinalExamPrep02;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class P03NeedForSpeed3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        Map<String, Integer> carsMileage = new LinkedHashMap<>();
        Map<String, Integer> carsFuel = new LinkedHashMap<>();

        for (int i = 1; i <= n; i++) {
            String[] input = scanner.nextLine().split("\\|");

            String currentCar = input[0];
            int currentMileage = Integer.parseInt(input[1]);
            int currentFuel = Integer.parseInt(input[2]);

            carsMileage.putIfAbsent(currentCar, currentMileage);
            carsFuel.putIfAbsent(currentCar, currentFuel);
        }

        String input = scanner.nextLine();

        while (!input.equals("Stop")) {
            String[] command = input.split(" : ");

            String action = command[0];
            String currentCar = command[1];
            int currentMileage = carsMileage.get(currentCar);
            int currentFuel = carsFuel.get(currentCar);

            switch (action) {
                case "Drive":
                    int distance = Integer.parseInt(command[2]);
                    int fuelNeeded = Integer.parseInt(command[3]);

                    if (fuelNeeded > currentFuel) {
                        System.out.println("Not enough fuel to make that ride");
                        input = scanner.nextLine();
                        continue;
                    }

                    carsMileage.put(currentCar, currentMileage + distance);
                    carsFuel.put(currentCar, currentFuel - fuelNeeded);
                    System.out.printf("%s driven for %d kilometers. %d liters of fuel consumed.%n", currentCar, distance, fuelNeeded);

                    if (carsMileage.get(currentCar) >= 100000) {
                        System.out.printf("Time to sell the %s!%n", currentCar);
                        carsMileage.remove(currentCar);
                        carsFuel.remove(currentCar);
                    }
                    break;

                case "Refuel":
                    int refuel = Integer.parseInt(command[2]);
                    int tankCap = 75;

                    if (currentFuel + refuel > tankCap) {
                        carsFuel.put(currentCar, tankCap);
                        System.out.printf("%s refueled with %d liters%n", currentCar, tankCap - currentFuel);
                    } else {
                        carsFuel.put(currentCar, currentFuel + refuel);
                        System.out.printf("%s refueled with %d liters%n", currentCar, refuel);
                    }
                    break;

                case "Revert":
                    int revertDistance = Integer.parseInt(command[2]);
                    int minMileage = 10000;

                    if (currentMileage - revertDistance < minMileage) {
                        carsMileage.put(currentCar, minMileage);
                    } else {
                        carsMileage.put(currentCar, currentMileage - revertDistance);
                        System.out.printf("%s mileage decreased by %d kilometers%n", currentCar, revertDistance);
                    }
                    break;
            }

            input = scanner.nextLine();
        }

        for (Map.Entry<String, Integer> entry : carsMileage.entrySet()) {
            String currentCar = entry.getKey();
            int currentMileage = entry.getValue();
            int currentFuel = carsFuel.get(entry.getKey());

            System.out.printf("%s -> Mileage: %d kms, Fuel in the tank: %d lt.%n", currentCar, currentMileage, currentFuel);
        }
    }
}
