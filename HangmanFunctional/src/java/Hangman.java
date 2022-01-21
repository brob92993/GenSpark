import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.Stream;

public class Hangman {

    public static String main (String [] args) {
        int guesses = 0;
        int maxGuesses = 10;
        int score = 0;
        int highscore = 0;

        // create a list of words
        List<String> words = Arrays.asList("apple", "banana", "orange", "kiwi", "pear", "plum", "strawberry");

        // create a stream from the list
        Stream<String> wordStream1 = words.stream();

        // get a random word
        String randomWord = wordStream1.skip(new Random().nextInt(words.size())).findFirst().get();

        // reduce the word to a stream of characters
        Stream<Character> wordStream = randomWord.chars().mapToObj(c -> (char) c);

        // hide the stream of characters
        Stream<Character> hiddenWord = wordStream.map(c -> '_');


        Scanner input = new Scanner(System.in);
        System.out.print("\n\nGuess a letter.\n > ");

        String guess = null;
        try {
            guess = input.nextLine().toLowerCase();

            if (guess.length() > 1) {
                System.out.println("please choose one letter at a time");
                new Scanner(System.in);
                System.out.print("\n\nGuess a letter.\n > ");
            }
            if (guess.isEmpty())
                return "+";

            return guess;

        } catch (Exception e) {
            System.out.println(e + " Error in theGuess method");
            new Scanner(System.in);
            System.out.print("\n\nGuess a letter.\n > ");
        }


        // check if the guessed letter is in the stream of characters
        boolean isInWord = wordStream.anyMatch(c -> c.equals(input));

        // check if the letter is in the word
        if (isInWord) {
            // replace the hidden word with the guessed letter
            hiddenWord = wordStream.map(c -> input.equals(c) ? c : '_');
            // add to the score
            score++;
            new Scanner(System.in);
            System.out.print("\n\nGuess a letter.\n > ");

        } else {
            guesses--;
            score--;
            System.out.println("Sorry, that letter is not in the word. You have " + guesses + " guesses left.");
            // draw the head of the hangman
            // increment the number of guesses
            new Scanner(System.in);
            System.out.print("\n\nGuess a letter.\n > ");
        }

        // check if the user has won
        if (!hiddenWord.anyMatch(c -> c.equals('_'))) {
            System.out.println("You win! The word was " + randomWord + ".");
            System.out.println("Your score is " + score + ".");

            if (score > highscore) {
                highscore = score;
                System.out.println("You have the new high score!");
            }
        } else if (guesses == 0) {
            System.out.println("Sorry, you lost. The word was " + randomWord);
            System.exit(0);
        }


        return null;
    }



// read lines from specified file
// public static void main (String [] args){
//     try{
//         Scanner input = new Scanner(new File("/Users/joshuahill/Desktop/hangman.txt"));
//         while(input.hasNextLine()){
//             System.out.println(input.nextLine());
//         }

// try (Stream<String> all_lines = Files.lines(Paths.get("myfile.txt"))) {
    // specific_line_15 = all_lines.skip(14).findFirst().get();
}