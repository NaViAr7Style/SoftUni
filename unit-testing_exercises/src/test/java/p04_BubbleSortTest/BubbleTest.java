package p04_BubbleSortTest;

import org.junit.Assert;
import org.junit.Test;

public class BubbleTest {

    @Test
    public void testBubbleSort() {
        int[] randomNumbers = {3, 1, 5, 2, -5, -10, 12};
        int[] sortedNumbers = {-10, -5, 1, 2, 3, 5, 12};
        Bubble.sort(randomNumbers);
        Assert.assertArrayEquals(sortedNumbers, randomNumbers);
    }
}