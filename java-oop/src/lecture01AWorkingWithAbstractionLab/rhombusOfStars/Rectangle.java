package lecture01AWorkingWithAbstractionLab.rhombusOfStars;

public class Rectangle {
    private Point bottomLeft;
    private Point upperRight;

    public Rectangle(Point bottomLeft, Point upperRight) {
        setBottomLeft(bottomLeft);
        setUpperRight(upperRight);
    }

    public boolean contains(Point point) {
        boolean isInsideX = bottomLeft.getX() <= point.getX() && point.getX() <= upperRight.getX();
        boolean isInsideY = bottomLeft.getY() <= point.getY() && point.getY() <= upperRight.getY();

        return isInsideX && isInsideY;
    }

    public void setBottomLeft(Point bottomLeft) {
        this.bottomLeft = bottomLeft;
    }

    public void setUpperRight(Point upperRight) {
        this.upperRight = upperRight;
    }
}
