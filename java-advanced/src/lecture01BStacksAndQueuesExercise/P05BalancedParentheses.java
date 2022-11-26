package lecture01BStacksAndQueuesExercise;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class P05BalancedParentheses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        Deque<Character> openingBrackets = new ArrayDeque<>();
        boolean isBalanced = true;

        for (char bracket : input.toCharArray()) {
            if (bracket == '(' || bracket == '{' || bracket == '[') {
                openingBrackets.push(bracket);
            } else {
                if (openingBrackets.isEmpty()) {
                    isBalanced = false;
                    break;
                }
                char lastOpeningBracket = openingBrackets.pop();
                if (bracket == ')' && lastOpeningBracket != '(') {
                    isBalanced = false;
                    break;
                } else if (bracket == '}' && lastOpeningBracket != '{') {
                    isBalanced = false;
                    break;
                } else if (bracket == ']' && lastOpeningBracket != '[') {
                    isBalanced = false;
                    break;
                }
            }
        }

        if (isBalanced && openingBrackets.isEmpty()) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
