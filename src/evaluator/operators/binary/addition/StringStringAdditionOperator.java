package evaluator.operators.binary.addition;

import evaluator.operators.binary.BinaryOperator;

public class StringStringAdditionOperator implements BinaryOperator {

    @Override
    public Object evaluate(Object left, Object right) {
        return (String) left + (String) right;
    }
}
