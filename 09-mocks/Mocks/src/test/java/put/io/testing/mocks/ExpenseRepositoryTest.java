package put.io.testing.mocks;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Collections;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InOrder;

import org.mockito.Mockito;
import put.io.students.fancylibrary.database.FancyDatabase;
import put.io.students.fancylibrary.database.IFancyDatabase;

public class ExpenseRepositoryTest {

    MyDatabase db= new MyDatabase();
    ExpenseRepository rep = new ExpenseRepository(db);
    /*
    @BeforeEach
    void setUp(){
        db= new MyDatabase();
        rep=new ExpenseRepository(db);
        rep.loadExpenses();
    }
     */
    @Test
    void loadExpensesTest() {
        //assertTrue(rep.getExpenses().isEmpty());
        IFancyDatabase mockdb=mock(IFancyDatabase.class);
        when(mockdb.queryAll()).thenReturn(Collections.emptyList());

        rep=new ExpenseRepository(mockdb);
        rep.loadExpenses();
        InOrder inOrder = inOrder(mockdb);
        inOrder.verify(mockdb).connect();
        inOrder.verify(mockdb).queryAll();
        inOrder.verify(mockdb).close();
        assertTrue(rep.getExpenses().isEmpty());
    }
    /*
    @Test
    void getExpensesTest(){
        assertTrue(rep.getExpenses().isEmpty());
    }
     */
    @Test
    void saveExpensesTest() {
        IFancyDatabase mockdb=mock(IFancyDatabase.class);
        when(mockdb.queryAll()).thenReturn(Collections.emptyList());

        rep=new ExpenseRepository(mockdb);
        Expense exp = new Expense();
        rep.loadExpenses();
        for(int i = 0; i < 5; i++) {
            rep.addExpense(exp);
        }
        rep.saveExpenses();
        verify(mockdb,times(5)).persist(any(Expense.class));
    }
    //2.1
    //Należy dodać zmienną typu boolean która podczas wywołania connect() ustawiana by była na true a przy close() na false

}
