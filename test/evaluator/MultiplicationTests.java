package evaluator;

import evaluator.operations.binary.Multiplication;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class MultiplicationTests {

    @Test
    public void testMultiplicationNumber() {
        assertEquals(4, new Multiplication(new Constant(2), new Constant(2)).evaluate());
        assertEquals(3.6, (double) new Multiplication(new Constant(3), new Constant(1.2)).evaluate(), 0.01);
        assertEquals(0.3, new Multiplication(new Constant(0.3), new Constant(1)).evaluate());
        assertEquals(0.75, (double) new Multiplication(new Constant(1.5), new Constant(0.5)).evaluate(), 0.01);
    }
}
