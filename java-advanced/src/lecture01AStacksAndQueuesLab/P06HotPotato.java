package lecture01AStacksAndQueuesLab;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class P06HotPotato {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] tokens = scanner.nextLine().split("\\s+");

        Deque<String> players = new ArrayDeque<>();

        for (String player : tokens) {
            players.offer(player);
        }

        int hotPotatoStep = Integer.parseInt(scanner.nextLine());
        int counter = 0;

        while (players.size() != 1) {
            counter++;

            if (counter % hotPotatoStep == 0) {
                System.out.printf("Removed %s%n", players.poll());
            } else {
                players.offer(players.poll());
            }
        }

        System.out.printf("Last is %s%n", players.poll());
    }
}
