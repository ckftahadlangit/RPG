package cute;

public class Quizzes extends Character {
    public static final int BASE_ATTACK = 5;
    private static final int ARMOR = 20;

    public Quizzes(String name, int level) {
        super(name, level + ARMOR, level);
    }

    public int attack() {
        return BASE_ATTACK + getLevel();
    }
}
