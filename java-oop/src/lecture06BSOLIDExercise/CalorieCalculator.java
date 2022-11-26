package lecture06BSOLIDExercise;

import lecture06BSOLIDExercise.products.Product;

import java.util.List;

public class CalorieCalculator {

    public double sum(List<Product> products) {
        return products.stream().mapToDouble(Product::getCalories).sum();
    }

    public double average(List<Product> products) {
        return products.stream().mapToDouble(Product::getCalories).average().orElse(0);
    }

}
