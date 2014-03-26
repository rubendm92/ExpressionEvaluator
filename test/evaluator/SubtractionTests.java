package evaluator;

import datatype.ComplexNumber;
import evaluator.operations.binary.Subtraction;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class SubtractionTests {
    
    @Test
    public void testSubstractionNumber() {
        assertEquals(0, new Subtraction(new Constant(2), new Constant(2)).evaluate());
        assertEquals(1.8, (double) new Subtraction(new Constant(3), new Constant(1.2)).evaluate(), 0.01);
        assertEquals(-0.7, new Subtraction(new Constant(0.3), new Constant(1)).evaluate());
        assertEquals(1, (double) new Subtraction(new Constant(1.5), new Constant(0.5)).evaluate(), 0.01);
    }
    
    @Test
    public void testSubtractionComplex() {
        assertEquals(new ComplexNumber(4, -4), new Subtraction(new Constant(new ComplexNumber(3, -1)), new Constant(new ComplexNumber(-1, 3))).evaluate());
    }
    
    @Test
    public void testSubtractionString() {
        assertEquals("Hola", new Subtraction(new Constant("HolaMundo"), new Constant("Mundo")).evaluate());
    }
}
