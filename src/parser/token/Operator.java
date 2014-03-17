package parser.token;

public class Operator implements Symbol{
    
    public static final Operator ADD = new Operator(0);
    public static final Operator SUBTRACT = new Operator(0);
    public static final Operator MULTIPLY = new Operator(1);
    public static final Operator DIVIDE = new Operator(1);
    
    private final int precedence;

    private Operator(int precedence) {
        this.precedence = precedence;
    }
    
    public boolean hasMorePrecedence(Operator symbol) {
        return precedence > symbol.precedence;
    }
    
    public boolean hasEqualPrecedence(Operator symbol) {
        return precedence == symbol.precedence;
    }
}
