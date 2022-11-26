package examApr2022;

import java.util.Scanner;

public class P01RoomPainting {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int paintBoxes = Integer.parseInt(scanner.nextLine());
        int wallpaperRolls = Integer.parseInt(scanner.nextLine());
        double glovePrice = Double.parseDouble(scanner.nextLine());
        double brushPrice = Double.parseDouble(scanner.nextLine());

        int gloveCount = (int) Math.ceil(wallpaperRolls * 0.35);
        int brushCount = (int) Math.floor(paintBoxes * 0.48);

        double totalCost = paintBoxes * 21.50 + wallpaperRolls * 5.20 + gloveCount * glovePrice + brushCount * brushPrice;

        System.out.printf("This delivery will cost %.2f lv.%n", totalCost / 15);
    }
}
