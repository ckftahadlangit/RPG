package cute;

public abstract class Character {

    private String name;
    private int hp;
    private int level;

    public Character(String name, int hp, int level) {
        this.name = name;
        this.hp = hp;
        this.level = level;
    }

    public abstract int attack();

    public boolean isAlive() {
        return hp > 0 ? true : false;
    }

    public int takeDamage(int damage, int rand) {
        if (rand == 7) {
            System.out.println("CRITICAL ATTACK!");
            hp -= damage * 2;
        } else if (rand == 13){
            System.out.println("ATTACK AVOIDED!");
        } else {
            System.out.println("NORMAL ATTACK!");
            hp -= damage;
        }
        if(hp < 1)
            hp = 0;
        return hp;
    }
    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level += level;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp += hp;
    }

    @Override
    public String toString() {
        return name + "     HP = " + hp;
    }

}
