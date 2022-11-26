package lecture06CNestedLoopsAdditionalExercises;

import java.util.Scanner;

public class P05ChallengeTheWedding {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int maleClients = Integer.parseInt(scanner.nextLine());
        int femaleClients = Integer.parseInt(scanner.nextLine());
        int tablesCount = Integer.parseInt(scanner.nextLine());

        int counter = 0;
        boolean isFull = false;

        for (int i = 1; i <= maleClients; i++) {
            for (int j = 1; j <= femaleClients; j++) {
                System.out.printf("(%d <-> %d) ", i, j);
                counter++;

                if (counter >= tablesCount) {
                    isFull = true;
                    break;
                }
            }

            if (isFull) {
                break;
            }
        }

        System.out.println();
    }
}
