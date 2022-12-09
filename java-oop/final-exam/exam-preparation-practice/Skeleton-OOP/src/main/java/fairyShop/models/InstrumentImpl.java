package fairyShop.models;

public class InstrumentImpl implements Instrument {

    private int power;

    public InstrumentImpl(int power) {
        setPower(power);
    }

    @Override
    public int getPower() {
        return 0;
    }

    @Override
    public void use() {

    }

    @Override
    public boolean isBroken() {
        return false;
    }

    private void setPower(int power) {
        this.power = power;
    }

}
