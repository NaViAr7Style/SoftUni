package lecture05BListsExercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P05BombNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numList = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());

        int[] numArray = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int bombNum = numArray[0];
        int bombPower = numArray[1];

        for (int i = 0; i < numList.size(); i++) {
            if (numList.get(i) == bombNum) {
                int startIndex = i - bombPower;
                int endIndex = i + bombPower;

                if (startIndex < 0) {
                    startIndex = 0;
                }
                if (endIndex >= numList.size()) {
                    endIndex = numList.size() - 1;
                }

                int loopCounter = endIndex - startIndex + 1;

                for (int j = 1; j <= loopCounter; j++) {
                    numList.remove(startIndex);
                }

                i = -1;
            }
        }

        int sum = 0;

        for (int num : numList) {
            sum += num;
        }

        System.out.println(sum);
    }
}
