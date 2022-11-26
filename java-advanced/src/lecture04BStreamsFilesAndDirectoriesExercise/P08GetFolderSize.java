package lecture04BStreamsFilesAndDirectoriesExercise;

import java.io.File;
import java.util.ArrayDeque;
import java.util.Deque;

public class P08GetFolderSize {

    public static void main(String[] args) {

        // #Breadth-first search - one of the 2 usual ways to search through a directory

        File folder = new File("resources/Exercises Resources");
        Deque<File> directories = new ArrayDeque<>();

        directories.offer(folder);

        int sumOfBytes = 0;

        while (!directories.isEmpty()) {

            File current = directories.poll();
            File[] files = current.listFiles();

            for (File file : files) {
                if (file.isDirectory()) {
                    directories.offer(file);
                } else {
                    sumOfBytes += file.length();
                }
            }
        }

        System.out.println(sumOfBytes);
    }
}
