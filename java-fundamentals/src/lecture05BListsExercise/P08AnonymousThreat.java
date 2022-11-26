package lecture05BListsExercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P08AnonymousThreat {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> stringList = Arrays.stream(scanner.nextLine().split(" ")).collect(Collectors.toList());

        String input = scanner.nextLine();

        while (!input.equals("3:1")) {
            String[] command = input.split(" ");

            switch (command[0]) {
                case "merge":
                    int startingIndex = Integer.parseInt(command[1]);
                    int endingIndex = Integer.parseInt(command[2]);

                    if (startingIndex < 0) {
                        startingIndex = 0;
                    }

                    if (endingIndex >= stringList.size()) {
                        endingIndex = stringList.size() - 1;
                    }

                    if (startingIndex >= stringList.size() || endingIndex < 0) {
                        input = scanner.nextLine();
                        continue;
                    }

                    String result = "";
                    int loopCounter = endingIndex - startingIndex;

                    while (loopCounter >= 0) {
                        result += stringList.get(startingIndex);
                        stringList.remove(startingIndex);
                        loopCounter--;
                    }

                    stringList.add(startingIndex, result);
                    break;
                case "divide":
                    int index = Integer.parseInt(command[1]);
                    int partitionsCount = Integer.parseInt(command[2]);

                    String element = stringList.get(index);
                    stringList.remove(index);

                    int charCount = element.length() / partitionsCount;
                    int initialIndex = 0;
                    int endIndex = charCount;

                    for (int i = 1; i < partitionsCount; i++) {
                        stringList.add(index, element.substring(initialIndex, endIndex));
                        initialIndex += charCount;
                        endIndex += charCount;
                        index++;
                    }

                    stringList.add(index, element.substring(initialIndex));
                    break;
            }
            input = scanner.nextLine();
        }

        System.out.println(stringList.toString().replaceAll("[\\[\\],]", ""));
    }
}
