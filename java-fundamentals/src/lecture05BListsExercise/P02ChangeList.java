package lecture05BListsExercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P02ChangeList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numList = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());

        String input = scanner.nextLine();

        while (!input.equalsIgnoreCase("end")) {
            String[] command = input.split(" ");

            int element = Integer.parseInt(command[1]);

            switch (command[0]) {
                case "Delete":
                    numList.removeAll(Arrays.asList(element));
                    break;
                case "Insert":
                    int index = Integer.parseInt(command[2]);
                    numList.add(index, element);
                    break;
            }

            input = scanner.nextLine();
        }

        System.out.println(numList.toString().replaceAll("[\\]\\[,]", ""));
    }
}
