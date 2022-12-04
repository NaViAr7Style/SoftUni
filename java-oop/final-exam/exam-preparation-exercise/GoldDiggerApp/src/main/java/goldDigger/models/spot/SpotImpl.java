package goldDigger.models.spot;

import java.util.ArrayList;
import java.util.Collection;

public class SpotImpl implements Spot {

    private String name;
    private Collection<String> exhibits;

    public SpotImpl(String name) {
        setName(name);
        exhibits = new ArrayList<>();
    }

    @Override
    public Collection<String> getExhibits() {
        return null;
    }

    @Override
    public String getName() {
        return null;
    }

    private void setName(String name) {
        this.name = name;
    }

}
