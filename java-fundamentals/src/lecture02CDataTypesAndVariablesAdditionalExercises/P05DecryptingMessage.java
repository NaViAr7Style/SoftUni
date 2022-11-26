package lecture02CDataTypesAndVariablesAdditionalExercises;

import java.util.Scanner;

public class P05DecryptingMessage {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int key = Integer.parseInt(scanner.nextLine());
        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= n; i++) {
            char encryptedSymbol = scanner.nextLine().charAt(0);

            int decryptedAscii = (int) encryptedSymbol + key;

            char decryptedSymbol = (char) decryptedAscii;

            System.out.print(decryptedSymbol);
        }

        System.out.println();
    }
}
