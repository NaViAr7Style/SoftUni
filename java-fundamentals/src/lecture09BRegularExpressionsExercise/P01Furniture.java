package lecture09BRegularExpressionsExercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P01Furniture {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        List<String> furniture = new ArrayList<>();
        double totalCost = 0;
        Pattern pattern = Pattern.compile(">>(\\w+)<<(\\d+.?\\d*)!(\\d+)");

        while (!input.equals("Purchase")) {
            Matcher matcher = pattern.matcher(input);

            if (matcher.find()) {
                double currentCost = Double.parseDouble(matcher.group(2)) * Integer.parseInt(matcher.group(3));
                totalCost += currentCost;
                furniture.add(matcher.group(1));
            }

            input = scanner.nextLine();
        }

        System.out.println("Bought furniture:");

        for (String s : furniture) {
            System.out.println(s);
        }

        System.out.printf("Total money spend: %.2f%n", totalCost);
    }
}
