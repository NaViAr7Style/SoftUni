package fairyShop.repositories;

import fairyShop.models.Helper;

import java.util.Collection;

public class HelperRepository implements Repository<Helper> {

    private Collection<Helper> helpers;

    @Override
    public Collection<Helper> getModels() {
        return null;
    }

    @Override
    public void add(Helper model) {

    }

    @Override
    public boolean remove(Helper model) {
        return false;
    }

    @Override
    public Helper findByName(String name) {
        return null;
    }

}
