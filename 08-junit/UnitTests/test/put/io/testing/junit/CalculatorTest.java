package put.io.testing.junit;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {
    private static Calculator kalkulator;

    @BeforeEach // @Beforeall także działa - klasa bezstanowa
    static void setup() {
        kalkulator = new Calculator();
    }

    @Test
    public void testAdd(){
        assertTrue(kalkulator.add(2,6)==8);
//        assertEquals(8, kalkulator.add(3,5));
//        assertEquals(-2,kalkulator.add(0,-2));
    }

    @Test
    public void testMul(){
        assertEquals(15,kalkulator.multiply(3,5));
        assertEquals(0,kalkulator.multiply(0,-2));
    }

    @Test
    public void testAddPosNum(){
//        assertTrue(kalkulator.addPositiveNumbers(-2,6)==4);
        assertThrows(IllegalArgumentException.class,()->{
            kalkulator.addPositiveNumbers(-2,4);
        });
    }

}