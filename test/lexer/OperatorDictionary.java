package lexer;

import java.util.HashMap;
import parser.token.Operator;

public class OperatorDictionary {
    
    private final HashMap<Character, Operator> dictionary;
    
    public OperatorDictionary() {
        this.dictionary = new HashMap<>();
        addOperators();
    }
    
    public Operator getOperator(char operator) {
        return dictionary.get(operator);
    }

    private void addOperators() {
        dictionary.put('+', Operator.ADD);
        dictionary.put('-', Operator.SUBTRACT);
        dictionary.put('*', Operator.MULTIPLY);
        dictionary.put('/', Operator.DIVIDE);
    }
}
