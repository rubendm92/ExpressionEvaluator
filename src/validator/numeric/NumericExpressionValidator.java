package validator.numeric;

import java.util.HashMap;
import validator.ExpressionValidator;
import validator.InvalidExpressionException;

public class NumericExpressionValidator implements ExpressionValidator {

    private final HashMap<Character, Function> functions;

    private boolean lastCharacterWasNumber;
    private int points;
    private int brackets;

    public NumericExpressionValidator() {
        this.functions = new HashMap<>();
        initOperators();
        initPoint();
        initNumbers();
        initBrackets();
    }

    private void initOperators() {
        functions.put('+', (Function) () -> processOperator('+'));
        functions.put('-', (Function) () -> processOperator('-'));
        functions.put('*', (Function) () -> processOperator('*'));
        functions.put('/', (Function) () -> processOperator('/'));
        
    }

    private void processOperator(char character) throws InvalidExpressionException {
        if (!lastCharacterWasNumber)
            if (character != '-') throw new InvalidExpressionException();
        lastCharacterWasNumber = false;
        if (points != 0) points--;
    }
    
    private void initPoint() {
        functions.put('.', (Function) () -> processPoint());
    }

    private void processPoint() throws InvalidExpressionException {
        if (++points > 1) throw new InvalidExpressionException();
        if (lastCharacterWasNumber) lastCharacterWasNumber = false;
    }
    
    private void initNumbers() {
        for (int i = 0; i < 10; i++)
            functions.put(Character.forDigit(i, 10), (Function) () -> lastCharacterWasNumber = true);
    }

    private void initBrackets() {
        functions.put('(', (Function) () -> brackets++);
        functions.put(')', (Function) () -> processCloseBrackets());
    }

    private void processCloseBrackets() throws InvalidExpressionException {
        if (brackets == 0) throw new InvalidExpressionException();
        if (lastCharacterWasNumber) brackets--;
    }
    
    @Override
    public void check(String expression) {
        init();
        for (char character : expressionWithoutSpaces(expression).toCharArray())
            checkCharacter(character);
        if (!lastCharacterIsValid()) throw new InvalidExpressionException();
    }

    private void init() {
        lastCharacterWasNumber = false;
        brackets = 0;
        points = 0;
    }
    
    private String expressionWithoutSpaces(String expression) {
        return expression.replace(" ", "");
    }

    private void checkCharacter(char character) {
        if (!isValidCharacter(character)) throw new InvalidExpressionException();
        functions.get(character).apply();
    }

    private boolean isValidCharacter(char character) {
        return functions.get(character) != null;

    }

    private boolean lastCharacterIsValid() {
        return (lastCharacterWasNumber && (brackets == 0) && points < 2);
    }

    private interface Function {
        public void apply();
    }
}
