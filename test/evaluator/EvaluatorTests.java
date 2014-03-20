package evaluator;

import evaluator.operators.InvalidOperationException;
import evaluator.operations.binary.Subtraction;
import evaluator.operations.binary.Addition;
import evaluator.operations.binary.Division;
import evaluator.operations.binary.Multiplication;
import evaluator.operations.unary.Minus;
import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.*;

public class EvaluatorTests {

    @Test
    public void testConstant() {
        assertEquals(2, new Constant(2).evaluate());
        assertEquals(2.3, new Constant(2.3).evaluate());
    }

    @Test
    public void testAddition() {
        assertEquals(4, new Addition(new Constant(2), new Constant(2)).evaluate());
        assertEquals(2.4, new Addition(new Constant(2), new Constant(0.4)).evaluate());
        assertEquals(1.3, new Addition(new Constant(0.3), new Constant(1)).evaluate());
        assertEquals(4.1, new Addition(new Constant(1.2), new Constant(2.9)).evaluate());
        assertEquals("HolaMundo", new Addition(new Constant("Hola"), new Constant("Mundo")).evaluate());
    }

    @Test
    public void testSubstraction() {
        assertEquals(0, new Subtraction(new Constant(2), new Constant(2)).evaluate());
        assertEquals(1.8, (double) new Subtraction(new Constant(3), new Constant(1.2)).evaluate(), 0.01);
        assertEquals(-0.7, new Subtraction(new Constant(0.3), new Constant(1)).evaluate());
        assertEquals(1, (double) new Subtraction(new Constant(1.5), new Constant(0.5)).evaluate(), 0.01);
    }

    @Test
    public void testMultiplication() {
        assertEquals(4, new Multiplication(new Constant(2), new Constant(2)).evaluate());
        assertEquals(3.6, (double) new Multiplication(new Constant(3), new Constant(1.2)).evaluate(), 0.01);
        assertEquals(0.3, new Multiplication(new Constant(0.3), new Constant(1)).evaluate());
        assertEquals(0.75, (double) new Multiplication(new Constant(1.5), new Constant(0.5)).evaluate(), 0.01);
    }

    @Test
    public void testDivision() {
        assertEquals(1, new Division(new Constant(2), new Constant(2)).evaluate());
        assertEquals(2.5, (double) new Division(new Constant(3), new Constant(1.2)).evaluate(), 0.01);
        assertEquals(0.3, new Division(new Constant(0.3), new Constant(1)).evaluate());
        assertEquals(3.0, (double) new Division(new Constant(1.5), new Constant(0.5)).evaluate(), 0.01);
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
    
    @Test
    public void testMinus() {
        assertEquals(-1, new Minus(new Constant(1)).evaluate());
    }
}
