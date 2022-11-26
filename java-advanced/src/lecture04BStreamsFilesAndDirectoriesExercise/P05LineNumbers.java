package lecture04BStreamsFilesAndDirectoriesExercise;

import java.io.*;

public class P05LineNumbers {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new FileReader("resources/inputLineNumbers.txt"));

        PrintWriter pw = new PrintWriter(new FileWriter("resources/output.txt"));

        String line = br.readLine();
        int lineCounter = 1;

        while (line != null) {
            pw.println(lineCounter + ". " + line);

            lineCounter++;
            line = br.readLine();
        }

        br.close();
        pw.close();
    }
}
