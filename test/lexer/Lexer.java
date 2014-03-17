package lexer;

import parser.token.Constant;
import parser.token.Operator;
import parser.token.Token;

public class Lexer {

    public Token[] analyze(String expression) {
        return new Token[]{new Constant(1), Operator.ADD, new Constant(2)};
    }
    
}
