package lexer;

import org.junit.Test;
import static org.junit.Assert.*;
import parser.shuntingyard.ShuntingYardParser;
import parser.shuntingyard.SimpleParserTreeBuildingStrategy;
import parser.token.Token;

public class LexerTests {
    
    @Test
    public void testAnalyzeSimpleExpression() {
        Lexer lexer = new Lexer();
        Token[] tokens = lexer.analyze("1+2");
        ShuntingYardParser parser = new ShuntingYardParser(new SimpleParserTreeBuildingStrategy());
        assertEquals(3, parser.parse(tokens).evaluate());
    }
}
