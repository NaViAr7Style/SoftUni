package lecture01BStacksAndQueuesExercise;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Deque;
import java.util.Scanner;

public class P03MaximumElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int commandCount = Integer.parseInt(scanner.nextLine());
        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 1; i <= commandCount; i++) {
            String[] tokens = scanner.nextLine().split(" ");
            int command = Integer.parseInt(tokens[0]);

            switch (command) {
                case 1:
                    int numToPush = Integer.parseInt(tokens[1]);
                    stack.push(numToPush);
                    break;
                case 2:
                    stack.pop();
                    break;
                case 3:
                    System.out.println(Collections.max(stack));
                    break;
            }
        }
    }
}
