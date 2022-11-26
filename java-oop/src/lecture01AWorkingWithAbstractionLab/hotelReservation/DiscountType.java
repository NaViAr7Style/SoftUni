package lecture01AWorkingWithAbstractionLab.hotelReservation;

public enum DiscountType {
    NONE(0),
    SECOND_VISIT(10),
    VIP(20);

    private final double percentage;

    DiscountType(double percentage) {
        this.percentage = percentage;
    }

    public double getPercentage() {
        return percentage;
    }
}