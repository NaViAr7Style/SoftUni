package lecture05BPolymorphismExercise.wildFarm;

public class Zebra extends Mammal {

    public Zebra(String animalType, String animalName, Double animalWeight, String livingRegion) {
        super(animalType, animalName, animalWeight, livingRegion);
    }

    @Override
    public void makeSound() {
        System.out.println("Zs");
    }

    @Override
    public void eat(Food food) {
        if (food instanceof Vegetable) {
            this.foodEaten += food.getQuantity();
        } else {
            System.out.println(getAnimalType() + "s are not eating that type of food!");
        }
    }

}
