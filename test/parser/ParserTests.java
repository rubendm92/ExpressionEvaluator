package parser;

import evaluator.Expression;
import java.util.Stack;
import org.junit.Test;
import static parser.Token.*;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class ParserTests {
    
    @Test
    public void testSimpleExpression() {
        ExpressionFactory factory = mock(ExpressionFactory.class);
        when(factory.getExpressionStack()).thenReturn(new Stack<Expression>());
        Token[] tokens = {
            constant(1),
            symbol("+"),
            constant(2)
        };
        Expression expression = new Parser(factory).parse(tokens);
        verify(factory).getExpressionStack();
        verify(factory).build(tokens[0]);
        verify(factory).build(tokens[2]);
        verify(factory).build(tokens[1]);
    }
    
    @Test
    public void testTwoOperandsExpression() {
        Parser parser = new Parser(new ExpressionFactoryImpl());
        Token[] tokens = {
            constant(1),
            symbol("+"),
            constant(2),
            symbol("+"),
            constant(2)
        };
        assertEquals(5, parser.parse(tokens).evaluate());
    }
    
    @Test
    public void testOperatorPrecedence() {
        Parser parser = new Parser(new ExpressionFactoryImpl());
        Token[] tokens = {
            constant(2),
            symbol("*"),
            constant(1),
            symbol("+"),
            constant(2)
        };
        assertEquals(4, parser.parse(tokens).evaluate());
    }
}
