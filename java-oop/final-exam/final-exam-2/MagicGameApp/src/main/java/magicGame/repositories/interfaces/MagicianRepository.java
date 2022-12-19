package magicGame.repositories.interfaces;

import magicGame.models.magicians.Magician;

import java.util.Collection;

public interface MagicianRepository<T> {
    Collection<T> getData();

    void addMagician(Magician magician);

    boolean removeMagician(Magician magician);

    T findByUsername(String name);
}
