package evaluator;

import evaluator.operations.Subtraction;
import evaluator.operations.Addition;
import evaluator.operations.Division;
import evaluator.operations.Multiplication;
import junit.framework.Assert;
import org.junit.Test;
import org.junit.Assert.*;

public class EvaluatorTests {

    @Test
    public void testConstant() {
        Assert.assertEquals(2, new Constant(2).evaluate());
        Assert.assertEquals(2.3, new Constant(2.3).evaluate());
    }

    @Test
    public void testAddition() {
        Assert.assertEquals(4, new Addition(new Constant(2), new Constant(2)).evaluate());
        Assert.assertEquals(2.4, new Addition(new Constant(2), new Constant(0.4)).evaluate());
        Assert.assertEquals(1.3, new Addition(new Constant(0.3), new Constant(1)).evaluate());
        Assert.assertEquals(4.1, new Addition(new Constant(1.2), new Constant(2.9)).evaluate());
    }
    @Test
    public void testSubstraction() {
        Assert.assertEquals(0, new Subtraction(new Constant(2), new Constant(2)).evaluate());
        Assert.assertEquals(1.8, (double) new Subtraction(new Constant(3), new Constant(1.2)).evaluate(), 0.01);
        Assert.assertEquals(-0.7, new Subtraction(new Constant(0.3), new Constant(1)).evaluate());
        Assert.assertEquals(1, (double) new Subtraction(new Constant(1.5), new Constant(0.5)).evaluate(), 0.01);
    }
    
    @Test
    public void testMultiplication() {
        Assert.assertEquals(4, new Multiplication(new Constant(2), new Constant(2)).evaluate());
        Assert.assertEquals(3.6, (double) new Multiplication(new Constant(3), new Constant(1.2)).evaluate(), 0.01);
        Assert.assertEquals(0.3, new Multiplication(new Constant(0.3), new Constant(1)).evaluate());
        Assert.assertEquals(0.75, (double) new Multiplication(new Constant(1.5), new Constant(0.5)).evaluate(), 0.01);
    }
    
    @Test
    public void testDivision() {
        Assert.assertEquals(1, new Division(new Constant(2), new Constant(2)).evaluate());
        Assert.assertEquals(2.5, (double) new Division(new Constant(3), new Constant(1.2)).evaluate(), 0.01);
        Assert.assertEquals(0.3, new Division(new Constant(0.3), new Constant(1)).evaluate());
        Assert.assertEquals(3.0, (double) new Division(new Constant(1.5), new Constant(0.5)).evaluate());
    }
}
