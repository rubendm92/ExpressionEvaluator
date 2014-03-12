package evaluator.operators.binary.addition;

import evaluator.operators.binary.BinaryOperator;

public class IntegerDoubleAdditionOperator implements BinaryOperator {

    @Override
    public Object evaluate(Object left, Object right) {
        return (Integer) left + (Double) right;
    }
}
