package put.io.testing.audiobooks;
import org.junit.jupiter.api.*;
import put.io.testing.junit.Calculator;

import static org.junit.jupiter.api.Assertions.*;

class AudiobookPriceCalculatorTest {

    @Test
    void testSub(){
        Customer klient=new Customer("TeD", Customer.LoyaltyLevel.STANDARD,true);
        Audiobook audiobook = new Audiobook("IO",100.00);
        assertTrue(new AudiobookPriceCalculator().calculate(klient,audiobook)==0);
    }

    @Test
    void testStandard(){
        Customer klient=new Customer("TeD", Customer.LoyaltyLevel.STANDARD,false);
        Audiobook audiobook = new Audiobook("IO",100.00);
        assertTrue(new AudiobookPriceCalculator().calculate(klient,audiobook)==100);
    }

    @Test
    void testSilver(){
        Customer klient=new Customer("TeD", Customer.LoyaltyLevel.SILVER,false);
        Audiobook audiobook = new Audiobook("IO",100.00);
        assertTrue(new AudiobookPriceCalculator().calculate(klient,audiobook)==90);
    }

    @Test
    void testGold(){
        Customer klient=new Customer("TeD", Customer.LoyaltyLevel.GOLD,false);
        Audiobook audiobook = new Audiobook("IO",100.00);
        assertTrue(new AudiobookPriceCalculator().calculate(klient,audiobook)==80);
    }

}