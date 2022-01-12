package Java;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    Main main;

    @BeforeEach
    void setUp() {
        main = new Main();
        main.setName("B");
        main.setPlayAgain("y");

    }

    @Test
    void getPlayerName() {
        assertEquals("B", main.getName(), "Name failed");
    }

    @Test
    void getPlayAgain() {
        assertEquals("y", main.getPlayAgain(), "play again failed");
    }

    @AfterEach
    void tearDown() {
    }
}