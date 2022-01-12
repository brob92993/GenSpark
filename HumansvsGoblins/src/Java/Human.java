package Java;

import java.util.Random;


public class Human extends Main {
    private int health = 10;

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    @Override
    public String toString(){
        return  Main.class.getName() + "has" + this.health + "left!";
    }

    public Goblin attack(Goblin gob) {
        Random random = new Random();

        int newGobHealth = (random.nextInt(10)+1) - gob.getHealth();
        gob.setHealth(newGobHealth);

        return gob;
    }
}