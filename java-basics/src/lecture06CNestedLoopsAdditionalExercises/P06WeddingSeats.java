package lecture06CNestedLoopsAdditionalExercises;

import java.util.Scanner;

public class P06WeddingSeats {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String lastSector = scanner.nextLine();
        int firstSectorRows = Integer.parseInt(scanner.nextLine());
        int firstRowSeats = Integer.parseInt(scanner.nextLine());

        int lastSectorNum = lastSector.charAt(0);
        int rows = firstSectorRows;
        int seatCounter = 0;

        for (int i = 65; i <= lastSectorNum; i++) {
            for (int j = 1; j <= rows; j++) {
                char sector = (char) i;
                if (j % 2 == 1) {
                    for (int k = 97; k < 97 + firstRowSeats; k++) {
                        char seat = (char) k;
                        System.out.printf("%s%d%s%n", sector, j, seat);
                        seatCounter++;
                    }
                } else {
                    for (int k = 97; k < 99 + firstRowSeats; k++) {
                        char seat = (char) k;
                        System.out.printf("%s%d%s%n", sector, j, seat);
                        seatCounter++;
                    }
                }
            }
            rows++;
        }

        System.out.println(seatCounter);
    }
}
