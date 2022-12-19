package put.io.testing.junit;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {
    private Calculator cal;
    @BeforeEach // po zmianie na BeforeAlltesty nie przechodzą
    public void setUp(){
        cal = new Calculator();
    }
    @Test
    void testAdd() {
        assertEquals(6,cal.add(3,3));
        assertEquals(-2,cal.add(0,-2));
    }

    @Test
    void testMultiply() {
        assertEquals(-9,cal.multiply(-3,3));
        assertEquals(0,cal.multiply(0,-2));
    }

    @Test
    void testAddPositiveNumbers() {
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> {
            cal.addPositiveNumbers(-3,23);
        },"The arguments must be positive");
    }
}