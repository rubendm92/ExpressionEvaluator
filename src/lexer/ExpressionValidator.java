package lexer;

public class ExpressionValidator {

    public void check(String expression) {
        if (expression.matches("[\\(]*" + numberRegex() + "+(\\+|\\-|\\*|\\/)+" + numberRegex() + "[\\)]*")) return;
        throw new InvalidExpressionException();
    }
    
    private String numberRegex() {
        return "([0-9]+|[0-9]+\\.[0-9]+)";
    }
}
