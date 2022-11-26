package lecture03BInheritanceExercise.animals;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        while (!"Beast!".equals(input)) {
            String[] animalInfo = scanner.nextLine().split("\\s+");

            String animalType = input;
            String name = animalInfo[0];
            int age = Integer.parseInt(animalInfo[1]);
            String gender = animalInfo[2];

            Animal animal;

            try {

                switch (animalType) {
                    case "Dog":
                        animal = new Dog(name, age, gender);
                        System.out.println(animal);
                        break;
                    case "Frog":
                        animal = new Frog(name, age, gender);
                        System.out.println(animal);
                        break;
                    case "Cat":
                        animal = new Cat(name, age, gender);
                        System.out.println(animal);
                        break;
                    case "Kitten":
                        animal = new Kitten(name, age);
                        System.out.println(animal);
                        break;
                    case "Tomcat":
                        animal = new Tomcat(name, age);
                        System.out.println(animal);
                        break;
                }

            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }

            input = scanner.nextLine();
        }
    }
}