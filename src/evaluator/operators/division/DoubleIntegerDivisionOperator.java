package evaluator.operators.division;

import evaluator.operators.BinaryOperator;

public class DoubleIntegerDivisionOperator implements BinaryOperator{

    @Override
    public Object evaluate(Object left, Object right) {
        return (Double) left / (Integer) right;
    }
}