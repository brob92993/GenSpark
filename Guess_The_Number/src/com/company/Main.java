package com.company;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // write your code here
        Boolean play = true;
        while (play) {

        int min = 1;
        int max = 20;
        int a;
        String s;
        int tries = 0;
        final int maxAttempts = 6;

        Random r = new Random();


            System.out.println("Hello! What is your name?");
            Scanner obj = new Scanner(System.in);
            s = obj.nextLine();
            System.out.println("Well, " + s + ", I am thinking of a number between 1 & 20. Take a guess..");
            int value = (int) (Math.random()*(max-min)) + min;
            ++tries;

            do {
                a = obj.nextInt();
                if (a == value) {
                    System.out.println("You guessed it! The number was " + value);
                    System.out.println("You guessed the number in " + tries + " tries");
                    break;
                    
                } else if (a < value) {
                    ++tries;
                    System.out.println("Your guess is too low. Take another guess.");
                } else if (a > value) {
                    ++tries;
                    System.out.println("Your guess is too high. Take another guess.");
                }
                if (tries == maxAttempts) {
                    System.out.println("Out of tries! The number was " + value);
                }
            } while (tries != maxAttempts);


            System.out.println("Do you want to play again? (y/n)");
            String answer = obj.next();
            if (answer.equals("y")) {
                play = true;
            } else {
                play = false;
            }
        }

    }
}
