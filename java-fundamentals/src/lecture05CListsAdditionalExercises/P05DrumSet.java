package lecture05CListsAdditionalExercises;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P05DrumSet {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double savings = Double.parseDouble(scanner.nextLine());
        List<Integer> initialQuality = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        List<Integer> drums = new ArrayList<>(initialQuality);

        String input = scanner.nextLine();

        while (!input.equals("Hit it again, Gabsy!")) {
            int damage = Integer.parseInt(input);

            drums.replaceAll(e -> e - damage);

            for (int i = 0; i < drums.size(); i++) {
                int currentDrum = drums.get(i);

                if (currentDrum <= 0) {
                    int replacementCost = initialQuality.get(i) * 3;

                    if (savings - replacementCost >= 0) {
                        drums.set(i, initialQuality.get(i));
                        savings -= replacementCost;
                    } else {
                        drums.remove(i);
                        initialQuality.remove(i);
                        i--;
                    }
                }
            }

            input = scanner.nextLine();
        }

        System.out.println(drums.toString().replaceAll("[\\[\\],]", ""));
        System.out.printf("Gabsy has %.2flv.%n", savings);
    }
}
