package lecture08AGenericsLab;

public class Scale<T extends Comparable<T>> {

    private T left;
    private T right;

    public Scale(T left, T right) {
        this.left = left;
        this.right = right;
    }

    public T getHeavier() {

        if (left.equals(right)) {
            return null;
        }

        int result = left.compareTo(right);

        if (result > 0) {
            return left;
        }

        return right;
    }

    public static <E extends Comparable<E>> E getHeavier(E left, E right) {

        if (left.equals(right)) {
            return null;
        }

        int result = left.compareTo(right);

        if (result > 0) {
            return left;
        }

        return right;
    }
}