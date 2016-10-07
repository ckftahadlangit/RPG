package cute;

public class Theses extends Character {
    public static final int BASE_ATTACK = 10;
    private static final int ARMOR = 50;

    public Theses(String name, int level) {
        super(name, level + ARMOR, level);
    }

    public int attack() {
        return BASE_ATTACK + getLevel();
    }
}
