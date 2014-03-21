package evaluator.operators.binary.and;

import evaluator.operators.binary.BinaryOperator;

public class IntegerIntegerAndOperator implements BinaryOperator {

    @Override
    public Object evaluate(Object left, Object right) {
        return (Integer) left & (Integer) right;
    }
}