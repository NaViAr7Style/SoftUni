package lecture01BStacksAndQueuesExercise;

import java.util.*;

public class P04BasicQueueOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(" ");

        int countToOffer = Integer.parseInt(input[0]);
        int countToPoll = Integer.parseInt(input[1]);
        int elementToSearch = Integer.parseInt(input[2]);

        int[] numArray = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Deque<Integer> queue = new ArrayDeque<>();

        for (int i = 0; i < countToOffer; i++) {
            queue.offer(numArray[i]);
        }

        for (int i = 0; i < countToPoll; i++) {
            queue.poll();
        }

        if (queue.isEmpty()) {
            System.out.println(0);
        } else if (queue.contains(elementToSearch)) {
            System.out.println(true);
        } else {
            System.out.println(Collections.min(queue));
        }
    }
}
