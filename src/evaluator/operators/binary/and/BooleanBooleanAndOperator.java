package evaluator.operators.binary.and;

import evaluator.operators.binary.BinaryOperator;

public class BooleanBooleanAndOperator implements BinaryOperator {

    @Override
    public Object evaluate(Object left, Object right) {
        return (Boolean) left & (Boolean) right;
    }
}