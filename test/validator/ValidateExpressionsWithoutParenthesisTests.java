package validator;

import org.junit.Test;
import static org.junit.Assert.*;

public class ValidateExpressionsWithoutParenthesisTests {
    
    @Test
    public void testValidateAdditionOfIntegerExpression() {
        try {
            ExpressionValidator validator = new ExpressionValidator();
            validator.check("2 + 2");
        } catch (InvalidExpressionException ex) {
            fail("Test should not throw InvalidExpressionException");
        }
    }
    
    @Test
    public void testValidateAdditionOfDoubleExpression() {
        try {
            ExpressionValidator validator = new ExpressionValidator();
            validator.check("2.2 + 2.3");
        } catch (InvalidExpressionException ex) {
            fail("Test should not throw InvalidExpressionException");
        }
    }
    
    @Test
    public void testValidateSubtractionOfIntegerExpression() {
        try {
            ExpressionValidator validator = new ExpressionValidator();
            validator.check("2 - 2");
        } catch (InvalidExpressionException ex) {
            fail("Test should not throw InvalidExpressionException");
        }
    }
    
    @Test
    public void testValidateSubtractionOfDoubleExpression() {
        try {
            ExpressionValidator validator = new ExpressionValidator();
            validator.check("2.2 - 2.3");
        } catch (InvalidExpressionException ex) {
            fail("Test should not throw InvalidExpressionException");
        }
    }
    
    @Test
    public void testValidateMultiplicationOfIntegerExpression() {
        try {
            ExpressionValidator validator = new ExpressionValidator();
            validator.check("22 * 11");
        } catch (InvalidExpressionException ex) {
            fail("Test should not throw InvalidExpressionException");
        }
    }
    
    @Test
    public void testValidateMultiplicationOfDoubleExpression() {
        try {
            ExpressionValidator validator = new ExpressionValidator();
            validator.check("4.22 * 1.3");
        } catch (InvalidExpressionException ex) {
            fail("Test should not throw InvalidExpressionException");
        }
    }
    
    @Test
    public void testValidateDivisionOfIntegerExpression() {
        try {
            ExpressionValidator validator = new ExpressionValidator();
            validator.check("2 / 2");
        } catch (InvalidExpressionException ex) {
            fail("Test should not throw InvalidExpressionException");
        }
    }
    
    @Test
    public void testValidateDivisionnOfDoubleExpression() {
        try {
            ExpressionValidator validator = new ExpressionValidator();
            validator.check("2.2 / 2.3");
        } catch (InvalidExpressionException ex) {
            fail("Test should not throw InvalidExpressionException");
        }
    }
    
    @Test
    public void testInvalidExpression() {
        try {
            ExpressionValidator validator = new ExpressionValidator();
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
            ExpressionValidator validator = new ExpressionValidator();
            validator.check("2.2b/2.3");
            fail("Test should throw InvalidExpressionException");
        } catch (InvalidExpressionException ex) {
        } catch (Exception ex) {
            fail("Test should not throw Exception");
        }
    }
}
