package magicGame.repositories.interfaces;

import magicGame.models.magicians.Magician;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

import static magicGame.common.ExceptionMessages.INVALID_MAGICIAN_REPOSITORY;

public class MagicianRepositoryImpl implements MagicianRepository<Magician> {

    Map<String, Magician> data;

    public MagicianRepositoryImpl() {
        data = new LinkedHashMap<>();
    }

    @Override
    public Collection<Magician> getData() {
        return data.values().stream().collect(Collectors.toUnmodifiableList());
    }

    @Override
    public void addMagician(Magician magician) {

        if (magician == null) {
            throw new NullPointerException(INVALID_MAGICIAN_REPOSITORY);
        }

        data.put(magician.getUsername(), magician);
    }

    @Override
    public boolean removeMagician(Magician magician) {
        return data.remove(magician.getUsername(), magician);
    }

    @Override
    public Magician findByUsername(String name) {
        return data.get(name);
    }

}
