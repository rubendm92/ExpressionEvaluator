package validator.numeric;

import validator.numeric.NumericExpressionValidator;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.BeforeClass;
import validator.ExpressionValidator;
import validator.InvalidExpressionException;

public class ValidateExpressionsWithParenthesis {
    
    private static ExpressionValidator validator;
    
    @BeforeClass
    public static void setUpClass() {
        validator = new NumericExpressionValidator();
    }
    
    @Test
    public void testValidExpressionWithParenthesis() {
        try {
            validator.check("(2.2+2.3)");
        } catch (InvalidExpressionException ex) {
            fail("Test should not throw InvalidExpressionException");
        }
    }
    
    @Test
    public void testValidExpressionWithOperationAfterParenthesis() {
        try {
            validator.check("(2.2+2.3)*3");
        } catch (InvalidExpressionException ex) {
            fail("Test should not throw InvalidExpressionException");
        }
    }
    
    @Test
    public void testValidExpressionWithOperationBeforeParenthesis() {
        try {
            validator.check("3*(2.2+2.3)");
        } catch (InvalidExpressionException ex) {
            fail("Test should not throw InvalidExpressionException");
        }
    }
    
    @Test
    public void testValidExpressionWithTwoParenthesis() {
        try {
            validator.check("(2.2+2.3)*(3-2)");
        } catch (InvalidExpressionException ex) {
            fail("Test should not throw InvalidExpressionException");
        }
    }
    
    @Test
    public void testInvalidExpressionWithParenthesis() {
        try {
            validator.check("((2.2+2.3)");
            fail("Test should throw InvalidExpressionException");
        } catch (InvalidExpressionException ex) {
        } catch (Exception ex) {
            fail("Test should not throw Exception");
        }
    }
    
    @Test
    public void testAnotherInvalidExpressionWithParenthesis() {
        try {
            validator.check("(2.2+2)+(3+)");
            fail("Test should throw InvalidExpressionException");
        } catch (InvalidExpressionException ex) {
        } catch (Exception ex) {
            fail("Test should not throw Exception");
        }
    }
}
