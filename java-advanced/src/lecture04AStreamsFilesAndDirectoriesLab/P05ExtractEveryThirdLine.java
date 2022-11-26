package lecture04AStreamsFilesAndDirectoriesLab;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class P05ExtractEveryThirdLine {

    public static void main(String[] args) throws IOException {

        File file = new File("resourcesLab/input.txt");

        Scanner scanner = new Scanner(file);
        PrintWriter printer = new PrintWriter("resourcesLab/05.WriteEveryThirdLineOutput.txt");

        int counter = 0;

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            counter++;

            if (counter % 3 == 0) {
                printer.println(line);
            }
        }

        scanner.close();
        printer.close();
    }
}