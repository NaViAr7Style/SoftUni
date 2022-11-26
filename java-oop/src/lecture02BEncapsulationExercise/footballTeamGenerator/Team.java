package lecture02BEncapsulationExercise.footballTeamGenerator;

import java.util.ArrayList;
import java.util.List;

public class Team {
    private String name;
    private final List<Player> players;

    public Team(String name) {
        setName(name);
        players = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    private void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("A name should not be empty.");
        }
        this.name = name;
    }

    public void addPlayer(Player player) {
        players.add(player);
    }

    public void removePlayer(String name) {
        boolean isRemoved = players.removeIf(p -> p.getName().equals(name));
        if (!isRemoved) {
            String errorMessage = String.format("Player %s is not in %s team.", name, this.name);
            throw new IllegalArgumentException(errorMessage);
        }
    }

    public double getRating() {
        return players.stream()
                .mapToDouble(Player::overallSkillLevel)
                .average()
                .orElse(0);
    }
}
