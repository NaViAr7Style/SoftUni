package lecture09BIteratorsAndComparatorsExercise;

import java.util.Arrays;
import java.util.Scanner;

public class MainListyIterator {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        ListyIterator listyIterator = null;

        while (!input.equals("END")) {
            String[] tokens = input.split("\\s+");
            String command = tokens[0];

            switch (command) {
                case "Create":

                    if (tokens.length > 1) {
                        String[] elementsArray = Arrays.copyOfRange(tokens, 1, tokens.length);
                        listyIterator = new ListyIterator(elementsArray);
                    } else {
                        listyIterator = new ListyIterator();
                    }

                    break;
                case "Move":
                    System.out.println(listyIterator.move());
                    break;
                case "HasNext":
                    System.out.println(listyIterator.hasNext());
                    break;
                case "Print":
                    try {
                        listyIterator.print();
                    } catch (IllegalStateException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case "PrintAll":
                    listyIterator.printAll();;
                    break;
            }

            input = scanner.nextLine();
        }
    }
}
