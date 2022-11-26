package lecture02BEncapsulationExercise.shoppingSpree;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Person {
    private String name;
    private  double money;
    private final List<Product> products;

    public Person(String name, double money) {
        setName(name);
        setMoney(money);
        products = new ArrayList<>();
    }

    public void buyProduct(Product product) {
        if (money < product.getCost()) {
            throw new IllegalArgumentException(name + " can't afford " + product.getName());
        }

        products.add(product);
        money -= product.getCost();
    }

    @Override
    public String toString() {
        String output;

        if (products.isEmpty()) {
            output = name + " - " + "Nothing bought";
        } else {
            output =  name + " - " +
                    products.stream().map(Product::getName).collect(Collectors.joining(", "));
        }

        return output;
    }

    public void setName(String name) {
        if (name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty");
        }
        this.name = name;
    }

    public void setMoney(double money) {
        if (money < 0) {
            throw new IllegalArgumentException("Money cannot be negative");
        }
        this.money = money;
    }
}
