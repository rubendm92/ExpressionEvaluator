package evaluator.operators.binary.addition;

import evaluator.operators.binary.BinaryOperator;

public class DoubleDoubleAdditionOperator implements BinaryOperator {

    @Override
    public Object evaluate(Object left, Object right) {
        return (Double) left + (Double) right;
    }
}
