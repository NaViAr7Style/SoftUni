package lecture05APolymorphismLab.shapes;

public class Circle implements Shape {
    private final Double radius;

    public Circle(Double radius) {
        this.radius = radius;
    }

    @Override
    public Double calculatePerimeter() {
        return 2 * radius * Math.PI;
    }

    @Override
    public Double calculateArea() {
        return radius * radius * Math.PI;
    }
}