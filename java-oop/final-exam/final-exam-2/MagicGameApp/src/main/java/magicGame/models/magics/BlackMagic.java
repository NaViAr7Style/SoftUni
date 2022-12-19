package magicGame.models.magics;

public class BlackMagic extends MagicImpl {

    private static final int BULLETS_SHOT_AT_ONCE = 10;

    public BlackMagic(String name, int bulletsCount) {
        super(name, bulletsCount);
    }

    @Override
    public int fire() {
        int remainingBullets = Math.max(0, getBulletsCount() - BULLETS_SHOT_AT_ONCE);

        this.setBulletsCount(remainingBullets);

        return BULLETS_SHOT_AT_ONCE;
    }
}
