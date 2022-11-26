package lecture10BExamPreparationExercise;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

public class P01Lootbox {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Deque<Integer> queue = new ArrayDeque<>();
        Deque<Integer> stack = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .forEach(queue::offer);

        Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .forEach(stack::push);

        int loot = 0;

        while (!queue.isEmpty() && !stack.isEmpty()) {
            int firstNum = queue.peek();
            int lastNum = stack.pop();

            int sum = firstNum + lastNum;

            if (sum % 2 == 0) {
                loot += sum;
                queue.poll();
            } else {
                queue.offer(lastNum);
            }
        }

        String emptyBox = queue.isEmpty() ? "First lootbox is empty"
                : "Second lootbox is empty";
        String lootValue = loot >= 100 ? String.format("Your loot was epic! Value: %d", loot)
                : String.format("Your loot was poor... Value: %d", loot);

        System.out.println(emptyBox);
        System.out.println(lootValue);
    }
}