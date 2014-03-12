package evaluator.operators.binary.division;

import evaluator.operators.binary.BinaryOperator;

public class DoubleIntegerDivisionOperator implements BinaryOperator {

    @Override
    public Object evaluate(Object left, Object right) {
        return (Double) left / (Integer) right;
    }
}
