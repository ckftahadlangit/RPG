package cute;

public class Stallions extends Character {
    public static final int BASE_ATTACK = 10;
    private static final int ARMOR = 20;

    public Stallions(String name, int level) {
        super(name, level + ARMOR, level);
    }

    public int attack() {
        return BASE_ATTACK + (getLevel()*2);
    }


}
