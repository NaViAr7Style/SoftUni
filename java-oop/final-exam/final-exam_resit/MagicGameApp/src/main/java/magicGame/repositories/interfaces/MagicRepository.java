package magicGame.repositories.interfaces;

import magicGame.models.magics.Magic;

import java.util.Collection;

public interface MagicRepository<T> {
    Collection<T> getData();

    void addMagic(Magic magic);

    boolean removeMagic(Magic magic);

    T findByName(String name);
}
