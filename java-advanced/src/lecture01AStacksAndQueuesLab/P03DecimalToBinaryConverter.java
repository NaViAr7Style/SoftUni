package lecture01AStacksAndQueuesLab;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class P03DecimalToBinaryConverter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numToConvert = Integer.parseInt(scanner.nextLine());

        Deque<Integer> binaryConverter = new ArrayDeque<>();

        while (numToConvert != 0) {
            binaryConverter.push(numToConvert % 2);
            numToConvert /= 2;
        }

        if (binaryConverter.isEmpty()) {
            System.out.println(0);
        } else {
            while (!binaryConverter.isEmpty()) {
                System.out.print(binaryConverter.pop());
            }
            System.out.println();
        }
    }
}
