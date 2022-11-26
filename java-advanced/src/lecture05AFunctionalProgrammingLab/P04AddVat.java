package lecture05AFunctionalProgrammingLab;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.DoubleUnaryOperator;
import java.util.stream.Collectors;

public class P04AddVat {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        double[] prices = Arrays.stream(scanner.nextLine().split(", "))
                .mapToDouble(Double::parseDouble)
                .toArray();

        DoubleUnaryOperator addVat = e -> e * 1.20;

        Consumer<double[]> printPrices = e -> {
            System.out.println("Prices with VAT:");
            System.out.println(Arrays.stream(e)
                    .map(addVat)
                    .mapToObj(d -> String.format("%.2f", d))
                    .collect(Collectors.joining(System.lineSeparator())));
        };

        printPrices.accept(prices);
    }
}