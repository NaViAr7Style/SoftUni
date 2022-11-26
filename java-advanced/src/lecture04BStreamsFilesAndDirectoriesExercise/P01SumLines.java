package lecture04BStreamsFilesAndDirectoriesExercise;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class P01SumLines {

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new FileReader("resources/input.txt"));

        String row = bufferedReader.readLine();

        while (row != null) {
            int sum = 0;

            for (char symbol : row.toCharArray()) {
                sum += symbol;
            }

            System.out.println(sum);
            row = bufferedReader.readLine();
        }

        bufferedReader.close();
    }
}