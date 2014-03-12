package evaluator.operators.binary.subtraction;

import evaluator.operators.binary.BinaryOperator;

public class IntegerIntegerSubtractionOperator implements BinaryOperator {

    @Override
    public Object evaluate(Object left, Object right) {
        return (Integer) left - (Integer) right;
    }
}
