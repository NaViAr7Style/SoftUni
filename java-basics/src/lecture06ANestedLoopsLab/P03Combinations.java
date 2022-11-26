package lecture06ANestedLoopsLab;

import java.util.Scanner;

public class P03Combinations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = Integer.parseInt(scanner.nextLine());
        int counter = 0;

        for (int i = 0; i <= num; i++) {
            for (int j = 0; j <= num; j++) {
                for (int k = 0; k <= num; k++) {
                    int sum = i + j + k;

                    if (sum == num) {
                        counter++;
                    }
                }
            }
        }

        System.out.println(counter);
    }
}
