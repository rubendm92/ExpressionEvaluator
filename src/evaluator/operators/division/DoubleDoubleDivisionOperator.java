package evaluator.operators.division;

import evaluator.operators.BinaryOperator;

public class DoubleDoubleDivisionOperator implements BinaryOperator {

    @Override
    public Object evaluate(Object left, Object right) {
        return (Double) left / (Double) right;
    }
}
