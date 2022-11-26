package lecture01AStacksAndQueuesLab;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class P07MathPotato {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] tokens = scanner.nextLine().split("\\s+");

        Deque<String> players = new ArrayDeque<>();

        for (String player : tokens) {
            players.offer(player);
        }

        int hotPotatoStep = Integer.parseInt(scanner.nextLine());
        int playerCounter = 0;
        int cycleCounter = 1;

        while (players.size() != 1) {
            playerCounter++;

            if (playerCounter % hotPotatoStep == 0) {
                if (isPrime(cycleCounter)) {
                    System.out.printf("Prime %s%n", players.peek());
                } else {
                    System.out.printf("Removed %s%n", players.poll());
                }
                cycleCounter++;
                playerCounter = 0;
            } else {
                players.offer(players.poll());
            }

        }

        System.out.printf("Last is %s%n", players.poll());
    }

    public static boolean isPrime(int a) {
        if (a == 1) {
            return false;
        }

        for (int i = 2; i <= a / 2; i++) {
            if (a % i == 0) {
                return false;
            }
        }

        return true;
    }
}
