package datatype;

import org.junit.Assert;
import org.junit.Test;

public class ComplexNumbersTests {
    
    @Test
    public void testCreateComplexNumber() {
        ComplexNumber complexNumber = new ComplexNumber(3, -1);
        Assert.assertEquals(3, complexNumber.getReal());
        Assert.assertEquals(-1, complexNumber.getImaginary());
    }
    
    @Test
    public void testEquals() {
        ComplexNumber complexNumber1 = new ComplexNumber(3, -1);
        ComplexNumber complexNumber2 = new ComplexNumber(3, -1);
        ComplexNumber complexNumber3 = new ComplexNumber(3, 1);
        ComplexNumber complexNumber4 = new ComplexNumber(4, 2);
        Assert.assertTrue(complexNumber1.equals(complexNumber2));
        Assert.assertFalse(complexNumber1.equals(complexNumber3));
        Assert.assertFalse(complexNumber3.equals(complexNumber4));
    }
}
