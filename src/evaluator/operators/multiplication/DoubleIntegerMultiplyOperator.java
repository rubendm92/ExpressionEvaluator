package evaluator.operators.multiplication;

import evaluator.operators.BinaryOperator;

public class DoubleIntegerMultiplyOperator implements BinaryOperator {

    @Override
    public Object evaluate(Object left, Object right) {
        return (Double) left * (Integer) right;
    }
}
