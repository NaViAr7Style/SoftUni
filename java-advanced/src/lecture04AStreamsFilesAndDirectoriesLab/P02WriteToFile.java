package lecture04AStreamsFilesAndDirectoriesLab;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.Set;

public class P02WriteToFile {

    public static void main(String[] args) throws IOException {

        File file = new File("resourcesLab/input.txt");

        Scanner scanner = new Scanner(file);
        PrintWriter pw = new PrintWriter("resourcesLab/02.WriteToFileOutput.txt");

        Set<Character> punctuationTable = Set.of(',', '.', '!', '?');

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            StringBuilder sb = new StringBuilder();

            for (char symbol : line.toCharArray()) {
                boolean isPunctuation = punctuationTable.contains(symbol);

                if (!isPunctuation) {
                    sb.append(symbol);
                }
            }

            pw.println(sb);
        }

        scanner.close();
        pw.close();
    }
}
