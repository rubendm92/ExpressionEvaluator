package evaluator.operators.unary.minus;

import evaluator.operators.unary.UnaryOperator;

public class DoubleMinusOperator implements UnaryOperator{

    @Override
    public Object evaluate(Object value) {
        return (-1) * (Double) value;
    }
}
