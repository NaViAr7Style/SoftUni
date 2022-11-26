package lecture08BGenericsExerciseCustomList;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        CustomList<String> list = new CustomList<>();

        while (!input.equals("END")) {
            String[] tokens = input.split(" ");

            String command = tokens[0];

            switch (command) {
                case "Add":
                    String elementToAdd = tokens[1];
                    list.add(elementToAdd);
                    break;
                case "Remove":
                    int indexToRemove = Integer.parseInt(tokens[1]);
                    list.remove(indexToRemove);
                    break;
                case "Contains":
                    String elementToSearch = tokens[1];
                    System.out.println(list.contains(elementToSearch));
                    break;
                case "Swap":
                    int firstIndex = Integer.parseInt(tokens[1]);
                    int secondIndex = Integer.parseInt(tokens[2]);
                    list.swap(firstIndex,secondIndex);
                    break;
                case "Greater":
                    String elementToCompare = tokens[1];
                    System.out.println(list.countGreaterThan(elementToCompare));
                    break;
                case "Max":
                    System.out.println(list.getMax());
                    break;
                case "Min":
                    System.out.println(list.getMin());
                    break;
                case "Sort":
                    Sorter.sort(list);
                    break;
                case "Print":
                    System.out.println(list);
                    break;
            }

            input = scanner.nextLine();
        }
    }
}
