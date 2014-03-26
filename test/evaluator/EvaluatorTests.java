package evaluator;

import evaluator.operations.binary.Addition;
import evaluator.operators.InvalidOperationException;
import java.util.ArrayList;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import org.junit.Test;

public class EvaluatorTests {

    @Test
    public void testConstant() {
        assertEquals(2, new Constant(2).evaluate());
        assertEquals(2.3, new Constant(2.3).evaluate());
    }

    @Test
    public void testInvalidOperation() {
        try {
            new Addition(new Constant(new ArrayList<>()), new Constant(1)).evaluate();
            fail("InvalidOperationException was not thrown.");
        } catch (InvalidOperationException ex) {
            assertTrue(true);
        } catch (Exception ex) {
            fail("Type of exception was not the expected.");
        }
    }
}
