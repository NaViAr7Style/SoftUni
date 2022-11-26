package lecture05BPolymorphismExercise.wildFarm;

public abstract class Animal {

    private final String animalType;
    private final String animalName;
    private final Double animalWeight;
    protected Integer foodEaten;

    public Animal(String animalType, String animalName, Double animalWeight) {
        this.animalType = animalType;
        this.animalName = animalName;
        this.animalWeight = animalWeight;
        foodEaten = 0;
    }

    public abstract void makeSound();
    public abstract void eat(Food food);

    public String getAnimalName() {
        return animalName;
    }

    public String getAnimalType() {
        return animalType;
    }

    public Double getAnimalWeight() {
        return animalWeight;
    }

    public Integer getFoodEaten() {
        return foodEaten;
    }



}
