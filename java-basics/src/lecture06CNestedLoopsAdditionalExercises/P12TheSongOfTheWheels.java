package lecture06CNestedLoopsAdditionalExercises;

import java.util.Scanner;

public class P12TheSongOfTheWheels {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int controlNumber = Integer.parseInt(scanner.nextLine());

        int counter = 0;
        boolean isFound = false;
        StringBuilder password = new StringBuilder();

        for (int a = 1; a <= 8; a++) {
            for (int b = 2; b <= 9; b++) {
                if (a >= b) {
                    continue;
                } else {
                    for (int c = 2; c <= 9; c++) {
                        for (int d = 1; d <= 8; d++) {
                            if (c <= d) {
                                continue;
                            } else if (a * b + c * d == controlNumber) {
                                System.out.printf("%d%d%d%d ", a, b, c, d);
                                counter++;
                                if (counter == 4) {
                                    isFound = true;
                                    password.append(a).append(b).append(c).append(d);
                                }
                            }
                        }
                    }
                }
            }
        }


        if (isFound) {
            System.out.printf("%nPassword: %s%n", password);
        } else if (counter == 0) {
            System.out.println("No!");
        } else {
            System.out.println("%nNo!");
        }
    }
}
