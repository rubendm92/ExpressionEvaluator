package parser;

import evaluator.Expression;
import org.junit.Test;
import static parser.Token.*;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class ParserTests {
    
    @Test
    public void testSimpleExpression() {
        ExpressionFactory factory = mock(ExpressionFactory.class);
        Parser parser = new Parser(factory);
        Token[] tokens = {
            constant(1),
            symbol("+"),
            constant(2)
        };
        Expression expression = parser.parse(tokens);
        verify(factory.build(constant(1)));
        verify(factory.build(symbol("+")));
        verify(factory.build(constant(2)));
    }
}
