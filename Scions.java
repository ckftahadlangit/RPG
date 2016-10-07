package cute;

public class Scions extends Character {

    public static final int BASE_ATTACK = 5;
    private static final int ARMOR = 50;

    public Scions(String name, int level) {
        super(name, level + ARMOR, level);
    }

    public int attack() {
        return BASE_ATTACK + (getLevel()*2);
    }
}
