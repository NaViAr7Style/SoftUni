package lecture02BEncapsulationExercise.classBoxDataValidation;

public class Box {
    private double length;
    private double width;
    private double height;

    public Box(double length, double width, double height) {
        setLength(length);
        setWidth(width);
        setHeight(height);
    }

    public double calculateSurfaceArea() {
        return 2 * (length * width + length * height + width * height);
    }

    public double calculateLateralSurfaceArea() {
        return 2 * (length * height + width * height);
    }

    public double calculateVolume() {
        return length * width * height;
    }

    private void validateLength(double length, String messagePrefix) {
        if (length <= 0) {
            throw new IllegalArgumentException(messagePrefix + " cannot be zero or negative.");
        }
    }

    private void setLength(double length) {
        validateLength(length, "Length");
        this.length = length;
    }

    private void setWidth(double width) {
        validateLength(width, "Width");
        this.width = width;
    }

    private void setHeight(double height) {
        validateLength(height, "Height");
        this.height = height;
    }
}