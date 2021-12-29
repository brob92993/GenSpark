import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Main {

    private int number, choice;
    private String playAgain;
    private String Name;

    public Main(){

    }

    public String getName(){
        return Name;
    }
    public void setName(String name){
        this.Name = name;
    }

    //getter setter for playAgain option
    public String getPlayAgain(){
        return playAgain;
    }
    public void setPlayAgain(String playAgain) {
        this.playAgain = playAgain;
    }


    public int getChoice(){
        return choice;
    }
    public void setChoice(int choice) {
        this.choice = choice;
    }


    public int getNumber(){
        return number;
    }
    public void setNumber(int number) {
        this.number = number;
    }

    // set up
    public void setUp(){
        Scanner input = new Scanner(System.in);
        System.out.println("Hey there! What's your name?");
        try {
            setName( input.nextLine() );
        }catch (Exception e){
            System.out.println("name error, We will make your name BBB");
            setName("BBB");
        }
    }

    //make number between 1 and 20
    private void createNumber(){
        System.out.println("Well, " + getName() + " I'm thinking of a number between 1 and 20...");
        Random random = new Random();
        setNumber(random.nextInt(20)+1);
    }

    // game
    public void game(){
        int count = 0;

        while(count<6){
            System.out.println("Take a guess...");

            setChoice( decision() );
            if (getChoice() > getNumber() )
                System.out.println("Your guess is too high. Lets try again");
            if (getChoice() < getNumber() )
                System.out.println("Your guess is too low. Lets try again");
            if (getChoice() == getNumber() ) {
                System.out.println("You got it " + getName() + "!");
                System.out.println( "You guessed the right number in " + (count + 1) + " tries!");
                return;
            }
            count++;
        }
        if(count == 6)
            System.out.println("Out of tries! The correct number was " + getNumber() + "\n");
    }

    // player decision
    public int decision(){
        Scanner input = new Scanner(System.in);
        try {
            return input.nextInt();
        }catch (InputMismatchException e) {
            System.out.println("Not a number! Try again...");
        } return 0;
    }

    public void playGame(){
        Scanner input = new Scanner(System.in);
        setPlayAgain("y");


        while(getPlayAgain().equals("y")) {
            setUp();
            createNumber();
            game();
            System.out.println("Play again? (y or n)");
            try{
                setPlayAgain( input.nextLine().toLowerCase() );
            }catch (Exception e) {
                System.out.println("Enter y or n");
                setPlayAgain("n");
            }
        }
    }


    public static void main(String[] args) {
        new Main().playGame();
    }

}
