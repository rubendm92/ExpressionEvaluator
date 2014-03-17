package parser;

import parser.token.Symbol;
import parser.token.Constant;
import parser.token.Token;
import evaluator.Expression;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import parser.token.Operator;
import parser.token.Parenthesis;

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
        assertEquals(4, parser.parse(tokens).evaluate());
    }
    
    @Test
    public void testOperationWithParenthesis() {
        ShuntingYardParser parser = new ShuntingYardParser(new SimpleParserTreeBuildingStrategy());
        Token[] tokens = {
            Parenthesis.OPEN,
            new Constant(2),
            Operator.ADD,
            new Constant(2),
            Parenthesis.CLOSE,
            Operator.MULTIPLY,
            new Constant(2)
        };
        assertEquals(8, parser.parse(tokens).evaluate());
    }
    
    @Test
    public void testAnotherOperationWithParenthesis() {
        ShuntingYardParser parser = new ShuntingYardParser(new SimpleParserTreeBuildingStrategy());
        System.out.println("test2");
        Token[] tokens = {
            new Constant(2),
            Operator.MULTIPLY,
            Parenthesis.OPEN,
            new Constant(2),
            Operator.ADD,
            new Constant(2),
            Parenthesis.CLOSE
        };
        assertEquals(8, parser.parse(tokens).evaluate());
    }
}
