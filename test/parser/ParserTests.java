package parser;

import evaluator.Expression;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import parser.shuntingyard.ShuntingYardParser;
import parser.shuntingyard.SimpleParserTreeBuildingStrategy;
import parser.token.Bracket;
import parser.token.Constant;
import parser.token.Operator;
import parser.token.Token;

public class ParserTests {
    
    @Test
    public void testStrategyStub() {
        ParserTreeBuildingStrategy strategy = mock(ParserTreeBuildingStrategy.class);
        Token[] tokens = {
            new Constant(1),
            Operator.ADD,
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
            Operator.ADD,
            new Constant(2),
            Operator.ADD,
            new Constant(2)
        };
        assertEquals(5, parser.parse(tokens).evaluate());
    }
    
    @Test
    public void testTwoOperandsExpressionWithPrecedence() {
        ShuntingYardParser parser = new ShuntingYardParser(new SimpleParserTreeBuildingStrategy());
        Token[] tokens = {
            new Constant(2),
            Operator.ADD,
            new Constant(2),
            Operator.MULTIPLY,
            new Constant(2)
        };
        assertEquals(6, parser.parse(tokens).evaluate());
    }
    
    @Test
    public void testAdditionAndSubtraction() {
        ShuntingYardParser parser = new ShuntingYardParser(new SimpleParserTreeBuildingStrategy());
        Token[] tokens = {
            new Constant(3),
            Operator.SUBTRACT,
            new Constant(1),
            Operator.ADD,
            new Constant(2)
        };
        Object val = parser.parse(tokens).evaluate();
        assertEquals(4, val);
    }
    
    @Test
    public void testOperationWithBrackets() {
        ShuntingYardParser parser = new ShuntingYardParser(new SimpleParserTreeBuildingStrategy());
        Token[] tokens = {
            Bracket.OPEN,
            new Constant(2),
            Operator.ADD,
            new Constant(2),
            Bracket.CLOSE,
            Operator.MULTIPLY,
            new Constant(2)
        };
        assertEquals(8, parser.parse(tokens).evaluate());
    }
    
    @Test
    public void testAnotherOperationWithBrackets() {
        ShuntingYardParser parser = new ShuntingYardParser(new SimpleParserTreeBuildingStrategy());
        Token[] tokens = {
            new Constant(3),
            Operator.MULTIPLY,
            Bracket.OPEN,
            new Constant(2),
            Operator.ADD,
            new Constant(2),
            Bracket.CLOSE
        };
        assertEquals(12, parser.parse(tokens).evaluate());
    }
    
    @Test
    public void testExpressionWithThreeOperators() {
        ShuntingYardParser parser = new ShuntingYardParser(new SimpleParserTreeBuildingStrategy());
        Token[] tokens = {
            new Constant(30),
            Operator.SUBTRACT,
            new Constant(8),
            Operator.DIVIDE,
            new Constant(4),
            Operator.SUBTRACT,
            new Constant(8)
        };
        assertEquals(20, parser.parse(tokens).evaluate());
    }
}
