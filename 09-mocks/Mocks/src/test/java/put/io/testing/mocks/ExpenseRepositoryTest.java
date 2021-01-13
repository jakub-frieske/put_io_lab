package put.io.testing.mocks;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

//import org.junit.*;
import org.junit.jupiter.api.*;
import org.mockito.*;

import put.io.students.fancylibrary.database.FancyDatabase;
import put.io.students.fancylibrary.database.IFancyDatabase;

import java.util.Collections;

public class ExpenseRepositoryTest {
    private static ExpenseRepository er;
    private static MyDatabase fd;

    @BeforeEach
    public void setup() {
        fd = mock(MyDatabase.class);
        er = new ExpenseRepository(fd);
    }

    @Test
    public void testLoad() {
        when(fd.queryAll()).thenReturn(Collections.emptyList());
        InOrder in = inOrder(fd);
        er.loadExpenses();
        assertTrue(er.getExpenses().isEmpty());
        in.verify(fd).connect();
        in.verify(fd).queryAll();
        in.verify(fd).close();
    }

    @Test
    public void testSave() {
        for (int i = 0; i < 5; i++) {
            er.addExpense(new Expense());
        }

        er.saveExpenses();
        verify(fd, times(5)).persist(any(Expense.class));
    }
}
