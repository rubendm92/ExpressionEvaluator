package lexer;

public class ExpressionValidator {

    public void check(String expression) {
        if (!checkParenthesis(expression)) throw new InvalidExpressionException();
        if (expression.matches("[\\(]*" + numberRegex() + "+(\\+|\\-|\\*|\\/)+" + numberRegex() + "[\\)]*")) return;
        throw new InvalidExpressionException();
    }
    
    private boolean checkParenthesis(String expression) {
        int openParenthesis = 0;
        int closedParenthesis = 0;
        for (char character : expression.toCharArray()) {
            if (character == '(') openParenthesis++;
            if (character == ')') closedParenthesis++;
        }
        return openParenthesis == closedParenthesis;
    }
    
    private String numberRegex() {
        return "([0-9]+|[0-9]+\\.[0-9]+)";
    }
}
