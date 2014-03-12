package evaluator.operators.binary.multiplication;

import evaluator.operators.binary.BinaryOperator;

public class DoubleDoubleMultiplicationOperator implements BinaryOperator {

    @Override
    public Object evaluate(Object left, Object right) {
        return (Double) left * (Double) right;
    }
}
