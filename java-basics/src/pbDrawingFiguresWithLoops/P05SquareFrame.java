package pbDrawingFiguresWithLoops;

import java.util.Scanner;

public class P05SquareFrame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        for (int rows = 1; rows <= n; rows++) {
            for (int cols = 1; cols <= n; cols++) {
                if ((rows == 1 && cols == 1) || (rows == 1 && cols == n) || (rows == n && cols == 1) || (rows == n && cols == n)) {
                    System.out.print("+ ");
                } else if ((rows != 1 && rows != n) && (cols == 1 || cols == n)) {
                    System.out.print("| ");
                } else {
                    System.out.print("- ");
                }
            }
            System.out.println();
        }
    }
}
