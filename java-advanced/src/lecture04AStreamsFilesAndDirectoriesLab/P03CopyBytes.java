package lecture04AStreamsFilesAndDirectoriesLab;

import java.io.*;

public class P03CopyBytes {

    public static void main(String[] args) throws IOException {

        BufferedInputStream bis = new BufferedInputStream(new FileInputStream("resourcesLab/input.txt"));
        PrintWriter printer = new PrintWriter("resourcesLab/03.CopyBytesOutput.txt");

        int oneByte = bis.read();

        while (oneByte >= 0) {

            if (oneByte == 10 || oneByte == 32) {
                printer.write(oneByte);
            } else {
                printer.print(oneByte);
            }

            oneByte = bis.read();
        }

        bis.close();
        printer.close();
    }
}