import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public void begin(){

        System.out.println(start());

        Scanner input = new Scanner(System.in);

        try{
            System.out.println(getOption( input.nextInt()));

        }catch (InputMismatchException e){
            System.out.println("Error: Not a number");
        }
    }

    public String getOption(int choice){
        if (choice == 1)
            return optionOne();

        if (choice == 2)
            return optionTwo();
        return invalid();
    }

    public String start(){
        return ("\nYou are in a land full of dragons. In front of you,\n" +
                "you see two caves. In one cave, the dragon is friendly\n" +
                "and will share his treasure with you. The other dragon\n" +
                "is greedy and hungry and will eat you on sight!\n" +
                "Which cave will you go into? choose 1 or 2..\n");
    }

    public String optionOne(){
        return ("\nYou approach the cave...\n" +
                "And a bright beam of light appears!\n" +
                "Next thing you know, you're on the back of a large (but friendly) dragon!\n" +
                "You and your new dragon friend soar off into the infinite realm with his treasure, never to be seen again...");
    }

    public String optionTwo(){
        return ("\nYou approach the cave...\n" +
                "It is dark and spooky...\n" +
                "A large dragon jumps out in front of you! He opens his jaws and...\n" +
                "Gobbles you down in one bite!\n");
    }

    public String invalid(){
        return ("\nYou made an invalid choice...choose 1 or 2\n");
    }

    public static void main(String[] args) {
        new Main().begin();
    }
}