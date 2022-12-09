package fairyShop.core;

import fairyShop.models.*;
import fairyShop.repositories.HelperRepository;
import fairyShop.repositories.PresentRepository;
import fairyShop.repositories.Repository;

import java.util.List;
import java.util.stream.Collectors;

import static fairyShop.common.ConstantMessages.*;
import static fairyShop.common.ExceptionMessages.*;

public class ControllerImpl implements Controller {

    private Repository<Helper> helperRepository;
    private Repository<Present> presentRepository;
    private int craftedPresents;
    private int brokenToolsCount;

    public ControllerImpl() {
        helperRepository = new HelperRepository();
        presentRepository = new PresentRepository();
    }

    @Override
    public String addHelper(String type, String helperName) {

        Helper helper;

        switch (type) {
            case "Happy":
                helper = new Happy(helperName);
                break;
            case "Sleepy":
                helper = new Sleepy(helperName);
                break;
            default:
                throw new IllegalArgumentException(HELPER_TYPE_DOESNT_EXIST);
        }

        helperRepository.add(helper);

        return String.format(ADDED_HELPER, type, helperName);
    }

    @Override
    public String addInstrumentToHelper(String helperName, int power) {

        Helper helper = helperRepository.findByName(helperName);
        Instrument instrument = new InstrumentImpl(power);

        if (helper == null) {
            throw new IllegalArgumentException(HELPER_DOESNT_EXIST);
        }

        helper.getInstruments().add(instrument);

        return String.format(SUCCESSFULLY_ADDED_INSTRUMENT_TO_HELPER, power, helperName);
    }

    @Override
    public String addPresent(String presentName, int energyRequired) {
        Present present = new PresentImpl(presentName, energyRequired);
        presentRepository.add(present);

        return String.format(SUCCESSFULLY_ADDED_PRESENT, presentName);
    }

    @Override
    public String craftPresent(String presentName) {

        List<Helper> suitableHelpers = helperRepository.getModels().stream()
                .filter(helper -> helper.getEnergy() > 50)
                .collect(Collectors.toList());

        if (suitableHelpers.isEmpty()) {
            throw new IllegalArgumentException(NO_HELPER_READY);
        }

        Shop shop = new ShopImpl();
        Helper helper = suitableHelpers.iterator().next();
        Present present = presentRepository.findByName(presentName);

        int allToolsCount = suitableHelpers.stream()
                .mapToInt(h -> h.getInstruments().size())
                .sum();

        while (helper.canWork() && !present.isDone() && helper.getInstruments().size() > 0) {
            shop.craft(present, helper);

            if (!helper.canWork() && suitableHelpers.iterator().hasNext()) {
                helper = suitableHelpers.iterator().next();
            }
        }

        int remainingToolsCount = suitableHelpers.stream()
                .mapToInt(h -> h.getInstruments().size())
                .sum();

        brokenToolsCount += allToolsCount - remainingToolsCount;

        String presentStatus = present.isDone() ?
                "done" :
                "not done";

        if (present.isDone()) {
            craftedPresents++;
        }

        return String.format(PRESENT_DONE, presentName, presentStatus) +
                String.format(COUNT_BROKEN_INSTRUMENTS, brokenToolsCount);
    }

    @Override
    public String report() {
        StringBuilder sb = new StringBuilder();

        sb.append(String.format("%d presents are done!", craftedPresents))
                .append(System.lineSeparator())
                .append("Helpers info:");

        for (Helper helper : helperRepository.getModels()) {

            sb.append(System.lineSeparator())
                    .append(String.format("Name: %s%n", helper.getName()))
                    .append(String.format("Energy: %d%n", helper.getEnergy()))
                    .append(String.format("Instruments: %d not broken left", helper.getInstruments().size()));

        }

        return sb.toString();
    }

}
