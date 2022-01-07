
import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

class MainTest {
Main main;
    @BeforeEach
    void setUp() {
        main = new Main();
        main.setCount(4);
        String wordTest = "test";
        main.setAnswer(wordTest);
        main.checkLetter = (main.hiddenArray(wordTest));
        main.showLetter("t");
    }

    @Test 
    void resultsTest() {
        assertEquals("correct", main.results("e"), "Results Test Failed");
        assertEquals("incorrect", main.results("z"), "Results Test Failed");
        assertEquals("letter already guessed. Try again.", main.results("t"), "Results Test Failed");
    }

    @Test 
    void hiddenArrayTest() {
        assertArrayEquals(new String[]{"_", "_", "_", "_"}, main.hiddenArray("test"), "Hidden Array Test Failed");
    }

    @Test
    void showLetterTest() {
        main.showLetter("t");
        assertArrayEquals(new String[]{"t", "_", "_", "t"}, main.checkLetter, "Show Letter Test Failed");
    }

    @Test
    void getAnswerTest() {
        assertEquals("test", main.getAnswer(), "Get Answer Test Failed");
    }
    @Test 
    void getCountTest () {
        main.setCount(4);
        assertEquals(4, main.getCount(), "Get Count Test Failed");
    }

    @AfterEach
    void tearDown() {
    }
}