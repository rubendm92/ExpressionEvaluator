package evaluator.operators.binary.xor;

import evaluator.operators.binary.BinaryOperator;

public class BooleanBooleanXorOperator implements BinaryOperator {

    @Override
    public Object evaluate(Object left, Object right) {
        return (Boolean) left ^ (Boolean) right;
    }
}