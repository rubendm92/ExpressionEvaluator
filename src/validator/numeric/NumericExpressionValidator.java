package validator.numeric;

import java.util.HashMap;
import validator.ExpressionValidator;
import validator.InvalidExpressionException;

public class NumericExpressionValidator implements ExpressionValidator {

    private final HashMap<Character, Function> functions;

    private boolean lastCharacterWasNumber;
    private int point;
    private int parenthesis;

    public NumericExpressionValidator() {
        this.functions = new HashMap<>();
        initOperators();
        initNumbers();
        initParenthesis();
    }

    private void initOperators() {
        functions.put('+', processOperator());
        functions.put('-', processOperator());
        functions.put('*', processOperator());
        functions.put('/', processOperator());
        functions.put('.', new Function() {

            @Override
            public void apply() {
                if (++point > 1) throw new InvalidExpressionException();
                if (lastCharacterWasNumber) lastCharacterWasNumber = false;
            }
        });
    }

    private Function processOperator() {
        return (Function) () -> {
            if (lastCharacterWasNumber) {
                lastCharacterWasNumber = false;
                if (point != 0) point--;
            }
        };
    }
    
    private void initNumbers() {
        for (int i = 0; i < 10; i++)
            functions.put(Character.forDigit(i, 10), (Function) () -> lastCharacterWasNumber = true);
    }

    private void initParenthesis() {
        functions.put('(', (Function) () -> parenthesis++);
        functions.put(')', (Function) () -> {
            if (lastCharacterWasNumber) parenthesis--;
        });
    }
    
    @Override
    public void check(String expression) {
        init();
        char[] expressionWithoutSpaces = expression.replace(" ", "").toCharArray();
        for (char character : expressionWithoutSpaces)
            checkCharacter(character);
        if (!lastCharacterIsValid())
            throw new InvalidExpressionException();
    }

    private void init() {
        lastCharacterWasNumber = false;
        parenthesis = 0;
        point = 0;
    }

    private void checkCharacter(char character) throws InvalidExpressionException {
        if (!isValidCharacter(character)) throw new InvalidExpressionException();
        functions.get(character).apply();
    }

    private boolean isValidCharacter(char character) {
        return functions.get(character) != null;

    }

    private boolean lastCharacterIsValid() {
        return (lastCharacterWasNumber && (parenthesis == 0));
    }

    private interface Function {

        public void apply();
    }
}
