package evaluator.operators.multiplication;

import evaluator.operators.BinaryOperator;

public class IntegerDoubleMultiplyOperator implements BinaryOperator {

    @Override
    public Object evaluate(Object left, Object right) {
        return (Integer) left * (Double) right;
    }
}
