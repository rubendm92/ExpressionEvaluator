package validator.numeric;

import static org.junit.Assert.fail;
import org.junit.BeforeClass;
import org.junit.Test;
import validator.ExpressionValidator;
import validator.InvalidExpressionException;

public class ValidateExpressionsWithBrackets {
    
    private static ExpressionValidator validator;
    
    @BeforeClass
    public static void setUpClass() {
        validator = new NumericExpressionValidator();
    }
    
    @Test
    public void testValidExpressionWithBrackets() {
        testShouldPass("(2.2+2.3)");
    }
    
    @Test
    public void testValidExpressionWithOperationAfterBrackets() {
        testShouldPass("(2.2+2.3)*3");
    }
    
    @Test
    public void testValidExpressionWithOperationBeforeBrackets() {
        testShouldPass("3*(2.2+2.3)");
    }
    
    @Test
    public void testValidExpressionWithTwoBrackets() {
        testShouldPass("(2.2+2.3)*(3-2)");
    }
    
    @Test
    public void testInvalidExpressionWithBrackets() {
        testShouldFail("((2.2+2.3)");
    }
    
    @Test
    public void testAnotherInvalidExpressionWithBrackets() {
        testShouldFail("(2.2+2)+(3+)");
    }
    
    @Test
    public void testInvalidExpressionWithTooManyPointsBeforeCloseBrackets() {
        testShouldFail("(2.2+2.2.3)");
    }
    
    @Test
    public void testInvalidExpressionWithBracketsBadPlaced() {
        testShouldFail("2)+4(");
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
