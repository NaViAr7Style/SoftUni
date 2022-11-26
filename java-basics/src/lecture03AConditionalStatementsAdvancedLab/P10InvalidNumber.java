package lecture03AConditionalStatementsAdvancedLab;

import java.util.Scanner;

public class P10InvalidNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());
        boolean isValid = (100 <= number && number <= 200) || number == 0;

        if (!isValid) {
            System.out.println("invalid");
        }
    }
}
