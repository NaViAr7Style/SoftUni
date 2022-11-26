package lecture06BObjectsAndClassesExercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class P04Articles2 {
    static class Article {
        private String title;
        private String content;
        private String author;

        public Article(String title, String content, String author) {
            this.title = title;
            this.content = content;
            this.author = author;
        }

        @Override
        public String toString() {
            return this.title + " - " + this.content + ": " + this.author;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        List<Article> articleList = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            String[] input = scanner.nextLine().split(", ");
            Article article = new Article(input[0], input[1], input[2]);
            articleList.add(article);
        }

        String input = scanner.nextLine();

        switch (input) {
            case "title":
            case "content":
            case "author":
                for (Article article : articleList) {
                    System.out.println(article);
                }
                break;
        }
    }
}
