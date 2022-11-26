package lecture02BEncapsulationExercise.classBoxDataValidation;

import java.util.Optional;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        double length = Double.parseDouble(scanner.nextLine());
        double width = Double.parseDouble(scanner.nextLine());
        double height = Double.parseDouble(scanner.nextLine());

        Optional<Box> box = Optional.empty();

        try {
            box = Optional.of(new Box(length, width, height));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        if (box.isPresent()) {
            System.out.printf("Surface Area - %.2f%n", box.get().calculateSurfaceArea());
            System.out.printf("Lateral Surface Area - %.2f%n", box.get().calculateLateralSurfaceArea());
            System.out.printf("Volume - %.2f%n", box.get().calculateVolume());
        }
    }
}