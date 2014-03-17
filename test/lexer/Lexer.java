package lexer;

import java.util.ArrayList;
import parser.token.Constant;
import parser.token.Operator;
import parser.token.Token;

public class Lexer {
    private final OperatorDictionary dictionary;

    public Lexer() {
        this.dictionary = new OperatorDictionary();
    }
    
    public ArrayList<Token> analyze(String expression) {
        ArrayList<Token> tokens = new ArrayList<>();
        String number = "";
        for (char character : formatExpression(expression).toCharArray()) {
            if (isOperator(character)) {
                tokens.add(constant(number));
                tokens.add(dictionary.getOperator(character));
                number = "";
                continue;
            }
            number += character;
        }
        tokens.add(constant(number));
        return tokens;
    }
    
    private String formatExpression(String expression) {
        return expression.replace(" ", "");
    }
    
    private boolean isOperator(char character) {
        char[] operators = new char[]{'+', '-', '*', '/'};
        for (char c : operators)
            if (c == character) return true;
        return false;
    }

    private Token constant(String number) {
        return new Constant(Integer.valueOf(number));
    }
    
}
