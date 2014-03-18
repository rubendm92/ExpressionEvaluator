package validator.numeric;

import validator.numeric.NumericExpressionValidator;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.BeforeClass;
import validator.ExpressionValidator;
import validator.InvalidExpressionException;

public class ValidateExpressionsWithoutParenthesisTests {
    
    private static ExpressionValidator validator;
    
    @BeforeClass
    public static void setUpClass() {
        validator = new NumericExpressionValidator();
    }
    
    @Test
    public void testValidateAdditionOfIntegerExpression() {
        try {
            validator.check("2 + 2");
        } catch (InvalidExpressionException ex) {
            fail("Test should not throw InvalidExpressionException");
        }
    }
    
    @Test
    public void testValidateAdditionOfDoubleExpression() {
        try {
            validator.check("2.2 + 2.3");
        } catch (InvalidExpressionException ex) {
            fail("Test should not throw InvalidExpressionException");
        }
    }
    
    @Test
    public void testValidateSubtractionOfIntegerExpression() {
        try {
            validator.check("2 - 2");
        } catch (InvalidExpressionException ex) {
            fail("Test should not throw InvalidExpressionException");
        }
    }
    
    @Test
    public void testValidateSubtractionOfDoubleExpression() {
        try {
            validator.check("2.2 - 2.3");
        } catch (InvalidExpressionException ex) {
            fail("Test should not throw InvalidExpressionException");
        }
    }
    
    @Test
    public void testValidateMultiplicationOfIntegerExpression() {
        try {
            validator.check("22 * 11");
        } catch (InvalidExpressionException ex) {
            fail("Test should not throw InvalidExpressionException");
        }
    }
    
    @Test
    public void testValidateMultiplicationOfDoubleExpression() {
        try {
            validator.check("4.22 * 1.3");
        } catch (InvalidExpressionException ex) {
            fail("Test should not throw InvalidExpressionException");
        }
    }
    
    @Test
    public void testValidateDivisionOfIntegerExpression() {
        try {
            validator.check("2 / 2");
        } catch (InvalidExpressionException ex) {
            fail("Test should not throw InvalidExpressionException");
        }
    }
    
    @Test
    public void testValidateDivisionnOfDoubleExpression() {
        try {
            validator.check("2.2 / 2.3");
        } catch (InvalidExpressionException ex) {
            fail("Test should not throw InvalidExpressionException");
        }
    }
    
    @Test
    public void testInvalidExpression() {
        try {
            validator.check("2.2b/2.3");
            fail("Test should throw InvalidExpressionException");
        } catch (InvalidExpressionException ex) {
        } catch (Exception ex) {
            fail("Test should not throw Exception");
        }
    }
    
    @Test
    public void testExpressionWithMoreThanTwoOperands() {
        try {
            validator.check("2.2b/2.3");
            fail("Test should throw InvalidExpressionException");
        } catch (InvalidExpressionException ex) {
        } catch (Exception ex) {
            fail("Test should not throw Exception");
        }
    }
}
