package fairyShop.models;

import java.util.ArrayList;
import java.util.Collection;

public abstract class BaseHelper implements Helper {

    private String name;
    private int energy;
    private Collection<Instrument> instruments;

    protected BaseHelper(String name, int energy) {
        setName(name);
        setEnergy(energy);
        instruments = new ArrayList<>();
    }

    @Override
    public void work() {
        energy = Math.max(0, energy - 10);
    }

    @Override
    public void addInstrument(Instrument instrument) {

    }

    @Override
    public boolean canWork() {
        return false;
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public int getEnergy() {
        return 0;
    }

    @Override
    public Collection<Instrument> getInstruments() {
        return null;
    }

    private void setName(String name) {
        this.name = name;
    }

    protected void setEnergy(int energy) {
        this.energy = energy;
    }
}
