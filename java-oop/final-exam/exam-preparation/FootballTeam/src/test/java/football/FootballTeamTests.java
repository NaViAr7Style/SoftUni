package football;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class FootballTeamTests {

    private static final int VACANT_POSITIONS = 12;
    private static final String PLAYER_NAME = "test_name";
    private static final String TEAM_NAME = "test_team";


    private Footballer footballer;
    private FootballTeam footballTeam;

    @Before
    public void setUp() {
        this.footballer = new Footballer(PLAYER_NAME);
        this.footballTeam = new FootballTeam(TEAM_NAME, VACANT_POSITIONS);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCreatingTeamWithNoPositions() {
        new FootballTeam(PLAYER_NAME, -1);
    }

    @Test
    public void testCreatingTeamWithActualPositionsShouldSetCorrectPositionsCount() {
        assertEquals(VACANT_POSITIONS, footballTeam.getVacantPositions());
    }

    @Test(expected = NullPointerException.class)
    public void testCreatingTeamWithNullNameShouldFail() {
        new FootballTeam(null, 1);
    }

    @Test(expected = NullPointerException.class)
    public void testCreatingTeamWithEmptyNameShouldFail() {
        new FootballTeam("      ", 1);
    }

    @Test
    public void testCreatingTeamWithNameShouldCreateTheTeam() {
        assertEquals(TEAM_NAME, footballTeam.getName());
    }

    @Test
    public void testAddPlayerShouldIncreaseTeamMembersCount() {
        footballTeam.addFootballer(footballer);

        assertEquals(1, footballTeam.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddPlayerShouldFailWhenTeamIsFull() {
        FootballTeam team = new FootballTeam(TEAM_NAME, 0);
        team.addFootballer(footballer);
    }

    @Test
    public void testRemoveFootballerShouldReduceTeamCount() {
        footballTeam.addFootballer(footballer);

        assertEquals(1, footballTeam.getCount());

        footballTeam.removeFootballer(footballer.getName());

        assertEquals(0, footballTeam.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveFootballerShouldFailWhenNoSuchPlayer() {
        footballTeam.addFootballer(footballer);
        footballTeam.removeFootballer("not_added");
    }

    @Test
    public void testFooballerForSaleShouldDeactivatePlayer() {
        footballTeam.addFootballer(footballer);

        footballTeam.footballerForSale(footballer.getName());

        assertFalse(footballer.isActive());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFooballerForSaleShouldFailIfPlayerIsMissing() {
        footballTeam.addFootballer(footballer);
        footballTeam.footballerForSale("not_added");
    }

}
