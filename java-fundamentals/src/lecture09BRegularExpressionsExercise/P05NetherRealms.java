package lecture09BRegularExpressionsExercise;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P05NetherRealms {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(",\\s+");

        for (String demon : input) {
            Pattern hpPattern = Pattern.compile("[^0-9+\\-*\\/\\.]");
            Matcher hpMatcher = hpPattern.matcher(demon);

            int health = 0;

            while (hpMatcher.find()) {
                char symbol = hpMatcher.group().charAt(0);
                health += symbol;
            }

            Pattern basePattern = Pattern.compile("[+-]?\\d+\\.?\\d*");
            Matcher baseMatcher = basePattern.matcher(demon);

            double damage = 0;

            while (baseMatcher.find()) {
                double currentNum = Double.parseDouble(baseMatcher.group());
                damage += currentNum;
            }

            int multiplication = 0;
            int division = 0;

            for (int j = 0; j < demon.length(); j++) {
                char symbol = demon.charAt(j);

                if (symbol == '*') {
                    multiplication++;
                } else if (symbol == '/') {
                    division++;
                }
            }

            if (multiplication != 0) {
                damage *= Math.pow(2, multiplication);
            }

            if (division != 0) {
                damage /= Math.pow(2, division);
            }

            System.out.printf("%s - %d health, %.2f damage%n", demon, health, damage);
        }
    }
}
