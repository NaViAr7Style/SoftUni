package toyStore;

import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;
import java.util.LinkedHashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class ToyStoryTest {

    private static final String TOY_MANUFACTURER = "test_manufacturer";
    private static final String TOY_ID = "12345";

    private ToyStore toyStore;
    private Toy toy;

    @Before
    public void setUp() {
        toyStore = new ToyStore();
        toy = new Toy(TOY_MANUFACTURER, TOY_ID);
    }

    @Test
    public void testConstructorCreatesEntity() {
        ToyStore expected = new ToyStore();

        Map<String, Toy> actual = new LinkedHashMap<>();
        actual.put("A", null);
        actual.put("B", null);
        actual.put("C", null);
        actual.put("D", null);
        actual.put("E", null);
        actual.put("F", null);
        actual.put("G", null);

        for (var shelfEntry : expected.getToyShelf().entrySet()) {
            assertEquals(actual.get(shelfEntry.getKey()), shelfEntry.getValue());
        }

    }

    @Test
    public void testAddToyAddsToTheCollection() throws OperationNotSupportedException {
        assertNull(toyStore.getToyShelf().get("A"));

        String expected = String.format("Toy:%s placed successfully!", toy.getToyId());

        String actual = toyStore.addToy("A", toy);

        assertEquals(toy, toyStore.getToyShelf().get("A"));
        assertEquals(expected, actual);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddToyThrowsWhenShelfDoesNotExist() throws OperationNotSupportedException {
        assertFalse(toyStore.getToyShelf().containsKey("ABCDEFG"));
        toyStore.addToy("ABCDEFG", toy);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddToyThrowsWhenShelfIsAlreadyTaken() throws OperationNotSupportedException {
        assertNull(toyStore.getToyShelf().get("A"));
        toyStore.addToy("A", toy);

        Toy anotherToy = new Toy(TOY_MANUFACTURER, TOY_ID);
        toyStore.addToy("A", anotherToy);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testAddToyThrowsWhenToyIsAlreadyPresent() throws OperationNotSupportedException {
        assertNull(toyStore.getToyShelf().get("A"));
        assertNull(toyStore.getToyShelf().get("B"));

        toyStore.addToy("A", toy);
        toyStore.addToy("B", toy);
    }

    @Test
    public void testRemoveToyRemovesFromTheCollection() throws OperationNotSupportedException {
        assertNull(toyStore.getToyShelf().get("A"));
        toyStore.addToy("A", toy);
        assertEquals(toy, toyStore.getToyShelf().get("A"));

        String expected = String.format("Remove toy:%s successfully!", toy.getToyId());

        String actual = toyStore.removeToy("A", toy);

        assertNull(toyStore.getToyShelf().get("A"));
        assertEquals(expected, actual);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveToyThrowsWhenShelfDoesNotExist() {
        assertFalse(toyStore.getToyShelf().containsKey("ABCDEFG"));
        toyStore.removeToy("ABCDEFG", toy);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveToyThrowsWhenToyInShelfIsMissing() {
        assertNull(toyStore.getToyShelf().get("A"));
        Toy notAdded = new Toy(TOY_MANUFACTURER, TOY_ID);
        toyStore.removeToy("A", notAdded);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveToyThrowsWhenToyInShelfIsDifferent() throws OperationNotSupportedException {
        assertNull(toyStore.getToyShelf().get("A"));
        toyStore.addToy("A", toy);

        Toy anotherToy = new Toy(TOY_MANUFACTURER, TOY_ID);
        toyStore.removeToy("A", anotherToy);
    }

    @Test
    public void testGetManufacturerReturnsCorrectEntity() {
        assertEquals(TOY_MANUFACTURER, toy.getManufacturer());
    }

}