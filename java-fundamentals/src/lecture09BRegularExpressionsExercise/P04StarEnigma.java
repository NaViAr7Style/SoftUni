package lecture09BRegularExpressionsExercise;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P04StarEnigma {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Pattern decryptCipher = Pattern.compile("[starSTAR]");

        List<String> attackedPlanets = new ArrayList<>();
        List<String> destroyedPlanets = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            String encryptedMessage = scanner.nextLine();
            Matcher decrypt = decryptCipher.matcher(encryptedMessage);

            int decryptCounter = 0;

            while (decrypt.find()) {
                decryptCounter++;
            }

            StringBuilder decryptedMessage = new StringBuilder();

            for (int j = 0; j < encryptedMessage.length(); j++) {
                char currentSymbol = encryptedMessage.charAt(j);
                currentSymbol -= decryptCounter;
                decryptedMessage.append(currentSymbol);
            }

            Pattern pattern = Pattern.compile("@(?<planetName>[A-Za-z]+)[^@\\-!\\:>]*:(?<population>\\d+)[^@\\-!\\:>]*!(?<attackType>[AD])![^@\\-!\\:>]*->(?<soldierCount>\\d+)");
            Matcher matcher = pattern.matcher(decryptedMessage);

            if (matcher.find()) {
                String currentPlanet = matcher.group("planetName");
                String attackType = matcher.group("attackType");

                if (attackType.equals("A")) {
                    attackedPlanets.add(currentPlanet);
                } else if (attackType.equals("D")) {
                    destroyedPlanets.add(currentPlanet);
                }
            }
        }

        System.out.printf("Attacked planets: %d%n", attackedPlanets.size());
        Collections.sort(attackedPlanets);
        for (String planet : attackedPlanets) {
            System.out.println("-> " + planet);
        }

        System.out.printf("Destroyed planets: %d%n", destroyedPlanets.size());
        Collections.sort(destroyedPlanets);
        for (String planet : destroyedPlanets) {
            System.out.println("-> " + planet);
        }
    }
}
