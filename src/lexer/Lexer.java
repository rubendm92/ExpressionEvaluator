package lexer;

import java.util.ArrayList;
import parser.token.Constant;
import parser.token.Token;

public class Lexer {
    
    private final SymbolDictionary dictionary;
    private ArrayList<Token> tokens;
    private String currentNumber;

    public Lexer() {
        this.dictionary = new SymbolDictionary();
    }
    
    public ArrayList<Token> analyze(String expression) {
        tokens = new ArrayList<>();
        currentNumber = "";
        processString(formatExpression(expression));
        return tokens;
    }
    
    private char[] formatExpression(String expression) {
        return expression.replace(" ", "").toCharArray();
    }

    private void processString(char[] expression) {
        for (char character : expression)
            processCharacter(character);
        processNumber();
    }

    private void processCharacter(char character) {
        if (dictionary.isSymbol(character))
            processSymbol(character);
        else
            currentNumber += character;
    }

    private void processSymbol(char character) {
        processNumber();
        tokens.add(dictionary.getSymbol(character));
    }
    
    private void processNumber() {
        if ("".equals(currentNumber)) return;
        if (currentNumber.contains(".")) tokens.add(new Constant(Double.valueOf(currentNumber)));
        else tokens.add(new Constant(Integer.valueOf(currentNumber)));
        currentNumber = "";
    }
}
