package fairyShop.models;

import java.util.Collection;

public class ShopImpl implements Shop {

    @Override
    public void craft(Present present, Helper helper) {

        Collection<Instrument> instruments = helper.getInstruments();

        if (instruments.isEmpty()) {
            return;
        }

        Instrument instrument = instruments.iterator().next();

        while (helper.canWork() && !present.isDone() && !instrument.isBroken()) {
            helper.work();
            present.getCrafted();
            instrument.use();

            if (instrument.isBroken() && instruments.iterator().hasNext()) {
                instrument = instruments.iterator().next();
            }
        }

    }

}
