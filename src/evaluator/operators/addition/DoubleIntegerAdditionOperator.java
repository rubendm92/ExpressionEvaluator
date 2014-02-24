package evaluator.operators.addition;

import evaluator.operators.BinaryOperator;

public class DoubleIntegerAdditionOperator implements BinaryOperator {

    @Override
    public Object evaluate(Object left, Object right) {
        return (Double) left + (Integer) right;
    }
}
