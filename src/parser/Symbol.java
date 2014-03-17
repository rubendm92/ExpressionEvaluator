package parser;

public class Symbol implements Token<String>{

    public static final Symbol ADD = new Symbol("+", 0);
    public static final Symbol SUBTRACT = new Symbol("-", 0);
    public static final Symbol MULTIPLY = new Symbol("*", 1);
    public static final Symbol DIVIDE = new Symbol("/", 1);
    
    private final String symbol;
    private final int precedence;

    private Symbol(String symbol, int precedence) {
        this.symbol = symbol;
        this.precedence = precedence;
    }

    public boolean hasMorePrecedence(Symbol symbol) {
        return precedence > symbol.precedence;
    }

    @Override
    public String value() {
        return symbol;
    }
}
