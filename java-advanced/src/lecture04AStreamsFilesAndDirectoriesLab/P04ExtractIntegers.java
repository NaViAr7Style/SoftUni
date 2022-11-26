package lecture04AStreamsFilesAndDirectoriesLab;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class P04ExtractIntegers {

    public static void main(String[] args) throws IOException {

        File file = new File("resourcesLab/input.txt");

        Scanner scanner = new Scanner(file);
        PrintWriter printer = new PrintWriter("resourcesLab/04.ExtractIntegersOutput.txt");

        while (scanner.hasNext()) {

            if (scanner.hasNextInt()) {
                printer.println(scanner.nextInt());
            }

            scanner.next();
        }

        scanner.close();
        printer.close();
    }
}