package lecture06AObjectsAndClassesLab;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class P04Songs {
    static class Song {
        String typeList;
        String name;
        String duration;

        public void setTypeList(String typeList) {
            this.typeList = typeList;
        }

        public String getTypeList() {
            return this.typeList;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getName() {
            return this.name;
        }

        public void setDuration(String duration) {
            this.duration = duration;
        }

        public String getDuration() {
            return this.duration;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        List<Song> songList = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            String[] input = scanner.nextLine().split("_");

            String inputType = input[0];
            String inputName = input[1];
            String inputDuration = input[2];

            Song currentSong = new Song();

            currentSong.setTypeList(inputType);
            currentSong.setName(inputName);
            currentSong.setDuration(inputDuration);

            songList.add(currentSong);
        }

        String command = scanner.nextLine();

        if (command.equals("all")) {
            for (Song song : songList) {
                System.out.println(song.getName());
            }
        } else {
            for (Song song : songList) {
                if (song.getTypeList().equals(command)) {
                    System.out.println(song.getName());
                }
            }
        }
    }
}
