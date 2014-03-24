package validator.numeric;

import static org.junit.Assert.fail;
import org.junit.BeforeClass;
import org.junit.Test;
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
        testShouldPass("(2.2+2.3)");
    }
    
    @Test
    public void testValidExpressionWithOperationAfterParenthesis() {
        testShouldPass("(2.2+2.3)*3");
    }
    
    @Test
    public void testValidExpressionWithOperationBeforeParenthesis() {
        testShouldPass("3*(2.2+2.3)");
    }
    
    @Test
    public void testValidExpressionWithTwoParenthesis() {
        testShouldPass("(2.2+2.3)*(3-2)");
    }
    
    @Test
    public void testInvalidExpressionWithParenthesis() {
        testShouldFail("((2.2+2.3)");
    }
    
    @Test
    public void testAnotherInvalidExpressionWithParenthesis() {
        testShouldFail("(2.2+2)+(3+)");
    }
    
    public void testShouldPass(String expression) {
        try {
            validator.check(expression);
        } catch (InvalidExpressionException ex) {
            fail("Test should not throw InvalidExpressionException");
        }
    }
    
    public void testShouldFail(String expression) {
        try {
            validator.check(expression);
            fail("Test should throw InvalidExpressionException");
        } catch (InvalidExpressionException ex) {
        } catch (Exception ex) {
            fail("Test should not throw Exception");
        }
    }
}
