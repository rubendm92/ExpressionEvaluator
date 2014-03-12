package evaluator.operators.binary.multiplication;

import evaluator.operators.binary.BinaryOperator;

public class IntegerIntegerMultiplicationOperator implements BinaryOperator {

    @Override
    public Object evaluate(Object left, Object right) {
        return (Integer) left * (Integer) right;
    }
}
