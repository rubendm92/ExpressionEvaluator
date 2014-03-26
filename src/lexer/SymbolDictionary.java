package lexer;

import java.util.HashMap;
import parser.token.Bracket;
import parser.token.Operator;
import parser.token.Symbol;

public class SymbolDictionary {
    
    private final HashMap<Character, Operator> operators;
    private final HashMap<Character, Bracket> brackets;
    
    public SymbolDictionary() {
        this.operators = new HashMap<>();
        addOperators();
        this.brackets = new HashMap<>();
        addBrackets();
    }
    
    public Symbol getSymbol(char symbol) {
        return (operators.get(symbol) == null) ? brackets.get(symbol) : operators.get(symbol);
    }
    
    public boolean isSymbol(char operator) {
        return getSymbol(operator) != null;
    }
    
    public boolean isOperator(char operator) {
         return operators.get(operator) != null;
    }
    
    public boolean isBracket(char bracket) {
         return brackets.get(bracket) != null;
    }

    private void addOperators() {
        operators.put('+', Operator.ADD);
        operators.put('-', Operator.SUBTRACT);
        operators.put('*', Operator.MULTIPLY);
        operators.put('/', Operator.DIVIDE);
    }

    private void addBrackets() {
        brackets.put('(', Bracket.OPEN);
        brackets.put(')', Bracket.CLOSE);
    }
}
