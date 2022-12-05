package goldDigger.repositories;

import goldDigger.models.spot.Spot;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class SpotRepository implements Repository<Spot> {

    private Map<String, Spot> spots;

    public SpotRepository() {
        spots = new LinkedHashMap<>();
    }

    @Override
    public Collection<Spot> getCollection() {
        return spots.values().stream().collect(Collectors.toUnmodifiableList());
    }

    @Override
    public void add(Spot entity) {
        spots.put(entity.getName(), entity);
    }

    @Override
    public boolean remove(Spot entity) {
        return spots.remove(entity.getName(), entity);
    }

    @Override
    public Spot byName(String name) {
        return spots.get(name);
    }

}
