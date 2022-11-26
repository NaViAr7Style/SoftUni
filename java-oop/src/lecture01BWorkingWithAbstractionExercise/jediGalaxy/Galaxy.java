package lecture01BWorkingWithAbstractionExercise.jediGalaxy;

public class Galaxy {
    private Field field;
    private Jedi jedi;
    private EvilPower evilPower;

    public Galaxy(Field field, Jedi jedi, EvilPower evilPower) {
        this.field = field;
        this.jedi = jedi;
        this.evilPower = evilPower;
    }

    public long moveJedi() {
        return jedi.move(field);
    }

    public void moveEvil() {
        evilPower.move(field);
    }
}