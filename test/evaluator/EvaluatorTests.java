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
}
