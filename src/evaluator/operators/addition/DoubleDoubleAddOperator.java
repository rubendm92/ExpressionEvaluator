package evaluator.operators.addition;

import evaluator.operators.BinaryOperator;

public class DoubleDoubleAddOperator implements BinaryOperator {

    @Override
    public Object evaluate(Object left, Object right) {
        return (Double) left + (Double) right;
    }
}
