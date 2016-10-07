package cute;

public class Bullets extends Character {
    public static final int BASE_ATTACK = 10;
    private static final int ARMOR = 30;

    public Bullets(String name, int level) {
        super(name, level + ARMOR, level);
    }
    public int attack() {
        return BASE_ATTACK + (getLevel()*2);
    }
}
