package evaluator.operators.binary.addition;

import evaluator.operators.binary.BinaryOperator;

public class IntegerIntegerAdditionOperator implements BinaryOperator {

    @Override
    public Object evaluate(Object left, Object right) {
        return (Integer) left + (Integer) right;
    }
}
