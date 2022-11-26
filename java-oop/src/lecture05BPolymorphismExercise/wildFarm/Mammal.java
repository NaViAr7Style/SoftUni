package lecture05BPolymorphismExercise.wildFarm;

import java.text.DecimalFormat;

public abstract class Mammal extends Animal {

    private final String livingRegion;

    public Mammal(String animalType, String animalName, Double animalWeight, String livingRegion) {
        super(animalType, animalName, animalWeight);
        this.livingRegion = livingRegion;
    }

    public String getLivingRegion() {
        return livingRegion;
    }

    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("0.##");

        return String.format("%s[%s, %s, %s, %d]", getAnimalType(), getAnimalName(), df.format(getAnimalWeight()), getLivingRegion(), getFoodEaten());
    }

}
