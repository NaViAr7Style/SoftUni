package midTerm01ExamPrep;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P03MovingTarget {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numList = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());

        String inputLine = scanner.nextLine();

        while (!inputLine.equals("End")) {
            String[] commandLine = inputLine.split(" ");
            String command = commandLine[0];
            int index = Integer.parseInt(commandLine[1]);
            int value = Integer.parseInt(commandLine[2]);

            switch (command) {
                case "Shoot":
                    if (invalidIndex(index, numList)) {
                        break;
                    }
                    numList.set(index, numList.get(index) - value);
                    numList.removeIf(e -> e <= 0);
                    break;
                case "Add":
                    if (invalidIndex(index, numList)) {
                        System.out.println("Invalid placement!");
                        break;
                    }
                    numList.add(index, value);
                    break;
                case "Strike":
                    if (index - value < 0 || index + value >= numList.size()) {
                        System.out.println("Strike missed!");
                        break;
                    }
                    int loopCounter = value * 2 + 1;

                    while (loopCounter > 0) {
                        numList.remove(index - value);
                        loopCounter--;
                    }
                    break;
            }

            inputLine = scanner.nextLine();
        }

        for (int i = 0; i < numList.size() - 1; i++) {
            System.out.print(numList.get(i) + "|");
        }
        System.out.println(numList.get(numList.size() - 1));
    }

    public static boolean invalidIndex(int index, List<Integer> list) {
        return index < 0 || index >= list.size();
    }
}
