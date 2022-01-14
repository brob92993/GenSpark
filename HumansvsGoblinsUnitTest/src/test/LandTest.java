import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LandTest {
    Land land;

    @BeforeEach
    void setUp() {
        land = new Land("land", 1, 2, 3, 4);

    }

    @Test
    void getN() {
        assertEquals(1,land.getN(),"getN failed");
    }

    @Test
    void setN() {
        land.setN(0);
        assertEquals(0,land.getN(), "setN failed" );
    }

    @Test
    void getS() {
        assertEquals(2,land.getS(),"getS failed");
    }

    @Test
    void setS() {
        land.setS(0);
        assertEquals(0, land.getS(), "setS failed");
    }

    @Test
    void getE() {
        assertEquals(3,land.getE(),"getE failed");
    }

    @Test
    void setE() {
        land.setE(0);
        assertEquals(0, land.getE(), "setE failed");
    }

    @Test
    void getW() {
        assertEquals(4,land.getW(),"getW failed");
    }

    @Test
    void setW() {
        land.setW(0);
        assertEquals(0, land.getW(), "setW failed");
    }

    @Test
    void getName() {
        assertEquals("land", land.getName(), "getName failed");
    }

    @Test
    void setName() {
        Land land1 = new Land("land1", 1, 1, 1, 1);
        assertEquals("land1", land1.getName(), "setName failed");
    }
}