import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {
    Main f;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        f = new Main();
        f.answer = "hello";
        f.checkAnswer = new ArrayList<>(f.hiddenArray(f.answer));
        f.count = 3;
    }

    @org.junit.jupiter.api.Test
    void result() {
        assertEquals("correct",f.result("h"), "the result failed!");
    }

    @org.junit.jupiter.api.Test
    void showLetter() {
        f.showLetter("h");
        assertEquals(new ArrayList<String>(){{
         add("h");
         add("_");
         add("_");
         add("_");
         add("_");
           }}, f.checkAnswer, "Error, revealLetter failed"
        );
    }

    @org.junit.jupiter.api.Test
    void won() {
        f.showLetter("h");
        f.showLetter("e");
        f.showLetter("l");
        f.showLetter("l");
        f.showLetter("o");
        assertEquals(true, f.won(), "won failed");
    }

    @org.junit.jupiter.api.Test
    void lost() {
        f.count = 7;
        assertEquals(true, f.lost(), "lost failed!");
    }

    @org.junit.jupiter.api.Test
    void hiddenArray() {
        assertEquals(
                Arrays.asList("_","_")
                , f.hiddenArray("hi"), "Error hidden Array failed");
    }
}