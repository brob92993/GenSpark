import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.*;

class MainTest {
    Main main;

    // runs before each method
    @BeforeEach
    void setUp() {
        main = new Main();
    }

    @Test
    void startTest(){
        assertEquals( "\nYou are in a land full of dragons. In front of you,\n" +
            "you see two caves. In one cave, the dragon is friendly\n" +
            "and will share his treasure with you. The other dragon\n" +
            "is greedy and hungry and will eat you on sight!\n" +
            "Which cave will you go into? choose 1 or 2..\n",
                main.start(),"intro has failed" );
    }

    @Test
    void optionOneTest(){
        assertEquals("\nYou approach the cave...\n" + "And a bright beam of light appears!\n" +
            "Next thing you know, you're on the back of a large (but friendly) dragon!\n" +
            "You and your new dragon friend soar off into the infinite realm with his treasure, never to be seen again...",
                main.optionOne(),"optionOne failed" );
    }

    @Test
    void optionTwoTest(){
        assertEquals("\nYou approach the cave...\n" + "It is dark and spooky...\n" +
            "A large dragon jumps out in front of you! He opens his jaws and...\n" +
            "Gobbles you down in one bite!\n", main.optionTwo(),"optionTwo test failed");
    }

    @Test
    void invalidTest(){
        assertEquals(
            "\nYou made an invalid choice...choose 1 or 2\n",main.invalid(),"isLost test failed");
    }

    @Test
    void getOptionOneTest(){
        assertEquals(main.optionOne(),  main.getOption(1),"Choice 1 failed");
    }

    @Test
    void getOptionTwoTest(){
        assertEquals(main.optionTwo(),  main.getOption(2),"Choice 2 failed");
    }
   
    @AfterEach
    void tearDown() {
    }


}