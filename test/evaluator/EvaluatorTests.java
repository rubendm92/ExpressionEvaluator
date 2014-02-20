package evaluator;

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
}
