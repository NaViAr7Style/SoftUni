package lecture05APolymorphismLab.mathOperation;

public class Main {

    public static void main(String[] args) {

        //Doesn't work in Judge because of private constructor.

        System.out.println(MathOperation.add(2, 2));
        System.out.println(MathOperation.add(3, 3, 3));
        System.out.println(MathOperation.add(4, 4, 4, 4));
    }
}
