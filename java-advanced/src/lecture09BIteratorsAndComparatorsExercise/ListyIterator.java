package lecture09BIteratorsAndComparatorsExercise;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class ListyIterator implements Iterable<String> {

    private class CustomIterator implements Iterator<String> {

        private int internalIndex;

        @Override
        public boolean hasNext() {
            return internalIndex < elements.size();
        }

        @Override
        public String next() {
            return elements.get(internalIndex++);
        }
    }

    private final List<String> elements;
    private int currentIndex;

    public ListyIterator(String... elements) {
        this.elements = Arrays.asList(elements);
        currentIndex = 0;
    }

    public boolean hasNext() {
        return currentIndex < elements.size() - 1;
    }

    public boolean move() {
        if (hasNext()) {
            currentIndex++;
            return true;
        }

        return false;
    }

    public void print() {

        if (elements.isEmpty()) {
            throw new IllegalStateException("Invalid Operation!");
        }
        System.out.println(elements.get(currentIndex));
    }

    public void printAll() {
        String result = String.join(" ", elements);
        System.out.printf("%s%n", result);
    }

    @Override
    public Iterator<String> iterator() {
        return new CustomIterator();
    }
}
