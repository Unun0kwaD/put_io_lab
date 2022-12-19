package put.io.testing.audiobooks;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AudiobookPriceCalculatorTest {
    //testowanie whitebox ponieważ widzimy testowany kod
    //są 4 możliwe ścieżki działania

    @Test
    void calculateTest1(){
        AudiobookPriceCalculator audcal = new AudiobookPriceCalculator();
        Customer customer = new Customer("Andrzej", Customer.LoyaltyLevel.SILVER,true);
        Audiobook audiobook = new Audiobook("Nowy Wspaniały Świat",30.0);
        assertEquals(0.0,audcal.calculate(customer,audiobook));
    }
    @Test
    void calculateTest2(){
        AudiobookPriceCalculator audcal = new AudiobookPriceCalculator();
        Customer customer = new Customer("Andrzej", Customer.LoyaltyLevel.SILVER,false);
        Audiobook audiobook = new Audiobook("Nowy Wspaniały Świat",30.0);
        assertEquals(27.0,audcal.calculate(customer,audiobook));
    }
    @Test
    void calculateTest3(){
        AudiobookPriceCalculator audcal = new AudiobookPriceCalculator();
        Customer customer = new Customer("Andrzej", Customer.LoyaltyLevel.GOLD,false);
        Audiobook audiobook = new Audiobook("Nowy Wspaniały Świat",30.0);
        assertEquals(24.0,audcal.calculate(customer,audiobook));
    }
    @Test
    void calculateTest4(){
        AudiobookPriceCalculator audcal = new AudiobookPriceCalculator();
        Customer customer = new Customer("Andrzej", Customer.LoyaltyLevel.STANDARD,false);
        Audiobook audiobook = new Audiobook("Nowy Wspaniały Świat",30.0);
        assertEquals(30.0,audcal.calculate(customer,audiobook));
    }
}