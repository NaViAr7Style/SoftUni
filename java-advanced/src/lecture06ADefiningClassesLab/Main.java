package lecture06ADefiningClassesLab;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        List<Car> carList = new ArrayList<>();

        while (n-- > 0) {
            String[] tokens = scanner.nextLine().split("\\s+");

            Car car = tokens.length== 1
                    ? new Car(tokens[0])
                    : new Car(tokens[0], tokens[1], Integer.parseInt(tokens[2]));

            carList.add(car);
        }

        for (Car car : carList) {
            System.out.println(car);
        }
    }
}