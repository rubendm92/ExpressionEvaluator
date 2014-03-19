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
        return countCharacter(expression, (char character) -> (character == '(')) == countCharacter(expression, (char character) -> (character == ')'));
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

    private int countCharacter(String expression, Function function) {
        int characterCount = 0;
        for (char character : expression.toCharArray())
            if (function.apply(character)) characterCount++;
        return characterCount;
    }
    
    private interface Function {
        public boolean apply(char character);
    }
}
