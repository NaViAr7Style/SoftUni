package archeologicalExcavations;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ExcavationTests {
    private static final int CAPACITY = 10;
    private static final String EXCAVATION_NAME = "excavation_name";
    private static final String ARCHAEOLOGIST_NAME = "archaeologist_name";
    private static final double ENERGY = 50.00;

    private Excavation excavation;
    private Archaeologist archaeologist;

    @Before
    public void setUp() {
        excavation = new Excavation(EXCAVATION_NAME, CAPACITY);
        archaeologist = new Archaeologist(ARCHAEOLOGIST_NAME, ENERGY);
    }

    @Test
    public void testCreateExcavation() {
        Excavation excavation = new Excavation(EXCAVATION_NAME, CAPACITY);

        assertEquals(EXCAVATION_NAME, excavation.getName());
        assertEquals(CAPACITY, excavation.getCapacity());
        assertEquals(0, excavation.getCount());
    }

    @Test(expected = NullPointerException.class)
    public void testConstructorShouldThrowWithEmptyName() {
        new Excavation("       ", CAPACITY);
    }

    @Test(expected = NullPointerException.class)
    public void testConstructorShouldThrowWithNullName() {
        new Excavation(null, CAPACITY);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConstructorShouldThrowWithNegativeCapacity() {
        new Excavation(EXCAVATION_NAME, -10);
    }

    @Test
    public void testAddArchaeologistShouldAdd() {
        excavation.addArchaeologist(archaeologist);
        assertEquals(1, excavation.getCount());

        Archaeologist anotherArchaeologist = new Archaeologist("test_name", 15);

        excavation.addArchaeologist(anotherArchaeologist);
        assertEquals(2, excavation.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddArchaeologistShouldThrowIfNoCapacity() {
        Excavation newExcavation = new Excavation(EXCAVATION_NAME, 0);
        newExcavation.addArchaeologist(archaeologist);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddArchaeologistShouldThrowIfArchaeologistExists() {
        excavation.addArchaeologist(archaeologist);
        excavation.addArchaeologist(archaeologist);
        excavation.addArchaeologist(archaeologist);
    }

    @Test
    public void testRemoveArchaeologistShouldRemove() {
        Archaeologist anotherArchaeologist = new Archaeologist("test_name", 15);

        excavation.addArchaeologist(archaeologist);
        excavation.addArchaeologist(anotherArchaeologist);

        assertTrue(excavation.removeArchaeologist(archaeologist.getName()));
        assertEquals(1, excavation.getCount());
    }

    @Test
    public void testRemoveArchaeologistShouldNotRemoveIfMissing() {
        Archaeologist anotherArchaeologist = new Archaeologist("test_name", 15);

        excavation.addArchaeologist(archaeologist);
        excavation.addArchaeologist(anotherArchaeologist);

        assertFalse(excavation.removeArchaeologist("not_added"));
        assertEquals(2, excavation.getCount());
    }

}