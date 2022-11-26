package lecture05BListsExercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class P03HouseParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int commandCount = Integer.parseInt(scanner.nextLine());
        List<String> guestList = new ArrayList<>();

        for (int i = 1; i <= commandCount; i++) {
            String[] command = scanner.nextLine().split(" ");
            boolean isOnTheList = false;

            for (String guest : guestList) {
                if (command[0].equals(guest) && command[2].equals("going!")) {
                    System.out.printf("%s is already in the list!%n", guest);
                    isOnTheList = true;
                    break;
                } else if (command[0].equals(guest) && command[2].equals("not")) {
                    guestList.remove(guest);
                    isOnTheList = true;
                    break;
                }
            }

            if (isOnTheList) {
                continue;
            }

            if (command[2].equals("going!")) {
                guestList.add(command[0]);
            } else if (command[2].equals("not")) {
                System.out.printf("%s is not in the list!%n", command[0]);
            }
        }

        for (String guest : guestList) {
            System.out.println(guest);
        }
    }
}
