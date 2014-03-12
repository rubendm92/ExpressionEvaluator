package evaluator.operators.binary.subtraction;

import evaluator.operators.binary.BinaryOperator;

public class DoubleDoubleSubtractionOperator implements BinaryOperator {

    @Override
    public Object evaluate(Object left, Object right) {
        return (Double) left - (Double) right;
    }
}
