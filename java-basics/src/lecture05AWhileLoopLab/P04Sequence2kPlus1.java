package lecture05AWhileLoopLab;

import java.util.Scanner;

public class P04Sequence2kPlus1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        int progression = 1;

        while (progression <= n) {
            System.out.println(progression);

            progression = progression * 2 +1;
        }
    }
}
