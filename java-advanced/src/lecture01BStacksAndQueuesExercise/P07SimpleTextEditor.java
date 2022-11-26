package lecture01BStacksAndQueuesExercise;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class P07SimpleTextEditor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int loopCounter = Integer.parseInt(scanner.nextLine());
        Deque<String> textHistory = new ArrayDeque<>();
        textHistory.push("");

        for (int i = 1; i <= loopCounter; i++) {
            String[] tokens = scanner.nextLine().split("\\s+");
            String command = tokens[0];

            switch (command) {
                case "1":
                    String textToAdd = tokens[1];
                    textHistory.push(textHistory.peek() + textToAdd);
                    break;
                case "2":
                    int charsToRemove = Integer.parseInt(tokens[1]);
                    textHistory.push(textHistory.peek().substring(0, textHistory.peek().length() - charsToRemove));
                    break;
                case "3":
                    int index = Integer.parseInt(tokens[1]) - 1;
                    System.out.println(textHistory.peek().charAt(index));
                    break;
                case "4":
                    textHistory.pop();
                    break;
            }
        }
    }
}
