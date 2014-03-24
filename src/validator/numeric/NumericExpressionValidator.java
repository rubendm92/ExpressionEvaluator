package validator.numeric;

import java.util.ArrayList;
import validator.ExpressionValidator;
import validator.InvalidExpressionException;

public class NumericExpressionValidator implements ExpressionValidator {

    private ArrayList<Character> numbers;
    private ArrayList<Character> operators;
    
    private boolean lastCharacterWasNumber;
    private int parenthesis;

    public NumericExpressionValidator() {
        initNumbers();
        initOperators();
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
        init();
        char[] expressionWithoutSpaces = expression.replace(" ", "").toCharArray();
        for (char character : expressionWithoutSpaces)
            checkCharacter(character);
        if (!lastCharacterIsValid()) throw  new InvalidExpressionException();
    }

    private void init() {
        lastCharacterWasNumber = false;
        parenthesis = 0;
    }
    
    private void checkCharacter(char character) throws InvalidExpressionException {
        if (!isValidCharacter(character)) throw  new InvalidExpressionException();
        process(character);
    }
    
    private boolean isValidCharacter(char character) {
        return (isNumber(character) || (characterAfterNumber(character)) || (character == '('));
    
    }
    private boolean isNumber(char character) {
        return numbers.contains(character);
    }
    
    private boolean characterAfterNumber(char character) {
        return (lastCharacterWasNumber && (character == '.' || isOperator(character) || character == ')'));
    }
    
    private void process(char character) {
        if (isNumber(character)) lastCharacterWasNumber = true;
        else if (lastCharacterWasNumber) whenLastCharacterWasNumber(character);
        else if (character == '(') parenthesis++;
    }

    private void whenLastCharacterWasNumber(char character) {
        if (character == '.') lastCharacterWasNumber = false;
        if (isOperator(character)) lastCharacterWasNumber = false;
        if (character == ')') parenthesis--;
    }
    
    private boolean isOperator(char character) {
        return operators.contains(character);
    }
    
    private boolean lastCharacterIsValid() {
        return (lastCharacterWasNumber && (parenthesis == 0));
    }
}
