package lecture05BPolymorphismExercise.wildFarm;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        List<Mammal> animals = new ArrayList<>();

        while (!"End".equals(input)) {
            String[] animalInfo = input.split("\\s+");
            String animalType = animalInfo[0];
            String animalName = animalInfo[1];
            Double animalWeight = Double.parseDouble(animalInfo[2]);
            String livingRegion = animalInfo[3];

            Optional<Mammal> mammal = Optional.empty();

            switch (animalType) {
                case "Cat":
                    String breed = animalInfo[4];
                    mammal = Optional.of(new Cat(animalType, animalName, animalWeight, livingRegion, breed));
                    break;
                case "Tiger":
                    mammal = Optional.of(new Tiger(animalType, animalName, animalWeight, livingRegion));
                    break;
                case "Zebra":
                    mammal = Optional.of(new Zebra(animalType, animalName, animalWeight, livingRegion));
                    break;
                case "Mouse":
                    mammal = Optional.of(new Mouse(animalType, animalName, animalWeight, livingRegion));
                    break;
            }

            String[] foodInfo = scanner.nextLine().split("\\s+");
            String foodType = foodInfo[0];
            Integer quantity = Integer.parseInt(foodInfo[1]);

            Optional<Food> food = Optional.empty();

            switch (foodType) {
                case "Vegetable":
                    food = Optional.of(new Vegetable(quantity));
                    break;
                case "Meat":
                    food = Optional.of(new Meat(quantity));
                    break;
            }

            if (mammal.isPresent() && food.isPresent()) {
                mammal.get().makeSound();
                mammal.get().eat(food.get());
                animals.add(mammal.get());
            }

            input = scanner.nextLine();
        }

        animals.forEach(System.out::println);

    }

}