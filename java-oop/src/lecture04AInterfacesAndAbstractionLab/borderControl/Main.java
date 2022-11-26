package lecture04AInterfacesAndAbstractionLab.borderControl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        List<Identifiable> identifiables = new ArrayList<>();

        while (!"End".equals(input)) {
            String[] info = input.split("\\s+");

            Identifiable identifiable;

            if (info.length == 3) {
                String name = info[0];
                int age = Integer.parseInt(info[1]);
                String id = info[2];

                identifiable = new Citizen(name, age, id);

            } else {
                String model = info[0];
                String id = info[1];

                identifiable = new Robot(model, id);
            }

            identifiables.add(identifiable);

            input = scanner.nextLine();
        }

        String fakeIdPostFix = scanner.nextLine();

        identifiables.stream()
                .map(Identifiable::getId)
                .filter(id -> id.endsWith(fakeIdPostFix))
                .forEach(System.out::println);
    }
}