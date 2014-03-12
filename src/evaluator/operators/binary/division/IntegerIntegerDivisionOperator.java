package evaluator.operators.binary.division;

import evaluator.operators.binary.BinaryOperator;

public class IntegerIntegerDivisionOperator implements BinaryOperator {

    @Override
    public Object evaluate(Object left, Object right) {
        return (Integer) left / (Integer) right;
    }
}
