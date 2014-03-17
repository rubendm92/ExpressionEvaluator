package lexer;

import java.util.ArrayList;
import parser.token.Constant;
import parser.token.Token;

public class Lexer {
    private final SymbolDictionary dictionary;

    public Lexer() {
        this.dictionary = new SymbolDictionary();
    }
    
    public ArrayList<Token> analyze(String expression) {
        ArrayList<Token> tokens = new ArrayList<>();
        String number = "";
        for (char character : formatExpression(expression).toCharArray()) {
            if (isSymbol(character)) {
                if (!number.equals("")) tokens.add(constant(number));
                tokens.add(dictionary.getSymbol(character));
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
    
    private boolean isSymbol(char character) {
        char[] operators = new char[]{'+', '-', '*', '/', '(', ')'};
        for (char c : operators)
            if (c == character) return true;
        return false;
    }

    private Token constant(String number) {
        if (number.contains(".")) return new Constant(Double.valueOf(number));
        return new Constant(Integer.valueOf(number));
    }
    
}
