package lecture04AStreamsFilesAndDirectoriesLab;

import java.io.File;
import java.util.ArrayDeque;
import java.util.Deque;

public class P08NestedFolders {

    public static void main(String[] args) {

        File root = new File("resourcesLab/Files-and-Streams");

        int folderCount = 1;

        Deque<File> queue = new ArrayDeque<>();

        queue.offer(root);

        while (!queue.isEmpty()) {

            File currentFile = queue.poll();
            File[] files = currentFile.listFiles();

            if (files != null) {
                for (File file : files) {
                    if (file.isDirectory()) {
                        queue.offer(file);
                        folderCount++;
                    }
                }
            }

            System.out.println(currentFile.getName());
        }

        System.out.println(folderCount + " folders");
    }
}