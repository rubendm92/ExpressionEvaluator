package parser;

import evaluator.Expression;
import org.junit.Test;
import static parser.Token.*;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class ParserTests {
    
    @Test
    public void testStrategyStub() {
        ParserTreeBuildingStrategy strategy = mock(ParserTreeBuildingStrategy.class);
        Token[] tokens = {
            constant(1),
            symbol("+"),
            constant(2)
        };
        Expression expression = new ShuntingYardParser(strategy).parse(tokens);
        verify(strategy).build(tokens[0]);
        verify(strategy).build(tokens[1]);
        verify(strategy).build(tokens[2]);
        verify(strategy).getExpression();
    }
    
    @Test
    public void testTwoOperandsExpression() {
        ShuntingYardParser parser = new ShuntingYardParser(new SimpleParserTreeBuildingStrategy());
        Token[] tokens = {
            constant(1),
            symbol("+"),
            constant(2),
            symbol("+"),
            constant(2)
        };
        assertEquals(5, parser.parse(tokens).evaluate());
    }
}
