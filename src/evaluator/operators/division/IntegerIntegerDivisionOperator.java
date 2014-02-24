package evaluator.operators.division;

import evaluator.operators.BinaryOperator;

public class IntegerIntegerDivisionOperator implements BinaryOperator{

    @Override
    public Object evaluate(Object left, Object right) {
        return (Integer) left / (Integer) right;
    }
}
