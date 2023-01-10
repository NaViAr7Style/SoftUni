package magicGame.models.region;

import magicGame.models.magicians.Magician;
import magicGame.models.magics.Magic;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class RegionImpl implements Region {

    @Override
    public String start(Collection<Magician> magicians) {

        List<Magician> wizards = new ArrayList<>();
        List<Magician> blackWidows = new ArrayList<>();

        magicians.forEach(magician -> {
                    if (magician.getClass().getSimpleName().equals("Wizard")) {
                        wizards.add(magician);
                    } else {
                        blackWidows.add(magician);
                    }
                });

        return null;
    }

    public boolean canShoot(Magic magic) {
        String magicType = magic.getClass().getSimpleName();
        int bulletCount = magic.getBulletsCount();

        boolean canShoot = false;

        if (magicType.equals("RedMagic") && bulletCount >= 1) {
            canShoot = true;
        } else if (magicType.equals("BlackMagic") && bulletCount >= 10) {
            canShoot = true;
        }

        return canShoot;
    }

}
