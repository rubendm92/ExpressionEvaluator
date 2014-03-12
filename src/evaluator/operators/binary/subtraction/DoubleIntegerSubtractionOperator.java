package evaluator.operators.binary.subtraction;

import evaluator.operators.binary.BinaryOperator;

public class DoubleIntegerSubtractionOperator implements BinaryOperator {

    @Override
    public Object evaluate(Object left, Object right) {
        return (Double) left - (Integer) right;
    }
}
