package evaluator;

import evaluator.operations.unary.Minus;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class UnaryOperationsTests {
    
    @Test
    public void testMinus() {
        assertEquals(-1, new Minus(new Constant(1)).evaluate());
    }
}
