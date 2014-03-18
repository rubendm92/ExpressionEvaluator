package validator.numeric;

import validator.ExpressionValidator;
import validator.InvalidExpressionException;

public class NumericExpressionValidator implements ExpressionValidator {

    private final String numberRegex = "([0-9]+|[0-9]+\\.[0-9]+)+";
    private final String operatorsRegex = "(\\+|\\-|\\*|\\/)+";
    private final String openParenthesisRegex = "[\\(]*";
    private final String closeParenthesisRegex = "[\\)]*";
    
    @Override
    public void check(String expression) {
        String expressionWithoutSpaces = expression.replace(" ", "");
        if (!checkParenthesis(expressionWithoutSpaces)) throw new InvalidExpressionException();
        if (expressionWithoutSpaces.matches(regularExpression())) return;
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
    
    private String regularExpression() {
        return expressionOperationBeforeParenthesis() + expressionWithParenthesis() + expressionOperationAfterParenthesis();
    }
    
    private String expressionOperationBeforeParenthesis() {
        return "[" + expressionWithParenthesis() + operatorsRegex + "]*";
    }
    
    private String expressionOperationAfterParenthesis() {
        return "[" + operatorsRegex + expressionWithParenthesis() + "]*";
    }

    private String expressionWithParenthesis() {
        return openParenthesisRegex + simpleRegularExpression() + closeParenthesisRegex;
    }
    
    private String simpleRegularExpression() {
        return numberRegex + operatorsRegex + numberRegex;
    }
}
