package parser.token;

public class Parenthesis implements Symbol{
    
    public static final Parenthesis OPEN = new Parenthesis();
    public static final Parenthesis CLOSE = new Parenthesis();
    
    private Parenthesis() {
    }
}
