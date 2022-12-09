package fairyShop.repositories;

import fairyShop.models.Present;

import java.util.Collection;

public class PresentRepository implements Repository<Present> {

    private Collection<Present> presents;

    @Override
    public Collection<Present> getModels() {
        return null;
    }

    @Override
    public void add(Present model) {

    }

    @Override
    public boolean remove(Present model) {
        return false;
    }

    @Override
    public Present findByName(String name) {
        return null;
    }

}
