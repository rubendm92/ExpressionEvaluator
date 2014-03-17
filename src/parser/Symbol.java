package parser;

public class Symbol implements Token<String>{

    public static final Symbol ADD = new Symbol(0);
    public static final Symbol SUBTRACT = new Symbol(0);
    public static final Symbol MULTIPLY = new Symbol(1);
    public static final Symbol DIVIDE = new Symbol(1);
    
    private final int precedence;

    private Symbol(int precedence) {
        this.precedence = precedence;
    }

    public boolean hasMorePrecedence(Symbol symbol) {
        return precedence > symbol.precedence;
    }
}
