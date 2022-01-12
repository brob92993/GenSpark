package Java;

import java.util.Random;
import java.util.Scanner;

public class Human {
    private int health = 10;
    private String Name;


    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public String getName(){
        return Name;
    }

    public void setName(String name){
        this.Name = name;
    }

    @Override
    public String toString(){
        return   "Human has" + this.health + " health left!";
    }

    public Goblin attack(Goblin gob) {
        Random random = new Random();
        
        int newGobHealth = (random.nextInt(10)+1) - gob.getHealth();
        gob.setHealth(newGobHealth);
        

        return gob;
    }
}