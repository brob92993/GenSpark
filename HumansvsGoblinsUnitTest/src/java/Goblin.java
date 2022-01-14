import java.util.Random;

public class Goblin {

    Random rand = new Random();
    private int health = 20;
    private int attack = rand.nextInt(10)+1;


    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    @Override
    public String toString(){
        return "Mr. Gob has " + this.health + " health left!";
    }
}
