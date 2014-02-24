package evaluator.operators.addition;

import evaluator.operators.BinaryOperator;

public class IntegerDoubleAdditionOperator implements BinaryOperator {

    @Override
    public Object evaluate(Object left, Object right) {
        return (Integer) left + (Double) right;
    }
}
