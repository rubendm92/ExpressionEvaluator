package lexer;

import java.util.ArrayList;
import parser.token.Constant;
import parser.token.Token;

public class Lexer {
    
    private final SymbolDictionary dictionary;
    private ArrayList<Token> tokens;

    public Lexer() {
        this.dictionary = new SymbolDictionary();
    }
    
    public ArrayList<Token> analyze(String expression) {
        tokens = new ArrayList<>();
        String number = "";
        for (char character : formatExpression(expression)) {
            if (dictionary.isSymbol(character)) {
                processNumber(number);
                tokens.add(dictionary.getSymbol(character));
                number = "";
            } else
                number += character;
        }
        processNumber(number);
        return tokens;
    }
    
    private char[] formatExpression(String expression) {
        return expression.replace(" ", "").toCharArray();
    }

    private void processNumber(String number) {
        if ("".equals(number)) return;
        if (number.contains(".")) tokens.add(new Constant(Double.valueOf(number)));
        else tokens.add(new Constant(Integer.valueOf(number)));
    }
}
