package lecture01BStacksAndQueuesExercise;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class P08InfixToPostfix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] tokens = scanner.nextLine().split(" ");
        Deque<String> output = new ArrayDeque<>();
        Deque<String> operators = new ArrayDeque<>();

        for (String token : tokens) {
            char symbol = token.charAt(0);

            switch (symbol) {
                case '+':
                case '-':
                    if (operators.isEmpty()) {
                        operators.push(token);
                    } else {
                        while (!operators.isEmpty() && !operators.peek().equals("(")) {
                            output.offer(operators.pop());
                        }
                        operators.push(token);
                    }
                    break;
                case '*':
                case '/':
                    if (operators.isEmpty()) {
                        operators.push(token);
                    } else {
                        while (operators.peek().equals("*") || operators.peek().equals("/")) {
                            output.offer(operators.pop());
                        }
                        operators.push(token);
                    }
                    break;
                case '(':
                    operators.push(token);
                    break;
                case ')':
                    while (!operators.peek().equals("(")) {
                        output.offer(operators.pop());
                    }
                    operators.pop();
                    break;
                default:
                    output.offer(token);
            }

        }

        while (!operators.isEmpty()) {
            output.offer(operators.pop());
        }

        while (!output.isEmpty()) {
            System.out.print(output.poll() + " ");
        }
    }
}