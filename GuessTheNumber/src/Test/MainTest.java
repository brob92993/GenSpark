import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

import java.io.InputStream;


class MainTest {
    Main main;

    @BeforeEach

    void setUp() {
        
        main = new Main();

        main.setName("B");

        main.setChoice(10);

        main.setPlayAgain("y");

        main.setNumber(9);
        
    }

    @Test
    void getPlayerName() {
        assertEquals("B", main.getName(), "Name failed");
    }

    @Test
    void getChoice() {
        assertEquals(10, main.getChoice(), "playerChoice has failed");
    }

    @Test
    void getPlayAgain() {
        assertEquals("y", main.getPlayAgain(), "play again failed");
    }

    @Test
    void getNumber() {
        assertEquals(9, main.getNumber(), "Answer has failed");
    }

    @AfterEach
    void tearDown() {
    }
}
