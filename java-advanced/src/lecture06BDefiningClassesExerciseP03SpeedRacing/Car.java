package lecture06BDefiningClassesExerciseP03SpeedRacing;

public class Car {
    private String model;
    private double fuelAmount;
    private double fuelConsumptionPer1Km;
    private int travelledDistance;

    public Car(String model, double fuelAmount, double fuelConsumptionPer1Km) {
        this.model = model;
        this.fuelAmount = fuelAmount;
        this.fuelConsumptionPer1Km = fuelConsumptionPer1Km;
        this.travelledDistance = 0;
    }

    @Override
    public String toString() {
        return String.format("%s %.2f %d", model, fuelAmount, travelledDistance);
    }

    public double calculateRequiredFuel(int distance) {
        return this.getFuelConsumptionPer1Km() * distance;
    }

    public boolean hasEnoughFuel(int distance) {
        return fuelAmount >= calculateRequiredFuel(distance);
    }

    public void drive(int distance) {
        if (hasEnoughFuel(distance)) {
            this.fuelAmount -= calculateRequiredFuel(distance);
            this.travelledDistance += distance;
        } else {
            System.out.println("Insufficient fuel for the drive");
        }
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getFuelAmount() {
        return fuelAmount;
    }

    public void setFuelAmount(double fuelAmount) {
        this.fuelAmount = fuelAmount;
    }

    public double getFuelConsumptionPer1Km() {
        return fuelConsumptionPer1Km;
    }

    public void setFuelConsumptionPer1Km(double fuelConsumptionPer1Km) {
        this.fuelConsumptionPer1Km = fuelConsumptionPer1Km;
    }

    public int getTravelledDistance() {
        return travelledDistance;
    }

    public void setTravelledDistance(int travelledDistance) {
        this.travelledDistance = travelledDistance;
    }
}
