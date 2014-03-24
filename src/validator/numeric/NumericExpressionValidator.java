package validator.numeric;

import java.util.ArrayList;
import validator.ExpressionValidator;
import validator.InvalidExpressionException;

public class NumericExpressionValidator implements ExpressionValidator {

    private ArrayList<Character> numbers;
    private ArrayList<Character> operators;
    
    private boolean lastCharacterWasNumber = false;
    private int parenthesis;

    public NumericExpressionValidator() {
        this.parenthesis = 0;
        initOperators();
        initNumbers();
    }

    private void initNumbers() {
        this.numbers = new ArrayList<>();
        for (int i = 0; i < 10; i++)
            numbers.add(Character.forDigit(i, 10));
    }

    private void initOperators() {
        this.operators = new ArrayList<>();
        this.operators.add('+');
        this.operators.add('-');
        this.operators.add('*');
        this.operators.add('/');
    }
    
    @Override
    public void check(String expression) {
        char[] expressionWithoutSpaces = expression.replace(" ", "").toCharArray();
        for (char character : expressionWithoutSpaces) {
            if (isNumber(character) || character == '.') {
                lastCharacterWasNumber = true;
                continue;
            }
            if (isOperator(character) && lastCharacterWasNumber) {
                lastCharacterWasNumber = false;
                continue;
            }
            if (character == '(') {
                parenthesis++;
                continue;
            }
            if (character == ')' && lastCharacterWasNumber) {
                parenthesis--;
                continue;
            }
            throw  new InvalidExpressionException();
        }
        if (!(lastCharacterWasNumber && (parenthesis == 0))) throw  new InvalidExpressionException();
    }

    private boolean isNumber(char character) {
        return numbers.contains(character);
    }
    
    private boolean isOperator(char character) {
        return operators.contains(character);
    }
    
}
