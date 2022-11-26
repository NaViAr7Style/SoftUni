package examApr2022;

import java.util.Scanner;

public class P04GiftsFromSanta {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int m = Integer.parseInt(scanner.nextLine());
        int s = Integer.parseInt(scanner.nextLine());

        for (int i = m; i >= n; i--) {
            boolean isDone = false;
            if (i % 6 == 0) {
                for (int j = i; j >= n; j -= 6) {
                    if (j == s) {
                        break;
                    } else {
                        System.out.printf("%d ", j);
                    }
                }
                isDone = true;
            }
            if (isDone) {
                break;
            }
        }
        System.out.println();


//        int t = 0;
//
//        for (int i = m; i >= n; i--) {
//            if (i % 6 == 0) {
//                t = i;
//                break;
//            }
//        }
//        for (int i = t; i >= n; i -= 6) {
//            if (i == s) {
//                break;
//            } else {
//                System.out.printf("%d ", i);
//            }
//        }

    }
}
