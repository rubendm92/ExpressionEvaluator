package lexer;

import org.junit.Test;
import static org.junit.Assert.*;

public class ExpressionValidatorTests {
    
    @Test
    public void testValidateAdditionOfIntegerExpression() {
        try {
            ExpressionValidator validator = new ExpressionValidator();
            validator.check("2+2");
        } catch (InvalidExpressionException ex) {
            fail("Test should not throw InvalidExpressionException");
        }
    }
    
    @Test
    public void testValidateAdditionOfDoubleExpression() {
        try {
            ExpressionValidator validator = new ExpressionValidator();
            validator.check("2.2+2.3");
        } catch (InvalidExpressionException ex) {
            fail("Test should not throw InvalidExpressionException");
        }
    }
}
