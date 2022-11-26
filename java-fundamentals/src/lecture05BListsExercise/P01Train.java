package lecture05BListsExercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P01Train {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> train = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        int wagonCapacity = Integer.parseInt(scanner.nextLine());
        String inputLine = scanner.nextLine();

        while (!inputLine.equals("end")) {
            String[] input = inputLine.split(" ");

            if (input[0].equals("Add")) {
                int passengers = Integer.parseInt(input[1]);
                train.add(passengers);
                inputLine = scanner.nextLine();
                continue;
            }
            int passengers = Integer.parseInt(input[0]);

            for (int i = 0; i < train.size(); i++) {
                if (train.get(i) + passengers <= wagonCapacity) {
                    passengers += train.get(i);
                    train.set(i, passengers);
                    break;
                }
            }

            inputLine = scanner.nextLine();
        }

        System.out.println(train.toString().replaceAll("[\\[\\],]", ""));
    }
}
