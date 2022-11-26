package lecture05BListsExercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P04ListOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numList = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());

        String input = scanner.nextLine();

        while (!input.equalsIgnoreCase("end")) {
            String[] command = input.split(" ");

            switch (command[0]) {
                case "Add":
                    int addNum = Integer.parseInt(command[1]);
                    numList.add(addNum);
                    break;
                case "Insert":
                    int insertNum = Integer.parseInt(command[1]);
                    int insertIndex = Integer.parseInt(command[2]);
                    if (insertIndex < 0 || insertIndex >= numList.size()) {
                        System.out.println("Invalid index");
                    } else {
                        numList.add(insertIndex, insertNum);
                    }
                    break;
                case "Remove":
                    int removeIndex = Integer.parseInt(command[1]);
                    if (removeIndex < 0 || removeIndex >= numList.size()) {
                        System.out.println("Invalid index");
                    } else {
                        numList.remove(removeIndex);
                    }
                    break;
                case "Shift":
                    int loopCount = Integer.parseInt(command[2]);
                    if (command[1].equalsIgnoreCase("left")) {
                        for (int i = 1; i <= loopCount; i++) {
                            int element = numList.get(0);
                            numList.remove(0);
                            numList.add(element);
                        }
                    } else if (command[1].equalsIgnoreCase("right"))
                        for (int i = 1; i <= loopCount; i++) {
                            int element = numList.get(numList.size() - 1);
                            numList.remove(numList.size() - 1);
                            numList.add(0, element);
                        }
                    break;
            }

            input = scanner.nextLine();
        }

        System.out.println(numList.toString().replaceAll("[\\]\\[,]", ""));
    }
}
