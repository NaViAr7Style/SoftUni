package lecture05BPolymorphismExercise.vehiclesExtension;

import lecture05BPolymorphismExercise.vehicles.Car;
import lecture05BPolymorphismExercise.vehicles.Truck;
import lecture05BPolymorphismExercise.vehicles.Vehicle;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Map<String, Vehicle> vehicles = new LinkedHashMap<>();
        vehicles.put("Car", getVehicle(scanner));
        vehicles.put("Truck", getVehicle(scanner));
        vehicles.put("Bus", getVehicle(scanner));

        int numberOfCommands = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < numberOfCommands; i++) {
            String[] tokens = scanner.nextLine().split("\\s+");

            String command = tokens[0];
            String vehicleType = tokens[1];
            double argument = Double.parseDouble(tokens[2]);

            switch (command) {
                case "DriveEmpty":
                    vehicles.get(vehicleType).driveAC(argument, vehicles.get(vehicleType).getFuelConsumption() - Bus.AC_ADDITIONAL_CONSUMPTION);
                    break;
                case "Drive":
                    System.out.println(vehicles.get(vehicleType).drive(argument));
                    break;
                case "Refuel":
                    try {
                        vehicles.get(vehicleType).refuel(argument);
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
            }

        }

        vehicles.values().forEach(System.out::println);
    }

    private static Vehicle getVehicle(Scanner scanner) {
        String[] vehicleData = scanner.nextLine().split("\\s+");
        String vehicleType = vehicleData[0];
        double fuelAmount = Double.parseDouble(vehicleData[1]);
        double fuelConsumption = Double.parseDouble(vehicleData[2]);
        double tankCapacity = Double.parseDouble(vehicleData[3]);

        switch (vehicleType) {
            case "Car":
                return new Car(fuelAmount, fuelConsumption, tankCapacity);
            case "Truck":
                return new Truck(fuelAmount, fuelConsumption, tankCapacity);
            case "Bus":
                return new Bus(fuelAmount, fuelConsumption, tankCapacity);
            default:
                throw new IllegalArgumentException("Missing car");
        }

    }

}
