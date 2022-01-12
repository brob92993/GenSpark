package Java;

import java.util.Scanner;

public class Main {
    String name;
    String playAgain;

    // need to add instance of the human and ask for humans name
    // Need an amount of turns
    // Turn based game
    // Need to have the character move across the land

    public String getName(){
        return Human.class.getName();
    }

    public void setName(String name){
        this.name = name;
    }

    public String getPlayAgain(){
        return playAgain;
    }
    public void setPlayAgain(String playAgain) {
        this.playAgain = playAgain;
    }

    public void setUp() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter your name");
        try {
            setName(input.nextLine());
        }catch (Exception e){
            System.out.println("name error, We will make your name BBB");
            setName("BBB");
        }
    }

    public void game() {
        Human h = new Human();
        h.setName(getName());
        System.out.println("Welcome to the game " + h.getName());
        System.out.println("You are on the land");
        System.out.println("You can move left(west), right(east), up(north), or down(south)! just type l, r, u, or d");
        System.out.println("You can also quit! just type q");
        
        Scanner input = new Scanner(System.in);
        String move = input.nextLine();

    while (move != "q") {
            if (move.equals("l")) {
                System.out.println("You moved left(west)");
            } else if (move.equals("r")) {
                System.out.println("You moved right(east)");
            } else if (move.equals("u")) {
                System.out.println("You moved up(north)");
            } else if (move.equals("d")) {
                System.out.println("You moved down(south)");
            } else if (move.equals("q")) {
                        break;
            } else {
                System.out.println("You did not move");
            }
             move = input.nextLine();
        }
    }

    private void quitGame() {
        setPlayAgain("n");
    }

    private void playGame() {
        Scanner input = new Scanner(System.in);
        setPlayAgain("y");

     while(getPlayAgain().equals("y")) {
        setUp();
        game();
        System.out.println("Play again? (y or n)");
     try{
        setPlayAgain( input.nextLine().toLowerCase() );
     } catch (Exception e) {
        System.out.println("Enter y or n");
        setPlayAgain("n");
        }
    }
 }

    public static void main(String[] args) {
        new Main().playGame();
    }
}





