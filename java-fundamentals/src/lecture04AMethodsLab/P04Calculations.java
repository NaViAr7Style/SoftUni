package lecture04AMethodsLab;


import java.util.Scanner;

public class P04Calculations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        int a = Integer.parseInt(scanner.nextLine());
        int b = Integer.parseInt(scanner.nextLine());

        executeOperation(input, a, b);
    }

    public static void executeOperation(String action, int a, int b) {
        switch (action) {
            case "add":
                printAdd(a, b);
                break;
            case "subtract":
                printSubtract(a, b);
                break;
            case "multiply":
                printMultiply(a, b);
                break;
            case "divide":
                printDivide(a, b);
                break;
        }
    }

    public static void printAdd(int a, int b) {
        System.out.println(a + b);
    }

    public static void printSubtract(int a, int b) {
        System.out.println(a - b);
    }

    public static void printMultiply(int a, int b) {
        System.out.println(a * b);
    }

    public static void printDivide(int a, int b) {
        if (b != 0) {
            System.out.println(a / b);
        } else {
            System.out.println("Cannot divide by 0!");
        }
    }
}
