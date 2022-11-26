package lecture05BPolymorphismExercise.vehicles;

public class Truck extends Vehicle {
    private final static double AC_ADDITIONAL_CONSUMPTION = 1.6;
    private final static double FUEL_LOST_DURING_REFUEL = 0.05;

    public Truck(double currentFuel, double fuelConsumption, double tankCapacity) {
        super(currentFuel, fuelConsumption + AC_ADDITIONAL_CONSUMPTION, tankCapacity);
    }

    @Override
    public void refuel(double fuel) {
        super.refuel(fuel * (1 - FUEL_LOST_DURING_REFUEL));
    }
}
