package evaluator.operators.addition;

import evaluator.operators.BinaryOperator;

public class DoubleDoubleAdditionOperator implements BinaryOperator {

    @Override
    public Object evaluate(Object left, Object right) {
        return (Double) left + (Double) right;
    }
}
