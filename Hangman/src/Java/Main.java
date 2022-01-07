import java.util.Random;
import java.util.Scanner;

public class Main {
    private String answer;
    String[] checkLetter;
    int count;

    // initial setup for the game with the count, word, answer, and checked letters
    public Main(){
        this.count = 0;
        String word = getWord();
        this.answer = word;
        this.checkLetter = (hiddenArray(word));
    }
    
    //get answer
    public String getAnswer(){
        return answer;
    }

    //set answer
    public void setAnswer(String answer){
        this.answer = answer;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String[] getCheckLetter() {
        return checkLetter;
    }


    // randomly choose a word 
    public String getWord(){

    String[] words = {"terminator", "banana", "computer", "cow", "rain", "water" };
	String word = words[(int) (Math.random() * words.length)];
    return word;  
    }

   
    public boolean contains(String[] list, String item){
        for(String element : list)
            if(element.equals(item))
                return true;
        return false;
    }

    // guessed letter comes in results comes out
    public String results(String letter){
        if(contains(checkLetter, letter))
            return "letter already guessed. Try again.";
        if(getAnswer().contains(letter)) {
            showLetter(letter);
            return "correct";
        }
        setCount(getCount()+1);
        return "incorrect";
    }

    // if the letter is guessed correctly it shall be revealed
    public void showLetter(String letter){
        for(int i = 0; i < getAnswer().length(); i++){
            if(getAnswer().charAt(i)==letter.charAt(0))
                checkLetter[i] = letter;
        }
    }

    // this creates the ____ blanks to start the game
    public String[] hiddenArray(String word){
        String[] hidden = new String[word.length()];
        for(int i = 0; i < hidden.length; i++)
            hidden[i] = "_";
        return hidden;
    }

    // this is where the hangman is drawn
    public String hangman(int error){
        switch(error) {
            case 0:
                return (" +---+\n" +
                        "     |\n" +
                        "     |\n" +
                        "     |\n" +
                        "    ===");
            case 1:
                return (" +---+\n" +
                        " O   |\n" +
                        "     |\n" +
                        "     |\n" +
                        "    ===");
            case 2:
                return (" +---+\n" +
                        " O   |\n" +
                        " |   |\n" +
                        "     |\n" +
                        "    ===");
            case 3:
                return (" +---+\n" +
                        " O   |\n" +
                        " |   |\n" +
                        " |   |\n" +
                        "    ===");
            case 4:
                return (" +---+\n" +
                        " O   |\n" +
                        "-|   |\n" +
                        " |   |\n" +
                        "    ===");
            case 5:
                return (" +---+\n" +
                        " O   |\n" +
                        "-|-  |\n" +
                        " |   |\n" +
                        "    ===");
            case 6:
                return (" +---+\n" +
                        " O   |\n" +
                        "-|-  |\n" +
                        " |   |\n" +
                        "/   ===");
            case 7:
                return (" +---+\n" +
                        " O   |\n" +
                        "-|-  |\n" +
                        " |   |\n" +
                        "/ \\ ===");
        }
        return "error";
    }

    // this was made to see the array
    public void checkArray(String[] wordList){
        for(String word : wordList)
            System.out.print(word + " ");
    }

    // checks to see if any of the blanks is still there
    public boolean checkResult(){
        if(contains(checkLetter, "_"))
            return false;
        return true;
    }

    //where the guess takes place
    public String theGuess(){
        Scanner input = new Scanner(System.in);
        System.out.print("\n\nGuess a letter.\n > ");

        try{
            String guess = input.nextLine().toLowerCase();

            if(guess.length()>1) {
                System.out.println("please choose one letter at a time");
                return theGuess();
            }
            if(guess.isEmpty())
                return "+";

            return guess;

        }catch(Exception e){
            System.out.println(e + " Error in theGuess method");
            return theGuess();
        }
    }

    // to ask if they want to play again or not
    public void playAgain(){
        Scanner input = new Scanner(System.in);

         try{
             String answer = input.nextLine();
             if(answer.equals("yes")) {
                 setCount(0);

                 String word = getWord();

                 setAnswer(word);

                 this.checkLetter = (hiddenArray(word));
                 
                 startGame();
             }
             else if(answer.equals("no"))
                 return;
             else{
                 System.out.println("is that a yes or a no?");
                 playAgain();
             }
         }catch(Exception e){
             System.err.println(e);
         }
    }

    // the game starts here
    public void startGame(){
        boolean gameOver = false;

        while(!gameOver) {
            System.out.println("****************************");
            System.out.println(hangman(getCount()));
            checkArray(checkLetter);

            String guess = theGuess();
            System.out.println(results(guess));

            // if guess too many times game ends
            if(getCount()==7){
                System.out.println("\nOh No you lost!");
                gameOver = true;
            }

            // if all letters are guessed correctly game ends
            if(checkResult()) {
                System.out.println("\nYes! The secret word is \"" + getAnswer() + "\"! You have won!");
                gameOver = true;
            }
        }
        System.out.println("\n********************************");
        System.out.println("Do you want to play again? (yes or no)");
        playAgain();
    }

    // main
    public static void main(String[] args) {
        new Main().startGame();
    }
}