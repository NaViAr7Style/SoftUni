package goldDigger.models.discoverer;

import goldDigger.models.museum.BaseMuseum;
import goldDigger.models.museum.Museum;

public abstract class BaseDiscoverer implements Discoverer {

    private String name;
    private double energy;
    private Museum museum;

    protected BaseDiscoverer(String name, double energy) {
        setName(name);
        setEnergy(energy);
        museum = new BaseMuseum();
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public double getEnergy() {
        return 0;
    }

    @Override
    public boolean canDig() {
        return false;
    }

    @Override
    public Museum getMuseum() {
        return null;
    }

    @Override
    public void dig() {

    }

    private void setName(String name) {
        this.name = name;
    }

    private void setEnergy(double energy) {
        this.energy = energy;
    }

}
