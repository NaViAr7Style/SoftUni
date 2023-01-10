package magicGame.models.magicians;

import magicGame.models.magics.Magic;

import static magicGame.common.ExceptionMessages.*;

public abstract class MagicianImpl implements Magician {

    private String username;
    private int health;
    private int protection;
    private boolean isAlive;
    private Magic magic;

    protected MagicianImpl(String username, int health, int protection, Magic magic) {
        setUsername(username);
        setHealth(health);
        setProtection(protection);
        setMagic(magic);

        if (this.health > 0) {
            isAlive = true;
        }
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public int getHealth() {
        return health;
    }

    @Override
    public int getProtection() {
        return protection;
    }

    @Override
    public Magic getMagic() {
        return magic;
    }

    @Override
    public boolean isAlive() {
        return isAlive;
    }

    @Override
    public void takeDamage(int points) {

        int leftover;

        if (points < protection) {
            protection -= points;
            return;
        } else {
            leftover = points - protection;
            protection = 0;
        }

        if (leftover >= 0) {
            health = Math.max(0, getHealth() - leftover);
        }

        if (health <= 0) {
            isAlive = false;
        }

    }

    private void setUsername(String username) {

        if (username == null || username.trim().isEmpty()) {
            throw new NullPointerException(INVALID_MAGICIAN_NAME);
        }

        this.username = username;
    }

    private void setHealth(int health) {

        if (health < 0) {
            throw new IllegalArgumentException(INVALID_MAGICIAN_HEALTH);
        }

        this.health = health;
    }

    private void setProtection(int protection) {

        if (protection < 0) {
            throw new IllegalArgumentException(INVALID_MAGICIAN_PROTECTION);
        }

        this.protection = protection;
    }

    private void setMagic(Magic magic) {

        if (magic == null) {
            throw new NullPointerException(INVALID_MAGIC);
        }

        this.magic = magic;
    }

    @Override
    public String toString() {

        return String.format("%s: %s%n", this.getClass().getSimpleName(), getUsername()) +
                String.format("Health: %d%n", getHealth()) +
                String.format("Protection: %d%n", getProtection()) +
                String.format("Magic: %s", getMagic().getName());
    }
}