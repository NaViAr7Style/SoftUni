package lecture08ATextProcessingLab;

import java.util.Scanner;

public class P01ReverseStrings {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        while (!input.equals("end")) {
            StringBuilder reverse = new StringBuilder();

            for (int i = input.length() - 1; i >= 0; i--) {
                reverse.append(input.charAt(i));
            }

            System.out.printf("%s = %s%n", input, reverse);

            input = scanner.nextLine();
        }
    }
}
