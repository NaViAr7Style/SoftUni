package lecture04BStreamsFilesAndDirectoriesExercise;

import java.io.*;

public class P03AllCapitals {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new FileReader("resources/input.txt"));

        PrintWriter pw = new PrintWriter(new FileWriter("resources/output.txt"));

        br.lines().forEach(line -> pw.println(line.toUpperCase()));

        br.close();
        pw.close();
    }
}
