package lecture04BStreamsFilesAndDirectoriesExercise;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class P07MergeTwoFiles {

    public static void main(String[] args) throws IOException {

        Path firstFile = Paths.get("resources/inputOne.txt");
        List<String> firstFileLines = Files.readAllLines(firstFile);

        Path secondFile = Paths.get("resources/inputTwo.txt");
        List<String> secondFileLines = Files.readAllLines(secondFile);

        Path output = Paths.get("resources/output.txt");

        Files.write(output, firstFileLines);
        Files.write(output, secondFileLines, StandardOpenOption.APPEND);
    }
}