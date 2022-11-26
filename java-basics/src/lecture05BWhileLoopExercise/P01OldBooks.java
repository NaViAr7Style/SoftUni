package lecture05BWhileLoopExercise;

import java.util.Scanner;

public class P01OldBooks {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String favouriteBook = scanner.nextLine();
        String bookTitle = scanner.nextLine();

        int bookCounter = 0;
        boolean isFound = false;

        while (!bookTitle.equals("No More Books")) {

            if (bookTitle.equals(favouriteBook)) {
                isFound = true;
                break;
            }

            bookCounter++;
            bookTitle = scanner.nextLine();
        }

        if (isFound) {
            System.out.printf("You checked %d books and found it.%n", bookCounter);
        } else {
            System.out.printf("The book you search is not here!%nYou checked %d books.%n", bookCounter);
        }
    }
}
