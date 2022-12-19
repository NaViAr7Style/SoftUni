package magicGame.repositories.interfaces;

import magicGame.models.magics.Magic;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

import static magicGame.common.ExceptionMessages.INVALID_MAGIC_REPOSITORY;

public class MagicRepositoryImpl implements MagicRepository<Magic> {

    Map<String, Magic> data;

    public MagicRepositoryImpl() {
        data = new LinkedHashMap<>();
    }

    @Override
    public Collection<Magic> getData() {
        return data.values().stream().collect(Collectors.toUnmodifiableList());
    }

    @Override
    public void addMagic(Magic magic) {

        if (magic == null) {
            throw new NullPointerException(INVALID_MAGIC_REPOSITORY);
        }

        data.put(magic.getName(), magic);
    }

    @Override
    public boolean removeMagic(Magic magic) {
        return data.remove(magic.getName(), magic);
    }

    @Override
    public Magic findByName(String name) {
        return data.get(name);
    }

}
