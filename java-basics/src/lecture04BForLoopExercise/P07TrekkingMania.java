package lecture04BForLoopExercise;

import java.util.Scanner;

public class P07TrekkingMania {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int groupCount = Integer.parseInt(scanner.nextLine());

        int t1 = 0;
        int t2 = 0;
        int t3 = 0;
        int t4 = 0;
        int t5 = 0;
        int headCount = 0;

        for (int i = 1; i <= groupCount; i++) {
            int groupSize = Integer.parseInt(scanner.nextLine());
            headCount += groupSize;
            if (groupSize < 6) {
                t1 += groupSize;
            } else if (groupSize < 13) {
                t2 += groupSize;
            } else if (groupSize < 26) {
                t3 += groupSize;
            } else if (groupSize < 41) {
                t4 += groupSize;
            } else {
                t5 += groupSize;
            }
        }

        System.out.printf("%.2f%%%n", t1 * 100.0 / headCount);
        System.out.printf("%.2f%%%n", t2 * 100.0 / headCount);
        System.out.printf("%.2f%%%n", t3 * 100.0 / headCount);
        System.out.printf("%.2f%%%n", t4 * 100.0 / headCount);
        System.out.printf("%.2f%%%n", t5 * 100.0 / headCount);
    }
}
