package lecture05BPolymorphismExercise.wildFarm;

public abstract class Food {

    private final Integer quantity;

    public Food(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getQuantity() {
        return quantity;
    }

}
