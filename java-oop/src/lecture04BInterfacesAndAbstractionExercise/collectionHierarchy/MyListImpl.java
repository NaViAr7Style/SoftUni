package lecture04BInterfacesAndAbstractionExercise.collectionHierarchy;

public class MyListImpl extends Collection implements MyList {

    @Override
    public String remove() {
        return getItems().remove(0);
    }

    @Override
    public int add(String item) {
        getItems().add(0, item);
        return 0;
    }

    @Override
    public int getUsed() {
        return getItems().size();
    }
}
