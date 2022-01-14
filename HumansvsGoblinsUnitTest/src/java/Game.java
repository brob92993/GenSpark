import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

public class Game {

        ArrayList<Land> map;
        Land yourArea;
        Land gobArea;
        Human player;
        Goblin goblin;

        // constructor
        public Game() {

            map = new LoadMap().getAllMaps();
            player = new Human();
            goblin = new Goblin();
            yourArea = map.get(1); // start in the middle of the map
            gobArea = map.get(0);

        }

        // main
        public static void main(String[] args) {
            new Game().gameFeed();
        }

        // gameArea Setter
        public void setCurrentArea(Land yourArea) {
            this.yourArea = yourArea;
        }

        // this method is used to decode directions
        public int toMove(String direction, HashMap<String, Integer> gameArea) {
            if (gameArea.get(direction) == -1) {
                System.out.println("Dead end! try another route");
                goblinMove();
                gameFeed();
            }
            return gameArea.get(direction);
        }

        // how the goblin moves through the map
        public void goblinMove() {

            Random random = new Random();
            ArrayList<Integer> route = new ArrayList<>();

            if (gobArea.getN() != -1)
                route.add(gobArea.getN());
            if (gobArea.getS() != -1)
                route.add(gobArea.getS());
            if (gobArea.getE() != -1)
                route.add(gobArea.getE());
            if (gobArea.getW() != -1)
                route.add(gobArea.getW());

            gobArea = map.get(route.get(random.nextInt(route.size())));
        }

        // built for requesting user input
        public String userInput() {

            Scanner input = new Scanner(System.in);
            String command;
            try {
                command = input.nextLine();
                return command.toLowerCase();

            } catch (Exception e) {
                return "Error: method userInput failed";
            }
        }

        // built for displaying the game info
        public void gameFeed() {
            System.out.println("\n------------------\nYou're in " + yourArea.getName());
            delay(1500);

            System.out.println("\nFind and defeat Mr. Gob in the " + gobArea.getName());
            delay(1500);

            System.out.println(player);

            delay(1000);

            System.out.println(goblin);

            // if the area you're in is the same as the area the goblin is in, theres a battle
            if (yourArea.getName().equals(gobArea.getName())) {

                System.out.println("\nBattle in " + yourArea.getName() + "!!!");
                delay(1500);

                goblin.setHealth(goblin.getHealth() - player.getAttack());
                player.setHealth(player.getHealth() - goblin.getAttack());
                delay(1500);

                System.out.println(player + "\n" + goblin);
                delay(1500);

                goblinMove();
                System.out.println("Mr Gob is now in " + gobArea.getName());
            }

            // if goblin is dead, you win
            if (goblin.getHealth() <= 0) {
                System.out.println("\nMr. Gob is dead, which means...");
                delay(1000);

                System.out.println("\nYou win!! Thanks for playing!");
                delay(4000);

                System.exit(0);

            }

            // if player is dead then game over
            else if (player.getHealth() <= 0) {
                System.out.println("\nYou are dead, which means....");
                delay(1000);

                System.out.println("\nYou lose.. Better luck next time!");
                delay(4000);

                System.exit(0);
            }

            // if both player and zombie die, you lose and game ends
            else if (player.getHealth() <= 0 && goblin.getHealth() <= 0){
                System.out.println("\nYou and Mr. Gob are both dead");
                delay(1000);

                System.out.println("\nYou lose.. Better luck next time!");
                delay(4000);

                System.exit(0);
            }

            delay(1000);
            System.out.print("\nType north, south, east, or west to move\n> ");

            String move = userInput();
            playerDecision(move);
        }

        // setting up the delay function
        public static void delay(int millis) {
            try {
                Thread.sleep(millis);
            } catch (InterruptedException exp) {
            }
        }

        // what happens after the user input
        public void playerDecision(String decision){

            try {
                setCurrentArea( map.get( toMove( decision, yourArea.getNavTable() ) ) );
                goblinMove();
                gameFeed();

            }catch (NullPointerException e){
                System.err.println("Error: Decision failure");
                goblinMove();
                gameFeed();

            }catch (ArrayIndexOutOfBoundsException e){
                System.err.println("Error: Index out of bounds");
                goblinMove();
                gameFeed();
            }
        }


    }




