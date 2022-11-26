package rpg_lab;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DummyTest {

    private static final int DUMMY_HEALTH = 100;
    private static final int DUMMY_EXPERIENCE = 10;
    private static final int ATTACK_POINTS = 10;

    private Dummy dummy;
    private Dummy deadDummy;

    @Before
    public void setUp() {
        this.dummy = new Dummy(DUMMY_HEALTH, DUMMY_EXPERIENCE);
        this.deadDummy = new Dummy(0, DUMMY_EXPERIENCE);
    }

    @Test
    public void testTakeAttackReducesHealth() {
        dummy.takeAttack(ATTACK_POINTS);
        assertEquals(DUMMY_HEALTH - ATTACK_POINTS, dummy.getHealth());
    }

    @Test(expected = IllegalStateException.class)
    public void testTakeAttackThrowsWhenDummyIsDead() {
        deadDummy.takeAttack(ATTACK_POINTS);
    }

    @Test
    public void testGiveExpWhenDummyIsDeadReturnsCorrectExp() {
        int actual = deadDummy.giveExperience();
        assertEquals(DUMMY_EXPERIENCE, actual);
    }

    @Test(expected = IllegalStateException.class)
    public void testGiveExpThrowsWhenDummyIsAlive() {
        dummy.giveExperience();
    }

}