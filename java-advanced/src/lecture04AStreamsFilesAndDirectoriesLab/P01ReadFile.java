package lecture04AStreamsFilesAndDirectoriesLab;

import java.io.*;

public class P01ReadFile {

    public static void main(String[] args) throws IOException {

        FileInputStream fis = new FileInputStream("resourcesLab/input.txt");

        int oneByte = fis.read();

        while (oneByte >= 0) {

            System.out.printf("%s ", Integer.toBinaryString(oneByte));

            oneByte = fis.read();
        }

    }
}
