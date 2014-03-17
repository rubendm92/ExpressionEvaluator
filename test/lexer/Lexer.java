package lexer;

import java.util.ArrayList;
import parser.token.Constant;
import parser.token.Operator;
import parser.token.Token;

public class Lexer {

    public ArrayList<Token> analyze(String expression) {
        ArrayList<Token> tokens = new ArrayList<>();
        String number = "";
        for (char character : expression.toCharArray()) {
            if (isOperator(character)) {
                tokens.add(constant(number));
                tokens.add(operator(character));
                number = "";
                continue;
            }
            number += character;
        }
        tokens.add(constant(number));
        return tokens;
    }
    
    private boolean isOperator(char character) {
        char[] operators = new char[]{'+', '-', '*', '/'};
        for (char c : operators)
            if (c == character) return true;
        return false;
    }
    
    private Operator operator(char character) {
        if (character == '+') return Operator.ADD;
        if (character == '-') return Operator.SUBTRACT;
        if (character == '*') return Operator.MULTIPLY;
        return Operator.DIVIDE;
    }

    private Token constant(String number) {
        return new Constant(Integer.valueOf(number));
    }
    
}
