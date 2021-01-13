package put.io.testing.junit;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class FailureOrErrorTest {

    @Test
    public void test1(){
        assertEquals(4, 3);
    }

    @Test
    public void test2() throws Exception {
        throw new Exception("dowolny wyjątek");
    }
    /**
     *  test1 - Failure - naruszenie asercji
     *  test2 - Error   - nieoczekiwany wyjątek
     */

    @Test
    public void test3() {
        try {
            assert (false);
        }
        catch (Throwable e) {
            e.printStackTrace();
        }
    }
}
