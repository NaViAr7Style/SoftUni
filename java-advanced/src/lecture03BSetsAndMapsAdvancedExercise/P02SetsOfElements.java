package lecture03BSetsAndMapsAdvancedExercise;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class P02SetsOfElements {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int firstSetSize = scanner.nextInt();
        int secondSetSize = scanner.nextInt();

        Set<Integer> firstSet = new LinkedHashSet<>();


        for (int i = 0; i < firstSetSize; i++) {
            firstSet.add(scanner.nextInt());
        }

        Set<Integer> secondSet = new LinkedHashSet<>();

        for (int i = 0; i < secondSetSize; i++) {
            secondSet.add(scanner.nextInt());
        }

        firstSet.retainAll(secondSet);

        for (Integer num : firstSet) {
            System.out.print(num + " ");
        }
    }
}
