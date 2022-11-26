package lecture01BStacksAndQueuesExercise;

import java.util.Scanner;

public class P06RecursiveFibonacci {
    public static long[] memory;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        memory = new long[n + 1];
        System.out.println(fib(n));
    }

    public static long fib(int a) {
        if (a < 2) {
            return 1;
        }
        if (memory[a] != 0) {
            return memory[a];
        }
        memory[a] = fib(a - 1) + fib(a - 2);
        return fib(a - 1) + fib(a - 2);
    }
}
