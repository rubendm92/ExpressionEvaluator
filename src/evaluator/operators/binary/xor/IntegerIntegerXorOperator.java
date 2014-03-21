package evaluator.operators.binary.xor;

import evaluator.operators.binary.BinaryOperator;

public class IntegerIntegerXorOperator implements BinaryOperator {

    @Override
    public Object evaluate(Object left, Object right) {
        return (Integer) left ^ (Integer) right;
    }
}