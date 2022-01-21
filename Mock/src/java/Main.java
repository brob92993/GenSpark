public class Main {

    public static void main (String [] args){
        System.out.println(reverse("hello"));
        reverse("word");
    }

    public static String reverse (String word){   // create the method

     String rev = ""; // initialize the string that will be returned

     for (int i = word.length(); i >= 0; i--){ // iterate through the word backwards
         rev = rev + word.charAt(i); // print the word in the backwards iterated form

        }
     return rev; // return that word
    }

    /* Create a new Java Project with a Main method.
Create a method that will take in a String as a parameter.
In your method reverse the String that is passed in and then return the new reversed String.
Call the method you created from main.
When calling the method, give it an argument of a string that will be reversed.
Print  your result to the console from main. This should be the reverse of whatever you passed to your method.
No String Builder

     */

}
