package lecture02BDataTypesAndVariablesExercise;

import java.util.Scanner;

public class P09SpiceMustFlow {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int sourceYield = Integer.parseInt(scanner.nextLine());
        int spicesMined = 0;
        int daysMined = 0;

        while (sourceYield >= 100) {
            spicesMined += sourceYield;
            daysMined++;
            spicesMined -= 26;



            sourceYield -= 10;
        }

        if (spicesMined >= 26) {
            spicesMined -= 26;
        }

        System.out.println(daysMined);
        System.out.println(spicesMined);
    }
}
