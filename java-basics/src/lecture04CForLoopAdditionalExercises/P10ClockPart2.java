package lecture04CForLoopAdditionalExercises;

public class P10ClockPart2 {
    public static void main(String[] args) {

        for (int h = 0; h <= 23; h++) {
            for (int m = 0; m <= 59; m++) {
                System.out.printf("%d : %d%n", h, m);
            }
        }
    }
}
