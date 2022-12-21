package put.io.testing.mocks;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.net.ConnectException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import put.io.students.fancylibrary.service.FancyService;

public class ExpenseManagerTest {
    @Test
    void calculateTotalTest(){
        ExpenseRepository rep =  mock(ExpenseRepository.class);
        List<Expense> arr = new ArrayList();
        Expense exp = new Expense();
        arr.add(exp);
        arr.add(exp);
        arr.add(exp);
        when(rep.getExpenses()).thenReturn(arr);
        FancyService fs =new FancyService();
        ExpenseManager man = new ExpenseManager(rep,fs);
        for(int i =0;i<3;i++) {
            arr.get(i).setAmount((i+1)*10);
        }
        Assertions.assertEquals(man.calculateTotal(), 90);
    }
    @Test
    void calculateTotalForCategoryTest(){
        ExpenseRepository rep =  mock(ExpenseRepository.class);
        FancyService fs =new FancyService();
        ExpenseManager man = new ExpenseManager(rep,fs);




        when(rep.getExpensesByCategory(anyString())).thenReturn(new ArrayList());
        when(rep.getExpensesByCategory("Car")).thenReturn(carExpences());
        when(rep.getExpensesByCategory("Home")).thenReturn(homeExpences());
        // 5.1
        // kolejność wywołań ma znaczenie

        Assertions.assertEquals(3120, man.calculateTotalForCategory("Car"));
        Assertions.assertEquals(1200, man.calculateTotalForCategory("Home"));
        Assertions.assertEquals(0, man.calculateTotalForCategory("Food"));
        Assertions.assertEquals(0, man.calculateTotalForCategory("Sport"));

    }
    private List<Expense> homeExpences() {
        List<Expense> home = new ArrayList();
        home.add(new Expense("Table", "Home", 200));
        home.add(new Expense("Washing machine", "Home", 1000));
        return home;
    }
    private List<Expense> carExpences() {
        List<Expense> car = new ArrayList();
        car.add(new Expense("New Engine", "Car", 3000));
        car.add(new Expense("Fuel", "Car", 120));
        return car;
    }
    @Test
    void calculateTotalInDollarsTest() throws ConnectException {
        ExpenseRepository rep = mock(ExpenseRepository.class);
        FancyService fs = mock(FancyService.class);
        ExpenseManager man = new ExpenseManager(rep,fs);

        when(rep.getExpenses()).thenReturn(homeExpences());
        when(fs.convert(anyDouble(),eq("PLN"),eq("USD"))).thenReturn(300.0);
        when(fs.convert(anyDouble(),eq("PLN"),eq("USD"))).thenThrow(new ConnectException());

        when(fs.convert(anyDouble(), eq("PLN"), eq("USD"))).thenAnswer((i) -> {
            return i.getArgument(0, Double.class) / 4;
        });

        assertEquals(300,man.calculateTotalInDollars());
    }

}
