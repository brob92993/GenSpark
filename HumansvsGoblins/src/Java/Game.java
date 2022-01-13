package Java;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

    public class Game {
        Land currentRoom;
        Land gobRoom;
        ArrayList<Land> map;
        Human player;
        Goblin goblin;

        // constructor
        public Game() {
            map = new LoadMap().getAllMaps();
            currentRoom = map.get(1);
            gobRoom = map.get(2);
            player = new Human();
            goblin = new Goblin();
        }

        // main
        public static void main(String[] args) {
            new Game().userInterface();
        }

        // gameRoom Setter
        public void setCurrentRoom(Land currentRoom) {
            this.currentRoom = currentRoom;
        }

        // this method is used to decode directions
        public int toMove(String direction, HashMap<String, Integer> gameRoom) {
            if (gameRoom.get(direction) == -1) {
                System.out.println("dead end try another route");
                userInterface();
            }else if (gameRoom.get(direction) == 0){
                System.out.println("you have reached the end of the map");
                userInterface();
            }else if 
            return gameRoom.get(direction);
        }

        // how the goblin moves through the map
        public void goblinMove() {

            Random random = new Random();
            ArrayList<Integer> route = new ArrayList<>();

            if (gobRoom.getN() != -1)
                route.add(gobRoom.getN());
            if (gobRoom.getS() != -1)
                route.add(gobRoom.getS());
            if (gobRoom.getE() != -1)
                route.add(gobRoom.getE());
            if (gobRoom.getW() != -1)
                route.add(gobRoom.getW());

            gobRoom = map.get(route.get(random.nextInt(route.size())));
        }

        // built for requesting user command
        public String userCommand() {
            Scanner input = new Scanner(System.in);
            String command;
            try {
                command = input.nextLine();
                return command.toLowerCase();

            } catch (Exception e) {
                return "Error: method userCommand failed";
            }
        }

        // this is default hub which is display information
        public void userInterface() {
            System.out.println("\n------------------\nYou're in " + currentRoom.getName());
            System.out.println(player);
            System.out.println("\n Mr. Gob is in " + gobRoom.getName());
            System.out.println(goblin);

            if (currentRoom.getName().equals(gobRoom.getName())) {
                System.out.println("\nthere was a battle!!!");
                goblin.setHealth(goblin.getHealth() - player.getAttack());
                player.setHealth(player.getHealth() - goblin.getAttack());
                System.out.println(player + "\n" + goblin);
            }

            System.out.print("\nWhat do you do?\n> ");

            String move = userCommand();
            decision(move);
        }

        // this method represent all action after decision has been made
        public void decision(String decision) {
            try {
                setCurrentRoom(map.get(toMove(decision, currentRoom.getNavTable())));
                goblinMove();
                userInterface();

            } catch (NullPointerException e) {
                System.err.println("Error: decision failure");
                goblinMove();
                userInterface();

            } catch (ArrayIndexOutOfBoundsException e) {
                System.err.println("Error: failure Index out of bound");
                goblinMove();
                userInterface();
            }
        }

    }

