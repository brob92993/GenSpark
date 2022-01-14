import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GoblinTest {

    @BeforeEach
    void setUp() {
    }

    @Test
    void getHealth() {
        Goblin goblin = new Goblin();
        goblin.setHealth(10);
        goblin.setAttack(10);

        assertEquals(10,goblin.getHealth(), "getHealth failed" );
    }

    @Test
    void setHealth() {
        Goblin goblin = new Goblin();
        goblin.setHealth(7);
        goblin.setAttack(10);
        assertEquals(7, goblin.getHealth(), "setHealth failed");
    }

    @Test
    void getAttack() {
        Goblin goblin = new Goblin();
        goblin.setHealth(10);
        goblin.setAttack(10);
        assertEquals(10, goblin.getAttack(), "getAttack failed");
    }

    @Test
    void setAttack() {
        Goblin goblin = new Goblin();
        goblin.setHealth(10);
        goblin.setAttack(7);
        assertEquals(7, goblin.getAttack(), "setAttack failed");
    }
}