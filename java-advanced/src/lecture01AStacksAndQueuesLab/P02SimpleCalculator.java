package lecture01AStacksAndQueuesLab;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class P02SimpleCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("\\s+");
        Deque<Integer> calculator = new ArrayDeque<>();
        calculator.push(0);
        char nextOperation = '+';

        for (int i = 0; i < input.length; i++) {
            int currentNum = 0;

            switch (input[i].charAt(0)) {
                case '+':
                    nextOperation = '+';
                    break;
                case '-':
                    nextOperation = '-';
                    break;
                default:
                    currentNum = Integer.parseInt(input[i]);
            }

            int lastNum = calculator.peek();

            if (nextOperation == '+') {
                calculator.push(lastNum + currentNum);
            } else {
                calculator.push(lastNum - currentNum);
            }
        }

        System.out.println(calculator.pop());
    }
}