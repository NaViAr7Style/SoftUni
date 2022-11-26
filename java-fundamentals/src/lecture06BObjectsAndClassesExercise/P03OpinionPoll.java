package lecture06BObjectsAndClassesExercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P03OpinionPoll {
    static class Person {
        private String name;
        private int age;

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return this.name;
        }

        public int getAge() {
            return this.age;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        List<Person> people = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            String[] input = scanner.nextLine().split(" ");
            String name = input[0];
            int age = Integer.parseInt(input[1]);

            Person person = new Person(name, age);
            people.add(person);
        }

        List<Person> olderThan30 = people.stream().filter(e -> e.getAge() > 30).collect(Collectors.toList());

        for (Person elder : olderThan30) {
            System.out.printf("%s - %d%n", elder.getName(), elder.getAge());
        }
    }
}
