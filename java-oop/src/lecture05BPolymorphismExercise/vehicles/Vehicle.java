package lecture05BPolymorphismExercise.vehicles;

import java.text.DecimalFormat;

public abstract class Vehicle {

    private double currentFuel;
    private double fuelConsumption;
    private double tankCapacity;

    public Vehicle(double currentFuel, double fuelConsumption, double tankCapacity) {
        this.currentFuel = currentFuel;
        this.fuelConsumption = fuelConsumption;
        this.tankCapacity = tankCapacity;
    }

    public double getCurrentFuel() {
        return currentFuel;
    }

    public double getFuelConsumption() {
        return fuelConsumption;
    }

    public void setCurrentFuel(double currentFuel) {
        this.currentFuel = currentFuel;
    }

    public void refuel(double fuel) {
        if (fuel <= 0) {
            throw new IllegalArgumentException("Fuel must be a positive number");
        }

        if (currentFuel + fuel > tankCapacity) {
            throw new IllegalArgumentException("Cannot fit fuel in tank");
        }

        setCurrentFuel(getCurrentFuel() + fuel);
    }

    public String drive(double distance) {
        double fuelNeeded = distance * (getFuelConsumption());

        if (fuelNeeded > getCurrentFuel()) {
            return this.getClass().getSimpleName() + " needs refueling";
        }

        setCurrentFuel(getCurrentFuel() - fuelNeeded);
        DecimalFormat df = new DecimalFormat("0.##");

        return String.format("%s travelled %s km", this.getClass().getSimpleName(), df.format(distance));
    }

    public String driveAC(double distance, double additionalConsumption) {
        setFuelConsumption(getFuelConsumption() + additionalConsumption);
        String result = this.drive(distance);
        setFuelConsumption(getFuelConsumption() - additionalConsumption);
        return result;
    }

    public void setFuelConsumption(double fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }

    @Override
    public String toString() {
        return String.format("%s: %.2f", this.getClass().getSimpleName(), currentFuel);
    }

}
