package lecture08BTextProcessingExercise;

import java.util.Arrays;
import java.util.Scanner;

public class P03ExtractFile {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] directory = scanner.nextLine().split("\\\\");

        String[] file = directory[directory.length - 1].split("\\.");

        System.out.printf("File name: %s%n", file[0]);
        System.out.printf("File extension: %s%n", file[1]);
    }
}
