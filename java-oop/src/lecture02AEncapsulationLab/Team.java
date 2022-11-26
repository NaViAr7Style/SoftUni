package lecture02AEncapsulationLab;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Team {
    private String name;
    private final List<Person> firstTeam;
    private final List<Person> reserveTeam;

    public Team(String name) {
        setName(name);
        firstTeam = new ArrayList<>();
        reserveTeam = new ArrayList<>();
    }

    public void addPlayer(Person person) {
        if (person.getAge() < 40) {
            firstTeam.add(person);
        } else {
            reserveTeam.add(person);
        }
    }

    private void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public List<Person> getFirstTeam() {
        return Collections.unmodifiableList(firstTeam);
    }

    public List<Person> getReserveTeam() {
        return Collections.unmodifiableList(reserveTeam);
    }
}