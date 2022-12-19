package magicGame.core;

import magicGame.models.magicians.BlackWidow;
import magicGame.models.magicians.Magician;
import magicGame.models.magicians.Wizard;
import magicGame.models.magics.BlackMagic;
import magicGame.models.magics.Magic;
import magicGame.models.magics.RedMagic;
import magicGame.models.region.Region;
import magicGame.models.region.RegionImpl;
import magicGame.repositories.interfaces.MagicRepository;
import magicGame.repositories.interfaces.MagicRepositoryImpl;
import magicGame.repositories.interfaces.MagicianRepository;
import magicGame.repositories.interfaces.MagicianRepositoryImpl;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static magicGame.common.ExceptionMessages.*;
import static magicGame.common.OutputMessages.*;

public class ControllerImpl implements Controller {

    private MagicRepository<Magic> magics;
    private MagicianRepository<Magician> magicians;
    private Region region;

    public ControllerImpl() {
        magics = new MagicRepositoryImpl();
        magicians = new MagicianRepositoryImpl();
        region = new RegionImpl();
    }

    @Override
    public String addMagic(String type, String name, int bulletsCount) {

        Magic magic;

        switch (type) {
            case "RedMagic":
                magic = new RedMagic(name, bulletsCount);
                break;
            case "BlackMagic":
                magic = new BlackMagic(name, bulletsCount);
                break;
            default:
                throw new IllegalArgumentException(INVALID_MAGIC_TYPE);
        }

        magics.addMagic(magic);

        return String.format(SUCCESSFULLY_ADDED_MAGIC, name);
    }

    @Override
    public String addMagician(String type, String username, int health, int protection, String magicName) {

        Magic magic = magics.findByName(magicName);

        if (magic == null) {
            throw new NullPointerException(MAGIC_CANNOT_BE_FOUND);
        }

        Magician magician;

        switch (type) {
            case "Wizard":
                magician = new Wizard(username, health, protection, magic);
                break;
            case "BlackWidow":
                magician = new BlackWidow(username, health, protection, magic);
                break;
            default:
                throw new IllegalArgumentException(INVALID_MAGICIAN_TYPE);
        }

        magicians.addMagician(magician);

        return String.format(SUCCESSFULLY_ADDED_MAGICIAN, username);
    }

    @Override
    public String startGame() {

        List<Magician> aliveMagicians = magicians.getData().stream()
                .filter(Magician::isAlive)
                .collect(Collectors.toList());

        return region.start(aliveMagicians);
    }

    @Override
    public String report() {

        StringBuilder sb = new StringBuilder();

        magicians.getData().stream()
                .sorted(Comparator.comparing(Magician::getHealth)
                        .thenComparing(Magician::getUsername)
                        .thenComparing(f -> f.getClass().getSimpleName()))
                .forEach(magician -> sb.append(magician)
                        .append(System.lineSeparator()));

        return sb.toString().trim();
    }

}
