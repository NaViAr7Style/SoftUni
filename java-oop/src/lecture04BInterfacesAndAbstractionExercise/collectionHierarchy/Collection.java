package lecture04BInterfacesAndAbstractionExercise.collectionHierarchy;

import java.util.ArrayList;
import java.util.List;

public abstract class Collection {
    private int maxSize;
    private List<String> items;

    public Collection() {
        items = new ArrayList<>();
        maxSize = 100;
    }

    public List<String> getItems() {
        return items;
    }

}
