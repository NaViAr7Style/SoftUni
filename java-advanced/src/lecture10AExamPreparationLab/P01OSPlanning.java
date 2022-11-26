package lecture10AExamPreparationLab;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

public class P01OSPlanning {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int[] tasks = Arrays.stream(scanner.nextLine()
                .split(", "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int[] threads = Arrays.stream(scanner.nextLine()
                .split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int taskToKill = Integer.parseInt(scanner.nextLine());

        Deque<Integer> taskStack = new ArrayDeque<>();

        for (int task : tasks) {
            taskStack.push(task);
        }

        Deque<Integer> threadQueue = new ArrayDeque<>();

        for (int thread : threads) {
            threadQueue.offer(thread);
        }

        while (true) {
            int currentTask = taskStack.peek();

            if (currentTask == taskToKill) {
                break;
            }

            int currentThread = threadQueue.peek();

            if (currentThread >= currentTask) {
                taskStack.pop();
            }

            threadQueue.poll();
        }

        System.out.printf("Thread with value %d killed task %d%n", threadQueue.peek(), taskToKill);

        System.out.println(String.join(" ", threadQueue.toString().replaceAll("[\\[\\],]", "")));
    }
}