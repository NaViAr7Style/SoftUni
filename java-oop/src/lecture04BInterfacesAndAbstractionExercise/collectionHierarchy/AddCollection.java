package lecture04BInterfacesAndAbstractionExercise.collectionHierarchy;

public class AddCollection extends Collection implements Addable {

    @Override
    public int add(String item) {
        getItems().add(item);
        return getItems().size() - 1;
    }

}
