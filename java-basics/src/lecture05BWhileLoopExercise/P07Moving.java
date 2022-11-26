package lecture05BWhileLoopExercise;

import java.util.Scanner;

public class P07Moving {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int flatWidth = Integer.parseInt(scanner.nextLine());
        int flatLength = Integer.parseInt(scanner.nextLine());
        int flatHeight = Integer.parseInt(scanner.nextLine());

        int spaceAvailable = flatWidth * flatLength * flatHeight;
        boolean isFull = false;

        String input = scanner.nextLine();

        while (!input.equals("Done")) {
            int boxesMoved = Integer.parseInt(input);
            spaceAvailable -= boxesMoved;

            if (spaceAvailable <= 0) {
                isFull = true;
                break;
            }

            input = scanner.nextLine();
        }

        if (isFull) {
            System.out.printf("No more free space! You need %d Cubic meters more.%n", spaceAvailable * (-1));
        } else {
            System.out.printf("%d Cubic meters left.%n", spaceAvailable);
        }
    }
}
