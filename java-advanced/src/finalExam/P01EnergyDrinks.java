package finalExam;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

public class P01EnergyDrinks {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Deque<Integer> caffeineStack = new ArrayDeque<>();
        Deque<Integer> energyDrinks = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine().split(", "))
                .mapToInt(Integer::parseInt)
                .forEach(caffeineStack::push);

        Arrays.stream(scanner.nextLine().split(", "))
                .mapToInt(Integer::parseInt)
                .forEach(energyDrinks::offer);

        int caffeineLevel = 0;

        while (!caffeineStack.isEmpty() && !energyDrinks.isEmpty()) {
            int milligramsOfCaffeine = caffeineStack.pop();
            int currentDrink = energyDrinks.poll();

            int currentCaffeine = milligramsOfCaffeine * currentDrink;

            if (currentCaffeine + caffeineLevel <= 300) {
                caffeineLevel += currentCaffeine;
            } else {
                energyDrinks.offer(currentDrink);
                caffeineLevel = Math.max(caffeineLevel - 30, 0);
            }
        }

        if (energyDrinks.isEmpty()) {
            System.out.println("At least Stamat wasn't exceeding the maximum caffeine.");
        } else {
            String drinksLeft = energyDrinks.toString().replaceAll("[\\[\\]]", "");
            System.out.printf("Drinks left: %s%n", drinksLeft);
        }

        System.out.printf("Stamat is going to sleep with %d mg caffeine.%n", caffeineLevel);
    }
}