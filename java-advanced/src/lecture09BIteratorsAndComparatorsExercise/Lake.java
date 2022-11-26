package lecture09BIteratorsAndComparatorsExercise;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Lake implements Iterable<Integer> {

    private class Frog implements Iterator<Integer> {
        private int index = 0;

        @Override
        public boolean hasNext() {

            if (index >= lake.size() && index % 2 == 0) {
                index = 1;
            }

            return index < lake.size();
        }

        @Override
        public Integer next() {
            Integer element = lake.get(index);
            index += 2;
            return element;
        }
    }

    private List<Integer> lake;

    public Lake(Integer... lake) {
        this.lake = Arrays.asList(lake);
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Frog();
    }
}
