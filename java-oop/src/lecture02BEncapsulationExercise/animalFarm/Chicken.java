package lecture02BEncapsulationExercise.animalFarm;

public class Chicken {
    private String name;
    private int age;

    public Chicken(String name, int age) {
        setName(name);
        setAge(age);
    }

    private void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty.");
        }

        this.name = name;
    }

    private void setAge(int age) {
        if (age < 0 || age > 15) {
            throw new IllegalArgumentException("Age should be between 0 and 15.");
        }

        this.age = age;
    }

    public double productPerDay() {
        return calculateProductPerDay();
    }

    @Override
    public String toString() {
        return String.format("chicken.Chicken %s (age %d) can produce %.2f eggs per day.", name, age, productPerDay());
    }

    private double calculateProductPerDay() {
        double product;
        if (age < 6) {
            product = 2;
        } else if (age < 12) {
            product = 1;
        } else {
            product = 0.75;
        }

        return product;
    }


}
