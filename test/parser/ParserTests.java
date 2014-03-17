package parser;

import parser.token.Symbol;
import parser.token.Constant;
import parser.token.Token;
import evaluator.Expression;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class ParserTests {
    
    @Test
    public void testStrategyStub() {
        ParserTreeBuildingStrategy strategy = mock(ParserTreeBuildingStrategy.class);
        Token[] tokens = {
            new Constant(1),
            Symbol.ADD,
            new Constant(2)
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
            new Constant(1),
            Symbol.ADD,
            new Constant(2),
            Symbol.ADD,
            new Constant(2)
        };
        assertEquals(5, parser.parse(tokens).evaluate());
    }
    
    @Test
    public void testTwoOperandsExpressionWithPrecedence() {
        ShuntingYardParser parser = new ShuntingYardParser(new SimpleParserTreeBuildingStrategy());
        Token[] tokens = {
            new Constant(2),
            Symbol.ADD,
            new Constant(2),
            Symbol.MULTIPLY,
            new Constant(2)
        };
        assertEquals(6, parser.parse(tokens).evaluate());
    }
    
    @Test
    public void testAdditionAndSubtraction() {
        ShuntingYardParser parser = new ShuntingYardParser(new SimpleParserTreeBuildingStrategy());
        Token[] tokens = {
            new Constant(3),
            Symbol.SUBTRACT,
            new Constant(1),
            Symbol.ADD,
            new Constant(2)
        };
        assertEquals(4, parser.parse(tokens).evaluate());
    }
}
