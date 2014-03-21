package evaluator.operators.binary.or;

import evaluator.operators.binary.BinaryOperator;

public class BooleanBooleanOrOperator implements BinaryOperator {

    @Override
    public Object evaluate(Object left, Object right) {
        return (Boolean) left | (Boolean) right;
    }
}