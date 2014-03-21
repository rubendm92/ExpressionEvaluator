package evaluator.operators.binary.or;

import evaluator.operators.binary.BinaryOperator;

public class IntegerIntegerOrOperator implements BinaryOperator {

    @Override
    public Object evaluate(Object left, Object right) {
        return (Integer) left | (Integer) right;
    }
}