package evaluator.operators.unary.minus;

import evaluator.operators.unary.UnaryOperator;

public class IntegerMinusOperator implements UnaryOperator{

    @Override
    public Object evaluate(Object value) {
        return (-1) * (Integer) value;
    }
}
