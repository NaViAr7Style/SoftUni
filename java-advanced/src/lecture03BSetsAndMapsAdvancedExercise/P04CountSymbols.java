package lecture03BSetsAndMapsAdvancedExercise;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class P04CountSymbols {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Map<Character, Integer> symbolCount = new TreeMap<>();

        for (char symbol : input.toCharArray()) {
            symbolCount.putIfAbsent(symbol, 0);
            symbolCount.replace(symbol, symbolCount.get(symbol) + 1);
        }

        for (var entry : symbolCount.entrySet()) {
            System.out.printf("%c: %d time/s%n", entry.getKey(), entry.getValue());
        }
    }
}