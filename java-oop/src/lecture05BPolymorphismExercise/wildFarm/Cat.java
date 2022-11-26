package lecture05BPolymorphismExercise.wildFarm;

import java.text.DecimalFormat;

public class Cat extends Feline {

    private final String breed;

    public Cat(String animalType, String animalName, Double animalWeight, String livingRegion, String breed) {
        super(animalType, animalName, animalWeight, livingRegion);
        this.breed = breed;
    }

    @Override
    public void makeSound() {
        System.out.println("Meowwww");
    }

    @Override
    public void eat(Food food) {
        this.foodEaten += food.getQuantity();
    }

    public String getBreed() {
        return breed;
    }

    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("0.##");

        return String.format("%s[%s, %s, %s, %s, %d]", getAnimalType(), getAnimalName(), getBreed(), df.format(getAnimalWeight()), getLivingRegion(), getFoodEaten());
    }

}
