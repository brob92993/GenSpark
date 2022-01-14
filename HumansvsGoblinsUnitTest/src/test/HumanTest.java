import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HumanTest {

    @BeforeEach
    void setUp() {
        Human human = new Human();
        human.setHealth(10);
        human.setAttack(10);
    }
    @Test
    void getHealth() {
        Human human = new Human();
        human.setHealth(10);
        human.setAttack(10);

        assertEquals(10,human.getHealth(), "getHealth failed" );
    }

    @Test
    void setHealth() {
        Human human = new Human();
        human.setHealth(7);
        human.setAttack(10);
        assertEquals(7, human.getHealth(), "setHealth failed");
    }

    @Test
    void getAttack() {
        Human human = new Human();
        human.setHealth(10);
        human.setAttack(10);
        assertEquals(10, human.getAttack(), "getAttack failed");
    }

    @Test
    void setAttack() {
        Human human = new Human();
        human.setHealth(10);
        human.setAttack(7);
        assertEquals(7, human.getAttack(), "setAttack failed");
    }
}