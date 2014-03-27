package lexer;

import java.util.ArrayList;
import static org.junit.Assert.assertEquals;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.mockito.Mockito.mock;
import parser.ExpressionFactoryImpl;
import parser.Parser;
import parser.shuntingyard.ShuntingYardParser;
import parser.shuntingyard.SimpleParserTreeBuildingStrategy;
import parser.token.Token;
import validator.ExpressionValidator;

public class LexerTests {
    
    private static Lexer lexer;
    private static Parser parser;
    
    @BeforeClass
    public static void setUpClass() {
        lexer = new Lexer(mock(ExpressionValidator.class));
        parser = new ShuntingYardParser(new SimpleParserTreeBuildingStrategy(new ExpressionFactoryImpl()));
    }
    
    @Test
    public void testAnalyzeSimpleExpression() {
        ArrayList<Token> tokens = lexer.analyze("1+2");
        assertEquals(3, parser.parse(tokens.toArray(new Token[]{})).evaluate());
    }
    
    @Test
    public void testAnalyzeAnotherSimpleExpression() {
        ArrayList<Token> tokens = lexer.analyze("2-2");
        assertEquals(0, parser.parse(tokens.toArray(new Token[]{})).evaluate());
    }
    
    @Test
    public void testAnalyzeAnotherSimpleExpressionWithDoubles() {
        ArrayList<Token> tokens = lexer.analyze("2.3-2.1");
        assertEquals(0.2, (double)parser.parse(tokens.toArray(new Token[]{})).evaluate(), 0.01);
    }
    
    @Test
    public void testAnalyzeExpressionWithSpaces() {
        ArrayList<Token> tokens = lexer.analyze("2 - 2");
        assertEquals(0, parser.parse(tokens.toArray(new Token[]{})).evaluate());
    }
    
    @Test
    public void testAnalyzeExpressionWithBrackets() {
        ArrayList<Token> tokens = lexer.analyze("(4 - 2) * 2");
        assertEquals(4, parser.parse(tokens.toArray(new Token[]{})).evaluate());
    }
    
    @Test
    public void testAnalyzeExpressionWithNegativeNumber() {
        ArrayList<Token> tokens = lexer.analyze("(-2) * 2");
        assertEquals(-4, parser.parse(tokens.toArray(new Token[]{})).evaluate());
    }
}
