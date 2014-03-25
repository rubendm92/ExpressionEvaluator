package validator.numeric;

import static org.junit.Assert.fail;
import org.junit.BeforeClass;
import org.junit.Test;
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
        testShouldPass("2 + 2");
    }
    
    @Test
    public void testValidateAdditionOfDoubleExpression() {
        testShouldPass("2.2 + 2.3");
    }
    
    @Test
    public void testValidateSubtractionOfIntegerExpression() {
        testShouldPass("2 - 2");
    }
    
    @Test
    public void testValidateSubtractionOfDoubleExpression() {
        testShouldPass("2.2 - 2.3");
    }
    
    @Test
    public void testValidateMultiplicationOfIntegerExpression() {
        testShouldPass("22 * 11");
    }
    
    @Test
    public void testValidateMultiplicationOfDoubleExpression() {
        testShouldPass("4.22 * 1.3");
    }
    
    @Test
    public void testValidateDivisionOfIntegerExpression() {
        testShouldPass("2 / 2");
    }
    
    @Test
    public void testValidateDivisionnOfDoubleExpression() {
        testShouldPass("2.2 / 2.3");
    }
    
    @Test
    public void testInvalidExpression() {
        testShouldFail("2.2b/2.3");
    }
    
    @Test
    public void testExpressionWithMoreThanTwoOperands() {
        testShouldPass("2.2 * 2.3 + 3");
    }
    
    @Test
    public void testInvalidExpressionTooManyPoints() {
        testShouldFail("2.2.3 + 3");
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
