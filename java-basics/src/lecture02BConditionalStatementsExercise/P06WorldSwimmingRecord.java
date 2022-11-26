package lecture02BConditionalStatementsExercise;

import java.util.Scanner;

public class P06WorldSwimmingRecord {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double worldRecord = Double.parseDouble(scanner.nextLine());
        double distance = Double.parseDouble(scanner.nextLine());
        double secondsPerMeter = Double.parseDouble(scanner.nextLine());

        double waterResistance = Math.floor(distance / 15);
        double totalTime = distance * secondsPerMeter + waterResistance * 12.5;
        double swimGap = worldRecord - totalTime;

        if (swimGap > 0) {
            System.out.printf("Yes, he succeeded! The new world record is %.2f seconds.", totalTime);
        } else {
            System.out.printf("No, he failed! He was %.2f seconds slower.", Math.abs(swimGap));
        }
    }
}
