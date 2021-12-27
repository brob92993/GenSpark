package com.company;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // write your code here

        System.out.println("You are in a land full of dragons.");
        System.out.println("In front of you, you see two caves.");
        System.out.println("In one cave, the dragon is friendly and will share his treasure with you");
        System.out.println("The other dragon is greedy and hungry and will eat you on sight");
        System.out.println("Which cave will you go into? 1? or 2..");

        try {
            Scanner getInput = new Scanner(System.in);
            String input = getInput.nextLine();
            if (input == "1") {
                System.out.println("You approach the cave...");
                System.out.println("It is dark and spooky...");
                System.out.println("A large dragon jumps out in front of you! He opens his jaws and...");
                System.out.println("Gobbles you down in one bite!");

            } else {
                System.out.println("You approach the cave...");
                System.out.println("And a bright beam of light appears!");
                System.out.println("Next thing you know, you're on the back of a large (but friendly) dragon!");
                System.out.println("You and your dragon soar off into the infinite realm, never to be seen again...");

            }
        } catch (Exception e) {
            System.out.println("Please enter a valid number");
            return;
        }
    }
}

