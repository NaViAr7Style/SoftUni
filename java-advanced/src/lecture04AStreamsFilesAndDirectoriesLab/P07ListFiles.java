package lecture04AStreamsFilesAndDirectoriesLab;

import java.io.File;

public class P07ListFiles {

    public static void main(String[] args) {

        File address = new File("resourcesLab/Files-and-Streams");

        File[] files = address.listFiles();

        for (File file : files) {

            if (!file.isDirectory()) {
                System.out.printf("%s: [%s]%n", file.getName(), file.length());
            }
        }
    }
}