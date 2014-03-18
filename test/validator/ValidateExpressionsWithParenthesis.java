package validator;

import org.junit.Test;
import static org.junit.Assert.*;

public class ValidateExpressionsWithParenthesis {
    
    @Test
    public void testValidExpressionWithParenthesis() {
        try {
            ExpressionValidator validator = new ExpressionValidator();
            validator.check("(2.2+2.3)");
        } catch (InvalidExpressionException ex) {
            fail("Test should not throw InvalidExpressionException");
        }
    }
    
    @Test
    public void testValidExpressionWithOperationAfterParenthesis() {
        try {
            ExpressionValidator validator = new ExpressionValidator();
            validator.check("(2.2+2.3)*3");
        } catch (InvalidExpressionException ex) {
            fail("Test should not throw InvalidExpressionException");
        }
    }
    
    @Test
    public void testValidExpressionWithOperationBeforeParenthesis() {
        try {
            ExpressionValidator validator = new ExpressionValidator();
            validator.check("3*(2.2+2.3)");
        } catch (InvalidExpressionException ex) {
            fail("Test should not throw InvalidExpressionException");
        }
    }
    
    @Test
    public void testValidExpressionWithTwoParenthesis() {
        try {
            ExpressionValidator validator = new ExpressionValidator();
            validator.check("(2.2+2.3)*(3-2)");
        } catch (InvalidExpressionException ex) {
            fail("Test should not throw InvalidExpressionException");
        }
    }
    
    @Test
    public void testInvalidExpressionWithParenthesis() {
        try {
            ExpressionValidator validator = new ExpressionValidator();
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
            ExpressionValidator validator = new ExpressionValidator();
            validator.check("(2.2+2)+(3+)");
            fail("Test should throw InvalidExpressionException");
        } catch (InvalidExpressionException ex) {
        } catch (Exception ex) {
            fail("Test should not throw Exception");
        }
    }
}
