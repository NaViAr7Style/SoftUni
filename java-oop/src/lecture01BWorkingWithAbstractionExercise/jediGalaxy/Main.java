package lecture01BWorkingWithAbstractionExercise.jediGalaxy;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] dimensions = readPositions(scanner);

        int rows = dimensions[0];
        int cols = dimensions[1];

        Field field = new Field(rows, cols);

        long starsCollected = 0;
        String command = scanner.nextLine();

        while (!command.equals("Let the Force be with you")) {
            int[] jediPositions = Arrays.stream(command.split("\\s+")).mapToInt(Integer::parseInt).toArray();
            Jedi jedi = new Jedi(jediPositions);
            EvilPower evilPower = new EvilPower(readPositions(scanner));
            Galaxy galaxy = new Galaxy(field, jedi, evilPower);

            galaxy.moveEvil();
            starsCollected += galaxy.moveJedi();

            command = scanner.nextLine();
        }

        System.out.println(starsCollected);
    }

    private static int[] readPositions(Scanner scanner) {
        return Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
    }
}