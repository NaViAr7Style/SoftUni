package lecture01AWorkingWithAbstractionLab.hotelReservation;

public class PriceCalculator {

    public static double calculateHolidayPrice(double pricePerDay, int days, Season season, DiscountType discountType) {
        double finalPrice = pricePerDay * days;
        finalPrice *= season.getCoefficient();
        finalPrice *= 1 - (discountType.getPercentage() / 100);

        return finalPrice;
    }
}
