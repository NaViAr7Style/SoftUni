package lecture01BStacksAndQueuesExercise;

import java.util.*;

public class P10Robotics {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] robotList = scanner.nextLine().split(";");

        Map<String, Integer> robotProcessTime = new LinkedHashMap<>();
        Map<String, Integer> robotStatus = new LinkedHashMap<>();

        String inputTime = scanner.nextLine();
        int startingTime = getTimeInSeconds(inputTime);

        for (String entry : robotList) {
            String[] tokens = entry.split("-");

            String robotName = tokens[0];
            int processingTime = Integer.parseInt(tokens[1]);

            robotProcessTime.put(robotName, processingTime);
            robotStatus.put(robotName, startingTime);
        }

        Deque<String> productQueue = new ArrayDeque<>();

        String product = scanner.nextLine();

        while (!product.equals("End")) {
            productQueue.offer(product);
            product = scanner.nextLine();
        }

        while (!productQueue.isEmpty()) {
            String currentProduct = productQueue.poll();
            startingTime++;
            boolean isBeingProcessed = false;

            for (var robot : robotStatus.entrySet()) {
                if (startingTime >= robot.getValue()) {
                    int endingTime = startingTime + robotProcessTime.get(robot.getKey());
                    System.out.printf("%s - %s [%s]%n", robot.getKey(), currentProduct, convertTime(startingTime));
                    robotStatus.put(robot.getKey(), endingTime);

                    isBeingProcessed = true;
                    break;
                }
            }

            if (!isBeingProcessed) {
                productQueue.offer(currentProduct);
            }
        }
    }

    private static String convertTime(int time) {
        int hours = (time / 3600) % 24;
        int minutes = (time / 60) % 60;
        int seconds = time % 60;

        return String.format("%02d:%02d:%02d", hours, minutes, seconds);
    }

    private static int getTimeInSeconds(String time) {
        String[] tokens = time.split(":");

        int hours = Integer.parseInt(tokens[0]);
        int minutes = Integer.parseInt(tokens[1]);
        int seconds = Integer.parseInt(tokens[2]);

        return hours * 3600 + minutes * 60 + seconds;
    }
}