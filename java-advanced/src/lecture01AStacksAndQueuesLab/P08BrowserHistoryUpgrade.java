package lecture01AStacksAndQueuesLab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class P08BrowserHistoryUpgrade {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<String> backHistory = new ArrayDeque<>();
        ArrayDeque<String> forwardHistory = new ArrayDeque<>();
        String currentUrl = null;
        String input = scanner.nextLine();

        while (!input.equals("Home")) {

            if (input.equals("back")) {
                if (backHistory.isEmpty()) {
                    System.out.println("no previous URLs");
                    input = scanner.nextLine();
                    continue;
                } else {
                    forwardHistory.push(currentUrl);
                    currentUrl = backHistory.pop();
                }
            } else if (input.equals("forward")) {
                if (forwardHistory.isEmpty()) {
                    System.out.println("no next URLs");
                    input = scanner.nextLine();
                    continue;
                } else {
                    backHistory.push(currentUrl);
                    currentUrl = forwardHistory.pop();
                }
            } else {
                if (currentUrl != null) {
                    backHistory.push(currentUrl);
                }
                currentUrl = input;
                forwardHistory.clear();
            }

            System.out.println(currentUrl);

            input = scanner.nextLine();
        }
    }
}
