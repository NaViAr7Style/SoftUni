package lecture05BListsExercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P06CardsGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> firstDeck = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        List<Integer> secondDeck = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());

        while (!firstDeck.isEmpty() && !secondDeck.isEmpty()) {
            int firstCard = firstDeck.get(0);
            int secondCard = secondDeck.get(0);

            if (firstCard > secondCard) {
                firstDeck.add(firstCard);
                firstDeck.add(secondCard);
                firstDeck.remove(0);
                secondDeck.remove(0);
            } else if (firstCard < secondCard) {
                secondDeck.add(secondCard);
                secondDeck.add(firstCard);
                firstDeck.remove(0);
                secondDeck.remove(0);
            } else {
                firstDeck.remove(0);
                secondDeck.remove(0);
            }
        }

        int sum = 0;

        if (firstDeck.isEmpty()) {
            for (int card : secondDeck) {
                sum += card;
            }
            System.out.printf("Second player wins! Sum: %d%n", sum);
        } else {
            for (int card : firstDeck) {
                sum += card;
            }
            System.out.printf("First player wins! Sum: %d%n", sum);
        }
    }
}
