package lexer;

public class ExpressionValidator {

    public void check(String expression) {
        if (expression.matches("\\d+[\\+|\\-|\\*\\/]+\\d")) return;
        throw new InvalidExpressionException();
    }
}
