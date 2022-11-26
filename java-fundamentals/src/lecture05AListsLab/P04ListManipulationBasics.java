package lecture05AListsLab;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P04ListManipulationBasics {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numList = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());

        String input = scanner.nextLine();

        while (!input.equalsIgnoreCase("end")) {
            List<String> commandLine = Arrays.stream(input.split(" ")).collect(Collectors.toList());

            int item = 0;

            switch (commandLine.get(0)) {
                case "Add":
                    item = Integer.parseInt(commandLine.get(1));
                    numList.add(item);
                    break;
                case "Remove":
                    item = Integer.parseInt(commandLine.get(1));
                    numList.remove(Integer.valueOf(item));
                    break;
                case "RemoveAt":
                    item = Integer.parseInt(commandLine.get(1));
                    numList.remove(item);
                    break;
                case "Insert":
                    item = Integer.parseInt(commandLine.get(1));
                    int index = Integer.parseInt(commandLine.get(2));
                    numList.add(index, item);
                    break;
            }

            input = scanner.nextLine();
        }

        System.out.println(numList.toString().replaceAll("[\\[\\],]", ""));
    }
}
