package lexer;

import java.util.HashMap;
import parser.token.Operator;
import parser.token.Parenthesis;
import parser.token.Symbol;

public class SymbolDictionary {
    
    private final HashMap<Character, Symbol> dictionary;
    
    public SymbolDictionary() {
        this.dictionary = new HashMap<>();
        addOperators();
    }
    
    public Symbol getSymbol(char operator) {
        return dictionary.get(operator);
    }

    private void addOperators() {
        dictionary.put('+', Operator.ADD);
        dictionary.put('-', Operator.SUBTRACT);
        dictionary.put('*', Operator.MULTIPLY);
        dictionary.put('/', Operator.DIVIDE);
        dictionary.put('(', Parenthesis.OPEN);
        dictionary.put(')', Parenthesis.CLOSE);
    }
}
