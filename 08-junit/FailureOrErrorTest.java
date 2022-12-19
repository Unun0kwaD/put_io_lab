package put.io.testing.junit;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FailureOrErrorTest {
    private Calculator cal;
    @BeforeEach
    public void setUp(){
        cal = new Calculator();
    }
    @Test
    void test1(){ //Failure
        assertEquals(6,cal.add(0,3));
    }
    @Test
    void test2(){ //Error Unexpected exception
        cal.addPositiveNumbers(-3,23);
    }
    @Test
    void test3(){ //Aby stwierdzić Failure Junit oczekuje AssertionFailedError
        try{
            assertEquals(6,cal.add(0,0));
        }
        catch (Exception e ){
            e.printStackTrace(System.out);
        }

    }


}