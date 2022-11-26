package lecture05BWhileLoopExercise;

import java.util.Scanner;

public class P06Cake {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int cakeWidth = Integer.parseInt(scanner.nextLine());
        int cakeLength = Integer.parseInt(scanner.nextLine());

        int cakePieces = cakeWidth * cakeLength;
        boolean isEaten = false;

        String input = scanner.nextLine();

        while (!input.equals("STOP")) {
            int piecesTaken = Integer.parseInt(input);
            cakePieces -= piecesTaken;

            if (cakePieces <= 0) {
                isEaten = true;
                break;
            }

            input = scanner.nextLine();
        }

        if (isEaten) {
            System.out.printf("No more cake left! You need %d pieces more.%n", cakePieces * (-1));
        } else {
            System.out.printf("%d pieces are left.%n", cakePieces);
        }
    }
}
