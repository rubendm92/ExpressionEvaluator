package lexer;

import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.*;
import parser.shuntingyard.ShuntingYardParser;
import parser.shuntingyard.SimpleParserTreeBuildingStrategy;
import parser.token.Token;

public class LexerTests {
    
    @Test
    public void testAnalyzeSimpleExpression() {
        Lexer lexer = new Lexer();
        ArrayList<Token> tokens = lexer.analyze("1+2");
        ShuntingYardParser parser = new ShuntingYardParser(new SimpleParserTreeBuildingStrategy());
        assertEquals(3, parser.parse(tokens.toArray(new Token[]{})).evaluate());
    }
    
    @Test
    public void testAnalyzeAnotherSimpleExpression() {
        Lexer lexer = new Lexer();
        ArrayList<Token> tokens = lexer.analyze("2-2");
        ShuntingYardParser parser = new ShuntingYardParser(new SimpleParserTreeBuildingStrategy());
        assertEquals(0, parser.parse(tokens.toArray(new Token[]{})).evaluate());
    }
    
    @Test
    public void testAnalyzeAnotherSimpleExpressionWithDoubles() {
        Lexer lexer = new Lexer();
        ArrayList<Token> tokens = lexer.analyze("2.3-2.1");
        ShuntingYardParser parser = new ShuntingYardParser(new SimpleParserTreeBuildingStrategy());
        assertEquals(0.2, (double)parser.parse(tokens.toArray(new Token[]{})).evaluate(), 0.01);
    }
    
    @Test
    public void testAnalyzeExpressionWithSpaces() {
        Lexer lexer = new Lexer();
        ArrayList<Token> tokens = lexer.analyze("2 - 2");
        ShuntingYardParser parser = new ShuntingYardParser(new SimpleParserTreeBuildingStrategy());
        assertEquals(0, parser.parse(tokens.toArray(new Token[]{})).evaluate());
    }
    
    @Test
    public void testAnalyzeExpressionWithParenthesis() {
        Lexer lexer = new Lexer();
        ArrayList<Token> tokens = lexer.analyze("(4 - 2) * 2");
        ShuntingYardParser parser = new ShuntingYardParser(new SimpleParserTreeBuildingStrategy());
        assertEquals(4, parser.parse(tokens.toArray(new Token[]{})).evaluate());
    }
}