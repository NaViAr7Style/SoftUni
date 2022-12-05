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
    public void add(Discoverer discoverer) {
        discoverers.put(discoverer.getName(), discoverer);
    }

    @Override
    public boolean remove(Discoverer discoverer) {
        return discoverers.remove(discoverer.getName(), discoverer);
    }

    @Override
    public Discoverer byName(String name) {
        return discoverers.get(name);
    }

}
