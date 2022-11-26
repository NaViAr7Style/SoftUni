package lecture01CBasicSyntaxConditionalStatementsAndLoopsAdditionalExercises;

import java.util.Scanner;

public class P01SortNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int firstNum = Integer.parseInt(scanner.nextLine());
        int secondNum = Integer.parseInt(scanner.nextLine());
        int thirdNum = Integer.parseInt(scanner.nextLine());

        int sum = firstNum + secondNum + thirdNum;
        int max = Math.max(Math.max(firstNum, secondNum), thirdNum);
        int min = Math.min(Math.min(firstNum, secondNum), thirdNum);

        System.out.println(max);
        System.out.println(sum - max - min);
        System.out.println(min);
    }
}
