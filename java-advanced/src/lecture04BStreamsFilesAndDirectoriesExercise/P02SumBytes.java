package lecture04BStreamsFilesAndDirectoriesExercise;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class P02SumBytes {

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new FileReader("resources/input.txt"));

        String row = bufferedReader.readLine();

        int sum = 0;

        while (row != null) {

            for (char symbol : row.toCharArray()) {
                sum += symbol;
            }

            row = bufferedReader.readLine();
        }

        System.out.println(sum);

        bufferedReader.close();
    }
}
