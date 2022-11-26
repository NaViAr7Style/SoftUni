package lecture02CDataTypesAndVariablesAdditionalExercises;

import java.util.Scanner;

public class P06BalancedBrackets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        char nextBracket = '(';
        char previousBracket = ')';
        boolean areBalanced = true;
        int constant = 1;

        for (int i = 1; i <= n; i++) {
            String input = scanner.nextLine();

            if (input.length() == 1 && input.charAt(0) == previousBracket) {
                areBalanced = false;
            } else if (input.length() == 1 && input.charAt(0) == nextBracket) {
                nextBracket += constant;
                previousBracket -= constant;
                constant *= -1;
            }
        }

        if (areBalanced && previousBracket != '(') {
            System.out.println("BALANCED");
        } else {
            System.out.println("UNBALANCED");
        }
    }
}
