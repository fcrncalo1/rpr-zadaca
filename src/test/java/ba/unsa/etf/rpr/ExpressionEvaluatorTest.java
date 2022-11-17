package ba.unsa.etf.rpr;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

public class ExpressionEvaluatorTest {

    @Test
    void Test1() {
        ExpressionEvaluator evaluator = new ExpressionEvaluator();
        assertEquals(5.0, evaluator.evaluate("( 1 + ( ( 2 + 3 ) * ( 4 / 5 ) ) )"));
    }

    @Test
    void Test2() {
        ExpressionEvaluator evaluator = new ExpressionEvaluator();
        assertEquals(6.708203932499369, evaluator.evaluate("( 3 * ( sqrt 5 ) )"));
    }

    @Test
    void Test3() {
        ExpressionEvaluator evaluator = new ExpressionEvaluator();
        assertThrows(RuntimeException.class, () -> evaluator.evaluate("* * 3"));
    }

    @Test
    void Test4() {
        ExpressionEvaluator evaluator = new ExpressionEvaluator();
        assertThrows(RuntimeException.class, () -> evaluator.evaluate("( 1 + ( ) * ( 3 / 2 ) )"));
    }

    @Test
    void Test5() {
        ExpressionEvaluator evaluator = new ExpressionEvaluator();
        assertEquals(125.0, evaluator.evaluate("( 5 * ( ( 100 / 4 ) * ( sqrt 1 ) ) )"));
    }
}
