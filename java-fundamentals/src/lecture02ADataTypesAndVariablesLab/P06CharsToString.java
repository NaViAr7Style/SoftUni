package lecture02ADataTypesAndVariablesLab;

import java.util.Scanner;

public class P06CharsToString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char firstInput = scanner.nextLine().charAt(0);
        char secondInput = scanner.nextLine().charAt(0);
        char thirdInput = scanner.nextLine().charAt(0);

        System.out.printf("%c%c%c", firstInput, secondInput, thirdInput);
    }
}
