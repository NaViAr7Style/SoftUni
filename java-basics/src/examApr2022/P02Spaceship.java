package examApr2022;

import java.util.Scanner;

public class P02Spaceship {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double width = Double.parseDouble(scanner.nextLine());
        double length = Double.parseDouble(scanner.nextLine());
        double height = Double.parseDouble(scanner.nextLine());
        double averageHeight = Double.parseDouble(scanner.nextLine());

        double totalVolume = width * length * height;
        double roomVolume = 4 * (averageHeight + 0.40);

        int headcount = (int) Math.floor(totalVolume / roomVolume);

        if (headcount < 3) {
            System.out.println("The spacecraft is too small.");
        } else if (headcount <= 10) {
            System.out.printf("The spacecraft holds %d astronauts.%n", headcount);
        } else {
            System.out.println("The spacecraft is too big.");
        }
    }
}
