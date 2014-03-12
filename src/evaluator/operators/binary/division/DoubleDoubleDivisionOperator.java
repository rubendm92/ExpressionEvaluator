package evaluator.operators.binary.division;

import evaluator.operators.binary.BinaryOperator;

public class DoubleDoubleDivisionOperator implements BinaryOperator {

    @Override
    public Object evaluate(Object left, Object right) {
        return (Double) left / (Double) right;
    }
}
