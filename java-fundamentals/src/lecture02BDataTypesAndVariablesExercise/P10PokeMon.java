package lecture02BDataTypesAndVariablesExercise;

import java.util.Scanner;

public class P10PokeMon {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int startPower = Integer.parseInt(scanner.nextLine());
        int distance = Integer.parseInt(scanner.nextLine());
        int exhaustionFactor = Integer.parseInt(scanner.nextLine());

        int pokePower = startPower;
        int pokedTargets = 0;

        while (pokePower >= distance) {
            pokedTargets++;
            pokePower -= distance;

            if (pokePower == startPower * 0.5) {
                if (exhaustionFactor > 0) {
                    pokePower /= exhaustionFactor;
                }
            }
        }

        System.out.println(pokePower);
        System.out.println(pokedTargets);
    }
}
