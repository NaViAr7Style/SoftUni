package lecture05APolymorphismLab.shapes;

public class Rectangle implements Shape {
    private final Double height;
    private final Double width;

    public Rectangle(Double height, Double width) {
        this.height = height;
        this.width = width;
    }

    @Override
    public Double calculatePerimeter() {
        return 2 * (height + width);
    }

    @Override
    public Double calculateArea() {
        return height * width;
    }

}