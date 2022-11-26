package vetClinic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Clinic {
    private List<Pet> data;
    private int capacity;

    public Clinic(int capacity) {
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public void add(Pet pet) {
        if (data.size() < capacity) {
            data.add(pet);
        }
    }

    public boolean remove(String name) {
        return data.removeIf(pet -> pet.getName().equals(name));
    }

    public Pet getPet(String name, String owner) {
        return data.stream()
                .filter(pet -> pet.getName().equals(name) && pet.getOwner().equals(owner))
                .findAny()
                .orElse(null);
    }

    public Pet getOldestPet() {
        return Collections.max(data, Comparator.comparingInt(Pet::getAge));
    }

    public int getCount(){
        return data.size();
    }

    public String getStatistics() {
        StringBuilder sb = new StringBuilder("The clinic has the following patients:");

        for (Pet pet : data) {
            sb.append(System.lineSeparator())
                    .append(pet.getName())
                    .append(" ")
                    .append(pet.getOwner());
        }

        return sb.toString();
    }
}
