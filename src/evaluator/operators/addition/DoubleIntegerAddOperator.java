package evaluator.operators.addition;

import evaluator.operators.BinaryOperator;

public class DoubleIntegerAddOperator implements BinaryOperator {

    @Override
    public Object evaluate(Object left, Object right) {
        return (Double) left + (Integer) right;
    }
}
