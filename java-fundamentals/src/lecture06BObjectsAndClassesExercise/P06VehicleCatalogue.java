package lecture06BObjectsAndClassesExercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P06VehicleCatalogue {
    static class Vehicle {
        private String type;
        private String model;
        private String color;
        private int horsepower;

        public Vehicle(String type, String model, String color, int horsepower) {
            this.type = type;
            this.model = model;
            this.color = color;
            this.horsepower = horsepower;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getModel() {
            return model;
        }

        public void setModel(String model) {
            this.model = model;
        }

        public String getColor() {
            return color;
        }

        public void setColor(String color) {
            this.color = color;
        }

        public int getHorsepower() {
            return horsepower;
        }

        public void setHorsepower(int horsepower) {
            this.horsepower = horsepower;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        List<Vehicle> vehicles = new ArrayList<>();

        while (!input.equals("End")) {
            String type = input.split(" ")[0];
            String model = input.split(" ")[1];
            String color = input.split(" ")[2];
            int horsepower = Integer.parseInt(input.split(" ")[3]);

            Vehicle vehicle = new Vehicle(type, model, color, horsepower);
            vehicles.add(vehicle);

            input = scanner.nextLine();
        }

        String model = scanner.nextLine();

        while (!model.equals("Close the Catalogue")) {
            String current = model;
            List<Vehicle> currentModel = vehicles.stream().filter(e -> e.getModel().equals(current)).collect(Collectors.toList());

            for (Vehicle vehicle : currentModel) {
                System.out.printf("Type: %s%n", vehicle.getType().substring(0, 1).toUpperCase() + vehicle.getType().substring(1));
                System.out.printf("Model: %s%n", vehicle.getModel());
                System.out.printf("Color: %s%n", vehicle.getColor());
                System.out.printf("Horsepower: %d%n", vehicle.getHorsepower());
            }

            model = scanner.nextLine();
        }

        List<Vehicle> cars = vehicles.stream().filter(e -> e.getType().equals("car")).collect(Collectors.toList());
        List<Vehicle> trucks = vehicles.stream().filter(e -> e.getType().equals("truck")).collect(Collectors.toList());

        int carsHorsepower = 0;

        for (Vehicle car : cars) {
            carsHorsepower += car.getHorsepower();
        }

        int trucksHorsepower = 0;

        for (Vehicle truck : trucks) {
            trucksHorsepower += truck.getHorsepower();
        }

        if (cars.isEmpty()) {
            System.out.println("Cars have average horsepower of: 0.00.");
        } else {
            System.out.printf("Cars have average horsepower of: %.2f.%n", carsHorsepower * 1.0 / cars.size());
        }

        if (trucks.isEmpty()) {
            System.out.println("Trucks have average horsepower of: 0.00.");
        } else {
            System.out.printf("Trucks have average horsepower of: %.2f.%n", trucksHorsepower * 1.0 / trucks.size());
        }
    }
}
