package Java;

import java.util.Random;

public class Goblin extends Main{
    private int health = 10;

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public Human attack(Human hum) {
        Random random = new Random();

        int newHumHealth = (random.nextInt(10)+1) - hum.getHealth();
        hum.setHealth(newHumHealth);

        return hum;
    }

    @Override
    public String toString(){
        return "This goblin has" + this.health + "left!";
    }
}

