package lecture02BEncapsulationExercise.shoppingSpree;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] people = scanner.nextLine().split(";");
        Map<String, Person> peopleMap = new LinkedHashMap<>();

        for (String personString : people) {
            String[] personData = personString.split("=");
            String name = personData[0];
            double money = Double.parseDouble(personData[1]);

            try {
                Person person = new Person(name, money);
                peopleMap.put(name, person);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                return;
            }
        }

        String[] products = scanner.nextLine().split(";");
        Map<String, Product> productMap = new LinkedHashMap<>();

        for (String productString : products) {
            String[] productData = productString.split("=");
            String name = productData[0];
            double cost = Double.parseDouble(productData[1]);

            try {
                Product product = new Product(name, cost);
                productMap.put(name, product);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                return;
            }
        }

        String command = scanner.nextLine();

        while (!"END".equals(command)) {
            String[] tokens = command.split("\\s+");
            String personName = tokens[0];
            String productName = tokens[1];

            Person person = peopleMap.get(personName);
            Product product = productMap.get(productName);

            try {
                person.buyProduct(product);
                System.out.printf("%s bought %s%n", personName, productName);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }

            command = scanner.nextLine();
        }

        peopleMap.values().forEach(System.out::println);
    }
}