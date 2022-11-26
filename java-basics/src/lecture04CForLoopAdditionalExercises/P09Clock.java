package lecture04CForLoopAdditionalExercises;

public class P09Clock {
    public static void main(String[] args) {

        for (int h = 0; h <= 23; h++) {
            for (int m = 0; m <= 59; m++) {
                for (int s = 0; s <= 59; s++) {
                    System.out.printf("%d : %d : %d%n", h, m, s);
                }
            }
        }
    }
}
