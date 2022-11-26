package lecture02ADataTypesAndVariablesLab;

import java.util.Scanner;

public class P08LowerOrUpper {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char symbol = scanner.nextLine().charAt(0);

//        if (65 <= symbol && symbol <= 90) {
//            System.out.println("upper-case");
//        } else if (97 <= symbol && symbol <= 122) {
//            System.out.println("lower-case");
//        }

        if (Character.isUpperCase(symbol)) {
            System.out.println("upper-case");
        } else if (Character.isLowerCase(symbol)) {
            System.out.println("lower-case");
        }
    }
}
