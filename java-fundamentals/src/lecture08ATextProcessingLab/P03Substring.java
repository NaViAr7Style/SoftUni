package lecture08ATextProcessingLab;

import java.util.Scanner;

public class P03Substring {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String sub = scanner.nextLine();
        String input = scanner.nextLine();

        while (input.contains(sub)) {
            input = input.replace(sub, "");
        }

        System.out.println(input);
    }
}
