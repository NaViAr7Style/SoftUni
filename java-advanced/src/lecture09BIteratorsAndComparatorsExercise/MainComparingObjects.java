package lecture09BIteratorsAndComparatorsExercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainComparingObjects {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        List<Person> people = new ArrayList<>();

        while (!input.equals("END")) {
            String[] personalData = input.split("\\s+");

            String name = personalData[0];
            int age = Integer.parseInt(personalData[1]);
            String town = personalData[2];

            Person person = new Person(name, age, town);

            people.add(person);

            input = scanner.nextLine();
        }

        int mainPersonIndex = Integer.parseInt(scanner.nextLine());
        int similarPeople = 0;

        Person mainPerson = people.get(mainPersonIndex - 1);

        for (Person person : people) {
            if (mainPerson.compareTo(person) == 0) {
                similarPeople++;
            }
        }

        if (similarPeople <= 1) {
            System.out.println("No matches");
        } else {
            System.out.printf("%d %d %d%n", similarPeople, people.size() - similarPeople, people.size());
        }
    }
}
