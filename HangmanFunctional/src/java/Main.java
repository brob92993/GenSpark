import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    Data io;
    String answer;
    ArrayList<String> checkAnswer;
    int count;
    int score;
    int highscore;

    // constructor
    
    public Main(){
        io = new Data();
        this.answer = getRandomWord();
        this.checkAnswer = new ArrayList<>( hiddenArray(answer) );
        this.count = 0;
        this.score = 0;
        this.highscore = 0;
    }

    // after user guesses

    public String result(String letter){
        if(checkAnswer.contains(letter))
            return "you have already guessed that letter. Choose again.";
        if(answer.contains(letter)){
            showLetter(letter);
            this.score++;
            return "correct";
    }
        this.count++;
        if (this.score > 0){
            this.score--;
        }
        return "incorrect";
    }

    // correct guess
    public void showLetter(String letter){
        IntStream.range(0,checkAnswer.size())
                .forEach( i -> {
                    if(answer.charAt(i)==letter.charAt(0))
                        checkAnswer.set(i,letter);
                });
    }

    // checking if user won

    public boolean won(){
        if( !this.checkAnswer.contains("_")){
            System.out.println("\nYes! The word was \"" + this.answer + "\"! You win!");
            delay(1000);
            System.out.println("You scored " + this.score + " points!");
            if(this.score > this.highscore)
                this.highscore = this.score;

            return true;
        }
        return false;
    }

    // check if user lost

    public boolean lost(){
        if(count>=7) {
            System.out.println("\nYou Lost! The word was" + this.answer);
            delay(1000);
            System.out.println("Your score was" + this.score + "!");
            delay(1000);
            return true;
        }
        return false;
    }

    //shows _ for each letter in the word

    public List<String> hiddenArray(String word){
        return Arrays
                .stream(new String[word.length()])
                .map(c -> "_")
                .collect(Collectors.toList());
    }

    // generate hangman art from file

    public String hangman(int wrongCounter){
        if( wrongCounter > 7 ) return "error";
        return Data.getDrawing(wrongCounter);
    }

    // get random word from word doc

    public String getRandomWord(){
        Random random = new Random();
        return Data.words.get(random.nextInt(Data.words.size()));
    }

    // user guess

    public String guess(){
        Scanner input = new Scanner(System.in);
        try {
            String guess = input.nextLine().toLowerCase();
            if (guess.length() != 1){
                System.out.println("one letter at a time!");
                guess();
            }
            return guess;

        } catch (Exception e){
            e.printStackTrace();
            System.out.println("Error: guess Failed");
            return "?";
        }
    }

    // play again

    public void replay(){
        System.out.println("Play again? (Type y or n)?");
        if( guess().equals("y")){
            this.answer = getRandomWord();
            this.checkAnswer = new ArrayList<>( hiddenArray(answer) );
            this.score = 0;
            this.count = 0;
            startGame();
        }else
            System.exit(0);
    }

    // see the array

    public void showWord(ArrayList<String> word){
         word.forEach( x -> System.out.print(x + " ") );
    }

    // start game

    public void startGame(){
        System.out.println("***********************************");
        System.out.println( hangman(this.count) );
        System.out.println("highscore: " + this.highscore);
        System.out.println("your score: " + this.score);
        showWord(this.checkAnswer);
        System.out.print("\n\nGuess a letter.\n > ");
        System.out.println( result( guess() ) );

        if ( won() || lost() )
            replay();

        startGame();
    }
    // set up the delay method

    public static void delay(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException exp) {
        }}

    // main method

    public static void main(String[] args) {
        new Main().startGame();
    }

}