package evaluator.operators.binary.multiplication;

import evaluator.operators.binary.BinaryOperator;

public class DoubleIntegerMultiplicationOperator implements BinaryOperator {

    @Override
    public Object evaluate(Object left, Object right) {
        return (Double) left * (Integer) right;
    }
}
