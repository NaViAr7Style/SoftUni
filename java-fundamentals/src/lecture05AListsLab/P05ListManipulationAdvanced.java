package lecture05AListsLab;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P05ListManipulationAdvanced {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numList = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());

        String input = scanner.nextLine();

        while (!input.equals("end")) {
            String[] command = input.split(" ");

            switch (command[0]) {
                case "Contains":
                    if (numList.contains(Integer.valueOf(command[1]))) {
                        System.out.print("Yes");
                    } else {
                        System.out.print("No such number");
                    }
                    break;
                case "Print":
                    if (command[1].equals("even")) {
                        for (int num : numList) {
                            if (num % 2 == 0) {
                                System.out.print(num + " ");
                            }
                        }

                    } else if (command[1].equals("odd")) {
                        for (int num : numList) {
                            if (num % 2 == 1) {
                                System.out.print(num + " ");
                            }
                        }
                    }
                    break;
                case "Get":
                    int sum = 0;
                    for (int num : numList) {
                        sum += num;
                    }
                    System.out.print(sum);
                    break;
                case "Filter":
                    int number = Integer.parseInt(command[2]);
                    switch (command[1]) {
                        case "<":
                            for (int num : numList) {
                                if (num < number) {
                                    System.out.print(num + " ");
                                }
                            }
                            break;
                        case ">":
                            for (int num : numList) {
                                if (num > number) {
                                    System.out.print(num + " ");
                                }
                            }
                            break;
                        case "<=":
                            for (int num : numList) {
                                if (num <= number) {
                                    System.out.print(num + " ");
                                }
                            }
                            break;
                        case ">=":
                            for (int num : numList) {
                                if (num >= number) {
                                    System.out.print(num + " ");
                                }
                            }
                            break;
                    }
                    break;
            }

            System.out.println();
            input = scanner.nextLine();
        }
    }
}
