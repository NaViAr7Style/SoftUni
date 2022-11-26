package lecture03AConditionalStatementsAdvancedLab;

import java.util.Scanner;

public class P06NumberInRange {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num = Integer.parseInt(scanner.nextLine());
        boolean isValid = -100 <= num && num <= 100 && num != 0;

        if (isValid) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
}
