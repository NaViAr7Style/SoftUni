package lecture01AWorkingWithAbstractionLab.pointInRectangle;

import lecture01AWorkingWithAbstractionLab.rhombusOfStars.Point;
import lecture01AWorkingWithAbstractionLab.rhombusOfStars.Rectangle;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int[] coordinates = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int bottomLeftX = coordinates[0];
        int bottomLeftY = coordinates[1];
        int upperRightX = coordinates[2];
        int upperRightY = coordinates[3];

        Point bottomLeft = new Point(bottomLeftX, bottomLeftY);
        Point upperRight = new Point(upperRightX, upperRightY);
        Rectangle rectangle = new Rectangle(bottomLeft, upperRight);

        int pointsCount = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < pointsCount; i++) {
            int[] checkPointCoordinates = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            int x = checkPointCoordinates[0];
            int y = checkPointCoordinates[1];

            Point searchedPoint = new Point(x, y);

            System.out.println(rectangle.contains(searchedPoint));
        }
    }
}
