package put.io.testing.mocks;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

//import org.junit.*;
import org.junit.jupiter.api.Test;
import org.mockito.*;


import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import put.io.students.fancylibrary.database.FancyDatabase;
import put.io.students.fancylibrary.database.IFancyDatabase;
import put.io.students.fancylibrary.service.FancyService;

import java.util.ArrayList;
import java.net.ConnectException;
import java.util.Collections;
import java.util.List;

public class ExpenseManagerTest {

    @Test
    public void testCalcu() {
        ExpenseRepository repo = mock(ExpenseRepository.class);
        Expense exp = new Expense();
        exp.setAmount(1);
        List<Expense> lista = new ArrayList<Expense>();
        lista.add(exp);
        lista.add(exp);
        lista.add(exp);
        when(repo.getExpenses()).thenReturn(lista);
        ExpenseManager manage = new ExpenseManager(repo, new FancyService());
        assertEquals(manage.calculateTotal(),3);
    }

    @Test
    public void testCalcuCat(){
        ExpenseRepository repo = mock(ExpenseRepository.class);
        Expense exp = new Expense();
        List<Expense> lista = new ArrayList<Expense>();
        lista.add(exp);
        lista.add(exp);
        when(repo.getExpenses()).thenReturn(lista);
        when(repo.getExpensesByCategory("Food")).thenReturn(Collections.emptyList());
        when(repo.getExpensesByCategory("Sport")).thenReturn(Collections.emptyList());
        when(repo.getExpensesByCategory("Home")).thenReturn(lista);
        when(repo.getExpensesByCategory("Car")).thenReturn(lista);

        ExpenseManager manage = new ExpenseManager(repo, new FancyService());

        assertEquals(manage.calculateTotal(), 0);
        assertEquals(manage.calculateTotalForCategory("Home"), 0);
        verify(repo).getExpensesByCategory(eq("Home"));

        assertEquals(manage.calculateTotalForCategory("Car"), 0);
        verify(repo).getExpensesByCategory(eq("Car"));

        assertEquals(manage.calculateTotalForCategory("Sport"), 0);
        verify(repo).getExpensesByCategory(eq("Car"));
    }

    @Test
    public void testCalcDollar() throws ConnectException {
        ExpenseRepository repo = mock(ExpenseRepository.class);
        FancyService fs = mock(FancyService.class);
        Expense exp = new Expense();
        repo.addExpense(exp);
        ExpenseManager manage = new ExpenseManager(repo, fs );

        when(fs.convert(anyDouble(), eq("PLN"), eq("USD"))).thenAnswer(
                new Answer() {
                    public Object answer(InvocationOnMock invocation) {
                        Object[] args = invocation.getArguments();
                        Object mock = invocation.getMock();
                        return (double) args[0]  * 4;
                    }
                });

        manage.calculateTotalInDollars();
        verify(fs).convert(anyDouble(), eq("PLN"), eq("USD"));

        when(fs.convert(4,"PLN", "USD")).thenReturn(16.0);
        assertEquals(fs.convert(4,"PLN", "USD"),16.0);

    }
}
