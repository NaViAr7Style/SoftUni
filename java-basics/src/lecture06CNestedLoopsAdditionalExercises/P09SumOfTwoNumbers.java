package lecture06CNestedLoopsAdditionalExercises;

import java.util.Scanner;

public class P09SumOfTwoNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int start = Integer.parseInt(scanner.nextLine());
        int end = Integer.parseInt(scanner.nextLine());
        int magicNum = Integer.parseInt(scanner.nextLine());

        int counter = 0;
        boolean isValid = false;

        for (int i = start; i <= end; i++) {
            for (int j = start; j <= end; j++) {
                counter++;
                int sum = i + j;

                if (sum == magicNum) {
                    System.out.printf("Combination N:%d (%d + %d = %d)%n", counter, i, j, sum);
                    isValid = true;
                    break;
                }
            }
            if (isValid) {
                break;
            }
        }

        if (!isValid) {
            System.out.printf("%d combinations - neither equals %d%n", counter, magicNum);
        }
    }
}
