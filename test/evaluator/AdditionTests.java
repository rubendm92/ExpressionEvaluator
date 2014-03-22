package evaluator;

import datatype.ComplexNumber;
import evaluator.operations.binary.Addition;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class AdditionTests {
    
    @Test
    public void testAdditionNumber() {
        assertEquals(4, new Addition(new Constant(2), new Constant(2)).evaluate());
        assertEquals(2.4, new Addition(new Constant(2), new Constant(0.4)).evaluate());
        assertEquals(1.3, new Addition(new Constant(0.3), new Constant(1)).evaluate());
        assertEquals(4.1, new Addition(new Constant(1.2), new Constant(2.9)).evaluate());
    }
    
    @Test
    public void testAdditionComplex() {
        assertEquals(new ComplexNumber(2, 2), new Addition(new Constant(new ComplexNumber(3, -1)), new Constant(new ComplexNumber(-1, 3))).evaluate());
    }
    
    @Test
    public void testAdditionString() {
        assertEquals("HolaMundo", new Addition(new Constant("Hola"), new Constant("Mundo")).evaluate());
    }
}
