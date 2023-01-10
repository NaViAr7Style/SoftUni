package magicGame;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class MagicianTests {

    private static final String MAGICIAN_NAME = "test_name";
    private static final int MAGICIAN_HEALTH = 100;
    private static final String NAME_OF_MAGIC = "Stormbolt";
    private static final int BULLETS = 5;


    private Magician magician;
    private Magic magic;

    @Before
    public void setUp() {
        magician = new Magician(MAGICIAN_NAME, MAGICIAN_HEALTH);
        magic = new Magic(NAME_OF_MAGIC, BULLETS);
    }

    @Test
    public void testConstructorCreatesObject() {
        Magician test_magician = new Magician(MAGICIAN_NAME, MAGICIAN_HEALTH);
        assertEquals(MAGICIAN_NAME, test_magician.getUsername());
        assertEquals(MAGICIAN_HEALTH, test_magician.getHealth());
    }

    @Test(expected = NullPointerException.class)
    public void testConstructorThrowsWithNullName() {
        Magician test_magician = new Magician(null, MAGICIAN_HEALTH);
    }

    @Test(expected = NullPointerException.class)
    public void testConstructorThrowsWithEmptyName() {
        Magician test_magician = new Magician("            ", MAGICIAN_HEALTH);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConstructorThrowsWithNegativeHealth() {
        Magician test_magician = new Magician(MAGICIAN_NAME, -5);
    }

    @Test
    public void testTakeDamageSubtractsDamage() {
        int currentHealth = magician.getHealth();
        int damage = 15;

        assertTrue(currentHealth > damage);
        magician.takeDamage(damage);
        assertEquals(currentHealth - damage, magician.getHealth());
    }

    @Test(expected = IllegalStateException.class)
    public void testTakeDamageThrowsIfHealthIsLessThanZero() {
        int currentHealth = magician.getHealth();
        magician.takeDamage(currentHealth);
        magician.takeDamage(currentHealth);
    }

    @Test
    public void testTakeDamageSetsHealthToZeroWhenDamageIsGreaterThanHealth() {
        int currentHealth = magician.getHealth();
        magician.takeDamage(currentHealth * 2);
        assertEquals(0, magician.getHealth());
    }

    @Test
    public void testAddMagicAddsToRepository() {
        assertEquals(new ArrayList<>(), magician.getMagics());
        List<Magic> expected = new ArrayList<>();
        expected.add(magic);
        magician.addMagic(magic);
        assertEquals(expected, magician.getMagics());
    }

    @Test(expected = NullPointerException.class)
    public void testAddMagicThrowsWhenMagicIsNull() {
        magician.addMagic(null);
    }

    @Test
    public void testRemoveMagicRemovesFromRepository() {
        assertEquals(new ArrayList<>(), magician.getMagics());
        magician.addMagic(magic);
        assertEquals(1, magician.getMagics().size());
        assertTrue(magician.removeMagic(magic));
        assertFalse(magician.removeMagic(magic));
        assertEquals(0, magician.getMagics().size());
    }

    @Test
    public void testGetMagicReturnsCorrectInstance() {
        magician.addMagic(magic);
        assertEquals(magic, magician.getMagic(NAME_OF_MAGIC));
    }

    @Test
    public void testGetMagicReturnsNullWhenMagicIsMissing() {
        assertEquals(new ArrayList<>(), magician.getMagics());
        magician.addMagic(magic);
        assertNull(magician.getMagic("not_added"));
    }

}
