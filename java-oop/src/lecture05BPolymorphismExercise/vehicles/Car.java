package lecture05BPolymorphismExercise.vehicles;

public class Car extends Vehicle {
    private final static double AC_ADDITIONAL_CONSUMPTION = 0.9;

    public Car(double currentFuel, double fuelConsumption, double tankCapacity) {
        super(currentFuel, fuelConsumption + AC_ADDITIONAL_CONSUMPTION, tankCapacity);
    }

}
