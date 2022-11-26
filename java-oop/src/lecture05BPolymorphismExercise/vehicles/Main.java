package lecture05BPolymorphismExercise.vehicles;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Map<String, Vehicle> vehicles = new LinkedHashMap<>();
        vehicles.put("Car", getVehicle(scanner));
        vehicles.put("Truck", getVehicle(scanner));

        int numberOfCommands = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < numberOfCommands; i++) {
            String[] tokens = scanner.nextLine().split("\\s+");

            String command = tokens[0];
            String vehicleType = tokens[1];
            double argument = Double.parseDouble(tokens[2]);

            switch (command) {
                case "Drive":
                    System.out.println(vehicles.get(vehicleType).drive(argument));
                    break;
                case "Refuel":
                    vehicles.get(vehicleType).refuel(argument);
            }

        }

        vehicles.values().forEach(System.out::println);

    }

    private static Vehicle getVehicle(Scanner scanner) {
        String[] vehicleData = scanner.nextLine().split("\\s+");
        String vehicleType = vehicleData[0];
        double fuelAmount = Double.parseDouble(vehicleData[1]);
        double fuelConsumption = Double.parseDouble(vehicleData[2]);

        switch (vehicleType) {
            case "Car":
                return new Car(fuelAmount, fuelConsumption, 50000);
            case "Truck":
                return new Truck(fuelAmount, fuelConsumption, 50000);
            default:
                throw new IllegalArgumentException("Missing car");
        }

    }

}