package evaluator.operators.multiplication;

import evaluator.operators.BinaryOperator;

public class DoubleDoubleMultiplicationOperator implements BinaryOperator {

    @Override
    public Object evaluate(Object left, Object right) {
        return (Double) left * (Double) right;
    }
}
