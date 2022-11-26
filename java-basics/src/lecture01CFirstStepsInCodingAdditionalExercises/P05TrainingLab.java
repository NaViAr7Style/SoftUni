package lecture01CFirstStepsInCodingAdditionalExercises;

import java.util.Scanner;

public class P05TrainingLab {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double w, h;
        do {
            w = Double.parseDouble(scanner.nextLine());
            h = Double.parseDouble(scanner.nextLine());
        } while (h < 3 || h > w || w > 100);

        double widthInCm = w * 100;
        double heightInCm = h * 100;

        int desksPerRow = (int) (heightInCm - 100) / 70;
        int rows = (int) widthInCm / 120;

        int workstations = rows * desksPerRow - 3;

        System.out.println(workstations);
    }
}
