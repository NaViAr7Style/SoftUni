package lecture01ABasicSyntaxConditionalStatementsAndLoopsLab;

import java.util.Scanner;

public class P09SumOfOddNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num = Integer.parseInt(scanner.nextLine());
        int sum = 0;

        for (int i = 1; i <= num * 2; i += 2) {
            System.out.println(i);
            sum += i;
        }

        System.out.printf("Sum: %d", sum);
    }
}
