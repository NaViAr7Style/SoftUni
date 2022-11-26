package lecture04AMethodsLab;

import java.util.Scanner;

public class P09GreaterOfTwoValues {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String dataType = scanner.nextLine();

        switch (dataType) {
            case "int":
                int firstNum = Integer.parseInt(scanner.nextLine());
                int secondNum = Integer.parseInt(scanner.nextLine());
                System.out.println(getMax(firstNum, secondNum));
                break;
            case "char":
                char firstChar = scanner.nextLine().charAt(0);
                char secondChar = scanner.nextLine().charAt(0);
                System.out.println(getMax(firstChar, secondChar));
                break;
            case "string":
                String firstString = scanner.nextLine();
                String secondString = scanner.nextLine();
                System.out.println(getMax(firstString, secondString));
                break;
        }
    }

    public static int getMax(int a, int b) {
        if (a >= b) {
            return a;
        } else {
            return b;
        }
    }

    public static char getMax(char a, char b) {
        if (a >= b) {
            return a;
        } else {
            return b;
        }
    }

    public static String getMax(String a, String b) {
        String result = "";

        if (a.compareTo(b) > 0) {
            result = a;
        } else {
            result = b;
        }

        return result;
    }
}
