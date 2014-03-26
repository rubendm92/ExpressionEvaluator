package evaluator;

import evaluator.operations.binary.Division;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class DivisionTests {
    
    @Test
    public void testDivision() {
        assertEquals(1, new Division(new Constant(2), new Constant(2)).evaluate());
        assertEquals(2.5, (double) new Division(new Constant(3), new Constant(1.2)).evaluate(), 0.01);
        assertEquals(0.3, new Division(new Constant(0.3), new Constant(1)).evaluate());
        assertEquals(3.0, (double) new Division(new Constant(1.5), new Constant(0.5)).evaluate(), 0.01);
    }
}
