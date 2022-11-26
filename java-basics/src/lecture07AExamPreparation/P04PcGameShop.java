package lecture07AExamPreparation;

import java.util.Scanner;

public class P04PcGameShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int soldCopies = Integer.parseInt(scanner.nextLine());

        int hearthstoneCounter = 0;
        int fortniteCounter = 0;
        int overwatchCounter = 0;
        int othersCounter = 0;

        for (int i = 1; i <= soldCopies; i++) {
            String gameTitle = scanner.nextLine();

            switch (gameTitle) {
                case "Hearthstone":
                    hearthstoneCounter++;
                    break;
                case "Fornite":
                    fortniteCounter++;
                    break;
                case "Overwatch":
                    overwatchCounter++;
                    break;
                default: othersCounter++;
            }
        }

        System.out.printf("Hearthstone - %.2f%%%n", hearthstoneCounter * 100.0 / soldCopies);
        System.out.printf("Fornite - %.2f%%%n", fortniteCounter * 100.0 / soldCopies);
        System.out.printf("Overwatch - %.2f%%%n", overwatchCounter * 100.0 / soldCopies);
        System.out.printf("Others - %.2f%%%n", othersCounter * 100.0 / soldCopies);
    }
}
