package lecture08AExceptionsAndErrorHandling;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P03EnterNumbers {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int start = 1;
        int end = 100;

        List<Integer> numbersInRange = new ArrayList<>();

        while (numbersInRange.size() < 10) {

            try {
                start = readNumber(start, end, scanner);
                numbersInRange.add(start);
            } catch (NumberFormatException e) {
                System.out.println("Invalid Number!");
            } catch (IllegalStateException e) {
                System.out.println(e.getMessage());
            }
        }

        System.out.println(numbersInRange.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(", ")));
    }

    private static int readNumber(int start, int end, Scanner scanner) {
        int number = Integer.parseInt(scanner.nextLine());

        if (number <= start || end <= number) {
            throw new IllegalStateException("Your number is not in range " + start + " - 100!");
        }

        return number;
    }
}