package goldDigger.repositories;

import goldDigger.models.discoverer.Discoverer;

import java.util.ArrayList;
import java.util.Collection;

public class DiscovererRepository implements Repository {

    private Collection<Discoverer> discoverers;

    public DiscovererRepository() {
        discoverers = new ArrayList<>();
    }

    @Override
    public Collection<Discoverer> getCollection() {
        return null;
    }

    @Override
    public void add(Object entity) {

    }

    @Override
    public boolean remove(Object entity) {
        return false;
    }

    @Override
    public Object byName(String name) {
        return null;
    }

}
