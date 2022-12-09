package fairyShop.repositories;

import fairyShop.models.Helper;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class HelperRepository implements Repository<Helper> {

    private Map<String, Helper> helpers;

    public HelperRepository() {
        helpers = new LinkedHashMap<>();
    }

    @Override
    public Collection<Helper> getModels() {
        return helpers.values().stream().collect(Collectors.toUnmodifiableList());
    }

    @Override
    public void add(Helper helper) {
        helpers.put(helper.getName(), helper);
    }

    @Override
    public boolean remove(Helper helper) {
        return helpers.remove(helper.getName(), helper);
    }

    @Override
    public Helper findByName(String name) {
        return helpers.get(name);
    }

}
