package evaluator;

import evaluator.operations.binary.And;
import evaluator.operations.binary.Or;
import evaluator.operations.binary.Xor;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class BooleanOperationsTests {
    
    @Test
    public void testAnd() {
        assertEquals(false, new And(new Constant(true), new Constant(false)).evaluate());
        assertEquals(4, new And(new Constant(6), new Constant(4)).evaluate());
    }
    
    @Test
    public void testOr() {
        assertEquals(true, new Or(new Constant(true), new Constant(false)).evaluate());
        assertEquals(7, new Or(new Constant(7), new Constant(4)).evaluate());
    }
    
    @Test
    public void testXor() {
        assertEquals(false, new Xor(new Constant(true), new Constant(true)).evaluate());
        assertEquals(3, new Xor(new Constant(7), new Constant(4)).evaluate());
    }
}
