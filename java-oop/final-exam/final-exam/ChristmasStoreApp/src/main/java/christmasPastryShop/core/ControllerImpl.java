package christmasPastryShop.core;

import christmasPastryShop.common.enums.BoothType;
import christmasPastryShop.common.enums.CocktailType;
import christmasPastryShop.common.enums.DelicacyType;
import christmasPastryShop.core.interfaces.Controller;
import christmasPastryShop.entities.booths.interfaces.OpenBooth;
import christmasPastryShop.entities.booths.interfaces.PrivateBooth;
import christmasPastryShop.entities.cocktails.interfaces.Hibernation;
import christmasPastryShop.entities.cocktails.interfaces.MulledWine;
import christmasPastryShop.entities.delicacies.interfaces.Delicacy;
import christmasPastryShop.entities.cocktails.interfaces.Cocktail;
import christmasPastryShop.entities.booths.interfaces.Booth;
import christmasPastryShop.entities.delicacies.interfaces.Gingerbread;
import christmasPastryShop.entities.delicacies.interfaces.Stolen;
import christmasPastryShop.repositories.interfaces.BoothRepository;
import christmasPastryShop.repositories.interfaces.CocktailRepository;
import christmasPastryShop.repositories.interfaces.DelicacyRepository;

import java.util.Optional;

import static christmasPastryShop.common.ExceptionMessages.*;
import static christmasPastryShop.common.OutputMessages.*;

public class ControllerImpl implements Controller {

    private DelicacyRepository<Delicacy> delicacyRepository;
    private CocktailRepository<Cocktail> cocktailRepository;
    private BoothRepository<Booth> boothRepository;
    private double totalIncome;

    public ControllerImpl(DelicacyRepository<Delicacy> delicacyRepository, CocktailRepository<Cocktail> cocktailRepository, BoothRepository<Booth> boothRepository) {
        this.delicacyRepository = delicacyRepository;
        this.cocktailRepository = cocktailRepository;
        this.boothRepository = boothRepository;
    }

    @Override
    public String addDelicacy(String type, String name, double price) {

        Optional<Delicacy> delicacy = Optional.empty();
        DelicacyType delicacyType = DelicacyType.valueOf(type);

        switch (delicacyType) {
            case Gingerbread:
                delicacy = Optional.of(new Gingerbread(name, price));
                break;
            case Stolen:
                delicacy = Optional.of(new Stolen(name, price));
                break;
        }

        if (delicacyRepository.getByName(name) != null) {
            alreadyPresentError(delicacyType.toString(), name);
        }

        delicacy.ifPresent(value -> delicacyRepository.add(value));

        return String.format(DELICACY_ADDED, name, delicacyType);
    }

    private static void alreadyPresentError(String type, String name) {
        String errorMessage = String.format(FOOD_OR_DRINK_EXIST, type, name);
        throw new IllegalArgumentException(errorMessage);
    }

    @Override
    public String addCocktail(String type, String name, int size, String brand) {

        Optional<Cocktail> cocktail = Optional.empty();
        CocktailType cocktailType = CocktailType.valueOf(type);

        switch (cocktailType) {
            case MulledWine:
                cocktail = Optional.of(new MulledWine(name, size, brand));
                break;
            case Hibernation:
                cocktail = Optional.of(new Hibernation(name, size, brand));
                break;
        }

        if (cocktailRepository.getByName(name) != null) {
            alreadyPresentError(cocktailType.toString(), name);
        }

        cocktail.ifPresent(value -> cocktailRepository.add(value));

        return String.format(COCKTAIL_ADDED, name, brand);
    }

    @Override
    public String addBooth(String type, int boothNumber, int capacity) {

        Optional<Booth> booth = Optional.empty();
        BoothType boothType = BoothType.valueOf(type);

        switch (boothType) {
            case OpenBooth:
                booth = Optional.of(new OpenBooth(boothNumber, capacity));
                break;
            case PrivateBooth:
                booth = Optional.of(new PrivateBooth(boothNumber, capacity));
                break;
        }

        if (boothRepository.getByNumber(boothNumber) != null) {
            String errorMessage = String.format(BOOTH_EXIST, boothNumber);
            throw new IllegalArgumentException(errorMessage);
        }

        booth.ifPresent(value -> boothRepository.add(value));

        return String.format(BOOTH_ADDED, boothNumber);
    }

    @Override
    public String reserveBooth(int numberOfPeople) {

        Booth suitableBooth = boothRepository.getAll().stream()
                .filter(booth -> !booth.isReserved())
                .filter(booth -> booth.getCapacity() >= numberOfPeople)
                .findFirst()
                .orElse(null);

        String output;

        if (suitableBooth == null) {
            output = String.format(RESERVATION_NOT_POSSIBLE, numberOfPeople);
        } else {
            suitableBooth.reserve(numberOfPeople);
            output = String.format(BOOTH_RESERVED, suitableBooth.getBoothNumber(), numberOfPeople);
        }

        return output;
    }

    @Override
    public String leaveBooth(int boothNumber) {

        Booth booth = boothRepository.getByNumber(boothNumber);

        double boothBill = booth.getBill();
        totalIncome += boothBill;
        booth.clear();

        return String.format(BILL, boothNumber, boothBill);
    }

    @Override
    public String getIncome() {
        return String.format(TOTAL_INCOME, totalIncome);
    }

}
