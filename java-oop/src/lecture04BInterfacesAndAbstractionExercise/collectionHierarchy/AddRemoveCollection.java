package lecture04BInterfacesAndAbstractionExercise.collectionHierarchy;

public class AddRemoveCollection extends Collection implements AddRemovable {

    @Override
    public String remove() {
        return getItems().remove(getItems().size() - 1);
    }

    @Override
    public int add(String item) {
        getItems().add(0, item);
        return 0;
    }
}
