package lecture04AStreamsFilesAndDirectoriesLab;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;

public class P06SortLines {

    public static void main(String[] args) throws IOException {

        Path path = Paths.get("resourcesLab/input.txt");

        List<String> allLines = Files.readAllLines(path);

        Collections.sort(allLines);

        PrintWriter printer = new PrintWriter("resourcesLab/06.SortLinesOutput.txt");

        for (String line : allLines) {
            printer.println(line);
        }

        printer.close();
    }
}
