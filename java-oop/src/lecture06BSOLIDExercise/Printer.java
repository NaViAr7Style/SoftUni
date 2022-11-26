package lecture06BSOLIDExercise;

import lecture06BSOLIDExercise.products.Product;

import java.util.List;

public class Printer {

    private static final String SUM = "Sum: %f";
    private static final String AVERAGE = "Average: %f";

    private CalorieCalculator calorieCalculator;

    public Printer(CalorieCalculator calorieCalculator) {
        this.calorieCalculator = calorieCalculator;
    }

    public void printSum(List<Product> products) {
        System.out.printf((SUM) + "%n", calorieCalculator.sum(products));
    }

    public void printAverage(List<Product> products) {
        System.out.printf((AVERAGE) + "%n", calorieCalculator.average(products));
    }

}
