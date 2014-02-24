package evaluator.operators.substraction;

import evaluator.operators.BinaryOperator;

public class DoubleIntegerSubtractionOperator implements BinaryOperator{
    
    @Override
    public Object evaluate(Object left, Object right) {
        return (Double) left - (Integer) right;
    }
}
