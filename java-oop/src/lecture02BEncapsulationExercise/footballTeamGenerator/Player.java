package lecture02BEncapsulationExercise.footballTeamGenerator;

public class Player {
    private String name;
    private int endurance;
    private int sprint;
    private int dribble;
    private int passing;
    private int shooting;

    public Player(String name, int endurance, int sprint, int dribble, int passing, int shooting) {
        setName(name);
        setEndurance(endurance);
        setSprint(sprint);
        setDribble(dribble);
        setPassing(passing);
        setShooting(shooting);
    }

    public double overallSkillLevel() {
        return (endurance + sprint + dribble + passing + shooting) / 5.0;
    }

    private void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("A name should not be empty.");
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }

    private void setEndurance(int endurance) {
        checkIfInRange(endurance, "Endurance");
        this.endurance = endurance;
    }

    private void setSprint(int sprint) {
        checkIfInRange(sprint, "Sprint");
        this.sprint = sprint;
    }

    private void setDribble(int dribble) {
        checkIfInRange(dribble, "Dribble");
        this.dribble = dribble;
    }

    private void setPassing(int passing) {
        checkIfInRange(passing, "Passing");
        this.passing = passing;
    }

    private void setShooting(int shooting) {
        checkIfInRange(shooting, "Shooting");
        this.shooting = shooting;
    }

    private void checkIfInRange(int stats, String messagePrefix) {
        if (stats < 0 || 100 < stats) {
            throw new IllegalArgumentException(messagePrefix + " should be between 0 and 100.");
        }
    }
}
