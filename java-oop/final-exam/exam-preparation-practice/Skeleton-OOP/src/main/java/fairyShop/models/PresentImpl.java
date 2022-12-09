package fairyShop.models;

public class PresentImpl implements Present {

    private String name;
    private int energyRequired;

    public PresentImpl(String name, int energyRequired) {
        setName(name);
        setEnergyRequired(energyRequired);
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public int getEnergyRequired() {
        return 0;
    }

    @Override
    public boolean isDone() {
        return false;
    }

    @Override
    public void getCrafted() {

    }

    private void setName(String name) {
        this.name = name;
    }

    private void setEnergyRequired(int energyRequired) {
        this.energyRequired = energyRequired;
    }

}
