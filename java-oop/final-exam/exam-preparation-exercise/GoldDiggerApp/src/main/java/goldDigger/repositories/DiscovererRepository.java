package goldDigger.repositories;

import goldDigger.models.discoverer.Discoverer;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class DiscovererRepository implements Repository<Discoverer> {

    private Map<String, Discoverer> discoverers;

    public DiscovererRepository() {
        discoverers = new LinkedHashMap<>();
    }

    @Override
    public Collection<Discoverer> getCollection() {
        return discoverers.values().stream().collect(Collectors.toUnmodifiableList());
    }

    @Override
    public void add(Discoverer entity) {
        discoverers.put(entity.getName(), entity);
    }

    @Override
    public boolean remove(Discoverer entity) {
        return discoverers.remove(entity.getName(), entity);
    }

    @Override
    public Discoverer byName(String name) {
        return discoverers.get(name);
    }

}
