package lecture06BObjectsAndClassesExercise;

import java.util.Scanner;

public class P02Articles {
    static class Article {
        private String title;
        private String content;
        private String author;

        public Article(String title, String content, String author) {
            this.title = title;
            this.content = content;
            this.author = author;
        }

        public void edit(String newContent) {
            this.content = newContent;
        }

        public void changeAuthor(String newAuthor) {
            this.author = newAuthor;
        }

        public void rename(String newTitle) {
            this.title = newTitle;
        }

        @Override
        public String toString() {
            return this.title + " - " + this.content + ": " + this.author;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(", ");
        Article newspaper = new Article(input[0], input[1], input[2]);

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= n; i++) {
            String[] command = scanner.nextLine().split(": ");

            switch (command[0]) {
                case "Edit":
                    newspaper.edit(command[1]);
                    break;
                case "ChangeAuthor":
                    newspaper.changeAuthor(command[1]);
                    break;
                case "Rename":
                    newspaper.rename(command[1]);
                    break;
            }
        }

        System.out.println(newspaper);
    }
}
