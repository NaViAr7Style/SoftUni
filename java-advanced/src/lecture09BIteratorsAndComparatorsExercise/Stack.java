package lecture09BIteratorsAndComparatorsExercise;

import java.util.Iterator;

public class Stack implements Iterable<Integer> {

    @Override
    public Iterator<Integer> iterator() {
        return new StackIterator();
    }

    private class StackIterator implements Iterator<Integer> {

        int internalIndex = currentIndex - 1;

        @Override
        public boolean hasNext() {
            return internalIndex >= 0;
        }

        @Override
        public Integer next() {
            return data[internalIndex--];
        }
    }

    private final int[] data;
    private int currentIndex;

    public Stack() {
        data = new int[20];
    }

    public void push(int[] numbers) {

        for (int num : numbers) {
            data[currentIndex] = num;
            currentIndex++;
        }
    }

    public void pop() {
        if (currentIndex == 0) {
            System.out.println("No elements");
            return;
        }

        data[currentIndex - 1] = 0;
        currentIndex--;
    }
}