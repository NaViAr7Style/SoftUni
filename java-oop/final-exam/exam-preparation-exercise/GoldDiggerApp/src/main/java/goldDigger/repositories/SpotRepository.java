package goldDigger.repositories;

import goldDigger.models.spot.Spot;

import java.util.ArrayList;
import java.util.Collection;

public class SpotRepository implements Repository {

    private Collection<Spot> spots;

    public SpotRepository() {
        spots = new ArrayList<>();
    }

    @Override
    public Collection getCollection() {
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
