package fairyShop.models;

import java.util.ArrayList;
import java.util.Collection;

import static fairyShop.common.ExceptionMessages.HELPER_NAME_NULL_OR_EMPTY;

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
        instruments.add(instrument);
    }

    @Override
    public boolean canWork() {
        return getEnergy() > 0;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getEnergy() {
        return energy;
    }

    @Override
    public Collection<Instrument> getInstruments() {
        return instruments;
    }

    private void setName(String name) {

        if (name == null || name.trim().isEmpty()) {
            throw new NullPointerException(HELPER_NAME_NULL_OR_EMPTY);
        }

        this.name = name;
    }

    protected void setEnergy(int energy) {
        this.energy = energy;
    }

}
