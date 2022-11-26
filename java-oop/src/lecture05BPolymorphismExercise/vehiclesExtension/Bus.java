package lecture05BPolymorphismExercise.vehiclesExtension;

import lecture05BPolymorphismExercise.vehicles.Vehicle;

public class Bus extends Vehicle {
    public final static double AC_ADDITIONAL_CONSUMPTION = 1.4;

    public Bus(double currentFuel, double fuelConsumption, double tankCapacity) {
        super(currentFuel, fuelConsumption, tankCapacity);
    }

    @Override
    public String drive(double distance) {
        setFuelConsumption(getFuelConsumption() + AC_ADDITIONAL_CONSUMPTION);
        String driveResult = super.drive(distance);
        setFuelConsumption(getFuelConsumption() - AC_ADDITIONAL_CONSUMPTION);
        return driveResult;
    }

    public String driveEmpty(double distance) {
        return super.drive(distance);
    }

}
