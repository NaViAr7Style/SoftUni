package p05_CustomLinkedList;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CustomLinkedListTest {
    private final static String DUMMY_1 = "Dummy 1";
    private final static String DUMMY_2 = "Dummy 2";
    private final static String DUMMY_3 = "Dummy 3";
    private final static String BUFFER_DUMMY = "Buffer Dummy";
    private CustomLinkedList<String> list;

    @Before
    public void setup() {
        list = new CustomLinkedList<>();
        list.add(DUMMY_1);
        list.add(DUMMY_2);
        list.add(DUMMY_3);
    }

    @Test
    public void testAddShouldAdd() {
        int previousSize = list.getCount();
        list.add(BUFFER_DUMMY);
        int currentSize = list.getCount();
        assertEquals(list.getCount() - 1, list.indexOf(BUFFER_DUMMY));
        assertEquals(previousSize + 1, currentSize);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetShouldThrowWithNegativeIndex() {
        list.get(-2);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetShouldThrowWithBigIndex() {
        list.get(list.getCount() + 1);
    }

    @Test
    public void testGetShouldGet() {
        list.add(BUFFER_DUMMY);
        assertEquals(BUFFER_DUMMY, list.get(list.getCount() - 1));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetShouldThrowWithNegativeIndex() {
        list.set(-2, BUFFER_DUMMY);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetShouldThrowWithBigIndex() {
        list.set(list.getCount() + 1, BUFFER_DUMMY);
    }

    @Test
    public void testSetShouldSet() {
        list.set(0, BUFFER_DUMMY);
        assertEquals(BUFFER_DUMMY, list.get(0));
    }

    @Test
    public void testIndexOfShouldFindIndex() {
        list.add(BUFFER_DUMMY);
        assertEquals(list.getCount() - 1, list.indexOf(BUFFER_DUMMY));
    }

    @Test
    public void testIndexOfShouldNotFindIndex() {
        assertEquals(-1, list.indexOf(BUFFER_DUMMY));
    }

    @Test
    public void testContainsShouldReturnTrue() {
        list.add(BUFFER_DUMMY);
        assertTrue(list.contains(BUFFER_DUMMY));
    }

    @Test
    public void testContainsShouldReturnFalse() {
        assertFalse(list.contains(BUFFER_DUMMY));
    }

    @Test
    public void testRemoveWithMissingElement() {
        assertEquals(-1, list.remove(BUFFER_DUMMY));
    }

    @Test
    public void testRemoveShouldRemoveElement() {
        int index = list.indexOf(DUMMY_1);
        int countBeforeRemove = list.getCount();
        assertEquals(index, list.remove(DUMMY_1));

        int countAfterRemove = list.getCount();
        assertEquals(countBeforeRemove - 1, countAfterRemove);
        assertEquals(-1, list.indexOf(DUMMY_1));
    }

    @Test
    public void testRemoveAtIndexShouldRemove() {
        int index = list.indexOf(DUMMY_1);
        int countBeforeRemove = list.getCount();
        assertEquals(DUMMY_1, list.removeAt(index));

        int countAfterRemove = list.getCount();
        assertEquals(countBeforeRemove - 1, countAfterRemove);
    }


}